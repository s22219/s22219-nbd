import scala.annotation.tailrec

object cwiczenia1 extends App {
  val list = List("Poniedziałek", "Wtorek", "Środa", "Czwartek", "Piątek", "Sobota", "Niedziela")

  // for
  def zadanie1_a(list: List[String]): String = {
    var tydzien = list.head
    for (n <- list.tail) {
        tydzien += "," + n
    }
    tydzien
  }
  println("zadanie 1.a: \n" + zadanie1_a(list))

  // for + P
  def zadanie1_b(list: List[String]): String = {
    val filteredList = list.filter(_.startsWith("P"))
    var tydzien = filteredList.head
      for (n <- filteredList.tail) {
          tydzien += "," + n
      }
      tydzien
  }
  println("zadanie 1.b: \n" + zadanie1_b(list))

  // while
  def zadanie1_c(list: List[String]): String = {
    var tydzien = list.head
    var i = list.tail
    while (!i.isEmpty) {
        tydzien += "," + i.head
        i = i.tail
    }
    tydzien
  }
  println("zadanie 1.c: \n" + zadanie1_c(list))

  // rekurencja
  def zadanie2_a(list: List[String]): String = {
    if(list.isEmpty) ""
    else list.head + "," + zadanie2_a(list.tail)
  }
  println("zadanie 2.a: \n" + zadanie2_a(list))

// rekurencja od końca
  def zadanie2_b(list: List[String]): String = {
    if(list.isEmpty) ""
    else list.last + "," + zadanie2_b(list.take(list.size - 1))
  }
  println("zadanie 2.b: \n" + zadanie2_b(list))

  // rekurencja ogonowa
  @tailrec def zadanie3(current: String, list: List[String]): String = {
    if(list.isEmpty) current.drop(1)
    else zadanie3(current + "," + list.head, list.tail)
  }
  println("zadanie 3: \n" + zadanie3("", list))

  // foldl
  def zadanie4_a(list: List[String]): String = {
    list.foldLeft("")(_+","+_).drop(1)
  }
  println("zadanie 4.a: \n" + zadanie4_a(list))

  // foldr
  def zadanie4_b(list: List[String]): String = {
    list.foldRight("")(_+","+_).dropRight(1)
  }
  println("zadanie 4.b: \n" + zadanie4_b(list))

  // foldl + dni na P
  def zadanie4_c(list: List[String]): String = {
    list.filter(_.startsWith("P")).foldLeft("")(_+","+_).drop(1)
  }
  println("zadanie 4.c: \n" + zadanie4_c(list))

  // mapa z produktami i 10% obnizka
  def zadanie5(products: Map[String, Double]): Map[String, Double] = {
    products.map(p => (p._1, p._2 * 0.9))
  }
  println("zadanie 5: \n" + zadanie5(Map("Mleko" -> 3,"Chleb" -> 2)))

  // tuple / krotki
  def zadanie6[T1, T2, T3] (tuple: Tuple3[T1, T2, T3]) = {
    println("Krotka1: " + tuple._1 + ", Krotka2: " + tuple._2 + ", Krotka3: " + tuple._3)
    "Krotka1: " + tuple._1 + ", Krotka2: " + tuple._2 + ", Krotka3: " + tuple._3
  }
  println("zadanie 6: \n" + zadanie6(Tuple3(1, "ABC", 0.7)))

  // option
  val students = Map("s001" -> "Kowalski", "s002" -> "Biedron")
  def zadanie7 (student: Option[String]) = student match {
    case Some(student) => student
    case None => "Nie ma takiego numeru"
  }
  println("zadanie 7 - dobry numer: \n" + zadanie7(students.get("s001")))
  println("zadanie 7 - błędny numer: \n" + zadanie7(students.get("s003")))

  // rekurencja + usuwanie 0
  val lista = List (0, 1, 0, 2, 0, 0, 3)
  def zadanie8(list: List[Int]): List[Int] = {
    if(list.isEmpty) Nil
    else if(list.head == 0 ) zadanie8(list.tail)
    else list.head :: zadanie8(list.tail)
  }
  println("zadanie 8: \n" + zadanie8(lista))

  // mapa zwiększona o 1
  def zadanie9(list: List[Int]): List[Int] = {
    list.map(element => element + 1)
  }
  println("zadanie 9: \n" + zadanie9(lista))

  // filtry + wartosc bezwzgledna
  def zadanie10(list: List[Double]): List[Double] = {
    list.filter(element => element >= -5).filter(element => element <= 12).map(element => Math.abs(element))
  }
  println("zadanie 10: \n" + zadanie10(List (1.1, -1.1, 10, -10, 13, -13, -5 )))
}
