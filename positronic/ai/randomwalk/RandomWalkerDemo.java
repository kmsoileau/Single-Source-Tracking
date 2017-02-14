package positronic.ai.randomwalk;

import java.util.ArrayList;

class Point implements IVertex
{
	int[] coordinates;
	int dimension;
	
	public Point(int dim)
	{
		super();
		this.coordinates =new int[dim];
		this.dimension=dim;
	}
	
	public IVertex duplicate()
	{
		Point dup=new Point(this.dimension);
		for(int i=0;i<dup.coordinates.length;i++)
			dup.coordinates[i]=this.coordinates[i];
		return dup;
	}

	public boolean endCondition()
	{
		// TODO Auto-generated method stub
		return false;
	}

	public boolean equals(Object o) 
	{
		if(!(o instanceof Point))
			return false;
		for(int i=0;i<this.dimension;i++)
			if(((Point)o).coordinates[i]!=this.coordinates[i])
				return false;
		return true;
	}
	
	public void moveToNeighbor()
	{
		double g=Math.random();
		int num=2*this.dimension;
		for(int i=0;i<num;i+=2)
		{
			if(g<(i+1.)/num)
			{
				this.coordinates[i/2]=rectify(this.coordinates[i/2]-1);
				return;
			}
			if(g<(i+2.)/num)
			{
				this.coordinates[i/2]=rectify(this.coordinates[i/2]+1);
				return;
			}
		}
		return;
	}
	
	private int rectify(int n)
	{
		int ret=n%3;
		if(ret<0)ret+=3;
		return ret;
	}

	public String toClause()
	{
		String ret="{";
		for(int i=0;i<this.dimension;i++)
		{
			if(coordinates[i]==0)
				continue;
			ret+=" ";
			if(coordinates[i]==2)
				ret+="$";
			ret+="x$"+i;
		}
		return ret+" }";
	}

	public String toString()
	{
		String ret="";
		for(int i=0;i<coordinates.length;i++)
			ret+=this.coordinates[i]+" ";
		return ret;
	}
	
}

public class RandomWalkerDemo
{
	public static void main(String[] args)
	{
		Point start=new Point(40);
		for(int i=0;i<start.dimension;i++)
			start.coordinates[i]=0;
		RandomWalker r=new RandomWalker();
		ArrayList<IVertex> res=r.walk(start, 500);
		for(int i=0;i<res.size();i++)
			System.out.println(i+"\t"+((Point)res.get(i)).toClause());
	}
}
