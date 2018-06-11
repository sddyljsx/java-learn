package neal.scala

object FunctionClosureTest {

  // 1、 函数字面量 值函数
  def max(x: Int, y: Int): Int = {
    if (x > y) x else y
  }

  val increase = (x: Int) => x + 1

  def increaseAnother(x: Int) = x + 1

  def increaseAnother2(x: Int): Int = {
    x + 1
  }

  val increase2=(x:Int)=>{
    println("Xue")
    println("Tu")
    println("Wu")
    println("You")
    x+1
  }


  def main(args: Array[String]): Unit = {
    println(max(1, 2))
    println(increase(9))
    println(increaseAnother(9))
    println(increaseAnother2(9))

    /**
      *   def map[B, That](f: A => B)(implicit bf: CanBuildFrom[Repr, B, That]): That = {
    def builder = { // extracted to keep method size under 35 bytes, so that it can be JIT-inlined
      val b = bf(repr)
      b.sizeHint(this)
      b
    }
    val b = builder
    for (x <- this) b += f(x)
    b.result
  }
      */
    println(Array(1,2,3,4).map(increase).mkString(","))

    // 2、匿名函数
    println(Array(1,2,3,4).map((x:Int)=>x+1).mkString(","))
    println(Array(1,2,3,4).map{(x:Int)=>x+1}.mkString(","))
    println(Array(1,2,3,4) map((x:Int)=>x+1) mkString(","))
    println(Array(1,2,3,4).map(x=>x+1).mkString(","))
    println(Array(1,2,3,4).map(_+1).mkString(","))

    val fun1=1+(_:Double)
    println(fun1(1.3))

    val fun2:(Double)=>Double=1+_
    println(fun2(9))


    //3、函数参数
    def convertIntToString(f:(Int)=>String)=f(4)
    println(convertIntToString((x:Int)=>x +" s"))

    //下列函数也是一种闭包，因为在运行时其值才得以确定
    def multiplyBy(factor:Double)=(x:Double)=>factor*x

    val x=multiplyBy(10)

    println(x(3))


    //4、closure
    //像这种运行时确定more类型及值的函数称为闭包,more是个自由变量，在运行时其值和类型得以确定
    //这是一个由开放(free)到封闭的过程，因此称为闭包
    var more=1
    val fun=(x:Int)=>x+more
    println(fun(10))

    val someNumbers = List(-11, -10, -5, 0, 5, 10)
    var sum = 0
    someNumbers.foreach(sum += _)
    println(sum)


  }


}
