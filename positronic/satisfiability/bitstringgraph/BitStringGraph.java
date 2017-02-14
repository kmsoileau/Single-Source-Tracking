/*
 * BitStringTree.java	1.0 06/03/31
 *
 * Copyright 2006 Positronic Software.
 *
 *
 */
/**
 * 
 *
 * @author  Kerry Michael Soileau
 * <blockquote><pre>
 * ksoileau@yahoo.com
 * http://kerrysoileau.com/index.html
 * </pre></blockquote>
 * @version 1.0, 06/03/31
 * @see HashSet
 * @see List
 * @see IBitString
 * @see BitStringGraphException
 */
package positronic.satisfiability.bitstringgraph;

import positronic.satisfiability.elements.BooleanVariable;
import positronic.satisfiability.elements.IBooleanVariable;
import positronic.satisfiability.exceptions.BitStringGraphException;

public class BitStringGraph implements IBitStringGraph
{
	private static int bSGCount;
	private IBooleanVariable[][] data;
	private String name;

	public BitStringGraph() throws Exception
	{
		this(1);
	}

	public BitStringGraph(int numberOfVertices) throws Exception
	{
		this("BitStringGraph$"+bSGCount++,numberOfVertices);
	}

	public BitStringGraph(String name) throws Exception
	{
		this(name,1);
	}

	public BitStringGraph(String name, int numberOfVertices) throws Exception
	{
		this.setData(new IBooleanVariable[numberOfVertices][numberOfVertices]);
		this.setName(name);
		for(int i=0;i<numberOfVertices;i++)
			for(int j=0;j<numberOfVertices;j++)
				this.setData(i,j,BooleanVariable.getBooleanVariable());
	}

	public IBooleanVariable[][] getData()
	{
		return this.data;
	}

	public IBooleanVariable getData(int i,int j)
	{
		return this.getData()[i][j];
	}

	public String getName()
	{
		return this.name;
	}

	public int getNumberOfVertices()
	{
		return this.getData().length;
	}

	public void setData(IBooleanVariable[][] iBooleanVariables)
	{
		this.data = iBooleanVariables;
	}

	public void setData(int i, int j, IBooleanVariable booleanVariable)
	{
		this.getData()[i][j]=booleanVariable;
	}

	public void setName(String name) throws BitStringGraphException
	{
		if(name==null)
			throw new BitStringGraphException("Passed null String to setName method.");

		this.name = name;
	}

	public String toString()
	{
		String ret="$"+this.getName()+":";
		for(int i=0;i<this.getNumberOfVertices();i++)
			for(int j=0;j<this.getNumberOfVertices();j++)
				if(this.getData(i,j).getValue())
					ret+="{"+i+"$"+j+"}";
		return ret+"$";
	}
}