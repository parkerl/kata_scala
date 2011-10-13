import org.scalatest.Spec
import org.scalatest.matchers.ShouldMatchers
import scala.collection.mutable.Stack
import learning.SciCalc

class SciCalcSpec extends Spec with ShouldMatchers {

  describe("Calculate numbers based on input") {
      
      it("ask for an initial calculation") {
         val calc = new SciCalc with MockInputCapturePrompt
         calc.run
         calc.messages should be(List("enter a calculation> "))
         
      }
      
      it("should parse 1 + 1 into a calculation"){
        val calc = new SciCalc
        
        calc.parseCalc("1 + 1") should be(("1","+","1"))
      }
       
       it("should parse +1 into a calculation"){
        val calc = new SciCalc
        
        calc.parseCalc("+1") should be(("","+","1"))
      }

      
      
       it("calculate 1 + 1 = 2") {
         val calc = new SciCalc
         calc.calculate(("1","+","1")) should be(2)
         
                  
      }
      
      it("should calculate 10 / 5 = 2"){
        val calc = new SciCalc
        calc.calculate(("10", "/", "5")) should be(2)
      }
      
      it("should string together subsequent calculations, 1 +1, + 1 = 3"){
        val calc = new SciCalc with MockListInput with MockOutputResultCapture
        calc.setInput(List("1+1","+1","",""))
        calc.run
        calc.outmessages should be(List("= 2.0","= 3.0"))
      }
      
    }
}