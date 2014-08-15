package com.github.mperry.fpinscala.chapter4

/**
 * Created by mperry on 15/08/2014.
 */
object Exercises {

	def map2[A,B,C](oa: Option[A], ob: Option[B])(f: (A, B) => C): Option[C] = {
		???
	}

	def sequence[A](list: List[Option[A]]): Option[List[A]] = {
		// sequence(List(Some(1), Some(2), Some(3))) == Some(List(1, 2, 3))
		// sequence(List(Some(1), None, Some(3))) == None
		???
	}

	def traverse[A, B](as: List[A])(f: A => Option[B]): Option[List[B]] = {
		???
	}

}


