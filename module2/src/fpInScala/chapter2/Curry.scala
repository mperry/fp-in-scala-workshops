package com.github.mperry.fpInScala

/**
 * Created with IntelliJ IDEA.
 * User: MarkPerry
 * Date: 21/05/13
 * Time: 9:07 PM
 * To change this template use File | Settings | File Templates.
 */
object Curry {

	def curry [A, B, C] (f: (A, B) => C): A => B => C = { a =>
		f(a, _)
	}

	def uncurry[A,B,C](f: A => B => C): (A, B) => C = { (a, b) =>
		f(a)(b)
	}

	def flip [A, B, C] (f: (A, B) => C): (B, A) => C = { (b, a) =>
		f(a, b)
	}

}
