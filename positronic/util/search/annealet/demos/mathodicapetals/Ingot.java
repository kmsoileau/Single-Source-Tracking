package positronic.util.search.annealet.demos.mathodicapetals;

import positronic.util.search.annealet.IIngot;

public class Ingot implements IIngot
{	
	public int[] values;
	private static final int PETALTOTAL=82;
	
	/*78:energy 96:
	23,13,21,17,20,18,22,14,24,16,
	19,15,4,9,5,7,6,8,1,10,
	3,12,2,11
	*/
	/*78:energy 96:
	23,13,21,18,19,16,22,14,24,15,
	20,17,5,8,4,12,1,10,2,11,
	6,7,3,9
	*/
	/*81:energy 6:
	23,13,19,12,20,17,22,14,24,16,
	21,18,3,11,5,15,4,8,1,10,
	6,9,2,7
	*/
	/*81:energy 6:
	23,10,24,15,20,18,21,17,22,14,
	19,16,6,11,5,9,2,12,1,8,
	3,13,4,7
	*/
	public Ingot()
	{
		values=new int[24];
		for(int i=0;i<24;i++)
			values[i]=i+1;
	}
	
	//Copy the contents of incumbent into this.
	public void duplicate(IIngot incumbent)
	{
		for(int i=0;i<24;i++)
			this.values[i]=((Ingot)incumbent).values[i];
	}
		
	public double evaluate()
	{
		int sum1=
			this.petalSum(new int[]{1,2,14,15,13,24,23,12});
		int sum2=
			this.petalSum(new int[]{12,24,13,23,22,21,10,11});
		int sum3=
			this.petalSum(new int[]{23,22,21,19,20,8,9,10});
		int sum4=
			this.petalSum(new int[]{19,17,18,6,7,8,20,21});
		int sum5=
			this.petalSum(new int[]{4,5,6,18,19,17,15,16});
		int sum6=
			this.petalSum(new int[]{3,4,16,17,15,13,14,2});
		int sum7=
			this.petalSum(new int[]{13,14,15,16,17,18,19,20,21,22,23,24});
		return 1d*((sum1-PETALTOTAL)*(sum1-PETALTOTAL)
				+(sum2-PETALTOTAL)*(sum2-PETALTOTAL)
				+(sum3-PETALTOTAL)*(sum3-PETALTOTAL)
				+(sum4-PETALTOTAL)*(sum4-PETALTOTAL)
				+(sum5-PETALTOTAL)*(sum5-PETALTOTAL)
				+(sum6-PETALTOTAL)*(sum6-PETALTOTAL)
				+(sum7-PETALTOTAL)*(sum7-PETALTOTAL));
	}
	
	public void mutate()
	{
		int n1=(int)(Math.random()*24);
		int n2=(int)(Math.random()*24);
		int dum=values[n1];
		values[n1]=values[n2];
		values[n2]=dum;
	}

	public int petal(int n)
	{
		return values[n-1];
	}
	
	public int petalSum(int[] petals)
	{
		int tot=0;
		for(int i=0;i<petals.length;i++)
			tot+=this.petal(petals[i]);
		return tot;
	}
	
	public void show()
	{
		for(int i=0;i<10;i++)
			System.out.print(this.values[i]+",");
		System.out.println("");
		for(int i=10;i<20;i++)
			System.out.print(this.values[i]+",");
		System.out.println("");
		for(int i=20;i<24;i++)
			System.out.print(this.values[i]+",");
	}
}



