package positronic.satisfiability.demos.naturalnumber;

import java.util.List;

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
import positronic.satisfiability.naturalnumber.NaturalNumberAdder;
import positronic.satisfiability.naturalnumber.NaturalNumberFixer;

public class KnapsackDemo 
{
	public static void main(String[] args) throws Exception
	{
		System.out.println("Compiling...");
		
		long knapsackCapacity=197L;
		long valueTarget=254L;
		long[] itemSize=new long[]{10,11,34,17,21,72,45,78,10,11,34,17,21,72,45,78};
		long[] itemValue=new long[]{20,31,14,27,23,52,46,38,11,21,44,11,20,12,35,68};
		
		INaturalNumber capacity=new NaturalNumber();
		INaturalNumber valueMinimum=new NaturalNumber();
		INaturalNumber totalValue=new NaturalNumber();
		INaturalNumber totalSize=new NaturalNumber();
		INaturalNumber sizeSlack=new NaturalNumber();
		INaturalNumber valueSlack=new NaturalNumber();
		INaturalNumber[] size=new INaturalNumber[itemSize.length];
		INaturalNumber[] value=new INaturalNumber[itemSize.length];
		for(int i=0;i<itemSize.length;i++)
			size[i]=new NaturalNumber();
		for(int i=0;i<itemSize.length;i++)
			value[i]=new NaturalNumber();
		//inTheKnapsack[i] indicates whether item i goes into the knapsack
		IBooleanVariable[] inTheKnapsack=new IBooleanVariable[itemSize.length];
		for(int row=0;row<itemSize.length;row++)
			inTheKnapsack[row]=BooleanVariable.getBooleanVariable();
		
		IProblem problem=new Conjunction(
				new IProblem[]{
						new NaturalNumberFixer(capacity,knapsackCapacity),
						new NaturalNumberFixer(valueMinimum,valueTarget),
						new ConditionalAdder(size, inTheKnapsack, totalSize),
						new NaturalNumberAdder(totalSize,sizeSlack,capacity),
						new ConditionalAdder(value, inTheKnapsack, totalValue),
						new NaturalNumberAdder(valueMinimum,valueSlack,totalValue)});
		for(int i=0;i<itemSize.length;i++)
			problem=new Conjunction(problem, new NaturalNumberFixer(size[i],itemSize[i]));
		for(int i=0;i<itemSize.length;i++)
			problem=new Conjunction(problem, new NaturalNumberFixer(value[i],itemValue[i]));
		
		System.out.println(problem.numberOfClauses()+" clauses generated...");
	    
		System.out.println("Solving SAT problem...");
		List<IBooleanLiteral> s=problem.findModel(Problem.defaultSolver());
		System.out.println("Reporting...");
		if(s!=null && s.size()>0)
		{
			BooleanLiteral.interpret(s);
			for(int item=0;item<itemSize.length;item++)
				if(inTheKnapsack[item].getValue())
					System.out.println("item "+item+" of size "+size[item]+" and value "+value[item]);
			System.out.println("Yielding a total value of "+totalValue);
			System.out.println("and having total size of "+totalSize);
		}
		else
			System.out.println("No solution.");
	}
}
