package positronic.satisfiability.bitstringrelation.binary;

import positronic.satisfiability.bitstring.BitStringEqualizer;
import positronic.satisfiability.bitstring.IBitString;
import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.Disjunction;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;
import positronic.satisfiability.exceptions.SymmetrizerException;

public class Symmetrizer extends Problem implements IProblem
{
	private static final long serialVersionUID = 1L;
	
	public Symmetrizer(BitStringBinaryRelation relation) throws Exception
	{
		if(relation==null)
			throw new SymmetrizerException("A null BitStringBinaryRelation was passed to a constructor.");
		IProblem accum1=null;
		for(int i=0;i<relation.getSize();i++)
		{
			IBitString currleft=relation.getBitString(i,0);
			IBitString currright=relation.getBitString(i,1);
			IProblem accum2=null;
			for(int j=0;j<relation.getSize();j++)
			{
				IProblem result=new Conjunction(new BitStringEqualizer(currright,relation.getBitString(j,0))
						,new BitStringEqualizer(currleft,relation.getBitString(j,1)));
				if(accum2==null)
					accum2=result;
				else
					accum2=new Disjunction(accum2,result);
			}
			accum1=new Conjunction(accum1,accum2);
		}
		
		this.setClauses(accum1.getClauses());
	}
}
