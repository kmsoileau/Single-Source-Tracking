package positronic.satisfiability.bitstringrelation.binary;

import positronic.satisfiability.bitstring.BitStringEqualizer;
import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.Disjunction;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;
import positronic.satisfiability.exceptions.ReverserException;

public class Reverser extends Problem implements IProblem
{
	private static final long serialVersionUID = 1L;

	public Reverser(BitStringBinaryRelation source,BitStringBinaryRelation ecruos) throws Exception
	{
		if(source==null || ecruos==null)
			throw new ReverserException("Null parameters were passed to the constructor.");
		if(source.getSize()!=ecruos.getSize())
			throw new ReverserException("BitStringBinaryRelations of different sizes were passed to the constructor.");
		IProblem accum2=null;
		for(int i=0;i<source.getSize();i++)
			for(int j=0;j<source.getSize();j++)
			{
				IProblem result1=new BitStringEqualizer(source.getBitString(i,0),ecruos.getBitString(i,1));
				IProblem result2=new BitStringEqualizer(source.getBitString(i,1),ecruos.getBitString(i,0));
				IProblem accum=new Conjunction(result1,result2);
				if(accum2==null)
					accum2=accum;
				else
					accum2=new Disjunction(accum2,accum);
			}
		this.setClauses(accum2.getClauses());
	}
}
