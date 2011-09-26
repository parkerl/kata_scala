import org.scalatest.Spec
import org.scalatest.matchers.ShouldMatchers
import scala.collection.mutable.Stack
import learning.NumberCruncher


trait MockListInput extends learning.InputReader {
     
     var input: Iterator[String] = List("").iterator
     
     override def read(prompt: String) = input.next()
     
     def setInput(in: List[String]) = input = in.iterator
     
  }

class NumberCruncherSpec extends Spec with ShouldMatchers {

  describe("Take a series of numbers and sort them in ascending order") {
      
      it("should print 123 when given 1,2,3 as input") {
         val num = new NumberCruncher with MockOutput
         val numbers = List(1,2,3)
         num.sortAscending(numbers)
         num.messages should be("123")
      }
      
       it("should print 321 when given 1,2,3 as input") {
         val num = new NumberCruncher with MockOutput
         val numbers = List(3,2,1)
         num.sortAscending(numbers)
         num.messages should be("123")
      }
      
      it ("should build a list from a series of strings"){
        val num = new NumberCruncher with MockListInput with MockOutput
        
        num.setInput(List("1","22","3",""))
        num.run
        num.messages should be("1322")              
      
      }
      
      it ("should print an error when passed a string that is not a number"){
        val num = new NumberCruncher with MockListInput with MockOutput
        
        num.setInput(List("Blah",""))
        num.run
        num.messages should be("Please enter only numbers")              
      
      }
      
      it ("should print an error when passed a string that is not an integer"){
        val num = new NumberCruncher with MockListInput with MockOutput
        
        num.setInput(List("1.0",""))
        num.run
        num.messages should be("Please enter only numbers")              
      
      }
      
      
  }
}