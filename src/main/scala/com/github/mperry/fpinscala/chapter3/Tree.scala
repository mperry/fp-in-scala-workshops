package fpinscala.datastructures

sealed trait Tree[+A]
case object Leaf extends Tree[Nothing]
case class Branch[+A](left: Tree[A], node: A, right: Tree[A]) extends Tree[A]

object Tree {



}