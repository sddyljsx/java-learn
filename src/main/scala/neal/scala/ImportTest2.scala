package neal.scala

//将java.util.HashMap重命名为JavaHashMap
import java.util.{ HashMap => JavaHashMap }


//通过HashMap=> _，这样类便被隐藏起来了
import java.util.{HashMap=> _,_}

/**
  * 在集合那一讲，我们提到，如果不引入任何包，scala会默认引入java.lang._
scala._
Predef._
包中或对象中所有的类和方法，称这种引入会隐式引入
  */
class OuterClass {
  //即使定义为 private[this] var x:Int=0，也是可行的
  private var x:Int=0

  //def getInnerY=y，外部类不能直接访问内部类的成员域
  class InnerClass{
    private var y:Int=0
    //内部的类可以直接访问外部类的成员变量和成员方法,注意外部类的成员变量是private
    def getOuterX= x
  }
}

object AppDemo{
  def main(args: Array[String]): Unit = {
    val o=new OuterClass
    //创建内部类对象，通过o.InnerClass方式，InnerClass就像是OuterClass的成员变量一样
    val i=new o.InnerClass
    println(i.getOuterX)
  }
}
