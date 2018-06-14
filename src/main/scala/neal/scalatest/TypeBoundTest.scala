package neal.scalatest

object TypeBoundTest {

}

class TypeVariableBound {
  //采用<:进行类型变量界定
  //该语法的意思是泛型T必须是实现了Comparable
  //接口的类型
  def compare[T <: Comparable[T]](first: T, second: T) = {
    if (first.compareTo(second) > 0)
      first
    else
      second
  }
}

object TypeVariableBound {
  def main(args: Array[String]): Unit = {
    val tvb = new TypeVariableBound
    //由于String类型实现了Comparable接口
    //下面这种使用方式是合法的
    println(tvb.compare("A", "B"))
  }
}


//利用<%符号对泛型S进行限定
//它的意思是S可以是Comparable类继承层次结构
//中实现了Comparable接口的类
//也可以是能够经过隐式转换得到的类,该类实现了
//Comparable接口
case class Students[T, S <% Comparable[S]](var name: T, var height: S)


object ViewBound extends App {
  val s = Students("john", "170")
  //下面这条语句在视图界定中是合法的
  //因为Int类型此时会隐工转换为
  //RichInt类，而RichInt类属于Comparable、
  //继承层次结构
  val s2 = Students("john", 170)
}
