package neal.scala


// 单例对象
object Student {
  private var studentNo: Int = 0

  def uniqueStudentNo() = {
    studentNo += 1
    studentNo
  }

   // 利用apply方法可以直接利用类名创建对象
  def apply(name:String,age:Int)=new Student(name,age)

  def main(args: Array[String]): Unit = {
    val student = new Student("a",12)
    println(student.sex)
  }
}

// object Student被称为class Student的伴生对象，而class Student被称为object Student的伴生类
//class Student(var name:String,age:Int)

// 伴生对象与伴生类本质上是不同的两个类，只不过伴生类与伴生对象之间可以相互访问到对主的成员包括私有的成员变量或方法
class Student(var name: String, var age: Int) {
  private var sex: Int = 0

  //直接访问伴生对象的私有成员
  def printCompanionObject() = println(Student.studentNo)
}


object ClassObjectTest2 {

  def main(args: Array[String]): Unit = {
    println(Student.uniqueStudentNo())
    println(Student.uniqueStudentNo())
    val student = new Student("a", 12)
    println(student.name)
    //println(student.sex)
    student.printCompanionObject()

    //直接利用类名进行对象的创建，这种方式实际上是调用前面的apply方法进行实现，这种方式的好处是避免了自己手动new去创建对象
    val s1=Student("john",29)
    println(s1.name)
    println(s1.age)
  }

}

//scala中的抽象类定义
abstract class Animal {
  //抽象字段(域）
  //前面我们提到，一般类中定义字段的话必须初始化，而抽象类中则没有这要求
  var height:Int
  def eat:Unit
}

class Dog(var height:Int) extends Animal{
  override def eat: Unit = {
    println("eat")
  }
}


//扩展App后，程序可以直接运行，而不需要自己定义main方法，代码更简洁
//通过扩展App创建程序的入口
object Dog extends App{
  new Dog(1).eat
}

