package positronic.satisfiability.bitstringgroup;

import positronic.satisfiability.bitstring.IBitString;

public interface IBitStringGroup
{
	void addRule(IBitString a,IBitString b,IBitString c);
	String getName();
	String toString();
}
	
	
