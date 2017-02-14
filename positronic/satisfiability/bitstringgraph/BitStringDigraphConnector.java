package positronic.satisfiability.bitstringgraph;

import positronic.satisfiability.bitstring.IBitString;
import positronic.satisfiability.bitstringlist.IBitStringList;
import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;

public class BitStringDigraphConnector extends Problem implements IProblem
{
	private static final long serialVersionUID = -4163638976009727304L;

	public BitStringDigraphConnector(IBitStringGraph bst, IBitString b1, IBitString b2) throws Exception
	{
		if(bst.getNumberOfVertices()==0)
			this.setClauses(Problem.unsolvableProblem().getClauses());
		else
		{
			/*BitStringPair[] list=bst.toArray();
			IProblem[] match=new IProblem[list.length];
			               
			for(int i=0;i<match.length;i++)
			{
				IBitString currb1=((BitStringPair)list[i]).getLeft();
				IBitString currb2=((BitStringPair)list[i]).getRight();
				match[i]=new Conjunction(
						new BitStringEqualizer(currb1,b1),
						new BitStringEqualizer(currb2,b2)
						);
			}
			this.setClauses(new Disjunction(match).getClauses());*/
		}
	}
	
	public BitStringDigraphConnector(IBitStringGraph bst, IBitString b1, IBitString[] path, IBitString b2) throws Exception
	{
		if(path.length==0)
			this.setClauses(new BitStringDigraphConnector(bst,b1,b2).getClauses());
		else
		{
			IProblem[] p=new IProblem[path.length+1];
			p[0]=new BitStringDigraphConnector(bst,b1,path[0]);
			for(int i=1;i<path.length;i++)
				p[i]=new BitStringDigraphConnector(bst,path[i-1],path[i]);
			p[path.length]=new BitStringDigraphConnector(bst,path[path.length-1],b2);
			this.setClauses(new Conjunction(p).getClauses());
		}
	}
	
	public BitStringDigraphConnector(IBitStringGraph bst, IBitString b1, IBitStringList path, IBitString b2) throws Exception
	{
		this(bst,b1,(IBitString[])path.toArray(new IBitString[0]),b2);
	}
}
