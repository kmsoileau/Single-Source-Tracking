package positronic.satisfiability.asdata.clause;

import positronic.satisfiability.elements.BooleanLiteral;
import positronic.satisfiability.elements.BooleanVariable;
import positronic.satisfiability.elements.Clause;
import positronic.satisfiability.elements.IBooleanLiteral;
import positronic.satisfiability.elements.IBooleanVariable;
import positronic.satisfiability.elements.IClause;
import positronic.satisfiability.exceptions.BooleanLiteralException;

public class ClauseAsData implements IClauseAsData
{
	private static IBooleanVariable[] VARIABLES;
	private static long cadCount;
	
	public static void declare(IBooleanVariable[] variables) throws Exception
	{
		ClauseAsData.VARIABLES=variables;
	}
	
	public static int findIndex(IBooleanVariable bv) throws Exception
	{
		for(int i=0;i<ClauseAsData.VARIABLES.length;i++)
			if(ClauseAsData.VARIABLES[i].equals(bv))
				return i;
		return -1;
	}
	
	public static IBooleanVariable[] getVARIABLES() 
	{
		return VARIABLES;
	}
	
	public static void main(String[] args) throws Exception
	{
		IBooleanVariable A=BooleanVariable.getBooleanVariable("A");
		IBooleanVariable B=BooleanVariable.getBooleanVariable("B");
		
		ClauseAsData.declare(new IBooleanVariable[]{A,B});
		
		IClauseAsData c1=new ClauseAsData();
		System.out.println("c1 = "+c1);
		
		IClauseAsData c2=new ClauseAsData("clause2");
		System.out.println(c2.getName()+" = "+c2);
		
		IClauseAsData c3=new ClauseAsData("clause2");
		c3.occurrenceIndicator(A).setValue(true);
		c3.barredIndicator(A).setValue(true);
		c3.occurrenceIndicator(B).setValue(true);
		System.out.println(c3.getName()+" = "+c3);
		System.out.println(c3.getName()+" = "+c3.toClause());
	}
	
	private String name;
	/*
	 * The nth booleanvariable in occurrence indicates whether the nth variable appears in the clause.
	 * If so, the nth booleanvariable in barred indicates whether the nth variable is barred, else it 
	 * is ignored.
	 */
	
	public IBooleanVariable[] occurrence;

	public IBooleanVariable[] barred;
	public ClauseAsData() throws Exception 
	{
		this("CAD$"+ ClauseAsData.cadCount++);
	}
	
	public ClauseAsData(String name) throws Exception 
	{
		if(ClauseAsData.VARIABLES==null)
			throw new UndeclaredVariablesException("ClauseAsData constructor was called before a call to ClauseAsData.declare method.");
		this.name=name;
		occurrence=new IBooleanVariable[ClauseAsData.VARIABLES.length];
		for(int i=0;i<occurrence.length;i++)
			occurrence[i]=BooleanVariable.getBooleanVariable(this.name+"$"+ClauseAsData.VARIABLES[i].getName()+"_occurrence$"+i);
		barred=new IBooleanVariable[ClauseAsData.VARIABLES.length];
		for(int i=0;i<barred.length;i++)
			barred[i]=BooleanVariable.getBooleanVariable(this.name+"$"+ClauseAsData.VARIABLES[i].getName()+"_barred$"+i);
	}
	
	public IBooleanVariable barredIndicator(IBooleanVariable bv) throws Exception
	{
		return this.barred[ClauseAsData.findIndex(bv)];
	}
	
	public String getName() 
	{
		return name;
	}
	
	public IBooleanVariable occurrenceIndicator(IBooleanVariable bv) throws Exception
	{
		return this.occurrence[ClauseAsData.findIndex(bv)];
	}
	
	public IClause toClause() throws Exception
	{
		IClause ret=Clause.newClause();
		for(IBooleanVariable bv : ClauseAsData.VARIABLES)
		{
			if(occurrenceIndicator(bv).getValue())
				if(barredIndicator(bv).getValue())
					ret.orNot(bv);
				else
					ret.or(bv);
		}
		return ret;
	}
	
	public String toString()
	  {
	    String res="{";
	    for(int j=0;j<ClauseAsData.VARIABLES.length;j++)
	    {
	    	if(!this.occurrence[j].getValue())
	    		continue;
	    	if(!this.barred[j].getValue())
	    	{
	    		IBooleanLiteral ib;
					try
					{
						ib = BooleanLiteral.getBooleanLiteral(ClauseAsData.VARIABLES[j], false);
						res+=ib;
					} 
					catch (BooleanLiteralException e)
					{
						e.printStackTrace();
					}
	    		
	    	}
	    	else
	    	{
	    		IBooleanLiteral ib;
					try
					{
						ib = BooleanLiteral.getBooleanLiteral(ClauseAsData.VARIABLES[j], true);
						res+=ib;
					} 
					catch (BooleanLiteralException e)
					{
						e.printStackTrace();
					}
	    		
	    	}
	    }
	    return res+"}";
	  }
}
