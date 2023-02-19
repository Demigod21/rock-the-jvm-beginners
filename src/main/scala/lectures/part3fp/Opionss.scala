package lectures.part3fp

import scala.util.Random

object Opionss extends App{

  val myFirstOption: Option[Int] = Some(4)
  val noOption: Option[Int] = None

  def unsfaceMethod(): String = null
  val result = Option(unsfaceMethod)

  def backupMethod(): String = "Valid"
  val chainedResult = Option(unsfaceMethod()).orElse(Option(backupMethod()))


  //DESIGN unsafe APIS
  def betterUnsafeMethod() : Option[String] = None
  def betterBackup(): Option[String] = Some("valid")

  val betterChained = betterUnsafeMethod() orElse betterBackup()

  //functions on options
  println(myFirstOption.isEmpty)
  println(myFirstOption.get) //UNSAFE

  //MAP, FLATMAP, FILTER
  println(myFirstOption.map(_*2))
  println(myFirstOption.filter(x => x > 10))
  println(myFirstOption.flatMap(x => Option(x*10)))

  //for compr
  val config: Map[String, String] = Map(
    "host" -> "127.0.0.1",
    "port" -> "8080"
  )

  class Connection {
    def connect = "Connected"
  }

  object Connection{
    val random = new Random(System.nanoTime())
    def apply(host: String, port:String) : Option[Connection] =
      if(random.nextBoolean()) Some(new Connection)
      else None
  }

  //try to establish connection, if so, print the connect method
  val host = config.get("host")
  val port = config.get("port")

  val connection = host.flatMap(h => port.flatMap(p => Connection.apply(h, p)))
  val connectionStatus = connection.map(c => c.connect) //options(string)

  //chained calls
  config.get("host")
    .flatMap(host2 => config.get("port")
    .flatMap(port2 => Connection(host2, port2))
    .map(connection => connection.connect))
    .foreach(println)

  //for compr
  for {
    host3 <- config.get("host")
    port3 <- config.get("port")
    connection <- Connection(host3, port3)
  } yield connection.connect




}
