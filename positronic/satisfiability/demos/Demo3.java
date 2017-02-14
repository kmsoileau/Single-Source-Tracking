package positronic.satisfiability.demos;

import java.util.List;

import positronic.satisfiability.elements.BitAnder;
import positronic.satisfiability.elements.BitFixer;
import positronic.satisfiability.elements.BooleanLiteral;
import positronic.satisfiability.elements.BooleanVariable;
import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.IBooleanLiteral;
import positronic.satisfiability.elements.IBooleanVariable;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;
/**
 * <p>Title: TBS</p>
 * <p>Description: TBS</p>
 * <p>Copyright (c) 2005</p>
 * <p>Company: Positronic Software</p>
 * @author Kerry Michael Soileau
 * @version 1.0
 */

public class Demo3
{
  public static void main(String[] args) throws Exception
  {
    IBooleanVariable x=BooleanVariable.getBooleanVariable("x");
    IBooleanVariable y=BooleanVariable.getBooleanVariable("y");
    IBooleanVariable z=BooleanVariable.getBooleanVariable("z");

    BitFixer bf1=new BitFixer(x,true);
    BitFixer bf2=new BitFixer(z,false);
    BitAnder p1=new BitAnder(x,y,z);

    IProblem problem=new Conjunction(bf1,bf2,p1);
    System.out.println(problem);
    List<IBooleanLiteral> s=problem.findModel(Problem.defaultSolver());
		if(s!=null && s.size()>0)
    {
      BooleanLiteral.interpret(s);
    	System.out.println("x= "+x.getValue());
    	System.out.println("y= "+y.getValue());
    	System.out.println("z= "+z.getValue());
    }
    else
      System.out.println("No solution.");
  }
}