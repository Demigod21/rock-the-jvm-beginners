package lectures.part2oop

import scala.language.postfixOps

object MethodNotations extends App{

  class Person(val name: String, favoriteMovie: String, val age: Int = 0) {
    def likes(movie: String) : Boolean = movie == favoriteMovie
    def +(person: Person) : String = s"${this.name} is hanging out with ${person.name}"
    def unary_! : String = s"$name what the heck!"
    def isAlive : Boolean = true
    def apply() : String = "Method apply"

    def +(nickname: String) = new Person(name + nickname, favoriteMovie)
    def unary_+ : Person = new Person(name, favoriteMovie, age + 1)

    def learns(subject: String) : String = s"$name learns $subject"
    def learnsScala : String = this learns "scala"

    def apply(times: Int) : String = s"$name watch $favoriteMovie $times times"
  }

  val mary = new Person("mary", "inception")
  println(mary likes "inception")
  // infix notation = operator notation (work only with method with 1 param)
  //syntactic sugar

  // "operators" in scala
  val tom = new Person("tom", "inception")
  println(mary + tom)


  //prefix notation
  val x = -1 //quivalent with 1.unary_-
  val y = 1.unary_-

  println(!mary)
  println(mary.unary_!)
  //unary work with ! + - tilde

  //postfix notation
  println(mary.isAlive)
  println(mary isAlive)

  //apply
  println(mary.apply())
  println(mary()) //same effect


  println(mary learnsScala)


  /*
  1. overload + operator string
  mary + "rockstar" => new person "mary the rockstar"

  2. add an age to the person class
  add + operator
  +mary => mary with age incremented

  3. add a "learns" method in the person clas => "mary learns Scala"
  add a learnScala metho, calls learns method with "Scala"
  Use it in postfix notation

  4. overload apply
  receive number returns in string
  mary.apply(2) => mary watch inception 2 times

   */



}
