package learning{

trait Output{
  def print(s: Any) = println(s)
}

trait Input{
  def getInput() = Console.readLine != ""
}

class NumberPrinter extends Output with Input{

  def print_1_to_5 {
    (1 to 5).foreach( i =>  print(i))
     
  }
  
  def go {
    print_1_to_5 
    while (getInput) {print_1_to_5}
  }
  
}

object NumberPrinterApp extends App {
    val num = new NumberPrinter
    num.go
}

}