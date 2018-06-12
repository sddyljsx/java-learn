package neal.scalatest

import scala.collection.mutable


object SetMapTupleTest {

  def main(args: Array[String]): Unit = {

    val mutableSet=mutable.Set(1,2,3,3)

    val mutableSet2=Set(1,2,3)

    mutableSet += 6

    for(i <- mutableSet){
      print(i)
    }


    val studentInfo= Map("john" -> 21, "stephen" -> 22,"lucy" -> 20)

    for( i <- studentInfo ) println(i)

    studentInfo.foreach(e=> println(e._1+":"+e._2))




    val xMap=new scala.collection.mutable.HashMap[String,Int]()
    xMap.put("spark",1)

    println(xMap.getOrElse("spark",2))
    println(xMap.getOrElse("sparkr",3))

    println(xMap.get("spark"))

    def show(x:Option[Int]) =x match{
     case Some(s) => s
     case None => "0"
    }

    println(show(xMap.get("spark")))
    println(show(xMap.get("sparkk")))



    var tuple=("Hello","China",1)
    println(tuple._1)
    val (first, second, third)=tuple
    println(second)


    var queue=scala.collection.mutable.Queue(1,2,3)

    val head = queue.dequeue

    queue.enqueue(4)

    queue += 5
    queue ++= List(6,7,8)

    println(head)


  }

}
