package lectures.part3fp

object TuplesMaps extends App{

  //finited ordered list tuple
  val aTuple = new Tuple2(2, "hello, scala")
  println(aTuple._1)
  println(aTuple.copy(_2 = "new"))

  // maps keys-> values
  val aMap = Map(("jim", 555), "daniel"-> 289)
  // a-> b is sugar for (a,b)



  //functionals on map
  //map, flatmap, filter


  //filterKeys
  println(aMap.view.filterKeys(_.startsWith("j")))

  //mapvalues
  println(aMap.view.mapValues(number => number * 10))


  /*
  1. what would happen if i had two original entries
  2. overly simplified social netweorkd based on maps
    Person = String
    - add a person to the network
    - remove a person to the network
    - friend (mutual)
    - unfriend

    - number of friends of a person
    - person with most friends
    - how many people have NO friends
    - if there is a social connection between two people (direct or not)

   */

  def add(network: Map[String, Set[String]], person: String) :
  Map[String, Set[String]] = network + (person -> List())

  def friend(network: Map[String, Set[String]], a: String, b: String):
  Map[String, Set[String]] = {
    val friendsA = network(a)
    val friendsB = network(b)

    val newFriendsA = friendsA + b
    val newFriendsB = friendsB + a

    network + (a -> newFriendsA) + (b -> newFriendsB)
  }

  def unfriend(network: Map[String, Set[String]], a: String, b: String):
  Map[String, Set[String]] = {
    val friendsA = network(a)
    val friendsB = network(b)

    val newFriendsA = friendsA - b
    val newFriendsB = friendsB - a

    network + (a -> newFriendsA) + (b -> newFriendsB)
  }

  def remove(network: Map[String, Set[String]], a: String):
  Map[String, Set[String]] = {

    def removeAux(friends: Set[String], networkAcc: Map[String, Set[String]]):
    Map[String, Set[String]] = {
      if(friends.isEmpty) networkAcc
      else removeAux(friends.tail, unfriend(networkAcc, a, friends.head))
    }

    val unfriended = removeAux(network(a), network)
    unfriended - a

  }

  def nFriends(network: Map[String, Set[String]], a: String):
    Int = network(a).size

  def mostFriendsnetwork(network: Map[String, Set[String]]): String = {
    network.maxBy(pair => pair._2.size)._1
  }


  def nPeopleFriendless(network: Map[String, Set[String]]): Int = {
    network.view.filterKeys(k => network(k).isEmpty).size
  }

  def socialConnection(network: Map[String, Set[String]], a: String, b:String):
  Boolean = {
    //BFS
    //tail recursion function
    def bfs(target: String, consideredPeople: Set[String], discoeveredPeople: Set[String]): Boolean = {
      if(discoeveredPeople.isEmpty) false
      else {
        val person = discoeveredPeople.head
        if(consideredPeople.contains(person)) bfs(target, consideredPeople, discoeveredPeople.tail)
        else if(person == target) true
        else bfs(target, consideredPeople + person, discoeveredPeople.tail ++ network(person))
      }
    }
    bfs(b, Set(), network(a) + a)
  }




}
