package positronic.math.statistics;

import java.util.List;

public class Mean 
{
	public static double eval(List<Double> lst)
	{
		Double tot=0.;
		for(int i=0;i<lst.size();i++)
			tot+=lst.get(i);
		return tot/lst.size();
	}
}
