package positronic.satisfiability.demos.bitstringlookuptable;

import java.util.List;

import positronic.satisfiability.bitstring.BitString;
import positronic.satisfiability.bitstring.BitStringFixer;
import positronic.satisfiability.bitstring.IBitString;
import positronic.satisfiability.bitstringlookuptable.BitStringLookupTable;
import positronic.satisfiability.bitstringlookuptable.BitStringLookupTabler;
import positronic.satisfiability.bitstringlookuptable.IBitStringLookupTable;
import positronic.satisfiability.elements.BooleanLiteral;
import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.IBooleanLiteral;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;

public class BitStringLookupTableFixerDemo2 
{
	public static void main(String[] args) throws Exception
	{
		IBitStringLookupTable table
			=new BitStringLookupTable("table",3,4);
		IBitString X1=new BitString(4);
		IBitString Y1=new BitString(4);
		IBitString X2=new BitString(4);
		IBitString Y2=new BitString(4);
		IBitString X3=new BitString(4);
		IBitString Y3=new BitString(4);
		
		IProblem problem=new Conjunction(
				new IProblem[]{
    			new BitStringFixer(X1,"0010"),
    			new BitStringFixer(Y1,"1010"),
    			new BitStringLookupTabler(X1,Y1,table),
    			new BitStringFixer(X2,"1101"),
    			new BitStringFixer(Y2,"1011"),
    			new BitStringLookupTabler(X2,Y2,table),
    			new BitStringFixer(X3,"1011"),
    			new BitStringFixer(Y3,"0111"),
    			new BitStringLookupTabler(X3,Y3,table)
    			}
    		);
		System.out.println(problem);
		List<IBooleanLiteral> s
			=problem.findModel(Problem.defaultSolver());
		if(s!=null && s.size()>0)
		{
			BooleanLiteral.interpret(s);
			for(int i=0;i<table.getLength();i++)
				System.out.println(table.getKey(i).toBits()
						+"->"+table.getEntry(i).toBits());
		}
		else
			System.out.println("No solution.");
	}
}
