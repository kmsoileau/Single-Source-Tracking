package positronic.satisfiability.demos.bit;

import java.util.List;

import positronic.satisfiability.elements.BitFixer;
import positronic.satisfiability.elements.BitXorer;
import positronic.satisfiability.elements.BooleanLiteral;
import positronic.satisfiability.elements.BooleanVariable;
import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.IBooleanLiteral;
import positronic.satisfiability.elements.IBooleanVariable;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;

public class BitXorerDemo
{
  public static void main(String[] args) throws Exception
  {
    IBooleanVariable x=BooleanVariable.getBooleanVariable("x");
    IBooleanVariable y=BooleanVariable.getBooleanVariable("y");
    IBooleanVariable z=BooleanVariable.getBooleanVariable("z");
    
    IProblem fixx=new BitFixer(x,false);
    IProblem fixz=new BitFixer(z,true);
    IProblem bitXorer1 = new BitXorer(x,y,z);

    IProblem problem=new Conjunction(fixx,fixz,bitXorer1);
    System.out.println(bitXorer1);
    
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