package neal.scalatest

object ImplicitTest {

  implicit def double2Int(x:Double)=x.toInt

  //定义完隐式转换后，便可以直接将Double类型赋值给Int类型
  val x:Int=3.5


}

import java.io.File
import scala.io.Source
//RichFile类中定义了Read方法
class RichFile(val file:File){
  def read=Source.fromFile(file).getLines().mkString
}

object ImplicitFunction extends App{
  implicit def double2Int(x:Double)=x.toInt
  var x:Int=3.5
  //隐式函数将java.io.File隐式转换为RichFile类
  implicit def file2RichFile(file:File)=new RichFile(file)
  val f=new File("file.log").read
  println(f)
}




class Studentsss(var name:String){
  //利用柯里化函数的定义方式，将函数的参数利用
  //implicit关键字标识
  //这样的话，在使用的时候可以不给出implicit对应的参数
  def formatStudent()(implicit outputFormat:OutputFormat)={
    outputFormat.first+" "+this.name+" "+outputFormat.second
  }
}

class OutputFormat(var first:String,val second:String)

object ImplicitParameter {
  def main(args: Array[String]): Unit = {
    //程序中定义的变量outputFormat被称隐式值
    implicit val outputFormat=new OutputFormat("<<",">>")
    //在.formatStudent()方法时，编译器会查找类型
    //为OutputFormat的隐式值,本程序中定义的隐式值
    //为outputFormat
    println(new Studentsss("john").formatStudent())
  }
}