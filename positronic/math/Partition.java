package positronic.math;

public class Partition
{
	public static String dump(int[] array)
	{
		String ret="";
		for(int i=0;i<array.length;i++)
			ret+=(array[i]+" ");
		return ret;
	}
	
	public static void main(String[] args) 
	{
		Partition p=new Partition(600,15);
		while(true)
		{
			int[] a = p.next();
			if(a==null)
				break;
			System.out.println(dump(a));
		}
	}
	
	private int[] partition;
	private int parts;
	private int total;
	
	public Partition(int total, int parts)
	{
		if(total>=1 && parts>=1)
		{
			this.parts=parts;
			this.total=total;
			partition=new int[parts];
			partition[0]=total;
		}
	}
	
	public int[] next()
	{
		for(int i=this.total;i>=this.total/this.parts;)
		{
			Partition p=new Partition(total-i,parts-1);
			partition[0]=i;
			if(p==null || p.partition==null)
				return null;
			for(int j=0;j<p.partition.length;j++)
				partition[j+1]=p.partition[j];
			return partition;
		}
		return null;
	}
}
