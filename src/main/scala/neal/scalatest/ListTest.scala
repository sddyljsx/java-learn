package neal.scalatest

object ListTest {

  def main(args: Array[String]): Unit = {

    val fruit = List("Apple", "Banana", "Orange")

    val fruit2 = List.apply("Apple", "Banana", "Orange")


    val diagMatrix = List(List(1, 0, 0), List(0, 1, 0), List(0, 0, 1))

    val nums = 1 :: (2 :: (3 :: (4 :: Nil)))


    List(1, 2, 3) ::: List(4, 5, 6)

    fruit.head

    /**
      * [B >: A] is a lower type bound. It means that B is constrained to be a supertype of A.

Similarly [B <: A] is an upper type bound, meaning that B is constrained to be a subtype of A
      */

  }

}
