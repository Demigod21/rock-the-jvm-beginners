package lectures.part2oop

object AbstractDataTypes extends App {

  // abstract
  abstract class Animal {
    val creatureType: String = "wild"
    def eat: Unit
  }

  class Dog extends Animal {
    override val creatureType: String = "Canine"
    def eat: Unit = println("crunch crunch")
  }


  // traits
  trait Carnivore {
    def eat(animal: Animal) : Unit
    def preferredMeal : String = "meat"
  }

  class Crocodile extends Animal with Carnivore {
    override val creatureType: String = "croc"
    def eat: Unit = "nom nom"
    def eat(animal: Animal): Unit = s"I'm a croc and i'm eating a ${animal.creatureType}"
  }

  val dog = new Dog
  val croc = new Crocodile

  croc eat dog

  // traits vs abastract classes
  // both have abstract and non abstract members
  // 1 - tratis do not have constructor paramethers
  // 2 - you can extends ONE class, but have WITH multiple traits
  // 3 - traits = behaviour ----- abstract class = type of thing

}
