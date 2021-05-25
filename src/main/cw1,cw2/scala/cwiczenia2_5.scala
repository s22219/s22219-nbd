object cwiczenia2_5 extends App {
  // zadanie 5
  abstract class Osoba(val imie: String, val nazwisko: String) {
    var pensja: Double = 1000.0
    def podatek: Double
  }
  trait Student extends Osoba {
    override def podatek = 0.0
  }
  trait Nauczyciel extends Osoba {
    override def podatek: Double = pensja * 0.1
  }
  trait Pracownik extends Osoba {
    override def podatek: Double = pensja * 0.2
  }

  var student = new Osoba("Jan", "B") with Student
  val pracownik = new Osoba("Max", "R") with Pracownik
  pracownik.pensja = 100

  var nauczyciel = new Osoba("Rafał", "L") with Nauczyciel
  nauczyciel.pensja = 100

  var nauczyciel_pracownik = new Osoba("Nauczyciel", "Pracownik") with Nauczyciel with Pracownik
  var pracownik_nauczyciel = new Osoba("Nowy", "Elo") with Pracownik with Nauczyciel

  println()
  println ("zadanie 5, podatek studenta: " + student.podatek)
  println ("zadanie 5, podatek pracownika o pensji 100: " + pracownik.podatek)
  println ("zadanie 5, podatek nauczyciela o pensji 100: " + nauczyciel.podatek)
  println ("zadanie 5, podatek nauczyciela i pracownika o pensji 1000: " + nauczyciel_pracownik.podatek)
  println ("zadanie 5, podatek pracownika i nauczyciela o pensji 1000: " + pracownik_nauczyciel.podatek)


}
