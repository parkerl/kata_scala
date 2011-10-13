import scala.util.matching.Regex

import java.text.{NumberFormat, ParsePosition}
 

package learning{


class SciCalc extends InputReader with Output{

var resultSoFar:Double = 0

def isNumeric(input: String): Boolean = {
    val formatter = NumberFormat.getInstance
    val pos = new ParsePosition(0)
    formatter.parse(input, pos)
    input.length == pos.getIndex // valid if parse position is at end of string
}

  
  def parseCalc(calc: String): Tuple3[String,String,String] = {
  
    val Parse = """^.*?(\d*\.?\d*)\W*([+])\W*(\d+\.?\d*)\W*""".r
    
    val Parse(first,op,last) = calc
    
    (first,op,last)
    
  }
   def calculate(parts: Tuple3[String,String,String]): Double = {
      parts match{
        case (f,"+",e) => f.toDouble + e.toDouble
        case (f,"/",e) => f.toDouble / e.toDouble
        
        }
   }
    
  def run{
    
    var calc = read("enter a calculation> ")
    while(calc != ""){
    try {
    
    val parts = parseCalc(calc)
    
    val f = if(parts._1 == "")
      (resultSoFar.toString, parts._2, parts._3)
    else 
      parts
      
    
    resultSoFar = calculate(f)
    
    print("= " + resultSoFar.toString)
    
    } catch {
      case _ => print("couldn't understand calculation")
    }
      calc = read("enter a calculation> ")
    }

  }
  
     
  
}

object SciCalcApp extends App {

  val sc = new SciCalc
  sc.run

}

}