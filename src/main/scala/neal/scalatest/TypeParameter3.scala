package neal.scalatest



//用+标识泛型T，表示List类具有协变性
class List[+T](val head: T, val tail: List[T]){
  //将函数也用泛型表示
  //因为是协变的，输入的类型必须是T的超类
  def prepend[U>:T](newHead:U):List[U]=new List(newHead,this)

  override def toString()=""+head
}

object NonVariance {
  def main(args: Array[String]): Unit = {
    val list:List[Any]= new List[String]("摇摆少年梦",null)
    println(list)
  }
}

object TypeParameter3 {

}

//声明逆变
class Person22[-A]{ def test(x:A){} }

//声明协变，但会报错
//covariant type A occurs in contravariant position in type A of value x
//class Person3[+A]{ def test(x:A){} }
