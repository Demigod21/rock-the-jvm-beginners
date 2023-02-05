package lectures.part3fp

object WhatAFun extends App {

  // use functions as first class elements
  // problem : we come from an oop
  val doubler = new MyFunction[Int, Int] {
    override def apply(element: Int): Int = element * 2
  }

  // function types = Function1[A, B]
  val stringToIntConverter = new Function1[String, Int] {
    override def apply(string: String): Int = string.toInt
  }

  println(stringToIntConverter("3")+4)

  val adder: ((Int, Int) => Int) = new Function2[Int, Int, Int] {
    override def apply(v1: Int, v2: Int): Int = v1 + v2
  }

  // ALL SCALA FUNCTIONS ARE OBJECTS
  // ARE INSTANCES OF FUNCTIONS1, FUNCTIONS2, FUNCTIONS3

  /*
  1. function takes 2 strings and concates them
  2. myList transform the MyPredicate and MyTransforems in MyFunction
  3. define a function which takes an int an returns another function which takes an int and return an int
    - what's the type
    - how to do it
   */

  def concatenator: ((String, String) => String) = new Function2[String, String, String]{
    override def apply(v1: String, v2: String): String = v1 + v2
  }

  //Function1 perché prende solo un Int
  //Function1[Int, Function1[Int, Int]]
  val superAdder : Function1[Int, Function1[Int, Int]] = new Function1[Int, Function1[Int, Int]] {
    override def apply(a:Int): Function1[Int, Int] = new Function1[Int, Int] {
      override def apply(b: Int): Int = a + b
    }
  }

  val adder3 = superAdder(3) //FUNZIONE CHE ADDA 3
  println(adder3(4)) //A = 4, B= 3
  println(superAdder(3)(4)) //curried function



}

trait MyFunction[A, B] {
  def apply(element: A): B
}
