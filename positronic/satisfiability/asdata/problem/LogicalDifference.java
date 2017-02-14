package positronic.satisfiability.asdata.problem;

import positronic.satisfiability.asdata.clause.ClauseAsData;
import positronic.satisfiability.asdata.clause.ClauseAsDataFixer;
import positronic.satisfiability.asdata.clause.IClauseAsData;
import positronic.satisfiability.elements.BooleanVariable;
import positronic.satisfiability.elements.Clause;
import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.IBooleanVariable;
import positronic.satisfiability.elements.IClause;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;

//Incomplete
public class LogicalDifference extends Problem implements IProblem
{
	private static final long serialVersionUID = 5205022226202851754L;

	public static void main(String[] args) throws Exception
	{
		IBooleanVariable A=BooleanVariable.getBooleanVariable("A");
		IBooleanVariable B=BooleanVariable.getBooleanVariable("B");
		IBooleanVariable C=BooleanVariable.getBooleanVariable("C");
		IBooleanVariable D=BooleanVariable.getBooleanVariable("D");
		IBooleanVariable E=BooleanVariable.getBooleanVariable("E");
		IBooleanVariable F=BooleanVariable.getBooleanVariable("F");
		
		IBooleanVariable[] vars=new IBooleanVariable[]
		                                             {
				B,
				A,
				F,
				E,
				C,
				D};
		
		ClauseAsData.declare(vars);
		IClauseAsData c1=new ClauseAsData();
		IClause clause1=Clause.randomClause(ClauseAsData.getVARIABLES());
		IClauseAsData c2=new ClauseAsData();
		IClause clause2=Clause.randomClause(ClauseAsData.getVARIABLES());
		IProblem prob1=null;
		for(int i=0;i<clause1.size();i++)
			prob1=new Conjunction(prob1,new ClauseAsDataFixer(c1,clause1));
		IProblem prob2=null;
		for(int i=0;i<clause2.size();i++)
			prob2=new Conjunction(prob2,new ClauseAsDataFixer(c2,clause2));
	}
	
	/*
	 * Satisfied by a model that satisfies p1 but not p2
	 */
	public LogicalDifference(IProblemAsData p1,IProblemAsData p2) throws Exception
	{
		IProblem prob=null;
		prob=new Conjunction(new ProblemAsDataSolver(p1),new ProblemAsDataNonsolver(p2));
		this.setClauses(prob.getClauses());
	}
}
