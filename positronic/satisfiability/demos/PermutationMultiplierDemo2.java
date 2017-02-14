package positronic.satisfiability.demos;

import java.util.List;

import positronic.satisfiability.elements.BooleanLiteral;
import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.IBooleanLiteral;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;
import positronic.satisfiability.naturalnumber.INaturalNumber;
import positronic.satisfiability.naturalnumber.NaturalNumber;
import positronic.satisfiability.naturalnumber.NaturalNumberFixer;
import positronic.satisfiability.naturalnumberlist.permutation.Permutation;
import positronic.satisfiability.naturalnumberlist.permutation.PermutationFixer;
import positronic.satisfiability.naturalnumberlist.permutation.PermuterMultiplier;

public class PermutationMultiplierDemo2 
{
	public static void main(String[] args) throws Exception
	{
		INaturalNumber x=new NaturalNumber("x");
		INaturalNumber y=new NaturalNumber("y");

		Permutation perm1 = new Permutation(5);
		Permutation perm2 = new Permutation(5);
		
		for(int k=0;k<perm1.getOrder();k++)
		{
			IProblem p=new Conjunction(
					new NaturalNumberFixer(x,k),
					new PermutationFixer(perm1,new long[]{1,2,0,3,4}),
					new PermutationFixer(perm2,new long[]{4,0,1,3,2}),
					new PermuterMultiplier(x,y,perm1,perm2));
	
	    List<IBooleanLiteral> s=p.findModel(Problem.defaultSolver());
			if(s!=null && s.size()>0)
	    {
				BooleanLiteral.interpret(s);
	    	System.out.println(x+"->"+y);
	    }
	    else
	    	System.out.println("No solution.");
		}
	}
}
