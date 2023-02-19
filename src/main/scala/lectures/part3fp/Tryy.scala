package lectures.part3fp

import scala.util.{Failure, Random, Success, Try}

object Tryy extends App{

  val aSuccess = Success(3)
  val aFailure = Failure(new RuntimeException("SUPER FAIL"))

  println(aSuccess)
  println(aFailure)

  def unafeMethod(): String = throw new RuntimeException("FAILL")

  val aPotentialFailure = Try(unafeMethod())
  println(aPotentialFailure)

  def betterUnsuafeMethod() : Try[String] = Failure(new RuntimeException)
  def betterBackup(): Try[String] = Success("win win")

  val betterFallback = betterUnsuafeMethod() orElse betterBackup()

  //map, flatmap, filter
  println(aSuccess.map(_*2))
  println(aSuccess.flatMap(x => Success(x*10)))
  println(aSuccess.filter(x => x>10))

  val host = "Localhost"
  val port = "8080"

  def renderHtml(page: String) = println(page)

  class Connection{
    def get(url: String) : String = {
      val random = new Random(System.nanoTime())
      if(random.nextBoolean()) "<html>..</html>"
      else throw new RuntimeException("Connection interrupted")
    }


    def getSafe(url: String) : Try[String] = {
      Try(get(url))
    }

   }

  object HttpService{
    val random = new Random(System.nanoTime())
    def getConnection(host:String, url: String): Connection = {
      if(random.nextBoolean()) new Connection
      else throw new RuntimeException("Port unavailable")
    }

    def getConnectionSafe(host:String, port: String): Try[Connection] =
      Try(getConnection(host, port))
  }



  /*
  with this scenario
    - if youg et html page from connection, print it to the console
    - ie call renderHtml
   */

  val possibleConnection = HttpService.getConnectionSafe(host, port)
  val possibleHTML = possibleConnection.flatMap(connection => connection.getSafe("url"))
  possibleHTML.foreach(renderHtml)

  //shorthand version
  HttpService.getConnectionSafe(host, port)
    .flatMap(connection => connection.getSafe("url"))
    .foreach(renderHtml)

  //for compr
  for {
    connection <- HttpService.getConnectionSafe(host, port)
    html <- connection.getSafe("url")
  } renderHtml(html)




}
