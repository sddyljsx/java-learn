package neal.scalatest

class NullTest {

  private var array: Array[Int] = _

  def getArray: Array[Int] = array

  def setArray = {
    array = Array.empty[Int]
  }

}

object test {


  def main(args: Array[String]): Unit = {
    val nullTest = new NullTest
    println(nullTest.getArray == null)
    nullTest.setArray
    println(nullTest.getArray == null)

  }


}
