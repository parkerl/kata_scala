import scala.util.matching.Regex
import scala.tools.nsc.{Interpreter,Settings}

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
   def calculate(input: String): Double = {
      
      var last = if(resultSoFar != 0) resultSoFar.toString else ""
      
      val settings = new Settings
      settings.embeddedDefaults[SciCalc]
      val interpreter = new Interpreter(settings)
      var res = Array[Any](null)
      interpreter.beQuietDuring({
      interpreter.bind("result", "Array[Any]", res)
      interpreter.interpret("class Calculator {def calc:Double = " + last + input + "}")
      interpreter.interpret("result(0) = new Calculator")
      })

      res(0).asInstanceOf[{def calc: Double}].calc
  }
    
  def run{
    
    var calc = read("enter a calculation> ")
    while(calc != ""){
    try {
    
    resultSoFar = calculate(calc)
    
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