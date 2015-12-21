package com.siliconintegra.sco

import scala.io._
import scala.util.control._
import scala.language.reflectiveCalls
import scala.annotation._



object SomeTest extends Enumeration  {
  
  type Week_day=Value
 val Mon,Tue,Wed,Thurs,Fri,Sat,Sun=Value
 def isWeekDay(d:Week_day)={
   
   
   !(d==Sat||d==Sun)
 }
 
 //Week_day.values foreach {i=>println("$i is a week day:"+isWeekDay(i)}
 
  
  
  
  
  
  def main(args:Array[String]){
   
    
println(isWeekDay(Mon))
   
   
   args foreach {args => countLines(args)}
  
    println(db_string)
    
    //eneumaration examples 
    

    type SomeTest= Value
    
    val dbrman=Value("Doberman Pinsher")
    val drman=Value("Doberman Pinsher")
    val drmdan=Value("Doberman Pinsher")
    val drmadn=Value("Doberman Pinsher")
    val drmand=Value("Dobermandfasflsd;af;sdkfkaslf;s; Pinsher")

    
    println("ID \t Breed")
for(brid<-SomeTest.values)println("{$brid.id} \t $brid")

  
  
  
  }
  

    
    
    
  // to discuss lazy value feature 
  
  
  lazy val db_string:String=init
  
  
  def init:String={
    
    new String("jdbc:odbc:thin@10.0.20.170:Naga;Silicon@09")
    
  }
  
  
  
  def countLines(src:String){
    
   val source=Source.fromFile(src)
        val size=source.getLines.size
        if(size>100) throw new RuntimeException("file size exceeds its limit")
      
      
      
  
    
    
  }
  
  
  
}