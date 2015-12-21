package com.siliconintegra.sco

import akka.actor.{Props,Actor,ActorRef,ActorSystem}
import com.typesafe.config.ConfigFactory
import akka.actor.Actor
import javax.swing._






  
import Messages._
import java.rmi.UnexpectedException

object Messages{

 object Exit
 object Finished
 object Error
 case class Response(message:String )
  
}


case class G_pos(x:Double=0.0 , y:Double=0.0){
  
  def shift(deltax:Double=0.0,deltay:Double=0.0)=
  {
  copy(x+deltax,y+deltay)  
  }
  
  
}

abstract class Shape(){
  
def draw(f:String =>Unit):Unit={f(s"draw:${this.toString()}")}

}
case class Circle(centre:G_pos,radius:Double) extends Shape
case class Rectangle(left:G_pos,height:Double,width:Double)extends Shape
case class Traingle (point1:G_pos,point2:G_pos,point3:G_pos) extends Shape 

class ShapesDrawingActor extends Actor
{
  
 def receive={
   
   case s:Shape => s.draw(str=>println(s"ShapesDrawingActor:$str"))
   sender !Response(s"ShapesDrawingActor:$s drawn")
   case Exit=>
     println(s"ShapesDrawingActor:exiting ........")
     sender !Finished
   case unexpected
   =>val response=Response(s"Unknown error occured :.....:$unexpected")
   println(s"ShapesDrawingActor:$response")
   sender !response 
  
   
 }
}

private object Start


// I pressume scala has both left to right and right to left associativity
object   ShapesDrawingDriver{
  
  def main(args:Array[String])
  {
    
    val system= ActorSystem("DrawingActorSystem",ConfigFactory.load())
    val drawer=system.actorOf(Props(new ShapesDrawingActor),"drawingActor")
    val driver=system.actorOf(Props(new ShapesDrawingDriver(drawer)), "drawingService")
    
    println("I want to copy some point")
    
    val p1=G_pos.apply(4,10)
     p1.shift(10.25, 100.256644)
     println("position  shifted :"+p1.x+""+p1.y)
     
    
    
    
    
    driver !Start
    
    
     
   }
}

class ShapesDrawingDriver(drawerActor:ActorRef) extends Actor
{
   def receive={
   case Start => 
     drawerActor ! Circle(G_pos(0.0,0.0),10)
     drawerActor ! Rectangle(G_pos(0.0,0.0),2,5)
     drawerActor ! 3.14159
     drawerActor ! Traingle(G_pos(0.0,0.0),G_pos(2.0,4.0),G_pos(3.0,4.0))
     drawerActor ! Exit
      
     
   case Finished =>
     println(s"ShapesDrawingDriver:cleaning up .....")
     context.system.shutdown()
   case response =>
     println(s"ShapesDrawingDriver:Response"+response)
   case unexpected =>
     println("ShapesDrawingDriver:ERROR:Received an unexpeted error message"+unexpected)
 //here s is called as interpolated string
     
 }

}




  