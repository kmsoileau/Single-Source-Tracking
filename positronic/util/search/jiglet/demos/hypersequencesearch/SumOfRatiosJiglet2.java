package positronic.util.search.jiglet.demos.hypersequencesearch;

import positronic.util.search.jiglet.IVertex;
import positronic.util.search.jiglet.Jiglet;

public class SumOfRatiosJiglet2 extends Jiglet
{
	//[3,2,-1,4,-20,6,18,-14,9,10,11,12,13,8,23,31,17,-25,19,30,-16,36,7,24,22,26,-15,28,29,-5,21,32,33,34,35,27,39,38,37,40,] 3.145077087651771E-8
	//[32,15,-4,-2,-5,-13,-6,31,-7,-45,40,-30,-46,18,-26,24,25,-8,1,20,33,12,-37,27,-21,3,14,-9,29,11,19,23,16,34,35,36,44,-38,39,-41,-28,-42,-43,-22,17,-48,-47,-10,49,50,] 5.8307034755955556E-9
	//2.5798206126914636E-8=43/2+3/34+4/6+7/8-9/53-11/76+13/14+15/16+17/18+19/20-21/77+82/24+25/40-85/26+29/91-64/45+37/12+35/10+33/38+42/28-52/86+79/88+31/80-47/90+49/50+51/67+75/54+5/56+57/58+59/30+61/22-63/1+65/66-36/68+69/70+71/72+73/74+62/27+39/78+32/83+81/23+44/84+41/94+87/48+89/46+60/92+93/97+95/96+55/98+99/100

	public static void main(String[] args) 
	{
		for(int i=0;i<10000;i++)
		{
			SumOfRatiosJiglet2 hss=new SumOfRatiosJiglet2();
			hss.setTrials(100000);
			hss.start();
		}
	}
	
	protected IVertex explore() 
	{
		IVertex output=currentVertex.duplicate();
		int coord1=(int)(output.dimension()*Math.random());
		int coord2=(int)(output.dimension()*Math.random());
		int coord3=(int)(output.dimension()*Math.random());
		int dum=output.getCoordinate(coord1);
		output.setCoordinate(coord1,output.getCoordinate(coord2));
		output.setCoordinate(coord2,output.getCoordinate(coord3));
		output.setCoordinate(coord3,dum);
		if(Math.random()>1./4)
			output.setCoordinate(coord1,-output.getCoordinate(coord1));
		if(Math.random()>2./4)
			output.setCoordinate(coord2,-output.getCoordinate(coord2));
		if(Math.random()>3./4)
			output.setCoordinate(coord3,-output.getCoordinate(coord3));	
		return output;
	}

	protected void init() 
	{
		currentVertex=new SumOfRatiosVertex2(10);
		for(int i=1;i<=currentVertex.dimension();i++)
			currentVertex.setCoordinate(i-1,i);
	}

	protected boolean perTrial() 
	{
		/*if(currentVertex.evaluate()<1e-7)
		{
			System.out.println(currentVertex);
			return false;
		}
		else*/
			return true;
	}

	protected void wrapup() 
	{
		if(currentVertex.evaluate()<1e-6)
		{
			System.out.println(currentVertex);
			//System.out.println(currentVertex.evaluate());
		}
	}
}

class SumOfRatiosVertex2 implements IVertex
{
	private int[] coords;
	private int dimension;
	
	public SumOfRatiosVertex2(int dimension)
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
		SumOfRatiosVertex2 m=new SumOfRatiosVertex2(this.dimension);
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
			//if(Math.abs(this.getCoordinate(i)-this.getCoordinate(i+1))>22)
			//	val+=10^6;
		}
		if(val<0)
			val=-val;
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
		String ret="";
		if(this.getCoordinate(0)>0)
		{
			if(this.getCoordinate(0+1)>0)
				ret+=this.getCoordinate(0)+"/"+this.getCoordinate(0+1);
			else
				ret+="$"+this.getCoordinate(0)+"/"+(-this.getCoordinate(0+1));
		}
		else
		{
			if(this.getCoordinate(0+1)>0)
				ret+="$"+(-this.getCoordinate(0))+"/"+this.getCoordinate(0+1);
			else
				ret+=(-this.getCoordinate(0))+"/"+(-this.getCoordinate(0+1));
		}
		for(int i=2;i+1<this.dimension();i+=2)
		{
			if(this.getCoordinate(i)>0)
			{
				if(this.getCoordinate(i+1)>0)
					ret+="+"+this.getCoordinate(i)+"/"+this.getCoordinate(i+1);
				else
					ret+="$"+this.getCoordinate(i)+"/"+(-this.getCoordinate(i+1));
			}
			else
			{
				if(this.getCoordinate(i+1)>0)
					ret+="$"+(-this.getCoordinate(i))+"/"+this.getCoordinate(i+1);
				else
					ret+="+"+(-this.getCoordinate(i))+"/"+(-this.getCoordinate(i+1));
			}
		}
			
		return this.evaluate()+"="+ret;
	}
}



