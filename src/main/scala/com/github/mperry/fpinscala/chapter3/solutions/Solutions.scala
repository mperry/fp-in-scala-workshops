package fpinscala.chapter3.solutions

import com.github.mperry.fpinscala.chapter3._
import fpinscala.datastructures.{Branch, Leaf, Tree}

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
				if (f(h)) dropWhile(t, f) else l
		}
	}

	def reverse[A](list: List[A]): List[A] = {
		???
	}

	/////////////////////////
	// trees

	def size[A](tree: Tree[A]): Int = {
		foldLeft(tree, 0)((a, b) => 1 + b)
	}

	def depth[A](tree: Tree[A]): Int = {
		???
	}

	def map[A, B](tree: Tree[A], f: A => B): Tree[B] = {
		???
	}

	def foldLeft[A, B](tree: Tree[A], acc: B)(f: (A, B) => B): B = {
		tree match {
			case Leaf => acc
			case Branch(l, n, r) => {
				foldLeft(r, f(n, foldLeft(l, acc)(f)))(f)
			}
		}
	}

	def traverseLeft[A](tree: Tree[A]): List[A] = {
		val n: List[A] = Nil
		reverse(foldLeft(tree, Nil: List[A])((a, acc) => Cons(a, acc)))
	}

}

