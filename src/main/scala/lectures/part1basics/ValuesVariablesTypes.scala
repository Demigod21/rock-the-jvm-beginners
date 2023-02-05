package lectures.part1basics

object ValuesVariablesTypes extends App {

  val x: Int = 42
  println(x)
  //VALS ARE IMMUTABLE

  //COMPILER CAN INFER TYPES

  val aString: String = "hello"
  val aBoolean: Boolean = false
  val aChar: Char = 'a'
  val anInt: Int = x
  val aShort: Short = 415
  val aLong: Long = 73281732889L
  val aFloat: Float = 1.0f
  val aDouble: Double = 1.0

  //variables
  var aVariable: Int = 4
  aVariable = 5 //side effects


}
