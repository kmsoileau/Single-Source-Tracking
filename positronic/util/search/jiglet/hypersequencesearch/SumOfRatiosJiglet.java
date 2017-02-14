package positronic.util.search.jiglet.hypersequencesearch;

import positronic.util.search.jiglet.IVertex;
import positronic.util.search.jiglet.Jiglet;

public class SumOfRatiosJiglet extends Jiglet
{
	public static void main(String[] args) 
	{
		for(int i=0;i<100000;i++)
		{
			SumOfRatiosJiglet hss=new SumOfRatiosJiglet();
			hss.setTrials(10000);
			hss.start();
		}
	}
	
	protected IVertex explore() 
	{
		IVertex output=currentVertex.duplicate();
		int coord1=(int)(output.dimension()*Math.random());
		int coord2=(int)(output.dimension()*Math.random());
		int dum=output.getCoordinate(coord1);
		output.setCoordinate(coord1,output.getCoordinate(coord2));
		output.setCoordinate(coord2,dum);
		return output;
	}

	protected void init() 
	{
		currentVertex=new SumOfRatiosVertex(50);
		for(int i=1;i<=currentVertex.dimension();i++)
			currentVertex.setCoordinate(i-1,i);
	}

	protected boolean perTrial() 
	{
		if(currentVertex.evaluate()!=0)
			return true;
		else
		{
			//System.out.println("Solution found!");
			//System.out.println(currentVertex);
			return false;
		}
	}

	protected void wrapup() 
	{
		System.out.println(currentVertex);
		System.out.println(currentVertex.evaluate());
	}
}

class SumOfRatiosVertex implements IVertex
{
	private int[] coords;
	private int dimension;
	
	public SumOfRatiosVertex(int dimension)
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
		SumOfRatiosVertex m=new SumOfRatiosVertex(this.dimension);
		for(int i=0;i<m.dimension();i++)
			m.setCoordinate(i, this.getCoordinate(i));
		return m;
	}

	public double evaluate() 
	{
		double val=0d;
		for(int i=0;i<this.dimension();i+=2)
		{
			val+=1d*this.getCoordinate(i)/this.getCoordinate(i+1);
			if(Math.abs(this.getCoordinate(i)-this.getCoordinate(i+1))>22)
				val+=10^6;
		}
		return val;
	}
	
	public int getCoordinate(int i) 
	{
		return this.coords[i];
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



