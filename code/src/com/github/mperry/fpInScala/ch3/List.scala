package com.github.mperry.fpInScala.ch3

/**
 * Created with IntelliJ IDEA.
 * User: MarkPerry
 * Date: 15/08/13
 * Time: 9:14 PM
 * To change this template use File | Settings | File Templates.
 */

// List data type, List is polymorphic on A, A is co-variant, List[Nothing] is subtype of List[A]
sealed trait List[+A]

// data constructors Nil and Cons
case object Nil extends List[Nothing]
case class Cons[+A](head: A, tail: List[A]) extends List[A]

// companion object List
object List {

	// List creation examples
	val example = Cons(1, Cons(2, Cons(3, Nil)))
	val example2 = List(1, 2, 3)

	def sum(ints: List[Int]): Int = ints match {
		// pattern matching
		case Nil => 0
		case Cons(x, xs) => x + sum(xs)
	}

	def product(ds: List[Double]): Double = ds match {
		case Nil => 1.0
		case Cons(x, xs) => x * product(xs)
	}

	// variadic function syntax
	def apply[A](as: A*): List[A] =
		if (as.isEmpty) Nil
		else Cons(as.head, apply(as.tail: _*))

	val total = sum(example)

}
