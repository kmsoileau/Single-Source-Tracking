package positronic.satisfiability.demos.naturalnumber;

import java.util.List;

import positronic.satisfiability.elements.BitArraySingleSetter;
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

public class BinPackingDemo 
{
	public static void main(String[] args) throws Exception
	{
		System.out.println("Compiling...");
		long[] itemSize=new long[]{10,11,34,17,21,72,45,78,10,11,34,17,21,72,45,78};
		long[] binCapacity=new long[]{99,99,99,99,99,99};
		INaturalNumber[] size=new INaturalNumber[itemSize.length];
		INaturalNumber[] sum=new INaturalNumber[binCapacity.length];
		INaturalNumber[] binSize=new INaturalNumber[binCapacity.length];
		INaturalNumber[] slack=new INaturalNumber[binCapacity.length];
		
		IBooleanVariable[][] indic=new IBooleanVariable[itemSize.length][binCapacity.length];
		//indic[row][col] indicates whether item row goes into bin col
		for(int row=0;row<itemSize.length;row++)
			for(int col=0;col<binCapacity.length;col++)
				indic[row][col]=BooleanVariable.getBooleanVariable();
		
		IProblem problem=null;
		for(int i=0;i<itemSize.length;i++)
			size[i]=new NaturalNumber();
		for(int j=0;j<binCapacity.length;j++)
			sum[j]=new NaturalNumber();
		for(int j=0;j<binCapacity.length;j++)
		{
			binSize[j]=new NaturalNumber();
			problem=new Conjunction(problem,
					new NaturalNumberFixer(binSize[j],binCapacity[j]));
			slack[j]=new NaturalNumber();
		}
		for(int i=0;i<itemSize.length;i++)
			problem=new Conjunction(problem, new NaturalNumberFixer(size[i],itemSize[i]));
		for(int i=0;i<itemSize.length;i++)
			problem=new Conjunction(problem,new BitArraySingleSetter(indic[i]));
		IBooleanVariable[] adhoc=new IBooleanVariable[itemSize.length];
		for(int j=0;j<binCapacity.length;j++)
		{
			for(int i=0;i<itemSize.length;i++)
				adhoc[i]=indic[i][j];
			problem=new Conjunction(problem,
					new ConditionalAdder(size,adhoc,sum[j]),
						new NaturalNumberAdder(sum[j],slack[j],binSize[j]));	
		}
		
		//System.out.println(problem);
	    
		System.out.println("Solving SAT problem...");
		List<IBooleanLiteral> s=problem.findModel(Problem.defaultSolver());
		System.out.println("Reporting...");
		if(s!=null && s.size()>0)
		{
			BooleanLiteral.interpret(s);
			for(int item=0;item<itemSize.length;item++)
				for(int bin=0;bin<binCapacity.length;bin++)
					if(indic[item][bin].getValue())
						System.out.println("item "+item+" of size "+size[item]+" is assigned to bin "+bin+" of capacity "+binCapacity[bin]);
			
			for(int j=0;j<binCapacity.length;j++)
				System.out.println("sum$"+j+"] = "+sum[j]);
		}
		else
			System.out.println("No solution.");
	}
}
