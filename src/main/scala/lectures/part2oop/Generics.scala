package lectures.part2oop

object Generics extends App{

  class MyList[+A]{

    def add[B >: A](element: B) : MyList[B] = ???
    /*
     A = CAT
     B = ANIMAL
     */
    // use the type A
  }

  class MyMap[Key, Value]

  val listOfInt = new MyList[Int]
  val listOfString = new MyList[String]

  // generic methods
  object MyList {
    def empty[A]: MyList[A] = ???
  }

  val emptyListOfIntegers = MyList.empty[Int]

  // variance problem
  class Animal
  class Cat extends Animal
  class Dog extends Animal

  // 1. yes List[Cat] extends List[Animal] = COVARIANCE
  class CovariantList[+A]
  val animal: Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat]
  // animalList.add(new Dog) ??? HARD QUESTION
  // should turn into a list of animals
  // def add[B >: A](element: B) : MyList[B] = ??? definizione sopra

  // 2. no = INVARIANCE
  class InvariantList[A]
  val invariantAnimalList: InvariantList[Animal] = new InvariantList[Animal] //can't be a cat or dog

  // 3. Hell, no! CONTRAVARIANCE
  class ContravariantList[-A]
  val contravariantList: ContravariantList[Cat] = new ContravariantList[Animal]

  //expand MyList to be generic


}
