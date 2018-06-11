package neal.scala

import scala.beans.BeanProperty


//采用关键字class定义
class Person {
  //类成员必须初始化，否则会报错
  //这里定义的是一个公有成员
  // Scala会默认帮我们生成name()与name_=（）及构造函数Person()。
  // 其中name()对应java中的getter方法，name_=()对应java中的setter方法
  var name: String = _
}


class Person2 {
  //定义私有成员
  private var privateName: String = null;

  //getter方法
  def name = privateName

  //setter方法
  def name_=(name: String) {
    this.privateName = name
  }

}

class Person3 {
  //类成员必须初始化，否则会报错
  //private[this]修饰
  // 如果将成员域定义为private[this]，则不会生成getter、setter方法
  private[this] var name: String = "john"
}

class Person4 {
  //类成员必须初始化，否则会报错
  //这里定义的是一个val公有成员
  // 如果类的成员域是val类型的变量，则只会生成getter方法
  val name: String = "john"
}

class Person5 {
  //类成员必须初始化，否则会报错
  //@BeanProperty用于生成getXxx,setXxx方法
  @BeanProperty var name: String = "john"
}


//下列代码不但定义了一个类Person，还定义了主构造器，主构造器的参数为String、Int类型
class Person6(val name: String, val age: Int)


//当在创建对象时，需要进行相关初始化操作时，可以将初始化语句放在类体中，同样也可以在类中添加或重写相关方法
class Person7(val name: String, val age: Int) {
  //println将作为主构建器中的一部分，在创建对象时被执行
  println("constructing Person ........")

  //重写toString()方法
  override def toString() = name + ":" + age
}

//默认参数的主构建器
class Person8(val name: String = "", val age: Int = 18) {
  println("constructing Person ........")

  override def toString() = name + ":" + age
}

//默认参数的主构建器，参数带访问控制符号
//age变成私有成员，其getter方法是私有的，外部不能访问
class Person9(var name: String = "", private val age: Int = 18) {
  println("constructing Person ........")

  override def toString() = name + ":" + age
}

//类名后面紧跟private关键字可以将主构建器设为私有，不允许外部使用
class Person10 private(var name: String, var age: Int) {
  println("constructing Person ........")
}


//只有辅助构造函数的类
class Person11{
  //类成员
  private var name:String=null
  private var age:Int=18
  private var sex:Int=0

  //辅助构造器
  def this(name:String){
    this()
    this.name=name
  }
  def this(name:String,age:Int){
    this(name)
    this.age=age
  }
  def this(name:String,age:Int,sex:Int){
    this(name,age)
    this.sex=sex
  }
}

//具有主构建函数和辅助构建函数的Person类
class Person12(var name:String,var age:Int){
  //类成员
  private var sex:Int=0

  //辅助构造器
  def this(name:String,age:Int,sex:Int){
    this(name,age)
    this.sex=sex
  }
}


//禁用主构造函数
class Person13 private(var name:String,var age:Int){
  //类成员
  private var sex:Int=0

  //辅助构造器
  def this(name:String,age:Int,sex:Int){
    this(name,age)
    this.sex=sex
  }

}


object ClassObjectTest {

  def main(args: Array[String]): Unit = {

    val person = new Person()
    println(person.name)
    person.name_=("a")
    println(person.name)

    val person5 = new Person5()
    person5.setName("b")
    println(person5.getName)

    val person6 = new Person6("A", 12)
    println(person6.age)

    val person7 = new Person7("A", 12)
    println(person7.toString())

    val person9 = new Person9()
    person9.name = "B"
    //person9.age=12

    //val person10 = new Person10("john", 19)

    val person13 = new Person13("A",12,1)
    println(person13.toString)
    println(person13.age)

  }

}
