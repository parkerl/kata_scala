import learning.Output


/*
Reynolds number is calculated using formula (D*v*rho)/mu Where D = Diameter, V= velocity, rho = density mu = viscosity 
Write a program that will accept all values in appropriate units (Don’t worry about unit conversion) If number is < 2100, display Laminar flow, 
If it’s between 2100 and 4000 display ’Transient flow’ and if more than ’4000’, display ’Turbulent Flow’ (If, else, then...) 
*/

package learning{




class FlowCalc extends InputReader with Output{
  
  def calculate (d: Int, v: Int, rho: Int, mu: Int): Int  = {
  
    (d*v*rho)/mu
  
  }
  
  def flowType(flow: Int): String = {
   
    flow match{
    case f if f < 2100 => "Laminar Flow"
    case f if f >= 2100 && f <=4000  => "Transient Flow"
    case f if f > 4000 => "Turbulent Flow"
    }
    
    
  }
  
  def run{
    val d = read("Diameter> ").toInt
    val v =  read("Velocity> ").toInt
    val rho =  read("Density> ").toInt
    val mu =  read("Viscosity> ").toInt
     
     val result = calculate(d,v,rho,mu)
     
     print(result + " : " + flowType(result))
  }
  
     
  
}

object FlowCalcApp extends App {

  val fc = new FlowCalc
  fc.run

}

}