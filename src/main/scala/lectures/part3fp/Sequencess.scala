package lectures.part3fp

import scala.util.Random

object Sequencess extends App {

  val aSeq = Seq(1,2,3,4)
  println(aSeq) //actually a list?
  println(aSeq.reverse)
  println(aSeq(2)) //.get(index)
  println(aSeq ++ Seq(5,6,7))

  //ranges
  val aRange: Seq[Int] = 1 to 10
  aRange.foreach(println)

  //lists

  val aList = List(1,2,3)
  val prepended = 42 :: aList
  val anotherPrep = 42 +: aList

  val apples5 = List.fill(5)("apple")
  println(apples5) //apple apple apple apple apple
  println(aList.mkString("-|-"))


  //arrays
  val numbers = Array(1,2,3,4)
  numbers(2) = 0
  //array and seq
  val numberSeq: Seq[Int] = numbers //implicit conversion

  //vector
  val vectors: Vector[Int] = Vector(1,2,3)

  //vectors vs list
  def getWriteTime(collection: Seq[Int]) : Double = {
    val r = new Random
    val times = for {
      it <- 1 to 1000
    } yield {
      val currentTime = System.nanoTime()
      collection.updated(r.nextInt(1000000), 0)
      System.nanoTime() - currentTime
    }
    times.sum * 1.0 / 1000

  }


  val numberList = (1 to 1000000).toList
  val numberVector = (1 to 1000000).toVector

  // keeps reference to tail
  // updating in the middle takes long time
  println(getWriteTime(numberList)) //LOSER 9 MILLION NANOSECONDS

  //depth of the tree is small
  //needs to replice an entire 32 element chunk
  println(getWriteTime(numberVector)) //WINNER 4 THOUSAND NANOSECND
  //VECTOR IS THE DEFAULT IMPLEMENTATION OF SEQUENCE


}
