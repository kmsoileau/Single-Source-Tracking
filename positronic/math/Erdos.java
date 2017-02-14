package positronic.math;

public class Erdos
{
	//4/n = 1/a + 1/b + 1/c
	public static void main(String[] args)
	{
		int max=4000;
		String[] res=new String[max];
		int sum=3;
		while(sum<max)
		{
			for(int a=1;a<sum-1;a++)
				for(int b=1;b<sum-a;b++)
				{
					int c=sum-a-b;
					double x=4./(1./a+1./b+1./c);
					long n=Math.round(x);
					if(n>0 && n<max && 4./n==1./a+1./b+1./c)
					{
						if(res[(int)n]==null)
							res[(int)n]="4/"+n+" = 1/"+a+" + 1/"+b+" + 1/"+c;
					}
				}
			sum++;
		}
		
		for(int i=1;i<max;i++)
			System.out.println(i+"\t\t"+res[i]);
	}
}
