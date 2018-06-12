package neal.scalatest

import java.io._
import scala.io._

import java.net.{URL, URLEncoder}
import scala.io.Source.fromURL


object IOTest {
  def main(args: Array[String]): Unit = {
    val fileWriter=new FileWriter("file.log")
    fileWriter.write("scala file writer")
    fileWriter.flush()
    fileWriter.close()

    //读取文件
    val file=Source.fromFile("file.log")
    //返回Iterator[String]
    val lines=file.getLines()
    //打印内容
    for(i<- lines) println(i)
    //关闭文件
    file.close()


    print(fromURL(new URL("http://www.baidu.com")).mkString)

  }
}
