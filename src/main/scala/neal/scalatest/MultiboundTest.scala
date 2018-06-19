package neal.scalatest

class A[T]

class B[T]

//T:M:K //这意味着在作用域中必须存在M[T]、K[T]类型的隐式值
//T<%M<%K //这意味着在作用域中必须存在T到M、T到K的隐式转换
//K>:T<:M //这意味着M是T类型的超类，K也是T类型的超类
object MultiboundTest extends App {
  implicit val a = new A[String]
  implicit val b = new B[String]

  //多重上下文界定，必须存在两个隐式值，类型为A[T],B[T]类型
  //前面定义的两个隐式值a,b便是
  def test[T: A : B](x: T) = println(x)

  test("摇摆少年梦")

  implicit def t2A[T](x: T) = new A[T]

  implicit def t2B[T](x: T) = new B[T]

  //多重视图界定，必须存在T到A，T到B的隐式转换
  //前面我们定义的两个隐式转换函数就是
  def test2[T <% A[T] <% B[T]](x: T) = println(x)

  test2("摇摆少年梦2")
}

//T=:=U  //用于判断T是否等于U
//T<:<U  //用于判断T是否为U的子类