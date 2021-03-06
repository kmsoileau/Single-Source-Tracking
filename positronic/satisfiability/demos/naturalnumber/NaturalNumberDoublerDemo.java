package positronic.satisfiability.demos.naturalnumber;
/**
 * <p>Title: TBS</p>
 * <p>Description: TBS</p>
 * <p>Copyright (c) 2005</p>
 * <p>Company: Positronic Software</p>
 * @author Kerry Michael Soileau
 * @version 1.0
 */
import java.util.List;

import positronic.satisfiability.elements.BooleanLiteral;
import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.IBooleanLiteral;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;
import positronic.satisfiability.naturalnumber.INaturalNumber;
import positronic.satisfiability.naturalnumber.NaturalNumber;
import positronic.satisfiability.naturalnumber.NaturalNumberDoubler;
import positronic.satisfiability.naturalnumber.NaturalNumberFixer;

public class NaturalNumberDoublerDemo
{
  public static void main(String[] args) throws Exception
  {
    INaturalNumber X=new NaturalNumber("X");
    INaturalNumber Y=new NaturalNumber("Y");

    for(long i=0;i<Math.pow(2.,1.*NaturalNumber.getLength())/2;i++)
    {
	    NaturalNumberFixer bnnfx=new NaturalNumberFixer(X,i);
	
	    NaturalNumberDoubler NaturalNumberDoubler1 = new NaturalNumberDoubler(X,Y);
	
	    IProblem p=new Conjunction(bnnfx,NaturalNumberDoubler1);
	    List<IBooleanLiteral> s=p.findModel(Problem.defaultSolver());
			if(s!=null && s.size()>0)
	    {
	      BooleanLiteral.interpret(s);
	    	System.out.print("\nX= "+X);
	    	System.out.print("\tY= "+Y);
	    }
	    else
	      System.out.print("No solution.");
    }
  }
}