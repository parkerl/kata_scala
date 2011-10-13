trait MockOutput extends learning.Output {
    var messages = ""

    override def print(s: Any) = messages = messages + s.toString
  }
  
trait MockSwitchInput extends learning.Input {
     var start = false
     override def getInput() = {start = !start; start}
  }

trait MockFalseInput extends learning.Input {
    
     override def getInput() =false
  
  }
  
trait MockListInput extends learning.InputReader {
     
     var input: Iterator[String] = List("").iterator
     
     override def read(prompt: String) = input.next()
     
     def setInput(in: List[String]) = input = in.iterator
     
  }


trait MockInputCapturePrompt extends MockListInput {
     
     var messages = List[String]()
     
     override def read(prompt: String) = {
     messages = messages :+ prompt
   
     input.next()
     }
     
  }

trait MockOutputResultCapture extends learning.Output {
     
     var outmessages = List[String]()
     
     override def print(s: Any) = {
     outmessages = outmessages :+ s.toString
     }
     
  }