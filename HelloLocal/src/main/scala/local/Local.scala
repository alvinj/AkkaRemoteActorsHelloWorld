package local

import akka.actor._

object Local extends App {

  implicit val system = ActorSystem("LocalSystem")
  val localActor = system.actorOf(Props[LocalActor], name = "LocalActor")  // the local actor
  localActor ! "START"                                                     // start the action

}

class LocalActor extends Actor {

  // create the remote actor
  val remote = context.actorSelection("akka.tcp://HelloRemoteSystem@127.0.0.1:2553/user/RemoteActor")
  val remote2 = context.actorOf
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


