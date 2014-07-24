package fpinscala.chapter2.test

/**
 * Created with IntelliJ IDEA.
 * User: MarkPerry
 * Date: 26/05/13
 * Time: 10:09 PM
 * To change this template use File | Settings | File Templates.
 */
object Recursion {

	def main(s: Array[String]): Unit = {
		println("hi world")
		println(1.to(10).map{x => fib(x)})
	}

	def fib_naive(i: Int): Int = {
		i match {
			case 1 => 0
			case 2 => 1
			case _ => fib(i - 1) + fib(i - 2)
		}
	}

	def fib(n: Int) = fib_tr(n, 1, 1)

	def fib_tr(n: Int, a: Int, b: Int): Int = {
		n match {
			case 1 => b
			case _ => fib_tr(n - 1, a + b, a)
		}
	}

}
