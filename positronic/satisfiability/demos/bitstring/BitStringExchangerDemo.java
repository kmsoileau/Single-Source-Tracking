package positronic.satisfiability.demos.bitstring;

import java.util.List;

import positronic.satisfiability.bitstring.BitString;
import positronic.satisfiability.bitstring.BitStringExchanger;
import positronic.satisfiability.bitstring.BitStringFixer;
import positronic.satisfiability.bitstring.IBitString;
import positronic.satisfiability.elements.BooleanLiteral;
import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.IBooleanLiteral;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;

public class BitStringExchangerDemo 
{
	public static void main(String[] args) throws Exception
	{
		IBitString xBefore=new BitString("01011");
		IBitString yBefore=new BitString("11010");
		IBitString xAfter=new BitString(5);
		IBitString yAfter=new BitString(5);
		
		IProblem p=new Conjunction(new IProblem[]{
				new BitStringFixer(xBefore),
				new BitStringFixer(yBefore),
				new BitStringExchanger(xBefore,yBefore,
						xAfter,yAfter)
				});
		
		System.out.println(p);
		
		List<IBooleanLiteral> s=p.findModel(Problem.defaultSolver());
		if(s!=null && s.size()>0)
		{
			BooleanLiteral.interpret(s);
			System.out.println("xBefore="+xBefore.toBits());
			System.out.println("yBefore="+yBefore.toBits());
			System.out.println("xAfter="+xAfter.toBits());
			System.out.println("yAfter="+yAfter.toBits());
		}
		else
			System.out.println("No solution.");
	}
}

