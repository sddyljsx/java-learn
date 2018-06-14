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







class Pair1[T](val first:T,val second:T){
  //下界通过[R >: T]的意思是
  //泛型R的类型必须是T的超类
  def replaceFirst[R >: T](newFirst:R)= new Pair1[R](newFirst,second)
  override def toString()=first+"---"+second
}

//Book类
class Book(val name:String){
  override def toString()="name--"+name
}
//Book子类Ebook
class Ebook(name:String) extends Book(name)
//Book子类Pbook
class Pbook(name:String) extends Book(name)
//Pbook子类,WeridBook
class WeirdBook(name:String) extends Pbook(name)

object LowerBound extends App{

  val first = new Ebook("hello")
  val second = new Pbook("paper book")


  val p1 = new Pair1(first,second)
  println(p1)
  //scala> val p1 = new Pair1(first,second)
  //p1: Pair1[Book] = name--hello---name--paper book
  //Ebook,Pbook，最终得到的类是Pair1[Book]

  val newFirst = new Book("generic pBook")
  val p2 = p1.replaceFirst(newFirst)
  //p2: Pair1[Book] = name--generic pBook---name--paper book
  println(p2)

  val weirdFirst:WeirdBook= new WeirdBook("generic pBook")
  val p3 = p1.replaceFirst(weirdFirst)
  //p3: Pair1[Book] = name--generic pBook---name--paper book

  val p4 = new Pair1(second,second)
  //p4: Pair1[Pbook] = name--paper book---name--paper book
  println(p4)
  val thirdBook=new Book("Super Books")
  val p5=p4.replaceFirst(thirdBook)
  println(p5)

  //下面这条语句会报错
  //type mismatch; found : cn.scala.xtwy.lowerbound.Pair1[cn.scala.xtwy.lowerbound.Pbook] required: cn.scala.xtwy.lowerbound.Pbook
  //val p6:Pbook=p4.replaceFirst(weirdFirst)
}
