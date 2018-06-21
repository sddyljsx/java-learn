package neal.scalatest

import akka.actor.{Actor, ActorSystem, Props}


object ActorTest {

  def main(args: Array[String]) = {

  }

}

class ActorDemo extends Actor {

  override def receive: Receive = {
    case "actorDemo" => println("receive....ActorDemo")
    case "test" => println("received test")
    case _ => println("received unknown message")
  }
}

object ActorDemo extends App {
  //创建ActorSystem对象
  val system = ActorSystem("MyActorSystem")
  //返回ActorSystem的LoggingAdpater
  val systemLog = system.log
  //创建MyActor,指定actor名称为myactor
  val myactor = system.actorOf(Props[ActorDemo], name = "myactor")

  systemLog.info("准备向myactor发送消息")
  //向myactor发送消息
  myactor ! "test"
  myactor ! 123

  //关闭ActorSystem，停止程序的运行
  system.shutdown()
}
