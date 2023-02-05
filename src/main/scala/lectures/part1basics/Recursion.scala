package lectures.part1basics

import scala.annotation.tailrec

object Recursion extends App{

  //Stack recursion
  def factorial(n: Int): Int = {
    if(n <= 1) 1
    else n * factorial(n-1)
  }


  def factorial2(n: Int) : Int = {

    @tailrec
    def aux(x: Int, accumulator: Int): Int = {
      if (x <= 1) accumulator
      else aux(x - 1, x * accumulator) //tail recursion = use recursive call as the LAST expression
    }

    aux(n, 1)

  }

  //WHEN YOU NEED LOOPS USE TAIL RECURSION

  /*
      1. Concate a string n times with tail rec
      2. isPrime tailRec
      3. Fibonacci tailRec
   */

  def concatenate(n: Int, word: String) : String = {

    def aux(n:Int, acc:String) : String = {
      if(n <= 0) acc
      else aux(n-1, acc+word)
    }
    aux(n, "")

  }


  def isPrime(n: Int) : Boolean = {

    def aux(t:Int, b: Boolean): Boolean = {
      if(!b) false
      else if(t <= 1) true
      else aux(t - 1, n % t != 0 && b)
    }

    aux(n / 2, true)

  }

  def fibonacci(n: Int) : Int = {

    def aux(i: Int, last: Int, nextToLast: Int) : Int = {
      if (i >= n) last
      else aux(i + 1, last + nextToLast, last)
    }

    if(n <= 2) 1
    else aux(2, 1, 1)

  }


}
