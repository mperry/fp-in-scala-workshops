package com.github.mperry.fpInScala.chapter6

/**
 * Created with IntelliJ IDEA.
 * User: MarkPerry
 * Date: 6/09/13
 * Time: 4:42 PM
 * To change this template use File | Settings | File Templates.
 */

trait RNG {
	def nextInt: (Int, RNG)
}

object RNG {
	def simple(seed: Long): RNG = new RNG {
		def nextInt: (Int, RNG) = {
			val seed2 = (seed * 0x5DEECE66DL + 0xBL) &
				((1L << 48) - 1)
			((seed2 >>> 16).asInstanceOf[Int],
				simple(seed2))
		}
	}


}
