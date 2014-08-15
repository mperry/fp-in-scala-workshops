package com.github.mperry.fpinscala.chapter4

/**
 * Created by mperry on 15/08/2014.
 */

sealed trait Validation[+E, +A] {
	def map[B](f: A => B): Validation[E, B] = {
		???
	}
	def flatMap[E2 >: E, B](f: A => Validation[E2, B]): Validation[E2, B] = {
		???
	}
	def orElse[E2 >: E, B >: A](v: => Validation[E2, B]): Validation[E2, B] = {
		???
	}
	def map2[E2 >: E, B, C](v: Validation[E2, B])(f: (A, B) => C): Validation[E2, C] = {
		???
	}
}

case class Failure[+E](error: E) extends Validation[E, Nothing]
case class Success[+A](get: A) extends Validation[Nothing, A]

object Validation {

	def traverse[E,A,B](as: List[A])(f: A => Validation[E, B]): Validation[E, List[B]] = {
		???
	}

	def sequence[E,A](vs: List[Validation[E,A]]): Validation[E,List[A]] = {
		???
	}


}
