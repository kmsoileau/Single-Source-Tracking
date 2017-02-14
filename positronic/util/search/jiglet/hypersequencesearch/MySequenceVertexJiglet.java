package positronic.util.search.jiglet.hypersequencesearch;

import positronic.util.search.jiglet.IVertex;
import positronic.util.search.jiglet.Jiglet;

public class MySequenceVertexJiglet extends Jiglet
{
	//20,18,19,16,23,13,21,10,22,17,24,15,2,12,3,7,5,9,6,14,4,8,1,11
	//19,18,22,12,24,13,21,15,23,17,20,14,2,7,5,10,6,9,3,11,4,8,1,16
	//21,17,24,16,20,15,22,12,23,11,19,18,1,10,2,9,3,13,4,7,6,14,5,8
	//23,18,19,12,21,17,20,15,22,11,24,16,1,10,3,14,5,8,2,9,6,13,4,7
	//24,16,19,11,21,14,22,18,20,17,23,13,6,9,5,15,1,12,3,8,4,10,2,7
	//24,15,23,17,21,16,22,12,20,18,19,11,2,7,6,8,4,9,1,13,5,10,3,14
	//21,11,24,14,20,17,22,16,23,18,19,13,5,12,2,10,4,9,6,7,1,8,3,15
	
	public static void main(String[] args) 
	{
		for(int i=0;i<100000;i++)
		{
			MySequenceVertexJiglet hss=new MySequenceVertexJiglet();
			hss.setTrials(10000);
			hss.start();
			/*Rotary<Integer> r=new Rotary<Integer>();
			for(int n=0;n<hss.currentVertex.dimension();n++)
				r.addAt(null,hss.currentVertex.getCoordinate(n));
			System.out.println(r);*/
			
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
		currentVertex=new MySequenceVertex(24);
		int[] nums=new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24};
		for(int i=0;i<24;i++)
			currentVertex.setCoordinate(i, nums[i]);
	}

	protected boolean perTrial() 
	{
		if(currentVertex.evaluate()!=0)
			return true;
		else
		{
			//System.out.println("Solution found!");
			System.out.println(currentVertex);
			return false;
		}
	}

	protected void wrapup() 
	{
		//System.out.println("Finis");
	}
}

class MySequenceVertex implements IVertex
{
	private int[] coords;
	private int dimension;
	private static final int PETALTOTAL=82;
	
	public MySequenceVertex(int dimension)
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
		MySequenceVertex m=new MySequenceVertex(this.dimension);
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



