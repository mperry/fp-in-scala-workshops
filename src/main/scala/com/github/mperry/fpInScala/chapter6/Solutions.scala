package com.github.mperry.fpInScala.chapter6

/**
 * Created with IntelliJ IDEA.
 * User: MarkPerry
 * Date: 6/09/13
 * Time: 4:45 PM
 * To change this template use File | Settings | File Templates.
 */
class Solutions {

	// 1
	def positiveInt(rng: RNG): (Int, RNG) = {
		val (i, r) = rng.nextInt
		if (i == Int.MinValue) (0, r) else (i.abs, r)
	}

	// 2 result double is in [0, 1)
	def double(rng: RNG): (Double, RNG) = {
		val (i, r) = positiveInt(rng)
		(i / (Int.MaxValue.toDouble + 1), r)
	}

	// 3
	def intDouble(rng: RNG): ((Int,Double), RNG) = {
		val (i, r) = rng.nextInt
		val (d, r2) = double(r)
		((i, d), r2)
	}
	def doubleInt(rng: RNG): ((Double,Int), RNG) = {
		val ((i, d), r) = intDouble(rng)
		((d, i), r)
	}
	def double3(rng: RNG): ((Double, Double, Double), RNG) = {
		val (d1, r1) = double(rng)
		val (d2, r2) = double(r1)
		val (d3, r3) = double(r2)
		((d1, d2, d3), r3)
	}

	def penultimate[A](list: List[A]): A = {
		list.foldLeft( (list.head, list.tail.head) )((r, c) => (r._2, c) )._1
	}

	def encode[A](list: List[A]): List[(A,Int)] =
		list.foldLeft(List[(A,Int)]()){ (r,c) =>
			r match {
				case (value, count) :: tail =>
					if (value == c) (c, count+1) :: tail
					else            (c, 1) :: r
				case Nil =>
					(c, 1) :: r
			}
		}.reverse

	def decode[A](list: List[(A,Int)]): List[A] =
		list.foldLeft(List[A]()){ (r,c) =>
			var result = r
			for (_ <- 1 to c._2) result = c._1 :: result
			result
		}.reverse

	// 4
	def ints(count: Int)(rng: RNG): (List[Int], RNG) = {
		1.to(5).foldLeft(List[Int]()) { (acc , i) =>
			i :: acc
		}
		if (count == 0) {
			(List(), rng)
		} else {
			val (i, r) = rng.nextInt
			val (list, r2) = ints(count - 1)(r)
			((i :: list), r2)
		}
		1.to(count).foldLeft((List[Int](), rng)) { case ((list: List[Int], r: RNG), i: Int) =>
			val (i2, r1) = r.nextInt
			(i2 :: list, r1)
		}

	}

}
