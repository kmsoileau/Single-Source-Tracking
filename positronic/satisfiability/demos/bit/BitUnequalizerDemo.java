package positronic.satisfiability.demos.bit;

import java.util.List;

import positronic.satisfiability.elements.BitFixer;
import positronic.satisfiability.elements.BitUnequalizer;
import positronic.satisfiability.elements.BooleanLiteral;
import positronic.satisfiability.elements.BooleanVariable;
import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.IBooleanLiteral;
import positronic.satisfiability.elements.IBooleanVariable;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;

public class BitUnequalizerDemo
{
  public static void main(String[] args) throws Exception
  {
    IBooleanVariable x=BooleanVariable.getBooleanVariable("x");
    IBooleanVariable y=BooleanVariable.getBooleanVariable("y");

    IProblem fixx=new BitFixer(x,true);
    IProblem fixy=new BitFixer(y,false);
    IProblem bitUnequalizer1 = new BitUnequalizer(x,y);

    IProblem problem=new Conjunction(fixx,fixy,bitUnequalizer1);
    System.out.println(problem);
    List<IBooleanLiteral> s=problem.findModel(Problem.defaultSolver());
		if(s!=null && s.size()>0)
    {
      BooleanLiteral.interpret(s);
    	System.out.println("x= "+x.getValue());
    	System.out.println("y= "+y.getValue());
    }
    else
      System.out.println("No solution.");
  }
}