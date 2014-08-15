package com.github.mperry.fpinscala.chapter4.solutions

import com.github.mperry.fpinscala.chapter3.Cons

/**
 * Created by mperry on 15/08/2014.
 */

sealed trait Validation[+E, +A] {
	def map[B](f: A => B): Validation[E, B] = {
		this match {
			case Failure(e) => Failure(e)
			case Success(a) => Success(f(a))
		}
	}
	def flatMap[E2 >: E, B](f: A => Validation[E2, B]): Validation[E2, B] = {
		this match {
			case Failure(e) => Failure(e)
			case Success(a) => f(a)
		}
	}
	def orElse[E2 >: E, B >: A](v: => Validation[E2, B]): Validation[E2, B] = {
		this match {
			case Failure(e) => v
			case Success(a) => Success(a)
		}
	}
	def map2[E2 >: E, B, C](v: Validation[E2, B])(f: (A, B) => C): Validation[E2, C] = {
		// case 1
		for {
			a <- this
			b <- v
		} yield f(a, b)
		// case 2
		this.flatMap(a => v.map(b => f(a, b)))
	}
}

case class Failure[+E](error: E) extends Validation[E, Nothing]
case class Success[+A](get: A) extends Validation[Nothing, A]

object Validation {

	def traverse[E,A,B](as: List[A])(f: A => Validation[E, B]): Validation[E, List[B]] = {
		// case 1
		as match {
			case Nil => Success(Nil)
			case h::t => f(h).map2(traverse(t)(f))((b, bs) => b::bs)
		}

		// case 2
		as.foldRight(Success(List()): Validation[E, List[B]]) { (a, acc) =>
			acc.flatMap { bs => f(a).map { b => b::bs } }
		}
	}

	def sequence[E,A](vs: List[Validation[E,A]]): Validation[E,List[A]] = {
		// case 1
		traverse(vs)(x => x)

		// case 2
		vs.foldRight(Success(List()): Validation[E, List[A]]) { (v, acc) =>
			acc.flatMap { as => v.map { a => a::as } }
		}
	}

}
