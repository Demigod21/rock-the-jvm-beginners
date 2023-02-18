package lectures.part3fp

object MapFlatmapFilterFor extends App {

  val list = List(1,2,3)
  println(list.head)
  println(list.tail)

  //map
  println(list.map(_ + 1))

  //filter
  println(list.filter(_ % 2 == 0))

  //flatmap
  val toPair = (x: Int) => List(x, x+1)
  println(list.flatMap(toPair))

  // print all combinations between two list
  val numbers = List(1,2,3,4)
  val characters = List('a','b', 'c', 'd')
  //List(a1, a2 ecc ecc)


  val sis = numbers.flatMap(number => characters.map(character => s"'$number, $character'"))
  println(sis)

  //for each
  list.foreach(println)


  //for compr
  val forComb = for {
    number <- numbers
    char <- characters
  } yield(s"'$number, $char'")
  println(forComb)

  /*
  1. MyList supports for comprehension?
  YES
  2. A small collection of at most ONE element - Maybe[+T]
    - map, flatMap, filter
   */

  abstract 


}
