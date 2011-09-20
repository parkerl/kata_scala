import learning.Input
import learning.Output

package learning{

class FibPrinter extends Input with Output{
  
    def printTo(i: Int){
      (1 to i).foreach(n =>print(fib(n)))
    }
    
    def fib( n: Int): Int = n match {

      case 0 | 1 => n
      case _ => fib( n -1) + fib( n-2)
      
    }

}

}