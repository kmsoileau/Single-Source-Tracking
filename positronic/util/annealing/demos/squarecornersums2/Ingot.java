package positronic.util.annealing.demos.squarecornersums2;

public class Ingot
{	
	public int[] values;
		
	public Ingot()
	{
		values=new int[9];
		for(int i=0;i<9;i++)
			values[i]=i+1;
	}

	//Copy the contents of ThatOne into this.
	public void copy(Ingot ThatOne)
	{
		for(int i=0;i<9;i++)
			this.values[i]=ThatOne.values[i];
	}

	public double evaluate()
	{
		int sum1=values[0]*values[0]+values[1]*values[1]+values[3]*values[3]+values[4]*values[4];
		int sum2=values[4]*values[4]+values[5]*values[5]+values[7]*values[7]+values[8]*values[8];
		return 1d*(sum1-sum2)*(sum1-sum2);
	}
	
	public void mutate()
	{
		int n1=(int)(Math.random()*9);
		int n2=(int)(Math.random()*9);
		int dum=values[n1];
		values[n1]=values[n2];
		values[n2]=dum;
	}
}



