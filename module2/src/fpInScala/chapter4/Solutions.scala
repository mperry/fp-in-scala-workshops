package fpInScala.chapter4

/**
 * Created with IntelliJ IDEA.
 * User: MarkPerry
 * Date: 26/08/13
 * Time: 8:37 AM
 * To change this template use File | Settings | File Templates.
 */
class Solutions {

	def map2[A,B,C](oa: Option[A], b: Option[B])(f: (A, B) => C): Option[C] = {
		oa.flatMap(a => b.map(f(a, _)))
	}

	def map2v2[A,B,C](oa: Option[A], ob: Option[B])(f: (A, B) => C): Option[C] = {
		oa.flatMap((a: A) => ob.map((b: B) => f(a, b)))
	}

	def sequence[A](list: List[Option[A]]): Option[List[A]] = {
		list.foldRight(Option(List[A]())) { (optionA, optionList) =>
			for {
				listA <- optionList
				a <- optionA
			} yield (a::listA)
		}
	}
	def traverse[A, B](a: List[A])(f: A => Option[B]): Option[List[B]] = ???

}
