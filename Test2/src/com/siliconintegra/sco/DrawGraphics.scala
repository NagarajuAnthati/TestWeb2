package com.siliconintegra.sco

import scala.annotation.tailrec
import java.util.HashMap
import scala.swing._
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.ExecutionContextExecutor
//static import com.siliconintegra.json.JSON.*;

object DrawGraphics {
  
  /*type inference in scala
   *scala allows you to do some implicit declarations 
   *     
   */
  
  //checking about some threads
  
  def sleep (millies:Long)={
    Thread.sleep(millies)
  }
  
  def doSomeStuff(index:Int)
  {
    sleep((math.random*10000).toLong)
     index
  }
 
  
  
  
  
  (1 to 10) by 2 foreach {
    
    index => val future= Future{
      doSomeStuff(index)
      
    }
    future onSuccess
  {
  
    case answer:Any => println(s"success: returned :$answer")
    
  }  
  
  future onFailure
  {
    
    case th:Any=>println(s"failure occured://: returned error:$th")  
  }
}
  
  sleep(1000)
  println("Finitio......")
  
 def  T1[A](a:A)(f:A=>String)
 {
 println(s"Some Strings:$a*$a")  
 }
  
 def main(args:Array[String])
 {  T1(100)(i=>s"$i*$i")
 }
 
 
 val h1=new HashMap[Int,String]
 println(h1.isEmpty())
 
 
 
 // scala implicit declarations
 
//nesting methods definition and recursion 
 var t2=(1.1,"jaffa",8458.6549875)
 var t3=('!',"dsfksaklfkas;f",49859080485.9024789572489758947985125)
 var t4=(t2,t3,"kgfdkgkl;sdg")
 
 println("whole jaffa tuple:"+t2)
 println("whole jaffa tuple:"+t4)
 println("whole jaffa tuple:"+t2._1)
 println("whole jaffa tuple:"+t2._2)
 println("whole jaffa tuple:"+t2._3)
 
 def recursion(i:Int):Long={
   
     def rec(i:Int,accumulator:Int):Long={
       if(i<=1)
         accumulator
       else 
         rec(i-1,i*accumulator)
 }
 rec(i,1)
 }
 
 0 to 20 foreach {
   i =>println(recursion(i))
   
   
 }
 //writing some fibonacci
 
 //@tailrec
// def fibonacci(i:Int):Long={
//  if(i<=1) 1L
//  
//  else fibonacci(i-1)+fibonacci(i-2)
// }
 
 //some work with strings 
 
 def strin(strings:String*)=
 {
   
 strings.map(str=>str.toUpperCase()).mkString("-") 
 
 }
 //some hash map functions
 
 
 println("some jaffa strings:" +strin("sdklfjklsjdfjls","dsklfsdlfwe4rKKKKLKL","d;fas;fkkslsklllllllkll;asd"))
 

 


/*
 * some of the key word discusssion 
 * final does not let you to derive any child instances or to be overriden 
 * forSome -->existential type declarations 
 * sealed --->applied for all parent class files to make sure entire source information is limited to single instance
 * super -->same as this 
 * trait ===> trait is an additional reference which adds state and behaviour similar to an interface
 * 	val --> read only value
 * var --writable values
 * 	with --> to add along with the class declared or object instantiated 
 * yield is part of the sequence for some for loop 
 * <- Generator expression 
 * => symbol to separate the attribute from the functions body
 * to preserve some white space use Symbol.apply("XX Vvdf")
 * 
 * */

/*
 * To discuss some function literals 
 * val f:f(Int.String)=>String=(i,s)=>i+s
 * the other way is 
 * val f2:f1[Int,String,String]=(i,s)=>i+s
 * Tuple literals 
 * val f2:[Int,String]=(1,"two")
 * nulls are avoided by using the options => like  Some,None 
 * Initialisig a  map 
 * scala supports namespace like structure for package declaration
 * like 
 * package pkg1
 * {
 * class c1{
 * def x
 * }
 * } 
 * 
 *  
 * */

val m1= Map("Alabama"->"Montogomery","Wyoming"->"Juneau")

println("states /t"+" capitals.....")

println(m1.get("Alabama"))
println(m1.get("Wyoming"))
println(m1.get("Unknown").getOrElse("I do not know"))

}


