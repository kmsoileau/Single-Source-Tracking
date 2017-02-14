package positronic.math;

import java.util.HashMap;

public class RandomPairing 
{
	public static void main(String[] args)
	{
		new RandomPairing(4);
	}
	
	HashMap<Integer,Integer> boys;	
	HashMap<Integer,Integer> girls;
	
	public RandomPairing(int n)
	{
		boys=new HashMap<Integer,Integer>(n);
		girls=new HashMap<Integer,Integer>(n);
		RandomPermutation h1=RandomPermutation.random(n);
		RandomPermutation h2=RandomPermutation.random(n);
		for(int i=0;i<n;i++)
		{
			this.boys.put((Integer)h1.get(i), (Integer)h2.get(i));
			this.girls.put((Integer)h2.get(i), (Integer)h1.get(i));
		}
	}
	
	public boolean equals(Object arg0)
	{
		if(!(arg0 instanceof RandomPairing))
			return false;
		RandomPairing rp=(RandomPairing)arg0;
		if(this.boys.size()!=rp.boys.size())
			return false;
		for(Integer i : this.boys.keySet())
			if(this.boys.get(i).compareTo(rp.boys.get(i))!=0)
				return false;
		return true;
	}
	
	public String toString()
	{
		String ret="";
		for(int i=1;i<=this.boys.size();i++)
			ret+=""+i+"$"+this.boys.get((Integer)i)+" ";
		return ret;
	}
}
