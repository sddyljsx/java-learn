package neal.scalatest

object CaseTest {
  def main(args: Array[String]) = {
    for (i <- 1 to 100) {
      i match {
        case 10 => println(10)
        case 50 => println(50)
        case 80 => println(80)
        case _ =>
      }
    }


    //case class 会自动生成apply方法，从而省去new操作
    val pp:Personb=Studentb("john",18,1024)
    //match case 匹配语法
    pp  match {
      case Studentb(name,age,studentNo)=>println(name+":"+age+":"+studentNo)
      case Teacherb(name,age,teacherNo)=>println(name+":"+age+":"+teacherNo)
      case Nobodyb(name)=>println(name)
    }


//    val sc=SchoolClass("学途无忧网Scala培训班",Teacher("摇摆少年梦",27,2015),Student("摇摆少年梦",27,2015))
//    sc match{
//      case SchoolClass(_,_,Student(name,age,studetNo))=>println(name)
//      case _ => println("Nobody")
//    }

    val p=List("spark","hive","SparkSQL")
    def sequencePattern(p:List[String])=p match {
      //只需要匹配第二个元素
      case List(_,second,_*) => second
      case _ => "Other"
    }
  }
}


//抽象类Person
abstract class Personb

//case class Student
case class Studentb(name:String,age:Int,studentNo:Int) extends Personb
//case class Teacher
case class Teacherb(name:String,age:Int,teacherNo:Int) extends Personb
//case class Nobody
case class Nobodyb(name:String) extends Personb

