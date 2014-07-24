package fpinscala.chapter4

/**
 * Created with IntelliJ IDEA.
 * User: MarkPerry
 * Date: 26/08/13
 * Time: 7:26 AM
 * To change this template use File | Settings | File Templates.
 */
import java.util.regex._

object Example2 {

	def pattern(s: String): Option[Pattern] =
		try {
			Some(Pattern.compile(s))
		} catch {
			case e: PatternSyntaxException => None
		}

	def mkMatcher(pat: String): Option[String => Boolean] =
		pattern(pat) map (p => (s: String) => p.matcher(s).matches)

	def doesMatch1(pat: String, s: String): Option[Boolean] =
		for {
			f <- mkMatcher(pat)
		} yield f(s)

	def doesMatch2(pat: String, s: String): Option[Boolean] =
		mkMatcher(pat).map(_(s))

	def bothMatch1(pat: String, pat2: String, s: String): Option[Boolean] =
		for {
			f <- mkMatcher(pat)
			g <- mkMatcher(pat2)
		} yield f(s) && g(s)

	def bothMatch2(pat: String, pat2: String, s: String): Option[Boolean] =
		mkMatcher(pat) flatMap (f =>
			mkMatcher(pat2) map (g => f(s) && g(s)))

	def bothMatch3(pat: String, pat2: String, s: String): Option[Boolean] =
		map2(mkMatcher(pat), mkMatcher(pat2))((f, g) => f(s) && g(s))

	def map2[A,B,C](oa: Option[A], ob: Option[B])(f: (A, B) => C): Option[C] = {
		oa.flatMap((a: A) => ob.map((b: B) => f(a, b)))
	}

	def sequence[A](a: List[Option[A]]): Option[List[A]] = ???
	def traverse[A, B](a: List[A])(f: A => Option[B]): Option[List[B]] = ???

}
