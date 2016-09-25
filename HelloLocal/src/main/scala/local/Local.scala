package local

import akka.actor._

object Local extends App {

  implicit val system = ActorSystem("LocalSystem")
  val localActor = system.actorOf(Props[LocalActor], name = "LocalActor")  // the local actor
  localActor ! "START"                                                     // start the action

}

class LocalActor extends Actor {

  import local.Local._

  private val path = "akka.tcp://HelloRemoteSystem@127.0.0.1:5150/user/RemoteActor"
  // create the remote actor
  val remote = system.actorSelection(path)
  var counter = 0

  def receive = {
    case "START" => 
        remote ! "Hello from the LocalActor"
    case msg: String => 
        println(s"LocalActor received message: '$msg'")
        if (counter < 5) {
            sender ! "Hello back to you"
            counter += 1
        }
  }
}


