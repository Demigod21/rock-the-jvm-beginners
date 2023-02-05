package lectures.part2oop

object Objects extends App{

  //scala does not have static class-level functionality

  object Person { //type and instance
    // static class - level functionality
    val N_EYES = 2

    //factory method
    def apply(mother: Person, father: Person) : Person = new Person("child")
  }

  class Person (val name: String) {
    // instance level funzionality
  }
  //COMPANION

  // scala object ) singleton instance
  val mary = Person
  val john = Person
  mary == john // TRUE


  val mary2 = new Person("Maruy")
  val john2 = new Person("John")
  mary2 == john2 //FALSE

  val child = Person(mary2, john2)

  // Scala Applications = Scala Object with
  // def main(args: Array[String]) : Unit

}
