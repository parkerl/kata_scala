import org.scalatest.Spec
import org.scalatest.matchers.ShouldMatchers
import scala.collection.mutable.Stack
import learning.NumberPrinter




class NumberPrinterSpec extends Spec with ShouldMatchers {

  describe("Printing loops of numbers") {
      
      it("should print 1 to 5") {
        val num = new NumberPrinter with MockOutput with MockFalseInput
        num.go
        num.messages should be("12345") 
      }

      it("should print again if there is no empty input") {
        val num = new NumberPrinter with MockOutput with MockSwitchInput
        num.go
        num.messages should be("1234512345") 
      } 
  }
}