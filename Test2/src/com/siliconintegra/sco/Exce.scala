package com.siliconintegra.sco

// some try catch usage 

import scala.io.Source
import scala.util.control._
import scala.language.reflectiveCalls
import scala.annotation._

object Exce {

  def main(args:Array[String]){
    
    args foreach(arg =>countLines(arg))
 
    
  
  
  
  
  }
  
  def countLines(fileName:String){
    
    var source:Option[Source]=None
    try{
      
      source=  Some(Source.fromFile(fileName.trim()))
      val size=source.get.getLines().length
      println(s"file :$fileName has  $size : number of lines:.....")
      if(size>100000) throw new RuntimeException("very bigfile man ....")
      
    }
    catch{
      
      case NonFatal(ex)=>println(s"Non Fatal Exception:"+ex)
      
    }
    finally{
      
      for(s<-source){
        println(s"Closing $fileName")
        s.close
      }
      
    }
    
  }
  
  
  //some examples   call by name and call by reference
  
 //def apply[R <:{def close():Unit},T](resource:=>R)(f:R=>T)=
 
 
 //{try{}catch{}finally{}}
  
 //some conditional stuff 
 
   }