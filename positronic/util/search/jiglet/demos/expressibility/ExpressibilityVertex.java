package positronic.util.search.jiglet.demos.expressibility;

import positronic.util.search.jiglet.IVertex;

public class ExpressibilityVertex implements IVertex
{
	private int[] values;
	
	public ExpressibilityVertex()
	{
		values=new int[dimension()];
		for(int i=0;i<dimension();i++)
			values[i]=i+1;
	}

	public int dimension()
	{
		return 9;
	}

	public IVertex duplicate() 
	{
		ExpressibilityVertex m=new ExpressibilityVertex();
		for(int i=0;i<this.dimension();i++)
			m.setCoordinate(i, this.getCoordinate(i));
		return m;
	}

	public double evaluate() 
	{
		int sum1=values[0]*values[0]+values[1]*values[1]+values[3]*values[3]+values[4]*values[4];
		int sum2=values[4]*values[4]+values[5]*values[5]+values[7]*values[7]+values[8]*values[8];
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
		String ret="$";
		for(int i=0;i<this.dimension();i++)
			ret+=this.getCoordinate(i)+" ";
		return ret+"$"+this.evaluate();
	}
}