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
 * <p>Title: MapperDemo2</p>
 * <p>Description: TBS</p>
 * <p>Copyright (c) 2005</p>
 * <p>Company: Positronic Software</p>
 * @author Kerry Michael Soileau
 * @version 1.0
 */

public class MapperDemo2
{
  public static void main(String[] args) throws Exception
  {
    INaturalNumber x=new NaturalNumber("x");
    INaturalNumber y=new NaturalNumber("y");
    
    Mapper map = new Mapper(
    		new ProblemPair[]
    		    {
    					new ProblemPair(new NaturalNumberFixer(x,1),new NaturalNumberFixer(y,31)),
    					new ProblemPair(new NaturalNumberFixer(x,2),new NaturalNumberFixer(y,28)),
    					new ProblemPair(new NaturalNumberFixer(x,3),new NaturalNumberFixer(y,31)),
    					new ProblemPair(new NaturalNumberFixer(x,4),new NaturalNumberFixer(y,30)),
    					new ProblemPair(new NaturalNumberFixer(x,5),new NaturalNumberFixer(y,31)),
    					new ProblemPair(new NaturalNumberFixer(x,6),new NaturalNumberFixer(y,30)),
    					new ProblemPair(new NaturalNumberFixer(x,7),new NaturalNumberFixer(y,31)),
    					new ProblemPair(new NaturalNumberFixer(x,8),new NaturalNumberFixer(y,31)),
    					new ProblemPair(new NaturalNumberFixer(x,9),new NaturalNumberFixer(y,30)),
    					new ProblemPair(new NaturalNumberFixer(x,10),new NaturalNumberFixer(y,31)),
    					new ProblemPair(new NaturalNumberFixer(x,11),new NaturalNumberFixer(y,30)),
    					new ProblemPair(new NaturalNumberFixer(x,12),new NaturalNumberFixer(y,31))
    				});
    
    IProblem problem=new Conjunction(new NaturalNumberFixer(x,7),map);
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