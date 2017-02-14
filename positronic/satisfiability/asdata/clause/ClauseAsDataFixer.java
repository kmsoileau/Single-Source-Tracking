package positronic.satisfiability.asdata.clause;

import java.util.List;

import positronic.satisfiability.elements.BitFixer;
import positronic.satisfiability.elements.BooleanLiteral;
import positronic.satisfiability.elements.BooleanVariable;
import positronic.satisfiability.elements.Clause;
import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.IBooleanLiteral;
import positronic.satisfiability.elements.IBooleanVariable;
import positronic.satisfiability.elements.IClause;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;

public class ClauseAsDataFixer extends Problem implements IProblem
{
	private static final long serialVersionUID = -199034896390290432L;

	public static void main(String[] args) throws Exception
	{
		IBooleanVariable A=BooleanVariable.getBooleanVariable("A");
		IBooleanVariable B=BooleanVariable.getBooleanVariable("B");
		IBooleanVariable C=BooleanVariable.getBooleanVariable("C");
		IBooleanVariable D=BooleanVariable.getBooleanVariable("D");
		IBooleanVariable E=BooleanVariable.getBooleanVariable("E");
		IBooleanVariable F=BooleanVariable.getBooleanVariable("F");
		
		ClauseAsData.declare(new IBooleanVariable[]{
					B,
					A,
					F,
					E,
					C,
					D});
		
		IClauseAsData c1=new ClauseAsData();
		IClause clause1=Clause.newClause().nor(A).or(B);
		IClauseAsData c2=new ClauseAsData();
		IClause clause2=Clause.randomClause(ClauseAsData.getVARIABLES());
		
		IProblem prob1=new ClauseAsDataFixer(c1,clause1);
		IProblem prob2=new ClauseAsDataFixer(c2,clause2);
		IProblem prob=new Conjunction(prob1,prob2);
		System.out.println(prob);
				
		List<IBooleanLiteral> s=prob.findModel(Problem.defaultSolver());
		System.out.println("Reporting...");
		if(s!=null && s.size()>0)
		{
			BooleanLiteral.interpret(s);
			System.out.println(clause1);
			System.out.println(c1);
			System.out.println(clause2);
			System.out.println(c2);
		}
		else
			System.out.println("No solution.");
		
		System.out.println(">\t"+c1.toClause());
		System.out.println(">\t"+c2.toClause());
	}
	
	public ClauseAsDataFixer(IClauseAsData c, IClause clause) throws Exception
	{
		IProblem prob=null;
		
		label: 
		for(IBooleanVariable bv : ClauseAsData.getVARIABLES())
		{
			IBooleanVariable occurs = c.occurrenceIndicator(bv);
			IBooleanVariable barred = c.barredIndicator(bv);
			
			for(int lit=0;lit<clause.size();lit++)
			{
				IBooleanLiteral v = clause.getLiteralAt(lit);
				if(v.getBooleanVariable().equals(bv))
				{
					prob = new Conjunction(prob,
							new BitFixer(occurs,true),
							new BitFixer(barred,v.isBarred()));
					continue label;
				}
			}
			prob = new Conjunction(prob,
					new BitFixer(occurs,false),
					new BitFixer(barred,false));
		}
			
		this.setClauses(prob.getClauses());
	}
}
