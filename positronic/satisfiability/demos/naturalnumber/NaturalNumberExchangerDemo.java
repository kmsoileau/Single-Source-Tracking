package positronic.satisfiability.demos.naturalnumber;

import java.util.List;

import positronic.satisfiability.elements.BooleanLiteral;
import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.IBooleanLiteral;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;
import positronic.satisfiability.naturalnumber.INaturalNumber;
import positronic.satisfiability.naturalnumber.NaturalNumber;
import positronic.satisfiability.naturalnumber.NaturalNumberExchanger;
import positronic.satisfiability.naturalnumber.NaturalNumberFixer;

public class NaturalNumberExchangerDemo 
{
	public static void main(String[] args) throws Exception
	{
		INaturalNumber xBefore=new NaturalNumber(12);
		INaturalNumber yBefore=new NaturalNumber(8);
		INaturalNumber xAfter=new NaturalNumber();
		INaturalNumber yAfter=new NaturalNumber();
		
		IProblem p=new Conjunction(new IProblem[]{
				new NaturalNumberFixer(xBefore),
				new NaturalNumberFixer(yBefore),
				new NaturalNumberExchanger(xBefore,yBefore,
						xAfter,yAfter)
				});
		
		List<IBooleanLiteral> s=p.findModel(Problem.defaultSolver());
		if(s!=null && s.size()>0)
		{
			BooleanLiteral.interpret(s);
			System.out.println("xBefore="+xBefore);
			System.out.println("yBefore="+yBefore);
			System.out.println("xAfter="+xAfter);
			System.out.println("yAfter="+yAfter);
		}
		else
			System.out.println("No solution.");
	}
}
