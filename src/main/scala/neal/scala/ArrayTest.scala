package neal.scala

import scala.collection.mutable.ArrayBuffer

object ArrayTest {

  def main(args: Array[String]): Unit = {


    val numberArray = new Array[Int](10)
    numberArray(0) = 1
    println(numberArray(0))
    for (element <- numberArray) {
      println(element)
    }


    println(numberArray.max)
    println(numberArray.sum)

    /**
      * 下面带横向标注表示 使用了 implicit
      */
    println(numberArray.mkString(","))
    println(numberArray.mkString("<", ",", ">"))


    val intArrayNoBuffer2 = for (i <- numberArray if i >= 1) yield i * 2
    for (e <- intArrayNoBuffer2) {
      println(e)
    }


    //这种调用方式其实是调用其apply方法进行数组创建操作
    val strArray2 = Array("e", "f")

    val stringArray3 = new Array[String](1)
    stringArray3(0) = "i"

    val arrayBuffer = ArrayBuffer[String]()
    arrayBuffer += ("a", "b")
    arrayBuffer ++= Array("c", "d")
    arrayBuffer ++= List("g", "h")
    arrayBuffer ++= stringArray3
    arrayBuffer ++= strArray2
    for (e <- arrayBuffer) {
      println(e)
    }

    arrayBuffer.trimEnd(3)
    arrayBuffer.insert(0, "a")
    arrayBuffer.toArray
    arrayBuffer.reverse

    var multiDimArr = Array(Array(1, 2, 3), Array(2, 3, 4))


  }
}
