package positronic.satisfiability.chromaticcompletegraph;

import positronic.satisfiability.bitstring.BitString;
import positronic.satisfiability.bitstring.IBitString;

public class ColoredEdge
{
	public IBitString firstpoint;
	public IBitString secondpoint;
	public IBitString color;
	
	public ColoredEdge() throws Exception
	{
		this(new BitString(),new BitString(),new BitString());
	}
	
	public ColoredEdge(IBitString firstpoint, IBitString secondpoint, IBitString color) 
	{
		super();
		this.firstpoint = firstpoint;
		this.secondpoint = secondpoint;
		this.color = color;
	}
	
	public ColoredEdge(int vertexbits, int colorbits) throws Exception
	{
		this(new BitString(vertexbits),new BitString(vertexbits),new BitString(colorbits));
	}
	
	public String toString()
	{
		String ret="<";
		ret+=firstpoint+"$"+secondpoint+","+color;
		return ret+">";
	}
}