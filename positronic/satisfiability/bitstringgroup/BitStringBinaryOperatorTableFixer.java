package positronic.satisfiability.bitstringgroup;

import positronic.satisfiability.bitstring.BitStringFixer;
import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;
//deprecated
public class BitStringBinaryOperatorTableFixer extends Problem implements IProblem
{
  private static final long serialVersionUID = 2099657338870714317L;

	public BitStringBinaryOperatorTableFixer(IBitStringBinaryOperatorTable table) throws Exception
  {
		if(table==null) 
    	throw new BitStringBinaryOperatorTableFixerException("A null IBitStringBinaryOperatorTable was passed to a constructor.");
    if(table.size()==0) 
    	throw new BitStringBinaryOperatorTableFixerException("An empty IBitStringBinaryOperatorTable was passed to a constructor.");
    IProblem res=null;
    for(int i=0;i<table.size();i++)
    {
    	res=new Conjunction(res,
    			new BitStringFixer(table.getLeft(i)),
    			new BitStringFixer(table.getRight(i)),
    			new BitStringFixer(table.getResult(i)));
    }
    this.setClauses(res.getClauses());
  }
}
