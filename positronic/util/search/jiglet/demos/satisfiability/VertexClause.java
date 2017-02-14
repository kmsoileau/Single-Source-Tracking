package positronic.util.search.jiglet.demos.satisfiability;

import positronic.satisfiability.elements.IClause;

public class VertexClause 
{
	public static double evaluate(BVMap bvm,IClause cl) throws Exception
	{
		if(cl.size()<1)
			return 0.;
		double ret=1.;
		for(int i=1;i<cl.size();i++)
			ret*=VertexBL.evaluate(bvm,cl.getLiteralAt(i));
		return ret;  
	}
}
