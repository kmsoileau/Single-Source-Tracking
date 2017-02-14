package positronic.math;

import java.util.Iterator;

public class PartitionM implements Iterator<Object>
{
	private int[] index;
	private int M;
	private int N;
	private boolean unused=true;
	Object[] array;
	
	public PartitionM(Object[] array, int M)
	{
		this.N=array.length;
		this.M=M;
		this.array=array;
		index=new int[N];
		index[0]=0;
		for(int i=1;i<this.M-1;i++)
			index[i]=0;
		for(int i=this.M-1;i<N;i++)
			index[i]=0;
	}
	
	
	public boolean isNullFree()
  {
  	boolean[] appears=new boolean[this.M];
  	for(int i=0;i<N;i++)
  		appears[index[i]]=true;
  	for(int i=0;i<this.M;i++)
  		if(!appears[i])
  			return false;
  	return true;
  }
	
	public boolean promote(int s)
	{
		if(s<0 || N-1<s)
			return false;
		if(index[s]<this.M-1)
			index[s]++;
		else
		{
			index[s]=0;
			promote(s+1);
		}
		return true;
	}
	
	public String toString()
	{
		String ret="";
		for(int j=0;j<this.M;j++)
		{
			ret+="{ ";
			for(int i=0;i<N;i++)
				if(index[i]==j)
				{
					ret+=(array[i]+" ");
				}
			ret+="}";
		}
		return ret;
	}
	
	/*public String toString()
	{
		String ret="";
		for(int j=0;j<this.M;j++)
		{
			ret+="{ ";
			for(int i=0;i<N;i++)
				if(index[i]==j)
				{
					ret+=(i+" ");
				}
			ret+="}";
		}
		return ret;
	}*/

	/**
   * Returns <tt>true</tt> if the PartitionM has more partitions. (In other
   * words, returns <tt>true</tt> if <tt>next</tt> would return a partitions
   * rather than throwing an exception.)
   *
   * @return <tt>true</tt> if the PartitionM has more partitions.
   */
  public boolean hasNext()
  {
  	if(this.index!=null)
    {
  		if(unused)return true;
      for(int i=0;i<this.index.length;i++)
        if(this.index[i]!=this.M-1)
          return true;
    }
    return false;
  }

	public Object next() 
	{
		if(unused)
			unused=false;
		else
			promote(0);
		return this;
	}
	
	public Object nextNonNull() 
	{
		next();
		while(!this.isNullFree() && hasNext())
			promote(0);
		if(this.isNullFree())
			return this;
		else return null;
	}

	/**
  *
  * Not supported by this class.
  *
  * @exception UnsupportedOperationException because the <tt>remove</tt>
  *		  operation is not supported by this Iterator.
  */
 public void remove()
 {
   throw new UnsupportedOperationException(
     "The PartitionM class does not support the remove method.");
 }

}
