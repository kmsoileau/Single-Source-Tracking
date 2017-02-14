package positronic.satisfiability.demos.bitstringlist;

import java.util.List;

import positronic.satisfiability.bitstringlist.BitStringList;
import positronic.satisfiability.bitstringlist.BitStringListFixer;
import positronic.satisfiability.bitstringlist.BitStringListJoiner;
import positronic.satisfiability.bitstringlist.IBitStringList;
import positronic.satisfiability.elements.BooleanLiteral;
import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;

public class BitStringListJoinerDemo
{
	public static void main(String[] args) throws Exception
	{
		IBitStringList a=new BitStringList("A",
    		new boolean[][]{
        {true,false,false},
        {true,true,false},
      });
    IProblem aFix=new BitStringListFixer(a);
    
    IBitStringList b=new BitStringList("B",
    		new boolean[][]{
        {true,false,true},
      });
    IProblem bFix=new BitStringListFixer(b);

    IBitStringList target=new BitStringList("target",
    		new boolean[3][3]);

    IProblem problem=new Conjunction(aFix,bFix,new BitStringListJoiner(target,a,b));
	
    System.out.println(problem);
    
    List<?> s=problem.findModel(Problem.defaultSolver());
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
