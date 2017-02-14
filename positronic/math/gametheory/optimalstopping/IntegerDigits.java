package positronic.math.gametheory.optimalstopping;

import java.util.ArrayList;

public class IntegerDigits
{

	public ArrayList<Integer> list;

//Produces an optionally padded Array of digits base b for the input number n.
//For instance, if
//IntegerDigits *res=[IntegerDigits alloc] initWithDetails:8 base:2 pad:6];
//is executed, then
//res.list={0,0,0,1,0,0}.
	public IntegerDigits(int n, int base, int pad)
	{
		if(this != null)
		{
			list=new ArrayList<Integer>();
			while(n>0)
		    {
				int currDigit=IntegerDigits.lowestDigit(n,base);
		        Integer num=new Integer(currDigit);
		        list.add(num);
		        n=(n-currDigit)/base;
		     }
		     Integer zero=new Integer(0);
		     while(list.size()<pad)
		    	 list.add(zero);
		}
	}

	public static int lowestDigit(int n, int base)
	{
		if(n<base)
			return n;
		int m=n-(n/base)*base;
		return m;
	}

/*-(NSString *)toString
{
  NSString *ret=@"{";
  ret=[ret stringByAppendingFormat:@"%li,",(long)[[list objectAtIndex:0] integerValue]];
  for(int i=1;i<[list count]-1;i++)
  {
      ret=[ret stringByAppendingFormat:@" %li,",(long)[[list objectAtIndex:i] integerValue]];
  }
  ret=[ret stringByAppendingFormat:@" %li}",(long)[[list objectAtIndex:[list count]-1] integerValue]];
  return ret;
}*/
}

