package com.github.mperry.fpinscala.chapter3

sealed trait List[+A] // `List` data type
case object Nil extends List[Nothing] // data constructor for `List`
case class Cons[+A](head: A, tail: List[A]) extends List[A]

object List { // `List` companion object

	val example = Cons(1, Cons(2, Cons(3, Nil))) // Creating lists
	val example2 = List(1,2,3)
	val total = sum(example)

	def sum(ints: List[Int]): Int = ints match { // Pattern matching example
    case Nil => 0
    case Cons(x,xs) => x + sum(xs)
  } 
  
  def product(ds: List[Double]): Double = ds match {
    case Nil => 1.0
    case Cons(x,xs) => x * product(xs)
  }
  
  def apply[A](as: A*): List[A] = // Variadic function syntax
    if (as.isEmpty) Nil
    else Cons(as.head, apply(as.tail: _*))
  

  val x = List(1,2,3,4,5) match {
    case Cons(x, Cons(2, Cons(4, _))) => x
    case Nil => 42 
    case Cons(x, Cons(y, Cons(3, Cons(4, _)))) => x + y
    case Cons(h, t) => h + sum(t)
    case _ => 101 
  }

  def append[A](a1: List[A], a2: List[A]): List[A] =
    a1 match {
      case Nil => a2
      case Cons(h,t) => Cons(h, append(t, a2))
    }

	val tailDemo = tail(List(2, 4, 6))
	val dropWhileDemo = dropWhile(List(2, 4, 6, 8), (x: Int) => x < 5)

	def tail[A](l: List[A]): List[A] = {
		l match {
			case Nil => Nil
			case Cons(h, t) => t
		}
	}

	val list1 = dropWhile(List(1, 4, 7, 2, 9), (x: Int) => x < 5)

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

	def foldRight[A,B](l: List[A], z: B)(f: (A, B) => B): B = ???

	def sum2(l: List[Int]) = ???

	def product2(l: List[Double]) = ???

}