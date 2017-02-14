package positronic.satisfiability.demos.integer;

import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.integer.IInteger;
import positronic.satisfiability.integer.Integer;
import positronic.satisfiability.integer.IntegerFixer;
import positronic.satisfiability.integer.IntegerMultiplier;

public class IntegerMultiplierDemo
{
	public static void main(String[] args) throws Exception
	{
		IInteger i1=new Integer("multiplier1");
		IInteger i2=new Integer("multiplier2",67L);
		IInteger i3=new Integer("product");
		
		IProblem p1=new IntegerFixer(i1,2L);
		IProblem p2=new IntegerFixer(i2);
		IProblem p3=new IntegerMultiplier(i1,i2,i3);
		
		IProblem problem=new Conjunction(p1,p2,p3);
		
		System.out.println(problem);
    
		/*
		List<IBooleanLiteral> s=problem.findModel(Problem.defaultSolver());

		if(s!=null && s.size()>0)
		{
			BooleanLiteral.interpret(s);
			System.out.println(i1);
			System.out.println(i2);
			System.out.println(i3);
		}
		else
			System.out.println("No solution.");
			*/
		
		System.out.println(problem.toCode());
		
	}
}
