import org.scalatest.Spec
import org.scalatest.matchers.ShouldMatchers
import scala.collection.mutable.Stack
import learning.FlowCalc

/*
Reynolds number is calculated using formula (D*v*rho)/mu Where D = Diameter, V= velocity, rho = density mu = viscosity 
Write a program that will accept all values in appropriate units (Don’t worry about unit conversion) If number is < 2100, display Laminar flow, 
If it’s between 2100 and 4000 display ’Transient flow’ and if more than ’4000’, display ’Turbulent Flow’ (If, else, then...) 
*/




class FlowCalcSpec extends Spec with ShouldMatchers {

  describe("Calculate flow based on user inputs for Diameter, velocity, density and viscosity") {
      
      it("ask for inputs for Diameter, velocity, density and viscosity") {
         val calc = new FlowCalc with MockInputCapturePrompt
         calc.setInput(List("1","1","1","1","N"))
         calc.run
        
         calc.messages should be(List("Diameter> ", "Velocity> ", "Density> ", "Viscosity> ", "Calculate again?> " ))
      }
      
       it("calculate the flow and output Laminar for flow type when given 1,1,1,1") {
         val calc = new FlowCalc with MockListInput with MockOutputResultCapture
         calc.setInput(List("1","1","1","1","N"))
         calc.run
         
         calc.outmessages should be(List("1 : Laminar Flow" ))
      }
      
      it("calculate the flow and output Transient for flow type when given 22,100,10,10") {
         val calc = new FlowCalc with MockListInput with MockOutputResultCapture
         calc.setInput(List("22","100","10","10","N"))
         calc.run
         
         calc.outmessages should be(List("2200 : Transient Flow" ))
      }
      
      it("calculate the flow and output Turbulent for flow type when given 44,100,10,10") {
         val calc = new FlowCalc with MockListInput with MockOutputResultCapture
         calc.setInput(List("44","100","10","10","N"))
         calc.run
         
         calc.outmessages should be(List("4400 : Turbulent Flow" ))
      }
      
      it("should ask for parameters again if the user enters Y when prompted"){
        val calc = new FlowCalc with MockInputCapturePrompt with MockOutputResultCapture
         calc.setInput(List("1","1","1","1","Y","1","1","1","1","N"))
         calc.run
         
         val putlist = List("Diameter> ", "Velocity> ", "Density> ", "Viscosity> ", "Calculate again?> " )
         calc.messages should be(putlist ::: putlist)
         
         val outlist = List("1 : Laminar Flow" )
         calc.outmessages should be(outlist ::: outlist)

      }
      
           
      
  }
}