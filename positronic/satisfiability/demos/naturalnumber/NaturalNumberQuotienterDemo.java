package positronic.satisfiability.demos.naturalnumber;

import java.util.List;

import positronic.satisfiability.elements.BooleanLiteral;
import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.IBooleanLiteral;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;
import positronic.satisfiability.naturalnumber.INaturalNumber;
import positronic.satisfiability.naturalnumber.NaturalNumber;
import positronic.satisfiability.naturalnumber.NaturalNumberFixer;
import positronic.satisfiability.naturalnumber.NaturalNumberQuotienter;

public class NaturalNumberQuotienterDemo
{
  public static void main(String[] args) throws Exception
  {
    INaturalNumber Dividend=new NaturalNumber("X");
    INaturalNumber Divisor=new NaturalNumber("Y");
    INaturalNumber Quotient=new NaturalNumber("Z");
    INaturalNumber Remainder=new NaturalNumber("C");

    IProblem p=new Conjunction(new IProblem[]
    		{
	    		new NaturalNumberQuotienter(Dividend,Divisor,Quotient,Remainder),
    			new NaturalNumberFixer(Quotient,194L),
    			new NaturalNumberFixer(Remainder,9L),
    			
    		}
    		);
    
    System.out.println(p);
    
    List<IBooleanLiteral> s=p.findModel(Problem.defaultSolver());
		if(s!=null && s.size()>0)
    {
      BooleanLiteral.interpret(s);
      System.out.println("X = "+Dividend);
      System.out.println("Y = "+Divisor);
      System.out.println("Z = "+Quotient);
      System.out.println("C = "+Remainder);
    }
		else
      System.out.println("No solution.");
  }
}