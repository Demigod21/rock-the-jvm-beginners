package lectures.part3fp

object AnonFun extends App {

  val doubler = new Function1[Int, Int] {
    override def apply(x: Int): Int = x * 2
  }

  val doublerAnon: Int => Int = x => x * 2 //anon function (LAMBDA)

  val adder: (Int, Int) => Int = (a: Int, b: Int) => a + b

  //no params
  val justDoSomething: () => Int = () => 3

  println(justDoSomething)  //function itself
  println(justDoSomething()) //call

  // curly braces with lambda
  val stringToInt = { (str: String) =>
    str.toInt
  }

  //more sytactic sugar
  val niceIncrementer: Int => Int = _ + 1 //equivalent to x => x + 1
  val niceAdder: (Int, Int) => Int = _ + _ //equivalent to (a,b) => a + b

  /*
  1. MyList : replace all FunctionX with lambdas
  2. Rewrite special adder as anon function
   */

  val superAdder : Function1[Int, Function1[Int, Int]] = new Function1[Int, Function1[Int, Int]] {
    override def apply(a:Int): Function1[Int, Int] = new Function1[Int, Int] {
      override def apply(b: Int): Int = a + b
    }
  }

  val superSuperAdder = (x: Int) => (y: Int) => x + y

  // instead of passing anon FuncionX instances everyday
  // we use lambdas

}
