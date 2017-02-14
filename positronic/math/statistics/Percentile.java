package positronic.math.statistics;

import java.util.ArrayList;

public class Percentile 
{
	public static double eval(ArrayList<?> lst, Double x)
	{
		if(x<(Double)lst.get(0))
			return 0.;
		if(x>(Double)lst.get(lst.size()-1))
			return 1.;
		for(int i=0;i<lst.size();i++)
			if((Double)lst.get(i)>x)
				return (double)i/lst.size();
		return 1.;
	}
}
