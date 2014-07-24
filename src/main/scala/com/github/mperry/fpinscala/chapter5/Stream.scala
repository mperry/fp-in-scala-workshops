package com.github.mperry.fpinscala.chapter5

/**
 * Created with IntelliJ IDEA.
 * User: MarkPerry
 * Date: 1/09/13
 * Time: 12:18 AM
 * To change this template use File | Settings | File Templates.
 */
sealed abstract class Stream[+A] {
	def uncons: Option[Cons[A]]
	def isEmpty: Boolean = uncons.isEmpty

	def toList: List[A] = ???
	def take(n: Int): Stream[A] = ???
	def takeWhile(p: A => Boolean): Stream[A] = ???
}
object Empty extends Stream[Nothing] {
	val uncons = None
}
sealed abstract class Cons[+A] extends Stream[A] {
	def head: A
	def tail: Stream[A]
	val uncons = Some(this)
}

object Stream {
	def empty[A]: Stream[A] = Empty
	def cons[A](h: => A, t: => Stream[A]): Stream[A] = {
		new Cons[A] {
			lazy val head = h
			lazy val tail = t
		}
	}
	def apply[A](as: A*): Stream[A] =
		if (as.isEmpty)
			Empty
		else
			cons(as.head, apply(as.tail: _*))
}