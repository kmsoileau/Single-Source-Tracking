package positronic.math;

public class Erdos2
{
	//3/n = 1/a + 1/b
	public static void main(String[] args)
	{
		int max=8000;
		String[] res=new String[max];
		int sum=2;
		while(sum<max)
		{
			for(int a=1;a<sum;a++)
				{
					int b=sum-a;
					double x=3./(1./a+1./b);
					long n=Math.round(x);
					if(n>0 && n<max && res[(int)n]==null && 3./n==1./a+1./b)
						res[(int)n]="3/"+n+" = 1/"+a+" + 1/"+b;
				}
			sum++;
		}
		
		for(int i=2;i<max;i++)
		{
			if(res[i]!=null)
				System.out.println(i+"\t\t"+res[i]);
		}
	}
}
