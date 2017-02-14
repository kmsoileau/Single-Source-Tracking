package positronic.satisfiability.bitstringlookuptable;

import positronic.satisfiability.bitstring.BitString;
import positronic.satisfiability.bitstring.IBitString;

public class BitStringLookupTable implements IBitStringLookupTable
{
	private IBitString[] key;
	private IBitString[] entry;
	private String name;

	public BitStringLookupTable(String name, IBitString[] key, IBitString[] entry)
	{
		super();
		this.key = key;
		this.entry = entry;
		this.name = name;
	}
	
	public BitStringLookupTable(String name, int length, int bits) throws Exception
	{
		this(name,new IBitString[length],new IBitString[length]);
		for(int i=0;i<this.key.length;i++)
		{
			this.key[i]=new BitString(bits);
			this.entry[i]=new BitString(bits);
		}
	}

	public IBitString getEntry(int i)
	{
		return this.entry[i];
	}

	public IBitString getKey(int i)
	{
		return this.key[i];
	}

	public int getLength()
	{
		return this.key.length;
	}

	public String getName()
	{
		return this.name;
	}
}
