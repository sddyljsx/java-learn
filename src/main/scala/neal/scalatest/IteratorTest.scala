package neal.scalatest

object IteratorTest {

  def main(args: Array[String]): Unit = {
    val a: Seq[Int] = List(1, 2, 3, 4, 5)

    val b = a.iterator.flatMap(x => List(x, x * 3))

    b.foreach(println)


    val c = a.map(Iterator(_))
    println(c.iterator.size)
    println(c.iterator.next())
  }

}
