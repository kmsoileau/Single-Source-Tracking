package positronic.satisfiability.asdata.clause;

import java.util.List;

import positronic.satisfiability.elements.BitFixer;
import positronic.satisfiability.elements.BitUnequalizer;
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

public class ClauseAsDataSolver extends Problem implements IProblem
{
	private static final long serialVersionUID = -7888023713289960699L;

	public static void main(String[] args) throws Exception
	{
		IBooleanVariable A=BooleanVariable.getBooleanVariable("A");
		IBooleanVariable B=BooleanVariable.getBooleanVariable("B");
		
		ClauseAsData.declare(new IBooleanVariable[]{A,B});
		
		IClause[] clauses=new IClause[]{
				Clause.newClause().or(A).nor(B),
				Clause.newClause().or(A).or(B)};
		
		IClauseAsData[] dataclauses=new IClauseAsData[]{
				new ClauseAsData(),
				new ClauseAsData()};
		
		IProblem[] probs=new IProblem[]{
				new Conjunction(new ClauseAsDataFixer(dataclauses[0],clauses[0]),new ClauseAsDataSolver(dataclauses[0])),
				new Conjunction(new ClauseAsDataFixer(dataclauses[1],clauses[1]),new ClauseAsDataSolver(dataclauses[1]))};
		
		IProblem prob=new Conjunction(probs);
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
	
	public ClauseAsDataSolver(IClauseAsData dataclauses) throws Exception
	{
		IProblem prob=null;
		for(IBooleanVariable bv : ClauseAsData.getVARIABLES())
			prob=new Disjunction(prob,new Conjunction(
					new BitFixer(dataclauses.occurrenceIndicator(bv),true),
					new BitUnequalizer(bv,dataclauses.barredIndicator(bv))));
		this.setClauses(prob.getClauses());
	}
}
