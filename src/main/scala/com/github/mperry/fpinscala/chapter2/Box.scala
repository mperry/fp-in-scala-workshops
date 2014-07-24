package com.github.mperry.fpinscala.chapter2

/**
 * Created with IntelliJ IDEA.
 * User: MarkPerry
 * Date: 20/05/13
 * Time: 10:15 PM
 * To change this template use File | Settings | File Templates.
 */

case class Box(width: Double, height: Double)

object Box {

	def main(a: Array[String]) {
		val b1 = new Box(10, 1)
		val b2 = new Box(5, 5)
		println(wider(b1, b2))
	}

	def greaterBy(x: Box, y: Box, f: Box => Double): Box =
		if (f(x) > f(y)) x else y

	// method
	def wider(x: Box, y: Box): Box =
		greaterBy(x, y, b => b.width)

	// function with underscore notation
	val wider2: (Box, Box) => Box =
		greaterBy(_, _, b => b.width)

	// function with lambda notation
	val wider3: (Box, Box) => Box =
		(b1, b2) => greaterBy(b1, b2, b => b.width)

	def taller(x: Box, y: Box) =
		greaterBy(x, y, b => b.height)

}
