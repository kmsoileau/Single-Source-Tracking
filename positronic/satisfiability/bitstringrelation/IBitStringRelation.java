package positronic.satisfiability.bitstringrelation;

import positronic.satisfiability.bitstring.IBitString;

public interface IBitStringRelation 
{
	IBitString getBitString(int relator, int component) throws Exception;
	int getBitStringSize();
	int getDimension();
	String getName();
	int getSize();
	void setBitString(int relator, int component, IBitString value);
}
