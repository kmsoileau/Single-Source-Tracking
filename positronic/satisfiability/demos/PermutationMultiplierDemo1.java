package positronic.satisfiability.demos;

import java.util.List;

import positronic.satisfiability.elements.BooleanLiteral;
import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.IBooleanLiteral;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;
import positronic.satisfiability.naturalnumberlist.permutation.Permutation;
import positronic.satisfiability.naturalnumberlist.permutation.PermutationFixer;
import positronic.satisfiability.naturalnumberlist.permutation.PermuterMultiplier;

public class PermutationMultiplierDemo1 
{
	public static void main(String[] args) throws Exception
	{
		Permutation perm1 = new Permutation(5);
		Permutation perm2 = new Permutation(5);
		Permutation perm3 = new Permutation(5);
		Permutation perm4 = new Permutation(5);
		Permutation product = new Permutation(5);
		
		IProblem p=new Conjunction(new IProblem[]{
				new PermutationFixer(perm1,new long[]{1,2,0,3,4}),
				new PermutationFixer(perm2,new long[]{4,0,1,3,2}),
				new PermutationFixer(perm3,new long[]{2,1,4,3,0}),
				new PermutationFixer(perm4,new long[]{3,4,2,0,1}),
				new PermuterMultiplier(
						new Permutation[]{perm1,perm2,perm3,perm4},
							product)});
		
		List<IBooleanLiteral> s=p.findModel(Problem.defaultSolver());
		if(s!=null && s.size()>0)
		{
			BooleanLiteral.interpret(s);
			System.out.println(perm1);
			System.out.println(perm2);
			System.out.println(perm3);
			System.out.println(perm4);
			System.out.println("----------------$");
			System.out.println(product);
		}
		else
			System.out.println("No solution.");
	}
}
