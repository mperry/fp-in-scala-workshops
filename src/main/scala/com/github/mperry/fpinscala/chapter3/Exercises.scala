package com.github.mperry.fpinscala.chapter3

import fpinscala.datastructures.Tree

/**
 * Created by mperry on 1/08/2014.
 */
object Exercises {

	val sumDemo = sum(List(1, 2, 3))

	def sum(ints: List[Int]): Int = ints match { // Pattern matching example
		case Nil => 0
		case Cons(x, xs) => x + sum(xs)
	}

	val tailDemo = tail(List(2, 4, 6))

	def tail[A](l: List[A]): List[A] = {
		???
	}

	val dropWhileDemo = dropWhile(List(2, 4, 6, 8), (x: Int) => x < 5)

	def dropWhile[A](list: List[A], f: A => Boolean): List[A] = {
		???
	}

	def foldLeft[A,B](list: List[A], acc: B, f: (B, A) => B): B = {
		???
	}

	def reverse[A](list: List[A]): List[A] = {
		???
	}

	def map[A,B](list: List[A])(f: A => B): List[B] = {
		???
	}

	def flatten[A](list: List[List[A]]): List[A] = {
		???
	}

	def flatMap[A,B](list: List[A], f: A => List[B]): List[B] = {
		???
	}

	///////////////////////////////
	// trees

	def size[A](tree: Tree[A]): Int = {
		???
	}

	def depth[A](tree: Tree[A]): Int = {
		???
	}

	def map[A, B](tree: Tree[A], f: A => B): Tree[B] = {
		???
	}

}
