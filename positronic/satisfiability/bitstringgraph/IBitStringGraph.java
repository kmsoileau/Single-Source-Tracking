/*
 * IBitStringTree.java	1.0 06/03/31
 *
 * Copyright 2006 Positronic Software.
 *
 *
 */

package positronic.satisfiability.bitstringgraph;

import positronic.satisfiability.elements.IBooleanVariable;
import positronic.satisfiability.exceptions.BitStringGraphException;

public interface IBitStringGraph extends Cloneable
{
	IBooleanVariable[][] getData();
	IBooleanVariable getData(int i,int j);
	String getName();
	int getNumberOfVertices();
	void setData(IBooleanVariable[][] iBooleanVariables);
	void setData(int i, int j, IBooleanVariable booleanVariable);
	void setName(String name) throws BitStringGraphException;
	String toString();
}
  