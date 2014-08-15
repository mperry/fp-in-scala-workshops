package com.github.mperry.fpinscala.chapter4.solutions

/**
 * Created by mperry on 15/08/2014.
 */
object Solutions {

	def map2[A,B,C](oa: Option[A], ob: Option[B])(f: (A, B) => C): Option[C] = {
		oa.flatMap(a => ob.map(b => f(a, b)))
	}

	def sequence[A](list: List[Option[A]]): Option[List[A]] = {
		list.foldRight(Option(List[A]())) { (oa, acc) =>
			for {
				as <- acc
				a <- oa
			} yield (a::as)
		}
	}

	def factors(numerator: Int, denominators: List[Int]): Option[List[Int]] = {
		val o1 = traverse(denominators) { i =>
			if (numerator % i != 0) None else Some(numerator / i)
		}
		println(o1)
		o1
	}

	def traverse[A, B](as: List[A])(f: A => Option[B]): Option[List[B]] = {
		as.foldRight(Option(List[B]())) { (a, acc) =>
			acc.flatMap { bs =>
				f(a).map { b => b::bs}
			}
		}
	}

}
