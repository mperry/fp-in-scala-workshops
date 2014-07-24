package fpinscala.chapter2.test

/**
 * Created with IntelliJ IDEA.
 * User: MarkPerry
 * Date: 20/05/13
 * Time: 11:05 PM
 * To change this template use File | Settings | File Templates.
 */
object Polymorphism {

	def not[A](p: A => Boolean): A => Boolean =
		a => !p(a)

	def isEmpty(): String => Boolean = {
		_ == ""
	}

	def isNotEmpty(): String => Boolean = {
		not(isEmpty())
	}

	def main(a: Array[String]) {
		println(isNotEmpty()("abc"))
	}

}
