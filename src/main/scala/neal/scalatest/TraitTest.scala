package neal.scalatest

import java.io.PrintWriter


trait Logger{
  def log(msg:String):Unit
}

trait FileLogger extends Logger{

  val fileName:String
  //将方法定义为lazy方式
  lazy val fileOutput=new PrintWriter(fileName:String)
  //下面这条语句不能出现，否则同样会报错
  //因此，它是FileLogger构造器里面的方法
  //在构造FileLogger的时候便会执行
  //fileOutput.println("#")

  def log(msg:String):Unit={
    fileOutput.print(msg)
    fileOutput.flush()
  }
}

class Persona
class Studenta extends Persona with FileLogger{
  val fileName="file.log"
}

object TraitTest{
  def main(args: Array[String]): Unit = {
    val s=new Studenta
    s.log("predifined variable ")
  }
}
