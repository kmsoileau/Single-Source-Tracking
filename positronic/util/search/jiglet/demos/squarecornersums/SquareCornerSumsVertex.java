package positronic.util.search.jiglet.demos.squarecornersums;

import positronic.util.search.jiglet.IVertex;

public class SquareCornerSumsVertex implements IVertex
{
	public int[] values;
	
	public SquareCornerSumsVertex()
	{
		values=new int[9];
		for(int i=0;i<9;i++)
			values[i]=i+1;
	}

	public int dimension()
	{
		return 9;
	}

	public IVertex duplicate() 
	{
		IVertex ret=new SquareCornerSumsVertex();
		for(int i=0;i<9;i++)
			((SquareCornerSumsVertex)ret).values[i]=((SquareCornerSumsVertex)this).values[i];
		return ret;
	}

	public double evaluate() 
	{
		int sum1=values[0]+values[1]+values[3]+values[4];
		int sum2=values[4]+values[5]+values[7]+values[8];
		return 1d*(sum1-sum2)*(sum1-sum2);
	}
	
	public int getCoordinate(int i) 
	{
		return this.values[i];
	}

	public void setCoordinate(int i, int n) 
	{
		this.values[i]=n;
	}

	public String toString()
	{
		String ret="";
		ret+="\n";
		for(int i=0;i<3;i++)
			ret+=this.values[i];
		ret+="\n";
		for(int i=3;i<6;i++)
			ret+=this.values[i];
		ret+="\n";
		for(int i=6;i<9;i++)
			ret+=this.values[i];
		ret+="\t"+this.evaluate()+"\n";
		return ret;
	}
}