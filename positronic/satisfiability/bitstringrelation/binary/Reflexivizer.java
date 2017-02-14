package positronic.satisfiability.bitstringrelation.binary;

import positronic.satisfiability.bitstring.BitStringEqualizer;
import positronic.satisfiability.bitstring.IBitString;
import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.Disjunction;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;
import positronic.satisfiability.exceptions.ReflexivizerException;

public class Reflexivizer extends Problem implements IProblem
{
	private static final long serialVersionUID = 1L;
	
	public Reflexivizer(BitStringBinaryRelation relation) throws Exception
	{
		if(relation==null)
			throw new ReflexivizerException("A null BitStringBinaryRelation was passed to a constructor.");
		IProblem accum1=null;
		for(int i=0;i<relation.getSize();i++)
		{
			IBitString curr=relation.getBitString(i,0);
			IProblem accum2=null;
			for(int j=0;j<relation.getSize();j++)
			{
				IProblem equal1=new BitStringEqualizer(curr,relation.getBitString(j,0));
				IProblem equal2=new BitStringEqualizer(curr,relation.getBitString(j,1));
				IProblem equal=new Conjunction(equal1,equal2);
				if(accum2==null)
					accum2=equal;
				else
					accum2=new Disjunction(accum2,equal);
			}
			accum1=new Conjunction(accum1,accum2);
		}
		for(int i=0;i<relation.getSize();i++)
		{
			IBitString curr=relation.getBitString(i,1);
			IProblem accum3=null;
			for(int j=0;j<relation.getSize();j++)
			{
				IProblem equal1=new BitStringEqualizer(curr,relation.getBitString(j,0));
				IProblem equal2=new BitStringEqualizer(curr,relation.getBitString(j,1));
				IProblem equal=new Conjunction(equal1,equal2);
				if(accum3==null)
					accum3=equal;
				else
					accum3=new Disjunction(accum3,equal);
			}
			accum1=new Conjunction(accum1,accum3);
		}
		
		this.setClauses(accum1.getClauses());
	}
}

