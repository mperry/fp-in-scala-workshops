package com.github.mperry.fpInScala.chapter6

/**
 * Created with IntelliJ IDEA.
 * User: MarkPerry
 * Date: 6/09/13
 * Time: 4:42 PM
 * To change this template use File | Settings | File Templates.
 */
class Exercises {

	// 1
	def positiveInt(rng: RNG): (Int, RNG) = ???

	// 2
	def double(rng: RNG): (Double, RNG) = ???

	// 3
	def intDouble(rng: RNG): ((Int,Double), RNG) = ???
	def doubleInt(rng: RNG): ((Double,Int), RNG) = ???
	def double3(rng: RNG): ((Double,Double,Double), RNG) = ???

	// 4
	def ints(count: Int)(rng: RNG): (List[Int], RNG) = ???

}
