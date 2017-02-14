package positronic.satisfiability.chromaticcompletegraph;

import positronic.satisfiability.bitstring.BitString;

public class Polygon
{
	private BitString[] vertex;
	
	public Polygon(int edges) throws Exception
	{
		this.vertex=new BitString[edges];
		int bits=(int)(Math.log(edges*1d)/Math.log(2d));
		for(int i=0;i<edges;i++)
			this.vertex[i]=new BitString("Vertex$"+i,bits);
	}
}
