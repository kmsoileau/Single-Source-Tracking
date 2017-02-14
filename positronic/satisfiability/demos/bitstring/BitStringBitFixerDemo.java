package positronic.satisfiability.demos.bitstring;

import java.util.List;

import positronic.satisfiability.bitstring.BitString;
import positronic.satisfiability.bitstring.BitStringBitFixer;
import positronic.satisfiability.bitstring.IBitString;
import positronic.satisfiability.elements.BooleanLiteral;
import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.IBooleanLiteral;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;

public class BitStringBitFixerDemo
{
	public static void main(String[] args) throws Exception
	{
		IBitString b=new BitString(new boolean[20]);
		IProblem p1=new BitStringBitFixer(b,3,true);
		IProblem p2=new BitStringBitFixer(b,7,true);
		IProblem p=new Conjunction(p1,p2);
		List<IBooleanLiteral> s=p.findModel(Problem.defaultSolver());
		if(s!=null && s.size()>0)
    {
      BooleanLiteral.interpret(s);
    	System.out.println(b);
    }
    else
      System.out.println("No solution.");
	}
}
