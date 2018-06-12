package neal.scala

/**
  *
  *修饰符	访问范围
无任何修饰符	任何地方都可以使用
private[scala]	在定义的类中可以访问，在scala包及子包中可以访问
private[this]	只能在定义的类中访问，即使伴生对象也不能访问团
private	在定义的的类及伴生对象中可以访问，其它地方不能访问
protected[scala]	在定义的类及子类中可以访问，在scala包及子包中可以访问，
protected[this]	只能在定义的类及子类中访问，即使伴生对象也不能访问
protected	在定义的类及子类中访问，伴生对象可以访问，其它地方不能访问
  */
class ImportTest(var name: String, var age: Int) {
  private var sex: Int = 0

  //内部类
  class Course(val cName: String, val gpa: Float) {
    //可以直接访问其外部类的私有成员
    def getStudentSex(student: Student) = student.sex
  }

}

//班级类
class Class {
  //下面这条语句统计通不过，因为sex是私有的
  // def getStudentSex(student:Student)=student.sex
}

object ImportTest {
  private var studentNo: Int = 0

  def uniqueStudentNo() = {
    studentNo += 1
    studentNo
  }

  def apply(name: String, age: Int) = new Student(name, age)

  def main(args: Array[String]): Unit = {
    println(Student.uniqueStudentNo())
    val s = new Student("john", 29)
    //直接访问伴生类Student中的私有成员
    println(s.sex)

    val s1 = Student("john", 29)
    println(s1.name)
    println(s1.age)

    //使用内部类
    val c1 = new s1.Course("Scala", 3.0f)

  }
}


package scala{
  //private[scala]限定Utils只能在scala及子包中使用
  private[scala] object Utils{
    def toString(x:String){
      println(x)
    }
    def getTeacher():ImportTest=new ImportTest("a",1)

  }
  package xtwy{
    class Teacher(var name:String) {
      def printName()={Utils.toString(name)}
    }

  }
}



class Teacher(var name: String) {
  private[this] def printName(tName:String="") :Unit= { println(tName) }
  //调用private[this] printName方法
  def print(n:String)=this.printName(n)
}

object Teacher{
  //private[this]限定的成员，即使伴生对象Teacher也不能使用
  //def printName=new Teacher("john").printName()
}


//利用package关键字定义单例对象
package object Math {
  val PI=3.141529
  val THETA=2.0
  val SIGMA=1.9
}

class Coputation{
  def computeArea(r:Double)=Math.PI*r*r
}