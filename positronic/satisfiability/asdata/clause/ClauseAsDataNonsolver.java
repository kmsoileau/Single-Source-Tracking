package positronic.satisfiability.asdata.clause;

import java.util.List;

import positronic.satisfiability.elements.BitEqualizer;
import positronic.satisfiability.elements.BitFixer;
import positronic.satisfiability.elements.BooleanLiteral;
import positronic.satisfiability.elements.BooleanVariable;
import positronic.satisfiability.elements.Clause;
import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.Disjunction;
import positronic.satisfiability.elements.IBooleanLiteral;
import positronic.satisfiability.elements.IBooleanVariable;
import positronic.satisfiability.elements.IClause;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;

public class ClauseAsDataNonsolver extends Problem implements IProblem
{
	private static final long serialVersionUID = 6778768848890457524L;

	public static void main(String[] args) throws Exception
	{
		IBooleanVariable A=BooleanVariable.getBooleanVariable("A");
		IBooleanVariable B=BooleanVariable.getBooleanVariable("B");
		
		ClauseAsData.declare(new IBooleanVariable[]{A,B});
		
		IClause clause=Clause.newClause().nor(B);
		
		IClauseAsData dataclause=new ClauseAsData();
		
		IProblem prob=new Conjunction(new ClauseAsDataFixer(dataclause,clause),
				new ClauseAsDataNonsolver(dataclause));
		
		System.out.println(prob);
				
		List<IBooleanLiteral> s=prob.findModel(Problem.defaultSolver());
		System.out.println("Reporting...");
		if(s!=null && s.size()>0)
		{
			BooleanLiteral.interpret(s);
			System.out.println(A);
			System.out.println(B);
		}
		else
			System.out.println("No solution.");
	}
	
	public ClauseAsDataNonsolver(IClauseAsData dataclause) throws Exception
	{
		IProblem prob=null;
		for(IBooleanVariable bv : ClauseAsData.getVARIABLES())
			prob=new Conjunction(prob,new Disjunction(
					new BitFixer(dataclause.occurrenceIndicator(bv),false),
					new BitEqualizer(bv,dataclause.barredIndicator(bv))));
		this.setClauses(prob.getClauses());
	}
}
