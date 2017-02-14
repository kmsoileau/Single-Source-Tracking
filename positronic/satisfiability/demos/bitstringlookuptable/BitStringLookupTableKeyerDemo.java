package positronic.satisfiability.demos.bitstringlookuptable;

import java.util.List;

import positronic.satisfiability.bitstring.BitString;
import positronic.satisfiability.bitstring.BitStringFixer;
import positronic.satisfiability.bitstring.IBitString;
import positronic.satisfiability.bitstringlookuptable.BitStringLookupTable;
import positronic.satisfiability.bitstringlookuptable.BitStringLookupTableFixer;
import positronic.satisfiability.bitstringlookuptable.BitStringLookupTableKeyer;
import positronic.satisfiability.bitstringlookuptable.IBitStringLookupTable;
import positronic.satisfiability.elements.BooleanLiteral;
import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.IBooleanLiteral;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;

public class BitStringLookupTableKeyerDemo 
{
	public static void main(String[] args) throws Exception
	{
		IBitStringLookupTable table=new BitStringLookupTable("table",3,4);
		IBitString X=new BitString(4);
		
		IProblem problem=new Conjunction(
					new BitStringLookupTableFixer(table,
    				new String[]{"0010","1101","1011"},
    				new String[]{"1010","1011","0111"}),
    				new BitStringLookupTableKeyer(X,table),
    			new BitStringFixer(X,"1011")
    		);
		System.out.println(problem);
		List<IBooleanLiteral> s=problem.findModel(Problem.defaultSolver());
		if(s!=null && s.size()>0)
		{
			BooleanLiteral.interpret(s);
			for(int i=0;i<table.getLength();i++)
				System.out.println(table.getKey(i).toBits()+"->"+table.getEntry(i).toBits());
			System.out.println("X="+X.toBits());
		}
		else
			System.out.println("No solution.");
	}
}
