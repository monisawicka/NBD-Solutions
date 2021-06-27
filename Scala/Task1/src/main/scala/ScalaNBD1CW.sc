import org.graalvm.compiler.api.replacements.Fold
import org.graalvm.compiler.core.common.util.IntList

import scala.::
import scala.annotation.tailrec

// Zadanie 1
val dniTygodnia = List("Poniedzialek", "Wtorek", "Sroda", "Czwartek", "Piatek", "Sobota", "Niedziela")

// Pętla FOR (pkt.A)
def PetlaFor(dniTygodnia: List[String]): String = {
  val result = new StringBuilder
  for (dzien <- dniTygodnia) {
    if (result.isEmpty) {
      result.append(dzien)
    } else {
      result.append(",")
      result.append(dzien)
    }
  }
  result.toString
}

println(PetlaFor(dniTygodnia))

// Petla FOR tylko P (pkt.B)
def PetlaForP(dniTygodnia: List[String]): String = {
  val result = new StringBuilder
  for (dzien <- dniTygodnia.filter(_.startsWith("P"))) {
    if (result.isEmpty) {
      result.append(dzien)
    } else {
      result.append(",")
      result.append(dzien)
    }
  }
  result.toString
}

println(PetlaForP(dniTygodnia))

// Petla while (pkt.B)

def PetlaWhile(dniTygodnia: List[String]): String = {
  val result = new StringBuilder(dniTygodnia.head)
  var i = 1
  while (i < dniTygodnia.size) {
    result.append(",")
    result.append(dniTygodnia(i))
    i += 1
  }
  result.toString
}

println(PetlaWhile(dniTygodnia))

//Zadanie2
//Funkcja rekurencyjna (pkt.A)
def RekurencyjnaFUN(myList: List[String]): String = {
  if (myList.isEmpty) ""
  else if (myList.size == 1) myList.head
  else myList.head + "," + RekurencyjnaFUN(myList.tail)
}

println(RekurencyjnaFUN(dniTygodnia))

//Funkcja rekurencyjna od końca(pkt.B)
def RekurencyjnaFUNodtylu(myList: List[String]): String = {
  if (myList.isEmpty) ""
  else if (myList.size == 1) myList.head
  else RekurencyjnaFUNodtylu(myList.tail) + "," + myList.head
}

println(RekurencyjnaFUNodtylu(dniTygodnia))

// Zadanie 3
// Pkt.A
@tailrec
def wypiszDniTygodniaTailRec(dniTygodnia: List[String], result: String = ""): String =
  dniTygodnia match {
    case head :: tail if result.isEmpty => wypiszDniTygodniaTailRec(tail, result + head)
    case head :: tail => wypiszDniTygodniaTailRec(tail, result + "," + head)
    case Nil => result
  }
println(wypiszDniTygodniaTailRec(dniTygodnia))

// Pkt.B
@tailrec
def wypiszDniTygodniaTailRecReverse(dniTygodnia: List[String], result: String = ""): String =
  dniTygodnia match {
    case head :: tail if result.isEmpty => wypiszDniTygodniaTailRecReverse(tail, head + result)
    case head :: tail => wypiszDniTygodniaTailRecReverse(tail, head + "," + result)
    case Nil => result
  }
println(wypiszDniTygodniaTailRecReverse(dniTygodnia))



// Zad4
// Punkt A
def MetodaFoldL(dniTygodnia: List[String]) =
  dniTygodnia.tail.foldLeft(dniTygodnia.head)((acc, dzien) => acc + "," + dzien)
println(MetodaFoldL(dniTygodnia))

// Punkt B
def MetodaFoldR(dniTygodnia: List[String]) =
  dniTygodnia.init.foldRight(dniTygodnia.last)((acc, dzien) => acc + "," + dzien)
println(MetodaFoldR(dniTygodnia))

// Punkt C
def MetodaLFilter(dniTygodnia: List[String]) = {
  val p = dniTygodnia.filter(_.startsWith("P"))
  p.tail.foldLeft(p.head)((acc, dzien) => acc + "," + dzien)
}

println(MetodaLFilter(dniTygodnia))

//Zadanie 5 produkty i obniżka
val produkty = Map("Jabko" -> 10, "Banany" -> 12, "Kiwi" -> 44)

val Obnizka = produkty.map { case (produkt, cena) => (produkt, cena * 0.9) }
println(Obnizka)

//Zadanie 6
def Zad6(tup: (String, Int, Any)) = {
  println(tup._1)
  println(tup._2)
  println(tup._3)
}

val produkt = "Kiwi"


//Zadanie 7
val price: Option[Double] = Obnizka.get(produkt)
price.map(cena => s"znizka na $produkt - cena $cena").foreach(println)

//Zadanie 8
@tailrec
def usunZero(input: List[Int], result: List[Int] = List[Int]()): List[Int] = input match {
  case head :: tail if head == 0 => usunZero(tail, result)
  case head :: tail => usunZero(tail, result :+ head)
  case Nil => result
}
println(usunZero(List(1, 0, 2, 0, 3, 0, 4, 0, 5, 0)))


//Zadanie 9
val lCalkowite = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
def plusjeden(calkowite: List[Int]): List[Int] = calkowite.map(_ + 1)
println(lCalkowite)
println(plusjeden(lCalkowite))

//Zadanie 10
val liczbyRzeczywiste = List(-10, -8, -6, -4, -2, -1, 1, 2, 3, 10, 85, 14)

def od5dos12(numbers: List[Int]) = numbers
  .filter(_ >= -5)
  .filter(_ <= 12)
  .map(_.abs)

println(od5dos12(liczbyRzeczywiste))



