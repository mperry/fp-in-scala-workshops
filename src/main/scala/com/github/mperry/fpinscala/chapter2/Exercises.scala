package fpinscala.chapter2

/**
 * Created with IntelliJ IDEA.
 * User: MarkPerry
 * Date: 25/07/13
 * Time: 10:45 PM
 * To change this template use File | Settings | File Templates.
 */
object Exercises {

	def compose[A, B, C] (f: B => C, g: A => B): A => C =
		???

	def flip [A, B, C] (f: (A, B) => C): (B, A) => C =
		???

	def curry [A, B, C] (f: (A, B) => C): A => B => C =
		???

	def uncurry[A,B,C](f: A => B => C): (A, B) => C =
		???

	def partial1[A, B, C] (f: (A, B) => C, a: A): B => C =
		???

}
