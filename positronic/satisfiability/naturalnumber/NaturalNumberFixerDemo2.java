package positronic.satisfiability.naturalnumber;

import java.util.List;

import org.sat4j.minisat.SolverFactory;

import positronic.satisfiability.elements.BooleanLiteral;

public class NaturalNumberFixerDemo2
{
  public static void main(String[] args) throws Exception
  {
    INaturalNumber X=new NaturalNumber("X");

    for(long i=0;i<Math.pow(2.,1.*NaturalNumber.getLength());i++)
    { 
	    List<?> s=new NaturalNumberFixer(X,i).findModel(SolverFactory.newMiniSATHeap());
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