package positronic.satisfiability.chromaticcompletegraph;

import positronic.satisfiability.bitstring.BitString;
import positronic.satisfiability.bitstring.BitStringFixer;
import positronic.satisfiability.bitstring.IBitString;
import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.IProblem;

public class ColoredGraph
{
	public static void main(String[] args) throws Exception
	{
		ColoredGraph cg=new ColoredGraph(6);
		System.out.println(cg);
		IBitString vertex1=new BitString("vertex1","001");
		IBitString vertex2=new BitString("vertex2","010");
		IBitString vertex3=new BitString("vertex3","011");
		IBitString vertex4=new BitString("vertex4","100");
		IBitString vertex5=new BitString("vertex5","101");
		IBitString vertex6=new BitString("vertex6","110");
		IProblem problem=new Conjunction(
				new IProblem[]
				{
					new BitStringFixer(vertex1),
					new BitStringFixer(vertex2),
					new BitStringFixer(vertex3),
					new BitStringFixer(vertex4),
					new BitStringFixer(vertex5),
					new BitStringFixer(vertex6)
				});
		System.out.println(problem);
	}

	private ColoredEdge[] cEdge;

	public ColoredGraph(int edges) throws Exception
	{
		this.cEdge=new ColoredEdge[edges];
		for(int i=0;i<edges;i++)
			this.cEdge[i]=new ColoredEdge(3,2);
	}
	
	public String toString()
	{
		if(this.cEdge.length==0)
			return "[$";
		String ret="$"+this.cEdge[0];
		for(int i=1;i<this.cEdge.length;i++)
			ret+=","+this.cEdge[i];
		return ret+"$";
	}
}
