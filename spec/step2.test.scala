import org.scalatest.Spec
import org.scalatest.matchers.ShouldMatchers
import scala.collection.mutable.Stack
import learning.FibPrinter
import spec.MockOutput


class FibPrinterSpec extends Spec with ShouldMatchers {

  describe("Printing fibonaci numbers up to n") {
      
      it("should print 11 when given 2") {
         val fibPrinter = new FibPrinter with MockOutput
         fibPrinter.printTo(2)
         fibPrinter.messages should be ("11")
      }
      
      it("should print 112358 when given 6") {
         val fibPrinter = new FibPrinter with MockOutput
         fibPrinter.printTo(6)
         fibPrinter.messages should be ("112358")
      }
  }
}