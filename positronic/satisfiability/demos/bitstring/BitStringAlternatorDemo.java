package positronic.satisfiability.demos.bitstring;

import java.util.List;

import positronic.satisfiability.bitstring.BitString;
import positronic.satisfiability.bitstring.BitStringAlternator;
import positronic.satisfiability.bitstring.IBitString;
import positronic.satisfiability.elements.BooleanLiteral;
import positronic.satisfiability.elements.IBooleanLiteral;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;

public class BitStringAlternatorDemo
{
	public static void main(String[] args) throws Exception
	{
		IBitString white=new BitString(new boolean[20]);
		IProblem problem=new BitStringAlternator(white);

		System.out.println(problem);
    List<IBooleanLiteral> s=problem.findModel(Problem.defaultSolver());

    if(s!=null && s.size()>0)
    {
    	BooleanLiteral.interpret(s);
    	System.out.println(white);
    }
    else
      System.out.println("No solution.");
	}

}
