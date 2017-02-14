package positronic.satisfiability.demos.integer;

import java.util.List;

import positronic.satisfiability.elements.BooleanLiteral;
import positronic.satisfiability.elements.IBooleanLiteral;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;
import positronic.satisfiability.integer.IInteger;
import positronic.satisfiability.integer.Integer;
import positronic.satisfiability.integer.IntegerFixer;

public class IntegerFixerDemo
{
	public static void main(String[] args) throws Exception
	{
		IInteger i1=new Integer("sample",482L);
		
		IProblem problem=new IntegerFixer(i1);
		
		System.out.println(problem);
    
		List<IBooleanLiteral> s=problem.findModel(Problem.defaultSolver());

		if(s!=null && s.size()>0)
		{
			BooleanLiteral.interpret(s);
			System.out.println(i1);
		}
		else
			System.out.println("No solution.");
		
		String sss=((Problem)problem).toSatSimTable();
		System.out.println(sss);
	}
}
