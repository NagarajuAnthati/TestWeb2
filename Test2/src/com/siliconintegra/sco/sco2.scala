package com.siliconintegra.sco
import scala.util._

//some of the statements I have got to remember is when you are calling a function you  need to follow 
/* use some interpolation
 * fun_name .!(parameters....)
 * or 
 * fun_name !parameter 
 * like sender ! Response(s"Some thing hell happening out there.....")
 * 
 */

object sco2 {
  
 // defining some methods 
  
  def m (str:String)=Console.println(str)
  def m1(str:String,str2:String)=Console.println("I am a jaffa:"+str+str2)
  def main(args:Array[String])
  {
    println(m("100"))
    m1("na bonda","ne bonda")  
    //some variable declarations 
    val x:Array[String]=new Array (100)
    
  }
  class Person(val name:String,var age:Int )
  val p= new Person("PZZZXXXXX",10)
  
  
  //lets discuss some partial functions 
  
  val pf1:PartialFunction[Any,String]={case s:String =>"YES"
  case d:String =>"Ne bonda ra Ne Bonda"}
  
  val pf2:PartialFunction[Any,String]={case s:Double =>"YES"}  
  val pf=pf1 orElse pf2
  
  def tryPF(x:Any,f:PartialFunction[Any,String]):String=try {f(x).toString()}catch{case _:MatchError=>"ERROR"}
  
  def d(x:Any,f:PartialFunction[Any,String])=f.isDefinedAt(x).toString
    
  println("pf1 - String |pf2 - Double |pf - All")
//
println("x| def? | pf1(x) | def? | pf2(x) | def? | pf(x)")
println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++")
List("str", 3.14, 10) foreach { x =>
printf("%-5s | %-5s | %-6s | %-5s | %-6s | %-5s | %-6s\n", x.toString,
d(x,pf1), tryPF(x,pf1), d(x,pf2), tryPF(x,pf2), d(x,pf), tryPF(x,pf))
}

  
  
  
}