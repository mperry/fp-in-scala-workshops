package fpInScala.chapter4

import java.util.Properties

/**
 * Created with IntelliJ IDEA.
 * User: MarkPerry
 * Date: 26/08/13
 * Time: 6:30 AM
 * To change this template use File | Settings | File Templates.
 */
class Example {

	def sToInt(s: String): Option[Int] = {
		try {
			Some(s.toInt)
		} catch {
			case e: Exception => None
		}
	}

	def stringProperty(p: Properties, key: String): Option[String] = {
		Option(p).map(_.getProperty(key))
	}

	def intProperty1(p: Properties, key: String): Option[Int] = {
		stringProperty(p, key).map(_.toInt)
	}

	def intProperty2(p: Properties, key: String): Option[Int] = {
		stringProperty(p, key).flatMap(sToInt(_))
	}

	def addOne(p: Properties, key: String): Option[Int] = {
		intProperty2(p, key).map(_ + 1)
	}

}
