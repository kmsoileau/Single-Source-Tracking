package positronic.util.search.jiglet.demos.petals;

import positronic.util.search.jiglet.IVertex;

public class PetalAssignmentVertex implements IVertex
{
	private int[] coords;
	private int dimension;
	private static final int PETALTOTAL=82;
	
	public PetalAssignmentVertex(int dimension)
	{
		this.dimension=dimension;
		coords=new int[dimension];
	}

	public int dimension() 
	{
		return this.dimension;
	}

	public IVertex duplicate() 
	{
		PetalAssignmentVertex m=new PetalAssignmentVertex(this.dimension);
		for(int i=0;i<m.dimension();i++)
			m.setCoordinate(i, this.getCoordinate(i));
		return m;
	}

	public double evaluate() 
	{
		int sum1=
			this.petalSum(new int[]{1,2,14,15,13,24,23,12});
		int sum2=
			this.petalSum(new int[]{12,24,13,23,22,21,10,11});
		int sum3=
			this.petalSum(new int[]{23,22,21,19,20,8,9,10});
		int sum4=
			this.petalSum(new int[]{19,17,18,6,7,8,20,21});
		int sum5=
			this.petalSum(new int[]{4,5,6,18,19,17,15,16});
		int sum6=
			this.petalSum(new int[]{3,4,16,17,15,13,14,2});
		int sum7=
			this.petalSum(new int[]{13,14,15,16,17,18,19,20,21,22,23,24});
		double val=1d*((sum1-PETALTOTAL)*(sum1-PETALTOTAL)
				+(sum2-PETALTOTAL)*(sum2-PETALTOTAL)
				+(sum3-PETALTOTAL)*(sum3-PETALTOTAL)
				+(sum4-PETALTOTAL)*(sum4-PETALTOTAL)
				+(sum5-PETALTOTAL)*(sum5-PETALTOTAL)
				+(sum6-PETALTOTAL)*(sum6-PETALTOTAL)
				+(sum7-PETALTOTAL)*(sum7-PETALTOTAL));
		return val;
	}
	
	public int getCoordinate(int i) 
	{
		return this.coords[i];
	}
	
	public int petalSum(int[] petals)
	{
		int tot=0;
		for(int i=0;i<petals.length;i++)
			tot+=this.getCoordinate(petals[i]-1);
		return tot;
	}
	
	public void setCoordinate(int i, int n) 
	{
		this.coords[i]=n;
	}
	
	public String toString()
	{
		String ret="$";
		for(int i=0;i<this.dimension();i++)
			ret+=this.getCoordinate(i)+",";
		return ret+"] "+this.evaluate();
	}
}