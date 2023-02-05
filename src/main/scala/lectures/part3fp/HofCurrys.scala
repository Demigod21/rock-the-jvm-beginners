package lectures.part3fp

object HofCurrys extends App {

  // higher order functions

  // map flatmap filter

  //function that applies a function n times over a x value
  // ntimes(f, n, x)
  // nTimes(f, 3, x) = f(f(f(x))) = nTimes(f, 2, f(x)) = f(f(f(x)))
  //nTimes (f, n, x) = f(f(...(x))) = nTimes(f, n-1, f(x))

  def nTimes(f: Int => Int, n: Int, x: Int) : Int = {
    if(n <= 0) x
    else nTimes(f, n-1, f(x))
  }

  val plusOne = (x:Int) => x + 1

  println(nTimes(plusOne, 10, 1))

  // ntb(f, n) ) x => f(f(f...(x)))
  // increment10 = ntb(plusOne, 10) = x => plusOne(plusOne...(x))
  // val y = incremenet10(1)
  def nTimesBetter(f: Int => Int, n: Int): (Int => Int) = {
    if(n <= 0) (x:Int) => x
    else (x: Int) => nTimesBetter(f, n-1)(f(x))
  }

  val plus10 = nTimesBetter(plusOne, 10)
  println(plus10(1))

  // curried function
  val superAdder: Int => (Int => Int) = (x: Int) => (y: Int) => x + y
  val add3 = superAdder(3)
  println(add3(10))
  println(superAdder(3)(10))

  //function with multiple parameter lists
  def curriedFormatter(c: String)(x: Double) : String = c.format(x)
  val standardFormat: (Double => String) = curriedFormatter("%4.2f")
  val preciseFormat: (Double => String) = curriedFormatter("%10.8f")

  println(standardFormat(Math.PI))
  println(preciseFormat(Math.PI))

  /*
  1. expand my list
    - foreach method  A => Unit apply this function to every element
    [1,2,3] foreach(x => println(x)

    - sort function((A, A) => Int)  => MyList
    [1, 2, 3].sort(x, y) => y - x)    => 3, 2, 1

    - zipWith (list, (A,A) => B) MyList[B]
    [1,2,3].zip([4,5,6], x*y) => 1*4, 2*5, 3*6

    - fold(start)(function) => a value
    [1,2,3].fold(0)(x+y) = 6

    2. toCurry(f: (Int, Int) => Int) => (Int => Int => Int)
    fromCurry(Int => Int => Int) => (Int,Int) => Int

    3. compose(f, g) => x => f(g(x))
    andThen(f, g) => x => g(f(x))

   */


}
