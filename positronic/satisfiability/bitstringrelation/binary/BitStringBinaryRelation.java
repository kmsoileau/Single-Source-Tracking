package positronic.satisfiability.bitstringrelation.binary;

import positronic.satisfiability.bitstringrelation.BitStringRelation;

public class BitStringBinaryRelation extends BitStringRelation
{
	private static int bSBRCount;
	
	public BitStringBinaryRelation(int size,int bitStringSize) throws Exception
	{
		super("BitStringBinaryRelation$"+bSBRCount++,2,size,bitStringSize);
	}
	
	public BitStringBinaryRelation(String name,int size,int bitStringSize) throws Exception
	{
		super(name,2,size,bitStringSize);
	}
}
