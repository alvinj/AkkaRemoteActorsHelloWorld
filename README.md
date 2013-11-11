Akka Remote "Hello, world" Example
==================================

As it's name indicates, this is a simple "Hello, world" example
for Akka remote actors. It shows how to create a local actor,
a remote actor, and send messages between them.

Assumptions
-----------

For the purposes of this code, I assume you know the following:

1. Scala
1. SBT (the Simple Build Tool)
1. How to use Akka actors within one JVM (i.e., the actor basics)

Running the Code
----------------

Follow these steps to run the code:

1. `cd` into the _HelloRemote_ directory.
1. Type `sbt run` to start the remote actor system.
1. In a separate terminal window, `cd` into the _HelloLocal_ directory.
1. Type `sbt run` to start the local actor system.

When the local actor system starts, it will send an initial message
to the remote actor system. The remote actor will send a reply through
its `sender` reference, and this will continue five times. When the
action stops, stop each system by pressing Ctrl-C.

Problems?
---------

If you're having any problems with this code, edit the _application.conf_
file in the _src/main/resources_ directory of each project, and remove the
comments from the debug-related lines.

More Information
----------------

See the following URL for more information:

http://alvinalexander.com/scala/simple-akka-actors-remote-example


