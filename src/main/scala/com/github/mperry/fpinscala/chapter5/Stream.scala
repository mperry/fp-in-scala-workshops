package com.github.mperry.fpinscala.chapter5

//import Stream._

trait Stream[+A] {

	def take(n: Int): Stream[A] = {
		???
	}

	def toList: List[A] = {
		???
	}

	def takeWhile(p: A => Boolean): Stream[A] = {
		???
	}

}

case object Empty extends Stream[Nothing]
case class Cons[+A](h: () => A, t: () => Stream[A]) extends Stream[A]

object Stream {


}
