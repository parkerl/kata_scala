import learning.Output

package learning{

trait InputReader{

   def read(prompt: String): String = {
     val line = readLine(prompt)
     line
   }
   
   

}


class NumberCruncher extends InputReader with Output{
  
  def sortAscending(l: List[Int]) {
  
    val sorted = l.sortWith((s,t) => s < t)
    
    sorted.foreach(i => print(i))
      
  }
  
  def run{
    var input = List[Int]()
    Iterator.continually(read("Enter a number> ")).takeWhile(_ != "").foreach(line => try {input = input :+ line.toInt} catch { case _ => print("Please enter only numbers") })
    sortAscending(input)
  
  }
  
     
  
}

object NumberCruncherApp extends App {

  val nc = new NumberCruncher
  nc.run

}

}