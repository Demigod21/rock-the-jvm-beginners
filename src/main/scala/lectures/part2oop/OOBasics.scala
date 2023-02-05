package lectures.part2oop

object OOBasics extends App{

  val person = new Person("John", 25)
  println(person.x)

}

class Person(name: String, val age: Int) {
  //body
  val x = 2

  println(1 + 3)

  //method
  def greet(name: String) : Unit = println(s"Hi $name")

  //overloading
  def greet() : Unit = println("Overloading")

  //multiple constructor
  def this(name: String) = this(name, 0)
  def this() = this("john doe")

}

/*
  Novel and Writer Class
  writer : first, last, year
  - method fullname
  novel : name, year release, author
  - authorAge at year of release
  - is writtenBy(author) boolean
  - copy (new year of release) = new instance of Novel
 */

/*
  Counter clas
  - receives an int value
  - method current count
  - method to increment/decrement => new counter
  - overload inc/dec to receive an amount => new counter
 */

class Writer(val name: String, val surname: String, val year: Int){

}

class Novel(val name: String, val yearRelease: Int, val author: Writer){
  def authorAge() = yearRelease - author.year

  def isWrittenBy(author: Writer) = author == this.author

  def copy(newYear: Int) = new Novel(this.name, newYear, this.author)
}


class Counter(val count: Int){

  def inc = new Counter(count + 1)

  def dec = new Counter(count - 1)

  //def increment(x: Int) = new Counter(count + x)

  //def decrement(x: Int) = new Counter(count - x)

  def inc(x: Int) : Counter = {
    if (x <= 0) this
    else inc.inc(x - 1)
  }

  def dec(x: Int) : Counter = {
    if (x <= 0) this
    else dec.dec(x - 1)
  }

}

// class parameters are NOT fields -> we need to add val