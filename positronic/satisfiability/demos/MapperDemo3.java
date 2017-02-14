package positronic.satisfiability.demos;

import java.util.List;

import positronic.satisfiability.elements.BooleanLiteral;
import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.IBooleanLiteral;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Mapper;
import positronic.satisfiability.elements.Problem;
import positronic.satisfiability.elements.ProblemPair;
import positronic.satisfiability.naturalnumber.INaturalNumber;
import positronic.satisfiability.naturalnumber.NaturalNumber;
import positronic.satisfiability.naturalnumber.NaturalNumberFixer;
/**
 * <p>Title: MapperDemo3</p>
 * <p>Description: TBS</p>
 * <p>Copyright (c) 2009</p>
 * <p>Company: Positronic Software</p>
 * @author Kerry Michael Soileau
 * @version 1.0
 */

public class MapperDemo3
{
	public static void main(String[] args) throws Exception
	{
		INaturalNumber x=new NaturalNumber("x");
	    INaturalNumber y=new NaturalNumber("y");
	    
	    Mapper shift = new Mapper(
	    		new ProblemPair[]{
	    				new ProblemPair(new NaturalNumberFixer(x,1),new NaturalNumberFixer(y,2)),
	    				new ProblemPair(new NaturalNumberFixer(x,2),new NaturalNumberFixer(y,3)),
	    				new ProblemPair(new NaturalNumberFixer(x,3),new NaturalNumberFixer(y,4)),
	    				new ProblemPair(new NaturalNumberFixer(x,4),new NaturalNumberFixer(y,5)),
	    				new ProblemPair(new NaturalNumberFixer(x,5),new NaturalNumberFixer(y,1))
	    			});
	    
	    IProblem problem=new Conjunction(new NaturalNumberFixer(x,3),shift);
	    List<IBooleanLiteral> s=problem.findModel(Problem.defaultSolver());
			if(s!=null && s.size()>0)
	    {
	      BooleanLiteral.interpret(s);
	    	System.out.println("x= "+x);
	    	System.out.println("y= "+y);
	    }
	    else
	      System.out.println("No solution.");
	  }
}