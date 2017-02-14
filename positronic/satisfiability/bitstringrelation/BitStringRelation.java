package positronic.satisfiability.bitstringrelation;

import positronic.satisfiability.bitstring.BitString;
import positronic.satisfiability.bitstring.IBitString;
import positronic.satisfiability.bitstringlist.BitStringList;
import positronic.satisfiability.bitstringlist.IBitStringList;
import positronic.satisfiability.exceptions.BitStringRelationException;

public class BitStringRelation implements IBitStringRelation
{
	private static int bSRCount;
	private int bitStringSize;
	private IBitStringList[] bsla;
	private int dimension=2;
	private String name;
	private int size=10;
	
	public BitStringRelation(IBitStringRelation bsl) throws Exception
	{
		this(bsl.getName(),bsl.getDimension(),bsl.getSize(),bsl.getBitStringSize());
		for(int i=0;i<bsl.getSize();i++)
			for(int j=0;j<bsl.getDimension();j++)
				setBitString(i, j, new BitString(bsl.getBitString(i,j)));
	}

	public BitStringRelation(int dimension,int size,int bitStringSize) throws Exception
	{
		this("BitStringRelation$"+bSRCount++,dimension,size,bitStringSize);
	}

	public BitStringRelation(String name,int dimension,int size,int bitStringSize) throws Exception
	{
		if(name==null || dimension<1 || size<1 || bitStringSize<1)
			throw new BitStringRelationException("Improper arguments were passed to constructor.");
		this.setName(name);
		this.setDimension(dimension);
		this.setSize(size);
		this.setBitStringSize(bitStringSize);
		bsla=new BitStringList[dimension];
		for(int i=0;i<dimension;i++)
		{
			bsla[i]=new BitStringList(size);
			for(int j=0;j<size;j++)
				bsla[i].add(j,new BitString(bitStringSize));//bsla[i].set(j,new BitString(bitStringSize));
		}
	}
	
	public IBitString getBitString(int relator, int component) throws Exception
	{
		return bsla[component].getBitString(relator);
	}
	
	public int getBitStringSize() 
	{
		return bitStringSize;
	}
	
	public int getDimension() 
	{
		return dimension;
	}
	
	public String getName() 
	{
		return name;
	}

	public int getSize() 
	{
		return size;
	}

	public void setBitString(int relator, int component, IBitString value) 
	{
		bsla[component].set(relator,(BitString)value);
	}

	public void setBitStringSize(int bitStringSize) 
	{
		this.bitStringSize = bitStringSize;
	}

	public void setDimension(int dimension) 
	{
		this.dimension = dimension;
	}

	public void setName(String name) 
	{
		this.name=name;
	}

	public void setSize(int size) 
	{
		this.size = size;
	}

	public String toString()
	{
		String ret="\nRelation "+this.getName()+"\n";
		int l=ret.length()-2;
		for(int i=0;i<l;i++)
			ret+="$";
		ret+="\n";
		for(int i=0;i<this.getSize();i++)
		{
			ret+=i+":";
			for(int j=0;j<this.getDimension();j++)
			{
				if(j!=0)
					ret+=",";
				try 
				{
					ret+=getBitString(i,j);
				} catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
			ret+="\n";
		}
		return ret;
	}
}
