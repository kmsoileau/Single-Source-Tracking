package positronic.util;

import java.util.HashSet;

public class Set
{
	public static void main(String[] args) 
	{
		Set s=new Set();
		s.add(13);
		s.add(1);
		s.remove(4);
		s.add(1);
		s.add(5);
		s.add(9);
		s.remove(5);
		s.add(5);
		s.add(13);
		s.add(5);
		System.out.println(s);
		System.out.println(s.size());
		System.out.println(s.compress());
	}
	
	private java.util.Set<Object> positive;
	private java.util.Set<Object> negative;
	
	public Set() 
	{
		this.positive=new HashSet<Object>();
		this.negative=new HashSet<Object>();
	}
	
	public boolean add(Object o)
	{
		return this.positive.add(o);
	}
	
	public boolean compress()
	{
		boolean ret=false;
		for(Object o : this.negative)
			if(this.positive.contains(o))
			{
				this.positive.remove(o);
				this.negative.remove(o);
				if(!ret)
					ret=true;
			}
		return ret;
	}
	
	public boolean contains(Object o)
	{
		if(this.negative.contains(o) || !positive.contains(o))
			return false;
		return true;
	}
	
	public boolean remove(Object o)
	{
		return negative.add(o);
	}
	
	public int size()
	{
		int ret=this.positive.size();
		
		for(Object o : this.negative)
			if(this.positive.contains(o))
				ret--;
		return ret;
	}
	
	public String toString()
	{
		java.util.HashSet<Object> res=new java.util.HashSet<Object>();
		for(Object o : this.positive)
			if(this.contains(o))
				res.add(o);
		return res.toString();	
	}
}
