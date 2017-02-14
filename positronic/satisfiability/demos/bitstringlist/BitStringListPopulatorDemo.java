package positronic.satisfiability.demos.bitstringlist;

import java.util.List;

import positronic.satisfiability.bitstring.BitString;
import positronic.satisfiability.bitstring.IBitString;
import positronic.satisfiability.bitstringlist.BitStringList;
import positronic.satisfiability.bitstringlist.BitStringListFixer;
import positronic.satisfiability.bitstringlist.BitStringListPopulator;
import positronic.satisfiability.bitstringlist.IBitStringList;
import positronic.satisfiability.elements.BooleanLiteral;
import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.IBooleanLiteral;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;

public class BitStringListPopulatorDemo 
{
	public static void main(String[] args) throws Exception
	{
		IBitStringList source=new BitStringList("source",new IBitString[]
	    {
	      new BitString("000"),
	      new BitString("001"),
	      new BitString("010"),
	      new BitString("011"),
	      new BitString("100"),
	      new BitString("101")
	    });
	
	    IBitStringList target=new BitStringList("target",new IBitString[]
	    {
	      new BitString(3),
	      new BitString(3),
	      new BitString(3),
	      new BitString(3),
	      new BitString(3),
	      new BitString(3),
	      new BitString(3),
	      new BitString(3),
	      new BitString(3),
	      new BitString(3),
	      new BitString(3),
	      new BitString(3),
	      new BitString(3),
	      new BitString(3),
	      new BitString(3),
	      new BitString(3),
	      new BitString(3),
	      new BitString(3),
	      new BitString(3),
	      new BitString(3),
	      new BitString(3),
	      new BitString(3),
	      new BitString(3),
	      new BitString(3),
	      new BitString(3),
	      new BitString(3),
	      new BitString(3),
	      new BitString(3)
	    });
	
	    IProblem problem=new Conjunction(new BitStringListFixer(source),
	    		new BitStringListPopulator(
	    				target,source));
	
	    System.out.println(problem);
	
	    List<IBooleanLiteral> s=problem.findModel(Problem.defaultSolver());
	
	    if(s!=null && s.size()>0)
	    {
	      BooleanLiteral.interpret(s);
	    	System.out.println(source.toBits());
	    	System.out.println(target.toBits());
	    }
	    else
	      System.out.println("No solution.");
  }
}
