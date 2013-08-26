package fpInScala.chapter3.solutions

import com.github.mperry.fpInScala.chapter3._

/**
 * Created with IntelliJ IDEA.
 * User: MarkPerry
 * Date: 21/08/13
 * Time: 12:16 AM
 * To change this template use File | Settings | File Templates.
 */
class Solutions {

	def foldRight[A,B](l: List[A], acc: B)(f: (A, B) => B): B =
		l match {
			case Nil => acc
			case Cons(x, xs) => f(x, foldRight(xs, acc)(f))
		}

	def sum2(l: List[Int]) =
		foldRight(l, 0)((a, acc) => a + acc)

	def product2(l: List[Int]) =
		foldRight(l, 1)(_ * _)

	def tail[A](l: List[A]): List[A] = {
		l match {
			case Nil => Nil
			case Cons(x, xs) => xs
		}
	}

	def dropWhile[A](l: List[A], f: A => Boolean): List[A] = {
		l match {
			case Nil => Nil
			case Cons(h, t) =>
				if (f(h)) {
					dropWhile(t, f)
				} else {
					l
				}
		}
	}

}
