package $package

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.{FlatSpec, Matchers}

import java.io.ByteArrayOutputStream

/**
 * Simple integration test using Scalatest and executed
 * with Failsafe
 */
@RunWith(classOf[JUnitRunner])
final class SimpleIT extends FlatSpec with Matchers {

  "Calling App without parameters" should "greet all world" in {
    val outContent: ByteArrayOutputStream = new ByteArrayOutputStream()

    Console.withOut(outContent) {
      App.main(Array())
    }

    outContent.toString shouldEqual "Hello World!\n"
  }

  "Calling App with parameters" should "greet only specified" in {
    val outContent: ByteArrayOutputStream = new ByteArrayOutputStream()

    Console.withOut(outContent) {
      App.main(Array("Toto", "Titi"))
    }

    outContent.toString shouldEqual "Hello Toto, Titi!\n"
  }

}
