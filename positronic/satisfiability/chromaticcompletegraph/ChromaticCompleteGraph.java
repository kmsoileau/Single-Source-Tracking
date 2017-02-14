package positronic.satisfiability.chromaticcompletegraph;

/*
 * ChromaticCompleteGraph.java	1.0 10/04/18
 *
 * Copyright 2010 Positronic Software.
 *
 *
 */
 /**
 * TBS
 *
 * @author  Kerry Michael Soileau
 * <blockquote><pre>
 * ksoileau@yahoo.com
 * http://kerrysoileau.com/index.html
 * </pre></blockquote>
 * @version 1.0, 10/04/18
 * @see BitString
 * @see java.util.Vector
 */

import java.util.Vector;

import positronic.satisfiability.bitstring.BitString;

public class ChromaticCompleteGraph implements IChromaticCompleteGraph
{
	private static int nNCount;
	private String name;
	private Vector<ColoredEdge> edges;
	
	public ChromaticCompleteGraph(int vertices, int colors) throws Exception
	{
		this("ChromaticCompleteGraph$"+ nNCount++,vertices,colors);
	}

	public ChromaticCompleteGraph(String name,int vertices, int colors) throws Exception
	{
		this.name=name;
	    this.edges=new Vector<ColoredEdge>();
	    for(ColoredEdge edge : this.edges)
	    {
	    	edge.firstpoint=new BitString();
	    	edge.secondpoint=new BitString();
	    	edge.color=new BitString();
	    }
	}

	public boolean equals(Object o)
	{
		if(o==null)
			return false; //this is never equal to null.
		if(!(o instanceof ChromaticCompleteGraph))
			return false;
		else
			return (this.getName().compareTo(((ChromaticCompleteGraph)o).getName()))==0;
	}
  
	public Vector<ColoredEdge> getEdges()
	{
		return edges;
	}

	public String getName()
	{
		return name;
	}

	public void setEdges(Vector<ColoredEdge> edges)
	{
		this.edges = edges;
	}

	public String toString()
	{
		return null;
	}
}