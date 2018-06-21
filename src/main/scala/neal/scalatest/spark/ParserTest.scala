package neal.scalatest.spark

object ParserTest {

}


import scala.util.parsing.combinator.PackratParsers
import scala.util.parsing.combinator.syntactical.StandardTokenParsers

/**
  */

///**
//  *
//  *
//  * parser中的表达式说明
//  * A<~B	只保留左侧内容 A<~B 只保留A
//  * A~>B	只保留右侧内容 A~>B 只保留A
//  * ^^	根据匹配结果生成语法短语
//  * ^^^	将语法短语转换成为另外的值,注意与 ^^的区别
//  * ~	连接符 A ?B 表示模式匹配是B紧跟于A之后
//  * |	或者 A|B 表示模式要么由A组成,要么由B组成

/*
p~q ，p成功,才会q;放回p,q的结果
p~>q ，p成功,才会q,返回q的结果
p<~q ，p成功,才会q,返回p的结果
p | q ，p 失败则 q,返回第一个成功的结果
p^^f ，如果p成功,将函数f应用到p的结果上
p^?f ，如果p成功,如果函数f可以应用到p的结果上的话,就将p的结果用f进行转换
但在阅读源码的时候，你还会用到下面两个复合因子：

opt， opt(p) is a parser that returns Some(x) if p returns x and None if p fails.如果p算子成功则返回则返回Some（x） 如果p算子失败，返回fails
^^^ ，p ^^^ v succeeds if p succeeds; discards its result, and returns v instead.如果左边的算子成功，取消左边算子的结果，返回右边算子。
*/

object MyLexical extends StandardTokenParsers with PackratParsers {

  //定义分割符
  lexical.delimiters ++= List(".", ";", "+", "-", "*")
  //定义表达式,支持加,减,乘
  lazy val expr: PackratParser[Int] = plus | minus | multi
  //加法表示式的实现
  lazy val plus: PackratParser[Int] = num ~ "+" ~ num ^^ {
    case n1 ~ "+" ~ n2 => n1.toInt + n2.toInt
  }
  //减法表达式的实现
  lazy val minus: PackratParser[Int] = num ~ "-" ~ num ^^ {
    case n1 ~ "-" ~ n2 => n1.toInt - n2.toInt
  }

  //乘法表达式的实现
  lazy val multi: PackratParser[Int] = num ~ "*" ~ num ^^ {
    case n1 ~ "*" ~ n2 => n1.toInt * n2.toInt
  }

  lazy val num = numericLit

  def parse(input: String) = {
    //定义词法读入器 myread,并将扫描头放置在 input 的首位
    val myread = new PackratReader(new lexical.Scanner(input))
    print("处理表达式 " + input)
    phrase(expr)(myread) match {
      case Success(result, _) => println(" Success!"); println(result); Some(result)
      case n => println(n); println("Err!"); None
    }
  }

  def main(args: Array[String]) {
    val prg = "6 * 3 " :: "24-/*aaa*/4" :: "a+5" :: "21/3" :: Nil
    prg.map(parse)
  }
}

