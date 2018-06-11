package neal.scala

object BasicTest {

  def gcdLoop(x: Long, y: Long): Long = {
    var a = x
    var b = y
    while (a != 0) {
      val temp = a
      a = b % a
      b = temp
    }
    b
  }

  def gcd(x: Long, y: Long): Long =
    if (y == 0) x else gcd(y, x % y)


  def main(args: Array[String]): Unit = {
    val x = 0x29
    print(x)
    val floatNumber = 0.314529e1
    print(floatNumber)

    val s = """ hello cruel world, \n \\\\ \b \\, I am " experienced" programmer"""
    print(s)

    var sumVlaue = (1).+(2)
    var sum = 1 + 2

    print(sumVlaue)
    print(sum)

    println("shift")
    //无符号右移（shift left）
    //11111111111111111111111111111111
    //00000000000000000000000000000001
    println(-1 >>> 31)


    //右移位（shift left）
    //00000110
    //00000011
    println(6 >> 1)
    println(-6 >> 1)
    println(-6 >>> 1)


    //左移位（shift left）
    //00000110
    //00001100
    println(6 << 1)

    println(-6 << 1)



    val z= if("hello"=="hell")  1 else 0
    val y= if("hello"=="hello")  1 else 0
    println(z)
    println(y)


    println(gcdLoop(1,2))

    println(gcd(1,2))


    val filesHere = (new java.io.File(".")).listFiles
    for (file <- filesHere if file.getName.endsWith(".scala"))
      println(file)

    def fileLines(file: java.io.File) =
      scala.io.Source.fromFile(file).getLines.toList


    def grep(pattern: String) =
      for (
        file <- filesHere
        if file.getName.endsWith(".scala");
        line <- fileLines(file)
        if line.trim.matches(pattern)
      ) println(file +": "+ line.trim)


  }

}
