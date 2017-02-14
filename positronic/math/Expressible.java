package positronic.math;

import java.util.Arrays;

import positronic.util.ArrayListSet;

//1,2,7,28,49,175,196
//102 149 148 31 34 13 30
//6 11 27 14 68 122 145

public class Expressible
{
	public static ArrayListSet<Long> expressibleList(ArrayListSet<Long> base)
	{
		if(base.isEmpty())
			return null;
		if(base.size()==1)
			return base;
		long intk=Long.MIN_VALUE;
		intk=base.get(0).longValue();
		Long singular=new Long(intk);
		ArrayListSet<Long> expressible=(ArrayListSet<Long>)base.clone();
		for(Long o : (ArrayListSet<Long>)expressible.clone())
			if(o.longValue()==intk)
				expressible.remove(o);
			else
				;
			
		ArrayListSet<Long> ret=expressibleList(expressible);
		ret.add(singular);
		ArrayListSet<Long> retclone=(ArrayListSet<Long>)ret.clone();
		for(Long o : retclone)
		{
			long i=Long.MIN_VALUE;
			i=(Long)o;
			if(i-singular>0)
				ret.add(new Long(i-singular));
			if(i-singular<0)
				ret.add(new Long(-i+singular));
			if(i+singular>0)
				ret.add(new Long(i+singular));
			if(i>0)
				ret.add(new Long(i));
		}
		retclone=null;
		
		return ret;
	}
	
	public static void main(String[] args) 
	{
		ArrayListSet<Long> param=new ArrayListSet<Long>();
		for(int i : new int[]{24,35,45,65,82,85,87,88})
			param.add(new Long(i));
		ArrayListSet<Long> a=Expressible.expressibleList(param);
		Long[] sorta=(Long[])a.toArray(new Long[0]);
		Arrays.sort(sorta);
		System.out.print("[ ");
		for(Long i:sorta)
			System.out.print(i+" ");
		System.out.print("$");
	}
}
