package lectures.part2oop

object CaseClasses extends App{

  case class Person(name: String, age: Int)
  //1 CLASS PARAMETERS ARE FIELDS
  val jim = new Person("Jim", 34)

  // 2 SENSIBLE TO STRING
  println(jim)

  //3 EQUALS AND HASCHODE IMPLEMENTED OOB
  val jim2 = new Person("Jim", 34)
  println(jim == jim2) //true

  //4 CC have copy method
  val jim3 = jim.copy(age = 45)

  //5 CC have companion object
  val thePerson = Person
  val mary = Person("Mary", 23)

  //6 CC ARE SERIALIZABLE AKKA

  //7 CC HAVE EXTRACTOR PATTERNS = CAN BE USED TO PATTERN MATCHING
  case object UnitedKingdom {
    def name : String = "The UK of GB in NI"
  }


}
