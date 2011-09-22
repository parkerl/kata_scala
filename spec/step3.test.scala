import org.scalatest.Spec
import org.scalatest.matchers.ShouldMatchers
import scala.collection.mutable.Stack
import learning.NumberCruncher
import spec.MockOutput

trait MockListInput extends learning.Input {
     val l = List("1","2","3",false)
     var i = 0
     var current = l(i)
     override def getInput() = {i=i++;current}
  }

class NumberCruncherSpec extends Spec with ShouldMatchers {

  describe("Take a series of numbers and sort them in either ascending or descending order") {
      
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
      
      it "should build a list from a series of strings"{
        val num = new NumberCruncher with MockInput
              
      
      }
      
      
      
  }
}