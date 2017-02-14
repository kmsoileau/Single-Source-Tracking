package positronic.satisfiability.demos.naturalnumberlist;

import java.util.List;

import positronic.satisfiability.elements.BooleanLiteral;
import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.IBooleanLiteral;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;
import positronic.satisfiability.naturalnumberlist.INaturalNumberList;
import positronic.satisfiability.naturalnumberlist.NaturalNumberList;
import positronic.satisfiability.naturalnumberlist.NaturalNumberListFixer;
import positronic.satisfiability.naturalnumberlist.NaturalNumberListJoiner;

public class NaturalNumberListJoinerDemo
{
	public static void main(String[] args) throws Exception
	{
		INaturalNumberList a=new NaturalNumberList("A",
    		new long[]{
        137,
        156,
      });
    IProblem aFix=new NaturalNumberListFixer(a);
    
    INaturalNumberList b=new NaturalNumberList("B",
    		new long[]{
        212
      });
    IProblem bFix=new NaturalNumberListFixer(b);

    INaturalNumberList target=new NaturalNumberList("target",
    		new long[3]);

    IProblem problem=new Conjunction(aFix,bFix,new NaturalNumberListJoiner(target,a,b));
	
    System.out.println(problem);
    
    List<IBooleanLiteral> s=problem.findModel(Problem.defaultSolver());
		if(s!=null && s.size()>0)
    {
      BooleanLiteral.interpret(s);
    	System.out.println("slm= "+a);
    	System.out.println("bsl= "+b);
    	System.out.println("target= "+target);
    }
    else
      System.out.println("No solution.");
	
	}

}
