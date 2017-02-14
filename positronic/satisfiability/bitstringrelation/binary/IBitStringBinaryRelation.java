package positronic.satisfiability.bitstringrelation.binary;

import positronic.satisfiability.bitstring.IBitString;

public interface IBitStringBinaryRelation 
{
	IBitString getBitString(int relator, int component) throws Exception;
	int getBitStringSize();
	String getName();
	int getSize();
	void setBitString(int relator, int component, IBitString value);
}
