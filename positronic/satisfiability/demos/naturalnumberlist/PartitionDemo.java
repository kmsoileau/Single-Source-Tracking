package positronic.satisfiability.demos.naturalnumberlist;

import java.util.List;

import positronic.satisfiability.elements.BitNoter;
import positronic.satisfiability.elements.BooleanLiteral;
import positronic.satisfiability.elements.BooleanVariable;
import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.IBooleanLiteral;
import positronic.satisfiability.elements.IBooleanVariable;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;
import positronic.satisfiability.naturalnumber.ConditionalAdder;
import positronic.satisfiability.naturalnumber.INaturalNumber;
import positronic.satisfiability.naturalnumber.NaturalNumber;
import positronic.satisfiability.naturalnumber.NaturalNumberEqualizer;
import positronic.satisfiability.naturalnumberlist.NaturalNumberList;
import positronic.satisfiability.naturalnumberlist.NaturalNumberListFixer;

public class PartitionDemo 
{
	public static void main(String[] args) throws Exception
	{
		long[] itemValue=new long[]{20,11,34,17,21,52,45,68,10,11,34,17,41,72,45,78};
		
		NaturalNumberList values=new NaturalNumberList("value",itemValue);
		
		System.out.println("Compiling...");
		INaturalNumber leftSetSum=new NaturalNumber();
		INaturalNumber rightSetSum=new NaturalNumber();
		IBooleanVariable[] leftSetMembership=new BooleanVariable[itemValue.length];
		IBooleanVariable[] rightSetMembership=new IBooleanVariable[itemValue.length];
		
		for(int i=0;i<itemValue.length;i++)
		{
			leftSetMembership[i]=BooleanVariable.getBooleanVariable();
			rightSetMembership[i]=BooleanVariable.getBooleanVariable();
		}
		
		IProblem problem=new Conjunction(new IProblem[]{
				new ConditionalAdder(values,leftSetMembership,leftSetSum),
					new ConditionalAdder(values,rightSetMembership,rightSetSum),
						new NaturalNumberEqualizer(leftSetSum,rightSetSum),
							 new NaturalNumberListFixer(values)});
			
		for(int i=0;i<itemValue.length;i++)
			problem=new Conjunction(problem, 
						new BitNoter(leftSetMembership[i],rightSetMembership[i]));
		
		System.out.println(problem);
	    
		System.out.println("Solving SAT problem...");
		List<IBooleanLiteral> s=problem.findModel(Problem.defaultSolver());
		System.out.println("Reporting...");
		if(s!=null && s.size()>0)
		{
			BooleanLiteral.interpret(s);
			System.out.println("First partition:");
			for(int item=0;item<itemValue.length;item++)
				if(leftSetMembership[item].getValue())
					System.out.println(values.getNaturalNumber(item));
			System.out.println("\tTotaling "+leftSetSum);
			System.out.println("Second partition:");
			for(int item=0;item<itemValue.length;item++)
				if(rightSetMembership[item].getValue())
					System.out.println(values.getNaturalNumber(item));
			System.out.println("\tTotaling "+rightSetSum);
		}
		else
			System.out.println("No solution.");
	}
}
