package positronic.satisfiability.demos.naturalnumber;

import java.util.List;

import positronic.satisfiability.elements.BooleanLiteral;
import positronic.satisfiability.elements.IBooleanLiteral;
import positronic.satisfiability.elements.Problem;
import positronic.satisfiability.naturalnumber.INaturalNumber;
import positronic.satisfiability.naturalnumber.NaturalNumber;
import positronic.satisfiability.naturalnumber.NaturalNumberFixer;

public class NaturalNumberFixerDemo2
{
  public static void main(String[] args) throws Exception
  {
    INaturalNumber X=new NaturalNumber("X");

    for(long i=0;i<Math.pow(2.,1.*NaturalNumber.getLength());i++)
    { 
	    List<IBooleanLiteral> s=new NaturalNumberFixer(X,i).findModel(Problem.defaultSolver());
		if(s!=null && s.size()>0)
	    {
	      BooleanLiteral.interpret(s);
	    	System.out.print("\ni= "+i);
	    	System.out.print("\tX= "+X);
	    }
	    else
	      System.out.print("No solution.");
    }
  }
}