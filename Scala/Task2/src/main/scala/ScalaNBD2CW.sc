/// NBD 2
/// Zadanie 1
def Dni(x: String): String = x match {
  case "Poniedzialek" => "Praca"
  case "Wtorek" => "Praca"
  case "Sroda" => "Praca"
  case "Czwartek" => "Praca"
  case "Piatek" => "Praca"
  case "Sobota" => "Weekend"
  case "Niedziela" => "Weekend"
  case _ => "Nie ma takiego dnia"
}
println(Dni("Poniedzialek"))
println(Dni("Sobota"))
println(Dni("Majowka"))

/// Zadanie 2
class KontoBankowe(saldo: Double) {
  private var _stanKonta: Double = saldo
  def stanKonta: Double = _stanKonta
  def this() {
    this(0)
  }

  def wplaty(kwota: Double): Double = {
    _stanKonta = _stanKonta + kwota
    _stanKonta
  }


  def rozchody(kwota: Double): Double = {
    _stanKonta = _stanKonta - kwota
    _stanKonta
  }
}

val saldo1 = new KontoBankowe(1000000)

println(saldo1.stanKonta) //Początkowy stan Konta
println(saldo1.wplaty(50000)) // wplaty
println(saldo1.rozchody(2)) // rozchod

/// Zadanie 3
case class Osoba(var Imie: String, var Nazwisko: String)

def show(osoba: Osoba): String = {
  osoba match {
    case Osoba("Piotr", "Warszawski") => "Czesc"
    case Osoba("Pawel", "Gdanski") => "Halko"
    case Osoba("Monika", "Sawicka") => "Siemka"
    case _ => "Dzien dobry"
  }
}

val p1 = Osoba("Piotr", "Warszawski")
val p2 = Osoba("Pawel", "Gdanski")
val p3 = Osoba("Monika", "Sawicka")
val p4 = Osoba("Piotr", "Kowalski")

println(show(p1))
println(show(p2))
println(show(p3))
println(show(p4))


// Zadanie 4
def zad4(number: Int, liczba: Int => Int): Int = {
  liczba(liczba(liczba(number)))
}

val number = 100000
def minus(num: Int): Int = num - 1
println(zad4(number, minus))

// Zadanie 5


case class Osoba1(private val imie: String, private val nazwisko: String, val podatek: Double = 0d)

trait Pracownik extends Osoba1 {
  override val podatek: Double = 0.2

  def pensja: Double = 0
}

trait Student extends Osoba1 {
  override val podatek: Double = 0
}

trait Nauczyciel extends Pracownik {
  override val podatek: Double = 0.1
}

val ludek0 = new Osoba1("Monika", "Sawicka") with Student
println(s"Podatek studenta: ${ludek0.podatek}%")

val ludek1 = new Osoba1("Pawel", "Pawlowski") with Pracownik
println(s"Podatek studenta: ${ludek1.podatek}%")

val ludek2 = new Osoba1("Mariusz", "Warszawski") with Nauczyciel
println(s"Podatek studenta: ${ludek2.podatek}%")

val ludek3 = new Osoba1("Janek", "Wroclawski") with Nauczyciel with Pracownik
println(s"Podatek nauczyciela pracownika: ${ludek3.podatek}%")

val ludek4 = new Osoba1("Tomek", "Tomkowski") with Pracownik with Nauczyciel
println(s"Podatek pracownika nauczyciela: ${ludek4.podatek}%")


















