package neal.scalatest



object ImplicitParameter2 extends App {
  //下面代码中的(implicit order:T=>Ordered[T])
  //给函数compare指定了一个隐式参数
  //该隐式参数是一个隐式转换
  def compare[T](first:T,second:T)(implicit x:T=>Ordered[T])={
    if (first > second)
      first
    else
      second
  }
  println(compare("A","B"))

  def sum(x: Int)(implicit y:Int)=x+y

}


object Main extends App {
  class PrintOps() {
    def print(implicit i: Int) = println(i)
  }

  implicit def str2PrintOps(s: String) = {
    println("str2PrintOps")
    new PrintOps
  }

  implicit def str2int(implicit s: String): Int = {
    println("str2int")
    Integer.parseInt(s)
  }

  implicit def getString = {
    println("getString")
    "123"
  }
  //下面的代码会发生三次隐式转换
  //首先编译器发现String类型是没有print方法的
  //尝试隐式转换，利用str2PrintOps方法将String
  //转换成PrintOps（第一次）
  //然后调用print方法，但print方法接受整型的隐式参数
  //此时编译器会搜索隐式值，但程序里面没有给定，此时
  //编译器会尝试调用 str2int方法进行隐式转换，但该方法
  //又接受一个implicit String类型参数，编译器又会尝试
  //查找一个对应的隐式值，此时又没有，因此编译器会尝试调用
  //getString方法对应的字符串（这是第二次隐式转换，
  //获取一个字符串，从无到有的过程）
  //得到该字符串后，再调用str2int方法将String类型字符串
  //转换成Int类型（这是第三次隐式转换）
  "a".print
}
