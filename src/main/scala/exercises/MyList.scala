package exercises

abstract class MyList[+A] {

  /*
    head = int 0 first element of the list
    tail = remainder of the list
    single linked list
    isEmpty : boolean
    add(Int) => new List with element added
    toString => string rappresentation
   */

  def head : A
  def tail : MyList[A]
  def isEmpty : Boolean
  def add[B >: A] (element: B) : MyList[B]

  def printElements: String
  override def toString: String = "[" + printElements + "]"

  // hihger-order funcionts
  def map[B](transformer: A => B ) : MyList[B]
  def flatMap[B](transformer: A => MyList[B]) : MyList[B]
  def filter(predicate: A => Boolean) : MyList[A]
  def ++[B >: A](list: MyList[B]) : MyList[B]

  def foreach(f: A=> Unit): Unit

  def sort(compare: (A, A) => Int) : MyList[A]

  def zipWith() = ???

  def fold() = ???

}


case object Empty extends MyList[Nothing] {
  def head : Nothing = throw new NoSuchElementException()
  def tail : MyList[Nothing] = throw new NoSuchElementException()
  def isEmpty : Boolean = true
  def add[B >: Nothing] (element: B) : MyList[B] = new Cons(element, Empty)

  override def printElements: String = ""

  def map[B](transformer: Nothing => B) : MyList[B] = Empty
  def flatMap[B](transformer: Nothing => MyList[B]) : MyList[B] = Empty
  def filter(predicate: Nothing => Boolean) : MyList[Nothing] = Empty
  def ++[B >: Nothing](list: MyList[B]) : MyList[B] = list

  def foreach(f: Nothing => Unit): Unit = ()
  def sort(compare: (Nothing, Nothing) => Int) : MyList[Nothing] = Empty

}

case class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {
  def head : A = h
  def tail : MyList[A] = t
  def isEmpty : Boolean = false
  def add[B >: A] (element: B) : MyList[B] = new Cons(element, this)

  override def printElements: String = {
    if(t.isEmpty) "" + h
    else h + " " + t.printElements
  }

  def ++[B >: A](list: MyList[B]) : MyList[B] = new Cons(h, t ++ list)


  def map[B](transformer: A => B) : MyList[B] = {
    new Cons(transformer(h), t.map(transformer))
  }

  def flatMap[B](transformer: A => MyList[B]) : MyList[B] = transformer(h) ++ t.flatMap(transformer)

  def filter(predicate: A => Boolean ) : MyList[A] = {
    if(predicate(h)) new Cons(h, t.filter(predicate))
    else t.filter(predicate)
  }
  /*
      - foreach method  A => Unit apply this function to every element
    [1,2,3] foreach(x => println(x)

    - sort function((A, A) => Int)  => MyList
    [1, 2, 3].sort(x, y) => y - x)    => 3, 2, 1

    - zipWith (list, (A,A) => B) MyList[B]
    [1,2,3].zip([4,5,6], x*y) => 1*4, 2*5, 3*6

    - fold(start)(function) => a value
    [1,2,3].fold(0)(x+y) = 6
   */
  def foreach(f: A => Unit): Unit = {
    f(h)
    t.foreach(f)
  }

  def sort(compare: (A, A) => Int) : MyList[A] = {

  }

  def zipWith() = ???

  def fold() = ???


}

/*trait MyPredicate[-T] {  // T => Boolean
  def test(elem: T) : Boolean
}

trait MyTransformer[-A, B] { // A => B
  def test(elem: A) : B
}*/


object ListTest extends App{
  var listOfIntegers: MyList[Int] = Empty
  var listOfString: MyList[String] = Empty

  println(listOfIntegers.map(elem => elem * 2).toString)
  println(listOfIntegers.filter(elem => elem % 2 == 0).toString)


}