package lectures.part2oop

object Exceptions extends App{

  val x: String = null
  // println(x.length)
  // this will crash with NPE

  // throwing and catching exception

  //val aWeirdValue = throw new NullPointerException //Nothing

  // Exceptions and Error are the major throwable
  def getInt(withException: Boolean) : Int =
    if(withException) throw new RuntimeException("Exception")
    else 42

  try{
    getInt(true)
  } catch {
    case e: RuntimeException => println("Caught runtime exception")
  } finally {
    // code that will be excecuted NO MATTER WHAT
    // optional
    // does not influence the return
    // use finally only for side effects
    println("finally")


/*    Ex : calculator that throws
      - OverFlowException if add(x, y) exceeds Int.MAX_VALUE
      - UnderflowException if subtract
      - MathCalculationException for division by 0
      */


    // OOM
    // val array = Array.ofDim(Int.MaxValue)

    //SO
    // def infinite: Int = 1 + infinite
    // def noLimit = infinite

    class OverflowException extends RuntimeException
    class UnderflowException extends RuntimeException
    class MathCalculationException extends RuntimeException


    object PocketCalculator {
      def add(x: Int, y: Int) = {
        val result = x + y
        if(x > 0 && y > 0 && result < 0) throw new OverflowException
        else if(x < 0 && y < 0 && result > 0) throw new UnderflowException
        else result
      }

      def divide(x: Int, y: Int) = {
        if (y == 0) throw new MathCalculationException
        else x / y
      }

    }

  }

}
