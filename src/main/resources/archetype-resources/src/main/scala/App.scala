package $package

/**
 * Hello world!
 *
 */
object App {

  def greet(s: String): String = {
    s"Hello $s!"
  }

  def main(args: Array[String]): Unit = {
    val whoToGreet = if (args.isEmpty) {
      "World"
    } else {
      s"${args.mkString(", ")}"
    }

    println(greet(whoToGreet))
  }

}
