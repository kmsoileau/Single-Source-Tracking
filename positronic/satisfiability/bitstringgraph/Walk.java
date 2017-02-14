package positronic.satisfiability.bitstringgraph;

import positronic.satisfiability.bitstring.IBitString;

public class Walk
{
	private IBitString[][] data;
	private int length;
	private int dimension;
	
	public Walk(IBitString[][] data)
	{
		this.data=data;
		this.length=data.length;
		this.dimension=data[0].length;
	}

	public IBitString[] firstVertex()
	{
		return getVertexAt(0);
	}

	public IBitString[][] getData() 
	{
		return data;
	}

	public int getDimension() 
	{
		return dimension;
	}
	
	public int getLength() 
	{
		return length;
	}
	
	public IBitString[] getVertexAt(int n)
	{
		return data[n];
	}
	
	public IBitString[] lastVertex()
	{
		return getVertexAt(length-1);
	}
}
