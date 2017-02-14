package positronic.util.search.jiglet.demos.hypercubesearch;

import positronic.util.search.jiglet.IVertex;
import positronic.util.search.jiglet.Jiglet;

public class MyCubeVertexJiglet extends Jiglet
{
	public static void main(String[] args)
	{
		MyCubeVertexJiglet hcs=new MyCubeVertexJiglet();
		hcs.setTrials(10000);
		hcs.start();
	}
	
	protected IVertex explore() 
	{
		IVertex output=currentVertex.duplicate();
		for(int coordinate=0;coordinate<output.dimension();coordinate++)
		{
			double r=Math.random();
			if(r<1./3)
				output.setCoordinate(coordinate,output.getCoordinate(coordinate)-1);
			else
				if(r<2./3)
					;
				else
					output.setCoordinate(coordinate,output.getCoordinate(coordinate)+1);
		}
		return output;
	}

	protected void init() 
	{
		currentVertex=new MyCubeVertex(5);
		currentVertex.setCoordinate(0, 2);
		currentVertex.setCoordinate(1, 6);
		currentVertex.setCoordinate(2, 1);
		currentVertex.setCoordinate(3, 2);
		currentVertex.setCoordinate(4, 9);
	}

	protected boolean perTrial() 
	{
		System.out.println(currentVertex);
		return true;
	}

	protected void wrapup() 
	{
		System.out.println("Finis");
	}
}

class MyCubeVertex implements IVertex
{
	private int[] coords;
	private int dimension;
	
	public MyCubeVertex(int dimension)
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
		MyCubeVertex m=new MyCubeVertex(this.dimension);
		for(int i=0;i<m.dimension();i++)
			m.setCoordinate(i, this.getCoordinate(i));
		return m;
	}

	public double evaluate() 
	{
		double tot=0.;
		for(int i=0;i<this.dimension()-1;i++)
			tot+=Math.abs(this.getCoordinate(i+1)-this.getCoordinate(i));
		double sum=0;
		for(int i=0;i<this.dimension();i++)
			sum+=this.getCoordinate(i);
		tot+=100.*Math.abs(sum-12);
		return tot;
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
			ret+=this.getCoordinate(i)+" ";
		return ret+"$";
	}
}




