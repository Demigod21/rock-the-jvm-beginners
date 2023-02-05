package lectures.part2oop

object Inheritance extends App {

  //single class inheritance
  class Animal {
    protected val creatureType = "wild"
    def eat = println("nomnom")
  }

  class Cat extends Animal {
    def crunch = {
      eat
    }
  }

  val cat = new Cat
  cat.crunch

  //constructor
  class Person(name: String, age: Int){
    def this(name: String) = this(name, 0)
  }
  class Adult(name: String, age: Int, idCard: String) extends Person(name)

  //overriding
  class Dog(override val creatureType: String) extends Animal {
    override def eat: Unit = {
      super.eat //SUPER
      println("Crunch")
    }
  }

  val dog = new Dog("Domestic")

  //type substition
  val unknownAnimal: Animal = new Dog("K9")
  unknownAnimal.eat //Crunch di DOG


  //overRIDING vs overLOADING

  // preveting over rides
  // 1 - use final keyword on the method/val
  // 2 - use final on the class
  // 3 - seal the class = extend class in THIS FILE but prevents in other files


}
