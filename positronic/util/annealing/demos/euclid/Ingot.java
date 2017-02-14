package positronic.util.annealing.demos.euclid;

import positronic.math.Prime;
import positronic.util.annealing.IIngot;

/*
 * 44 4 8 14 92 47 76 46 88 26 67 55 99 48 95 25 10 89 73 75 78 12 51 32 98 61 22 11 53 64 90 18 19 60 27 33 6 63 72 15 80 5 31 9 39 82 16 24 45 66 59 93 81 94 100 28 70 62 86 43 23 77 91 7 37 20 85 58 52 2 68 42 69 35 84 3 30 57 74 34 50 97 79 56 49 13 83 71 87 41 21 38 96 54 36 40 65 29 1 17
 * 
 * 2 54 82 41 1 53 8 44 11 55 80 6 30 57 19 95 75 72 58 29 61 79 71 3 60 5 65 91 49 35 40 42 27 15 25 85 17 43 86 16 78 81 93 31 62 84 77 88 24 26 13 59 89 97 67 83 73 47 94 66 87 33 18 22 28 7 14 90 99 63 21 9 45 12 38 70 10 76 68 34 51 39 36 64 50 100 96 69 23 92 56 46 20 52 4 32 98 48 74 37
 * 
 * 6 72 75 65 60 10 32 8 40 82 64 68 44 14 49 56 20 58 88 76 24 9 30 87 93 33 18 45 25 35 91 77 63 99 27 66 21 96 50 54 81 15 55 85 51 12 92 100 36 28 46 22 26 70 4 37 74 16 48 34 38 57 95 80 84 62 90 52 78 13 39 69 42 7 98 86 43 97 29 67 83 23 59 31 3 71 53 5 41 61 19 2 94 47 11 73 17 89 1 79 
 */
public class Ingot implements IIngot
{	
	public int[] values;
	private static final int TOP=100;
	
	public Ingot()
	{
		values=new int[TOP];
		for(int i=0;i<TOP;i++)
			values[i]=i+1;
	}
	
	//Copy the contents of incumbent into this.
	public void copy(IIngot incumbent)
	{
		for(int i=0;i<TOP;i++)
			this.values[i]=((Ingot)incumbent).values[i];
	}
	
	public double evaluate()
	{
		double tot=0d;
		for(int i=0;i<values.length-1;i++)
			if(gcd(values[i],values[i+1])>1)
				//tot-=1d;
				tot-=(values[i]+values[i+1]);
		for(int i=0;i<values.length;i++)
			if(!Prime.isComposite(values[i]))
				tot-=i;
		return tot;
	}
		
	public int gcd(int m,int n)
	{
		if(m==0)
			return n;
		if(n==0)
			return m;
		if(m==1 || n==1)
			return 1;
		if(m>n)
			return gcd(n,m-(m/n)*n);
		else
			return gcd(m,n-(n/m)*m);
	}
	
	public void mutate()
	{
		int n1=(int)(Math.random()*TOP);
		int n2=(int)(Math.random()*TOP);
		int dum=values[n1];
		values[n1]=values[n2];
		values[n2]=dum;
	}

	public void show()
	{
		for(int i=0;i<TOP;i++)
			System.out.print(this.values[i]+" ");
	}
}



