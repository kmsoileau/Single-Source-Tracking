package positronic.satisfiability.demos.bitstring;

import java.util.List;

import positronic.satisfiability.bitstring.BitString;
import positronic.satisfiability.bitstring.BitStringFixer;
import positronic.satisfiability.bitstring.BitStringSubstringer;
import positronic.satisfiability.bitstring.IBitString;
import positronic.satisfiability.elements.BooleanLiteral;
import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;

public class BitStringSubstringerDemo
{
  public static void main(String[] args) throws Exception
  {
    // Create the BitStrings:
  	IBitString X=new BitString("X","010001");
    IBitString Y=new BitString("Y","001000101010101");
    // Construct the object that implements the constraint X is a substring of
    // Y:
    IProblem bitSubstringer1 = new BitStringSubstringer(X,Y);
    System.out.println(bitSubstringer1);
    // Fix the values of X and Y :
    IProblem bfx1=new BitStringFixer(X);
    IProblem bfy1=new BitStringFixer(Y);
    //Combine the constraints into a Problem object:
    IProblem p1=new Conjunction(bitSubstringer1,bfx1,bfy1);
    System.out.println(p1);
    //Find a solution to the Problem object :
    List<?> s=p1.findModel(Problem.defaultSolver());
    if(s!=null && s.size()>0)
    {
      BooleanLiteral.interpret(s);
    	System.out.println("X= "+X);
    	System.out.println("Y= "+Y);
    }
    else
      System.out.println("No solution.");
  }
}