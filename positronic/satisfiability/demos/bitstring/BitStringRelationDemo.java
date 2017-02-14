package positronic.satisfiability.demos.bitstring;

import positronic.satisfiability.bitstring.BitString;
import positronic.satisfiability.bitstringrelation.IBitStringRelation;
import positronic.satisfiability.bitstringrelation.binary.BitStringBinaryRelation;

public class BitStringRelationDemo
{
	public static void main(String[] args) throws Exception
	{
		IBitStringRelation ibsr=new BitStringBinaryRelation("MyTestRelation",3,2);
		ibsr.setBitString(1,1,new BitString("01"));
		ibsr.setBitString(2,1,new BitString("11"));
		System.out.println(ibsr.getBitString(2,1));
		System.out.println(ibsr.toString());
	}
}
