package positronic.satisfiability.demos.bitstring;

import java.util.List;

import positronic.satisfiability.bitstring.BitString;
import positronic.satisfiability.bitstring.BitStringZerothBitFixer;
import positronic.satisfiability.bitstring.IBitString;
import positronic.satisfiability.elements.BooleanLiteral;
import positronic.satisfiability.elements.IBooleanLiteral;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;

public class BitStringZerothBitFixerDemo
{

	public static void main(String[] args) throws Exception
	{
		IBitString b=new BitString(new boolean[20]);
		IProblem problem=new BitStringZerothBitFixer(b,false);

		System.out.println(problem);
		List<IBooleanLiteral> s=problem.findModel(Problem.defaultSolver());

    if(s!=null && s.size()>0)
    {
    	BooleanLiteral.interpret(s);
    	System.out.println(b);
    }
    else
      System.out.println("No solution.");
	}
}