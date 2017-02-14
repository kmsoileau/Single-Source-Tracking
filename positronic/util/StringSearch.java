package positronic.util;

import java.util.Calendar;

public class StringSearch
{
	private static int hash(char[] str) 
	{
		return hash(str,0,str.length);
	}
	
	private static int hash(char[] str, int start, int end) 
	{
		int ret=0;
		for(int i=start;i<end;i++)
			ret+=str[i];
		return ret;
	}
	
	static int indexOf(char[] source, char[] target)
	{
		if(target.length>source.length)
			return -1;
		if(target.length==0)
			return -1;
		int hs=hash(source,0,target.length);
		int ht=hash(target);
		for(int i=0;i<source.length-target.length+1;i++)
		{
			ifblock:
			if(ht==hs)
			{
				for(int j=0;j<target.length;j++)
					if(source[i+j]!=target[j])
						break ifblock;
				return i;
			}
			hs+=(source[i+target.length]-source[i]);
		}
		
		return -1;
	}
	
	static int indexOf(String source, String target)
	{
		return indexOf(source.toCharArray(),target.toCharArray());
	}

	public static void main(final String[] args)
	{
		long start=Calendar.getInstance().getTimeInMillis();
		for(int i=0;i<100000000;i++)
		{
			///int h=indexOf("Kerry","er");
		}
		long finish=Calendar.getInstance().getTimeInMillis();
		System.out.println(finish-start);
		
		long start2=Calendar.getInstance().getTimeInMillis();
		for(int i=0;i<100000000;i++)
		{
			///int h="Kerry".indexOf("er");
		}
		long finish2=Calendar.getInstance().getTimeInMillis();
		System.out.println(finish2-start2);
	}
}
