package fpinscala.datastructures

sealed trait Tree[+A]
case class Leaf[A](node: A) extends Tree[A]
case class Branch[A](left: Tree[A], node: A, right: Tree[A]) extends Tree[A]

object Tree {



}