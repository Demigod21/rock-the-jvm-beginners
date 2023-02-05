package lectures.part1basics

object Expressions extends App {

  val x = 1 + 2 //expression
  println(x)

  println(2 + 3 * 4)
  //+ - * / & | ^ << >> <<< >>>

  println(1 == x) //false
  // == != < > <= >=

  println(!(1 ==x)) // true
  // ! && ||

  var aVariable = 2
  aVariable += 3
  // -= += *= /=  SIDE EFFECTS

  //Instructions vs Expressions
  //Instruction is something that we tell the computer TO DO
  //Expression is something that has a VALUE

  // IF expression

  val aCondition = true
  val aConditionValue = if (aCondition) 5 else 2
  println(aConditionValue) //5

  println(if (aCondition) 5 else 2) //5 IF IS AN EXPRESSION

  //NEVER WRITE WHILE LOOPS

  //EVERYTHING in scala is an expression

  val aWeirdValue: Unit = (aVariable = 3) //UNIT == void
  println(aWeirdValue) // ()

  //side effects; println(), whiles, reassigning ---- they're expressions returning unit

  //code blocks

  val aCodeBlock = {
    val y = 2
    val z = y+1
    if(y < z) "hello" else "goodbye" //this is the value of the code block
  } //STRING


  //1 difference between "hello world" vs println("hello world")
  //1 is string 2 is unit
  //1 is variable, 2 is side effect





}
