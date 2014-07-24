package com.github.mperry.fpinscala.chapter2

// singleton type
object MyModule {

	// Unit equivalent to void
	def main(args: Array[String]): Unit =
		println(formatAbs(-42))

	// if/else is an expression
	def abs(n: Int): Int =
		if (n < 0) -n else n

	// type inference on return type
	// val is immutable
	private def formatAbs(x: Int) = {
		val msg = "The absolute value of %d is %d"
		msg.format(x, abs(x))
	}

}
