import learning.Input
import learning.Output

package learning{

trait ListInput{

def retry[a](expr: => a): a = {
     var i: Option[a] = None
     do {
       i = try { Some(expr) } catch { 
       case _ => Console.println("Not valid");None  }
     } while (i == None)
     i.get
   } 
   
   def getInputList: List[Int] = {
     var input = List[Int]()
     Iterator.continually(Console.readLine("Enter a number> ")).takeWhile(_ != "").foreach(line => try {input = input :+ line.toInt} catch { case _ => Console.println("Please enter only numbers") })
     input
   }
   
   

}


class NumberCruncher extends ListInput with Output{
  
  def sortAscending(l: List[Int]) {
  
    val sorted = l.sortWith((s,t) => s < t)
    
    sorted.foreach(i => print(i))
      
  }
  
  def run{
    
    val l: List[Int] = getInputList
    sortAscending(l)
  
  }
  
     
  
}

object NumberCruncherApp extends App {

  val nc = new NumberCruncher
  nc.run

}

}