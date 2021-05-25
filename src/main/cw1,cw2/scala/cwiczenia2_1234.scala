import cwiczenia2_1234.{list}

object cwiczenia2_1234 extends App {
  val list = List("Poniedziałek", "Wtorek", "Środa", "Czwartek", "Piątek", "Sobota", "Niedziela")

  // pattern matching
  def zadanie1(param: String): String = param match{
    case "Poniedziałek" | "Wtorek" | "Środa" | "Czwartek" | "Piątek" => "Praca"
    case "Sobota" | "Niedziela" => "Weekend"
    case _ => "Nie ma takiego dnia"
  }
  println("zadanie 1, argument Poniedziałek: \n" + zadanie1(list(0)))
  println("zadanie 1, argument Niedziela: : \n" + zadanie1(list(6)))
  println("zadanie 1, argument Ponieśroda: \n" + zadanie1("Ponieśroda"))

  // zadanie2
  class KontoBankowe(private var stanKonta: Double) {
    def this() {
      this(0.0)
    }
    def getStanKonta = stanKonta
    def wplata(kwota: Double) = stanKonta += kwota
    def wyplata(kwota: Double) = stanKonta -= kwota
  }
  def zadanie2() {
    val konto20 = new KontoBankowe (20.0)
    val konto0 = new KontoBankowe ()
    println ("zadanie 2, konstruktor przyjmujący początkowy stan konta: " + konto20.getStanKonta)
    println ("zadanie 2, konstruktor zerujący początkowy stan konta: " + konto0.getStanKonta)
    konto0.wplata(100.0)
    println ("zadanie 2, stan konta po wpłacie 100 PLN: " + konto0.getStanKonta)
    konto0.wyplata(5.0)
    println ("zadanie 2, stan konta po wypłacie 5 PLN: " + konto0.getStanKonta)
  }
  println()
  zadanie2()

  // zadanie3
  case class Osoba(imie: String, nazwisko: String) { }
  def zadanie3() {
    val student = new Osoba ("Jan", "Bobek")
    val profesor = new Osoba ("Michał", "Tupak")
    val obcy = new Osoba ("Mateusz", "Dzban")
    def przywitaj(osoba: Osoba): String = osoba match{
      case Osoba("Michał", "Tupak") => "Dzień dobry profesorze Tupak."
      case Osoba("Jan", "Bobek") => "Siemano Janek!"
      case Osoba(imie, nazwisko) => s"Cześć $imie."
     }
    println ("zadanie 3, przywitanie studenta: " + przywitaj(student))
    println ("zadanie 3, przywitanie profesora: " + przywitaj(profesor))
    println ("zadanie 3, przywitanie obcej osoby: " + przywitaj(obcy))
  }
  println()
  zadanie3()

  // zadanie4
  def add(x: Int): Int = x + x
  def zadanie4(x: Int, fun: Int => Int ) = fun(fun(fun(x)))
  println ("zadanie 4: 3*2*2*2: \n" + zadanie4(3, add))


}
