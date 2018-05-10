package $package

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.{FlatSpec, Matchers}

/**
 * Simple unit test using Scalatest and executed
 * with Surefire
 */
@RunWith(classOf[JUnitRunner])
final class SimpleTest extends FlatSpec with Matchers {

  "greet method" should "say Hello" in {
    App.greet("") shouldEqual "Hello !"
    App.greet("Toto") shouldEqual "Hello Toto!"
    App.greet("Toto, Titi") shouldEqual "Hello Toto, Titi!"
  }

}
