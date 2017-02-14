package positronic.math;

public class Prime 
{
	public static boolean isComposite(long N)
	{
		for(long n=2;n*n<=N;n++)
			if(N==n*(N/n))
				return true;
		return false;
	}

	public static boolean isPrime(long N)
	{
		if(N==0 || N==1)
			return false;
		for(long n=2;n*n<=N;n++)
			if(N==n*(N/n))
				return false;
		return true;
	}
	
	public static boolean isPrimeInteger(int N)
	{
		if(N==0 || N==1)
			return false;
		for(int n=2;n*n<=N;n++)
			if(N==n*(N/n))
				return false;
		return true;
	}
	
	public static void main(String[] args) 
	{
		double res=0.;
		for(long i=2;i<1000000;i++)
			if(isComposite(i))
				;
			else
				res+=Math.pow(2., -1.*i);
		System.out.println(res);
	}
	
	public Prime()
	{
		super();
		// TODO Auto-generated constructor stub
	}
}
