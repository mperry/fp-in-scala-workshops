package com.github.mperry.fpInScala.chapter2

import java.lang.String

/**
 * Created with IntelliJ IDEA.
 * User: MarkPerry
 * Date: 20/05/13
 * Time: 8:43 PM
 * To change this template use File | Settings | File Templates.
 */
object MyModule {

	def abs(n: Int): Int =
		if (n < 0) -n else n

	private def formatAbs(x: Int) = {
		val msg = "The absolute value of %d is %d"
		msg.format(x, abs(x))
	}

	def main(args: Array[String]): Unit =
		println(formatAbs(-42))

}
