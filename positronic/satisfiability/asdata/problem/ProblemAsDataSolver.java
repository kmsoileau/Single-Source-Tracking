package positronic.satisfiability.asdata.problem;

import java.util.List;

import positronic.satisfiability.asdata.clause.ClauseAsData;
import positronic.satisfiability.asdata.clause.ClauseAsDataFixer;
import positronic.satisfiability.asdata.clause.ClauseAsDataSolver;
import positronic.satisfiability.asdata.clause.IClauseAsData;
import positronic.satisfiability.elements.BooleanLiteral;
import positronic.satisfiability.elements.BooleanVariable;
import positronic.satisfiability.elements.Clause;
import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.IBooleanLiteral;
import positronic.satisfiability.elements.IBooleanVariable;
import positronic.satisfiability.elements.IClause;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;

public class ProblemAsDataSolver extends Problem implements IProblem
{
	private static final long serialVersionUID = -7014017023460519813L;

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
		IClauseAsData[] clauses = new IClauseAsData[]{c1,c2};
		IProblemAsData p=new ProblemAsData(clauses);
		IProblem prob=new Conjunction(prob1,prob2,
				new ProblemAsDataSolver(p));
		List<IBooleanLiteral> s=prob.findModel(Problem.defaultSolver());
		System.out.println("Reporting...");
		if(s!=null && s.size()>0)
		{
			BooleanLiteral.interpret(s);
			for(IClauseAsData cl : clauses)
				System.out.println(cl);
			for(IBooleanVariable bv : ClauseAsData.getVARIABLES())
				System.out.println(bv);
		}
		else
			System.out.println("No solution.");
		
		System.out.println(p.toProblem());
	}
	
	public ProblemAsDataSolver(IClauseAsData[] clause) throws Exception 
	{
		IProblem prob=null;
		for(IClauseAsData cl : clause)
			prob=new Conjunction(prob,new ClauseAsDataSolver(cl));
		this.setClauses(prob.getClauses());
	}
	
	public ProblemAsDataSolver(IProblemAsData problem) throws Exception 
	{
		this(problem.getClausesArray());
	}
}
