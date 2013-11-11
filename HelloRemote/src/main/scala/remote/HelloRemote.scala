package remote

import akka.actor._

object HelloRemote extends App  {
  val system = ActorSystem("HelloRemoteSystem")
  val remoteActor = system.actorOf(Props[RemoteActor], name = "RemoteActor")
  remoteActor ! "The RemoteActor is alive"
}

class RemoteActor extends Actor {
  def receive = {
    case msg: String => 
        println(s"RemoteActor received message '$msg'")
        sender ! "Hello from the RemoteActor"
  }
}


