package neal.scala

object ApplyTest {

  class Apply{
    def apply() = {
      println("I am into Scala so much!")
    }

    def haveTry() = {
      println("Hava a try on apply!")
    }
  }

  object Apply{
    def apply() = {
      println("I am also into Scala so much!")
      new Apply
    }
  }

  def main(args: Array[String]): Unit = {

    val a = Apply()
    a.haveTry()
    a()
  }

}



