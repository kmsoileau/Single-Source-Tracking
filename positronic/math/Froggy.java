package positronic.math;

public class Froggy 
{
	public static void main(String[] args) 
	{
		for(double p=0.;p<1.;p+=.01)
			System.out.println(p+"\t"+probability(p));
	}
	
	public static double probability(double p)
	{
		int count=0;
		for(int i=1;i<10000;i++)
			if(trial(p))
				count++;
		return count/10000.;
	}
	
	public static boolean trial(double p)
	{
		int pos=0;
		for(int i=1;i<10000;i++)
		{
			pos+=Math.random()<p?-1:1;
			if(pos<0)
				return true;
		}
		return false;
	}

}
