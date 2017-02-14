package positronic.satisfiability.demos.naturalnumberlist.permutation;

import java.util.List;

import positronic.satisfiability.elements.BooleanLiteral;
import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.IBooleanLiteral;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;
import positronic.satisfiability.naturalnumberlist.permutation.Permutation;
import positronic.satisfiability.naturalnumberlist.permutation.PermutationFixer;

public class PermutationDemo 
{
	public static void main(String[] args) throws Exception
	{
		Permutation perm1 = new Permutation(5);
		
		IProblem p=new Conjunction(new IProblem[]{
				new PermutationFixer(perm1,new long[]{1,2,0,3,4}),
				});
		
		List<IBooleanLiteral> s=p.findModel(Problem.defaultSolver());
		if(s!=null && s.size()>0)
		{
			BooleanLiteral.interpret(s);
			System.out.println(perm1);
		}
		else
			System.out.println("No solution.");
	}
}
