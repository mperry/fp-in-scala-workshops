package com.github.mperry.fpinscala.chapter2.solutions

/**
 * Created with IntelliJ IDEA.
 * User: MarkPerry
 * Date: 25/07/13
 * Time: 10:46 PM
 * To change this template use File | Settings | File Templates.
 */
object Solutions {

	def compose[A, B, C] (f: B => C, g: A => B): A => C = { a: A =>
		f(g(a))
	}

	def flip [A, B, C] (f: (A, B) => C): (B, A) => C = { (b, a) =>
		f(a, b)
	}

	def curry [A, B, C] (f: (A, B) => C): A => B => C = { a =>
		f(a, _)
	}

	def uncurry[A,B,C](f: A => B => C): (A, B) => C = { (a, b) =>
		f(a)(b)
	}

	def partial1[A, B, C] (f: (A, B) => C, a: A): B => C = {
		f(a, _)
	}

}
