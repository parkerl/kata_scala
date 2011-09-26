import learning.Input
import learning.Output

package learning{

class FibPrinter extends Input with Output{

    def run {Iterator.continually(Console.readLine("Enter a number> ")).takeWhile(_ != "").foreach(line => try {printTo(line.toInt)} catch { case _ => Console.println("Please enter only numbers") })}
  
    def printTo(i: Int){
      (1 to i).foreach(n =>print(fib(n)))
    }
    
    def fib( n: Int): Int = n match {

      case 0 | 1 => n
      case _ => fib( n -1) + fib( n-2)
      
    }

}

object FibPrinter extends App{
  val f = new FibPrinter
  f.run
}

}