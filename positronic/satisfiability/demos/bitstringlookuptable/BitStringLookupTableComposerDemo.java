package positronic.satisfiability.demos.bitstringlookuptable;

import java.util.List;

import positronic.satisfiability.bitstring.BitString;
import positronic.satisfiability.bitstring.BitStringFixer;
import positronic.satisfiability.bitstring.IBitString;
import positronic.satisfiability.bitstringlookuptable.BitStringLookupTable;
import positronic.satisfiability.bitstringlookuptable.BitStringLookupTableComposer;
import positronic.satisfiability.bitstringlookuptable.BitStringLookupTableFixer;
import positronic.satisfiability.bitstringlookuptable.IBitStringLookupTable;
import positronic.satisfiability.elements.BooleanLiteral;
import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.IBooleanLiteral;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;

public class BitStringLookupTableComposerDemo 
{
	public static void main(String[] args) throws Exception
	{
		IBitStringLookupTable table1=new BitStringLookupTable("table1",3,4);
		IBitStringLookupTable table2=new BitStringLookupTable("table2",3,4);
		IBitString X=new BitString(4);
		IBitString Y=new BitString(4);
		IProblem problem=new Conjunction(
					new BitStringLookupTableFixer(table1,
	    				new String[]{"0010","1101","1011"},
	    				new String[]{"1010","1001","0111"}),
					new BitStringLookupTableFixer(table2,
	    				new String[]{"1001","0111","1011"},
	    				new String[]{"1011","1011","0111"}),
	    		new BitStringLookupTableComposer(X,Y,table1, table2),
    			new BitStringFixer(X,"1011")
    		);
		System.out.println(problem.toXML());
		List<IBooleanLiteral> s=problem.findModel(Problem.defaultSolver());
		if(s!=null && s.size()>0)
		{
			BooleanLiteral.interpret(s);
			for(int i=0;i<table1.getLength();i++)
				System.out.println(table1.getKey(i).toBits()+"->"+table1.getEntry(i).toBits());
			System.out.print("\n");
			for(int i=0;i<table1.getLength();i++)
				System.out.println(table2.getKey(i).toBits()+"->"+table2.getEntry(i).toBits());
			System.out.print("\n");
			System.out.println("X="+X.toBits());
			System.out.println("Y="+Y.toBits());
		}
		else
			System.out.println("No solution.");
	}
}
