package positronic.satisfiability.bitstringgroup;
/*
 * IBitStringBinaryOperatorTable.java	1.0 November 30, 2009
 *
 * Copyright 2009 Positronic Software.
 *
 *
 */

import positronic.satisfiability.bitstring.IBitString;

public interface IBitStringBinaryOperatorTable
{
	IBitString getLeft(int i);
	String getName();
	IBitString getResult(int i);
	IBitString getRight(int i);
	void setLeft(int i, IBitString X);
	void setResult(int i, IBitString X);
	void setRight(int i, IBitString X);
	int size();
}
