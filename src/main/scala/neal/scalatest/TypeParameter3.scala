package neal.scalatest


//用+标识泛型T，表示List类具有协变性
class List[+T](val head: T, val tail: List[T]) {
  //将函数也用泛型表示
  //因为是协变的，输入的类型必须是T的超类
  def prepend[U >: T](newHead: U): List[U] = new List(newHead, this)

  override def toString() = "" + head
}

object NonVariance {
  def main(args: Array[String]): Unit = {
    val list: List[Any] = new List[String]("摇摆少年梦", null)
    println(list)


    val invaildDomain = List(124, 112, 113, 114, 115, 116, 117, 118, 119, 123, 125, 135, 136, 137, 127, 128, 587, 588, 589, 590, 591, 592, 593, 594)


    val map = Map(
      507 -> 331025,
      120 -> 3518550,
      544 -> 37265,
      541 -> 23592,
      519 -> 257,
      526 -> 81994,
      552 -> 9426,
      121 -> 46463067,
      523 -> 36,
      110 -> 12486572,
      104 -> 2016888,
      556 -> 28409,
      139 -> 2413247,
      132 -> 720381,
      512 -> 9879,
      134 -> 348860,
      107 -> 139579,
      509 -> 11227,
      516 -> 12315,
      527 -> 22218,
      553 -> 6128,
      103 -> 1004132,
      548 -> 42686,
      522 -> 268,
      550 -> 678,
      572 -> 224717,
      533 -> 2727282,
      138 -> 1372979,
      559 -> 50062,
      530 -> 114734,
      508 -> 359852,
      561 -> 2193,
      108 -> 17726260,
      505 -> 3657357,
      106 -> 1127737,
      568 -> 5288,
      126 -> 3586477,
      557 -> 12326,
      140 -> 2820886,
      133 -> 111907,
      536 -> 15252,
      122 -> 10215,
      111 -> 113989,
      151 -> 304731,
      571 -> 284293,
      539 -> 150560,
      525 -> 201185,
      528 -> 32774,
      517 -> 1881,
      560 -> 87811,
      109 -> 678684,
      514 -> 1373,
      564 -> 133861,
      558 -> 81632,
      506 -> 65067,
      562 -> 3827,
      531 -> 743080,
      520 -> 17036,
      551 -> 4127,
      570 -> 17497,
      535 -> 7231,
      130 -> 498640,
      129 -> 1359502,
      569 -> 2621,
      105 -> 729973,
      547 -> 133162,
      518 -> 14737,
      131 -> 76508,
      543 -> 85405,
      576 -> 79,
      513 -> 2468)


    //    val map2 = Map(
    //      507 -> 331025,
    //      120 -> 3518550,
    //      544 -> 37265,
    //      541 -> 23592,
    //      124 -> 43510283,
    //      519 -> 257,
    //      526 -> 81994,
    //      100 -> 2321,
    //      552 -> 9426,
    //      128 -> 227476,
    //      121 -> 46463067,
    //      523 -> 36,
    //      110 -> 12486572,
    //      104 -> 2016888,
    //      556 -> 28409,
    //      139 -> 2413247,
    //      132 -> 720381,
    //      512 -> 9879,
    //      134 -> 348860,
    //      107 -> 139579,
    //      509 -> 11227,
    //      516 -> 12315,
    //      527 -> 22218,
    //      553 -> 6128,
    //      103 -> 1004132,
    //      548 -> 42686,
    //      522 -> 268,
    //      550 -> 678,
    //      572 -> 224717,
    //      533 -> 2727282,
    //      138 -> 1372979,
    //      559 -> 50062,
    //      530 -> 114734,
    //      127 -> 779196,
    //      508 -> 359852,
    //      561 -> 2193,
    //      108 -> 17726260,
    //      505 -> 3657357,
    //      106 -> 1127737,
    //      568 -> 5288,
    //      126 -> 3586477,
    //      557 -> 12326,
    //      140 -> 2820886,
    //      133 -> 111907,
    //      536 -> 15252,
    //      122 -> 10215,
    //      111 -> 113989,
    //      151 -> 304731,
    //      571 -> 284293,
    //      539 -> 150560,
    //      525 -> 201185,
    //      528 -> 32774,
    //      517 -> 1881,
    //      560 -> 87811,
    //      109 -> 678684,
    //      514 -> 1373,
    //      564 -> 133861,
    //      558 -> 81632,
    //      506 -> 65067,
    //      562 -> 3827,
    //      531 -> 743080,
    //      573 -> 7137,
    //      520 -> 17036,
    //      101 -> 1180,
    //      551 -> 4127,
    //      570 -> 17497,
    //      535 -> 7231,
    //      130 -> 498640,
    //      129 -> 1359502,
    //      569 -> 2621,
    //      105 -> 729973,
    //      547 -> 133162,
    //      518 -> 14737,
    //      131 -> 76508,
    //      543 -> 85405,
    //      576 -> 79,
    //      513 -> 2468,
    //      136 -> 8631771)


    println(map.values.sum)
    //println(map2.values.sum)


    val map3 = Map("5a5da9b44bcd5" -> 1,
      "58df2c66ba0c1" -> 1625448,
      "5acee13e9e630" -> 326,
      "5aceddd995f60" -> 16933,
      "5acede75c3e9f" -> 3248,
      "584e5c69efc03" -> 1,
      "5acedecca01c0 " -> 1990,
      "484e5c69efc47 " -> 579,
      "584e5c69efc57  " -> 1,
      "render_duration " -> 1,
      "5acedfbf710a4 " -> 250,
      "5acee17054f85 " -> 1499,
      "58df2c7637b14 " -> 2915763,
      "595dd4f028a84 " -> 4811,
      "58df2c7ebe7a9 " -> 3098702,
      "5a54634535991 " -> 3043,
      "4857b592b6db1 " -> 107,
      "5ab4a5b514aa6  " -> 7717,
      "5acedfa1ef52f " -> 80990,
      "59ccc8eba902a " -> 333,
      "58eb2ead71ba0 " -> 332747,
      "5acedf0b00434 " -> 1873,
      "5a7840c115d31 " -> 143576,
      "584e5c69efc47 " -> 48655629,
      "595f48107fed6 " -> 98758,
      "5acee18b8b92d " -> 303,

      "595f47fd24aab " -> 37708
      ,
      "5acee0649835c " -> 948135
      ,
      "5acee07f19922 " -> 15498
      ,
      "5aceddfecc09d " -> 68029
      ,
      "584e5c69egc47 " -> 1
      ,
      "597aab63a8073 " -> 52817
      ,
      "48df2c7ebe7a9 " -> 10
      ,
      "5857b592b6db1 " -> 24455620
      ,
      "5acedeae1b814 " -> 35
      ,
      "586e5c69efc47 " -> 2
      ,
      "4a7840c115d31 " -> 2
      ,
      "58c215ab35565 " -> 388104
      ,
      "5acedd75ad076 " -> 8320
      ,
      "587c6ed11d72b " -> 506590
      ,
      "5`ceddfecc09d " -> 3
      ,
      "584e5b69efc47 " -> 34
      ,
      "5acee034a6033 " -> 198
      ,
      "584e4c69efc47 " -> 29
      ,
      "5857b582b6db1 " -> 4
      ,
      "58te5c69efc47 " -> 1
      ,
      "59476b46b4b2f " -> 2181
      ,
      "5950600279400 " -> 3694
      ,
      "5aa790539f954 " -> 4
      ,
      "585e5c69efc47 " -> 1
      ,
      "5a0a940105e8a " -> 60017
      ,
      "5acedeeb22f01 " -> 4187
      ,
      "584e5c69dfc47 " -> 23
      ,
      "58df2c7ebe6a9 " -> 7
      ,
      "5acedfefc4b70 " -> 17217
      ,
      "584u5c69gfc47 " -> 1
      ,
      "58df2c7ebe7a8 " -> 5
      ,
      "5acee0faa7613 " -> 42316
      ,
      "5b18a813803cf " -> 1
    )

    println(map3.values.sum)

    println(map.filterKeys(x => !invaildDomain.contains(x)).values.sum + map3.values.sum)
    //println(map2.values.sum+map3.values.sum)


  }
}

object TypeParameter3 {

}

//声明逆变
class Person22[-A] {
  def test(x: A) {}
}

//声明协变，但会报错
//covariant type A occurs in contravariant position in type A of value x
//class Person3[+A]{ def test(x:A){} }
