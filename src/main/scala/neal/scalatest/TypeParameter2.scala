package neal.scalatest


case class Student3(val name: String) extends Ordered[Student3] {
  override def compare(that: Student3): Int = {
    if (this.name == that.name)
      1
    else
      -1
  }
}

//将类型参数定义为T<:Ordered[T]
class Pair1111[T <: Ordered[T]](val first: T, val second: T) {
  //比较的时候直接使用<符号进行对象间的比较
  def smaller() = {
    if (first < second)
      first
    else
      second
  }
}

//PersonOrdering混入了Ordering，它与实现了Comparator接口的类的功能一致
class PersonOrdering extends Ordering[Person66] {
  override def compare(x: Person66, y: Person66): Int = {
    if (x.name > y.name)
      1
    else
      -1
  }
}

case class Person66(val name: String) {
  println("正在构造对象:" + name)
}

//下面的代码定义了一个上下文界定
//它的意思是在对应作用域中，必须存在一个类型为Ordering[T]的隐式值，该隐式值可以作用于内部的方法
class Pair9[T: Ordering](val first: T, val second: T) {
  //smaller方法中有一个隐式参数，该隐式参数类型为Ordering[T]
  def smaller(implicit ord: Ordering[T]) = {
    if (ord.compare(first, second) > 0)
      first
    else
      second
  }
}

class Pair10[T: Ordering](val first: T, val second: T) {
  //引入odering到Ordered的隐式转换
  //在查找作用域范围内的Ordering[T]的隐式值
  //本例的话是implicit val p1=new PersonOrdering
  //编译器看到比较方式是<的方式进行的时候，会自动进行
  //隐式转换，转换成Ordered，然后调用其中的<方法进行比较
  import Ordered.orderingToOrdered

  def smaller = {
    if (first < second)
      first
    else
      second
  }
}


object TypeParameter2 extends App {
  val p = new Pair1111(Student3("摇摆少年梦"), Student3("摇摆少年梦2"))
  println(p.smaller)


  //定义一个隐式值，它的类型为Ordering[Person]
  implicit val p1 = new PersonOrdering
  val pp = new Pair9(Person66("123"), Person66("456"))
  //不给函数指定参数，此时会查找一个隐式值，该隐式值类型为Ordering[Person],根据上下文界定的要求，该类型正好满足要求
  //因此它会作为smaller的隐式参数传入，从而调用ord.compare(first, second)方法进行比较
  println(pp.smaller)


  val ppp = new Pair10(Person66("123"), Person66("456"))
  println(ppp.smaller)


}

//T:M:K //这意味着在作用域中必须存在M[T]、K[T]类型的隐式值
//T<%M<%K //这意味着在作用域中必须存在T到M、T到K的隐式转换
//K>:T<:M //这意味着M是T类型的超类，K也是T类型的超类



