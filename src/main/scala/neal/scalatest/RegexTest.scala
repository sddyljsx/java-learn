package neal.scalatest

object RegexTest {

  def main(args: Array[String]): Unit = {
    val sparkRegex="(86)*0*13\\d{9}".r
    for(matchString <- sparkRegex.findAllIn("13887888888"))
    {
      println(matchString)
    }


    val ipRegex="(\\d+)\\.(\\d+)\\.(\\d+)\\.(\\d+)".r
    for(ipRegex(one,two,three,four) <- ipRegex.findAllIn("192.168.1.1"))
    {
      println("IP子段1:"+one)
      println("IP子段2:"+two)
      println("IP子段3:"+three)
      println("IP子段4:"+four)
    }


    val sparkRegexa="^([\\w-]+(\\.[\\w-]+)*)@[\\w-]+(\\.[\\w-]+)+$".r
    for(sparkRegexa(domainName,_*) <- sparkRegexa.findAllIn("aa@sina.com"))
    {
      println(domainName)
    }




  }

}
