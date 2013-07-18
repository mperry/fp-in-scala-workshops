package com.github.mperry.fpInScala.chapter2

/**
 * Created with IntelliJ IDEA.
 * User: MarkPerry
 * Date: 21/05/13
 * Time: 1:31 AM
 * To change this template use File | Settings | File Templates.
 */
object Composition {

	def compose[A, B, C] (f: B => C, g: A => B): A => C = { a =>
		f(g(a))
	}

}
