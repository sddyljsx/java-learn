package neal.scalatest

object FunctionTest {

  def main(args: Array[String]) {

    Map("spark"->1,"hive"->2,"hadoop"->3).map(_._1)
    Array(1,2,4,3,5).filter(_>3)


    val x = Array(1,2,4,3,5).reduce(_+_)
    println(x)

    val y = Array(1,2,4,3,5).foldRight(0)((x:Int,y:Int)=>{println(x,y);x+y})
    println(y)

    val z = Array(1,2,4,3,5).foldRight(10)(_+_)
    println(z)

    val x1=Array(1,2,4,3,5).scanRight(0)((x:Int,y:Int)=>{println(x,y);x+y})
    println(x1(0))

    def multiplyBy(factor:Double)(x:Double)=x*factor
    println(multiplyBy(12)(9))

    Array("Hadoop","Hive","Spark").foreach(println)


    def sum(x:Int,y:Int,z:Int)=x+y+z

    val s2=sum(1,_:Int,3)
    println(s2(2))



  }

}
