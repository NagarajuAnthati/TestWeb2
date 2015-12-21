package com.siliconintegra.sco
import java.io._
import org.scalatest.{FunSpec,ShouldMatchers}
import java.util.Calendar



object FileTest
{
  
  
   def findIfFriday(cal:Calendar):Boolean={
     
     val day=cal.get(13)
     val   dayOf=cal.get(13)
     
     (day==Calendar.FRIDAY)&&(dayOf==13)
     
   }
  
  
  
   
  def read:String={
    
   val source= new File("/home/global/Desktop/tests")
      val in= new BufferedInputStream(new FileInputStream(source))
      println("what the hell is going on :"+source)
     val numBytes=in.available()
     println("where are your bytes man :"+numBytes)
     val bytes=new Array[Byte](numBytes)
     in.read(bytes, 0, numBytes)
     new String(bytes)
  }   
   
   def main(args:Array[String]){
               println("/n"+FileTest.read)
               //adding an element to list
               val list=List('b','c','d')
               'a' ::list
               println(list)
               
               
               if(3+3==5)
     
     println("you have no brain  ")
     else 
       println("you are a non Orwellian ")
     
       val configFile= new File("/home/global/Desktop/tests.pdf")
       val configPath=if(configFile.exists())
         configFile.getAbsolutePath
       else 
         configFile.createNewFile()
         configFile.getAbsolutePath
         
        println(configFile+":"+configPath)
        
               //sample for loop in scala 
               
               val breeds=List (Some("Terrior"),None,Some("Labradar"),None,Some("Jaffa"),None,"DingDing")
               
            val choice=   for{breed<-breeds
                   
            }yield breed 
            
            for{breed2<-breeds
                upBreed1=breed2.toString().toUpperCase()
            }println(upBreed1)
            
            
            
            
            
            //scala has right to left associativity and below example illustrate with Options  
            
         
            
            println("all pigs are eaten:"+choice+": only found") 
                    
                 
             //jaffa generator expressions 
                 
                 for(i <- 1 to 100 by 2)
                 println(i)
                
               
               
    }
   
   /*discussing more about the function var =>transform 
     coming to precedence rules it follows as here 
     Letters ,|,^,
     any method name that ends with : binds to the right and any other general convention is left biding 
    * */
   
   //checking some  domain specific language stuff 
   
//   class NerdFinderSpec extends FunSpec with ShouldMatchers
//   {
//     
//     //describe is keyword that is similar to a macro
//     
//     describe("nerd finder"){
//       
//       it("find some stuff in the list "){
//      val actors=List("Ricky Martin","James Cook","Srinivasa Ramanujan")
//   val finder =new NerdFinder(actors)
//      finder.findNerds ShouldEqual List("Srinivasa Ramanujan","Ricky Martin")
//      
//       
//      }
//       }
//     }
//     
 
   //if statements in scala can return some thing as shown in below snippet
   
   
   //working with calender 
   
   
  
       
       
       
       
       
       
       
 
   
}