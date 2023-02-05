package lectures.part1basics

object Functions extends App {

  def aFunction(a: String, b: Int): String =
    a + "  " + b

  println(aFunction("hello", 3))

  def aParamlessFunction(): Int = 42
  println(aParamlessFunction)
  println(aParamlessFunction())

  def aRepeatedFcuntion(a: String, b: Int): String = {
    if (b == 1) a
    else a + aRepeatedFcuntion(a, b-1)
  }

  //Recursive functions needs return types (:String)

  //WHEN YOU NEED LOOPS, USE RECURSION

  /*
    1. A greeting (name age) "Hi my name is and i'm age years old)
    2. Factorial function
    3. A fibonacci function
    4. Test if a number is prime
   */

  def greeting(name: String, age:Int): String = s"My name is $name and i'm $age years old"

  def factorial(n: Int): Int = {
    if(n == 0) 1
    else n * factorial(n-1)
  }

  def fibonacci(n: Int): Int = {
    if(n == 1) 1
    else fibonacci(n-1) + fibonacci(n-2)
  }

  def prime(n:Int) : Boolean = {

      def primeUntill(t: Int) : Boolean = {
        if (n<=1) true
        else n%t != 0 && primeUntill(t-1)
      }

    primeUntill(n/2)

  }


}
