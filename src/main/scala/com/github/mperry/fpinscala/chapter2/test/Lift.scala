package fpinscala.chapter2.test

//import com.github.mperry.fpinscala.chapter2.solutions.Solutions._
//import com.github.mperry.fpinscala.chapter2.solutions.Solutions

/**
 * Created with IntelliJ IDEA.
 * User: MarkPerry
 * Date: 21/05/13
 * Time: 12:33 AM
 * To change this template use File | Settings | File Templates.
 */
object Lift {

	val divisibleByBoth: (Int, Int, Int) => Boolean = { (num, denom1, denom2) =>
		isDividedBy(num, denom1) && isDividedBy(num, denom2)
	}

	val divisibleByEither: (Int, Int, Int) => Boolean = { (num, denom1, denom2) =>
		isDividedBy(num, denom1) || isDividedBy(num, denom2)
	}

	val isDividedBy: (Int, Int) => Boolean = { (numerator, denominator) =>
		numerator % denominator == 0
	}

	/////////////////////////////////

	val flexibleIsDivisibleBy: ((Boolean, Boolean) => Boolean, Int, Int) => (Int => Boolean) = { (f, denom1, denom2) =>
//		lift(f, flip(isDividedBy)(denom1, _), flip(isDividedBy)(denom2, _))
		lift(f, isDividedBy(_, denom1), isDividedBy(_, denom2))
	}

	def test() {
		val b1 = flexibleIsDivisibleBy(_ && _, 3, 5) (17)
		val f1 = flexibleIsDivisibleBy(_ && _, 3, 5)
		val b2 = f1(17)
		val b3 = f1(18)
		val b4 = f1(15)

		val b5 = flexibleIsDivisibleBy(_ || _, 3, 5) (17)
		val f2 = flexibleIsDivisibleBy(_ || _, 3, 5)
		val b6 = f2(13)
		val b7 = f2(12)

	}

	/////////////////////////////

	def lift [A, B, C, D] (f: (B, C) => D, g: A => B, h: A => C): A => D = { a =>
		f(g(a), h(a))
	}

}
