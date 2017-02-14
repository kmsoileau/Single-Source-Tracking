package positronic.util;
/**
 * AlphaHashSet
 * 11/25/2008
 * @author Kerry Soileau
 *
 */

import java.util.ArrayList;

import positronic.satisfiability.elements.BooleanLiteral;
import positronic.satisfiability.elements.BooleanLiteralSet;
import positronic.satisfiability.elements.BooleanVariable;
import positronic.satisfiability.elements.IBooleanLiteral;
import positronic.satisfiability.elements.IBooleanVariable;
import positronic.satisfiability.exceptions.BooleanLiteralException;

public class AlphaHashSet extends PersistentArrayList<BooleanLiteralSet>
{
	private static final long serialVersionUID = -8451485508225118870L;

	public static void main(String[] args) throws Exception
	{
		IBooleanVariable A=BooleanVariable.getBooleanVariable("A");
		IBooleanVariable B=BooleanVariable.getBooleanVariable("B");
		IBooleanVariable C=BooleanVariable.getBooleanVariable("C");
		AlphaHashSet as=new AlphaHashSet(
				new BooleanLiteralSet[]{
						new BooleanLiteralSet(
								new IBooleanLiteral[]{
										BooleanLiteral.getBooleanLiteral(A, true),
										BooleanLiteral.getBooleanLiteral(B, true)}
								),
								new BooleanLiteralSet(
										new IBooleanLiteral[]{
												BooleanLiteral.getBooleanLiteral(A, true),
												BooleanLiteral.getBooleanLiteral(C, false),
												BooleanLiteral.getBooleanLiteral(B, true)
												}
										)
				}
		);
		System.out.println(as);
	}
	
	public AlphaHashSet(BooleanLiteralSet[] array)
	{
		for(BooleanLiteralSet bls : array)
			this.add(bls);
	}
	
	/**
	 * If s==null, does nothing but return false.
	 * If s contains some BooleanLiteral b and also the
	 * negation of b, then does nothing but return false.
	 * If s is already a member of this, then does nothing but 
	 * return false.
	 * If there is some member t of this such that t is a proper
	 * subset of s, then does nothing but return false.
	 * For each member t of this such that s is a proper subset of t, 
	 * then t is deleted. Finally s is added.
	 * Otherwise, s is added.
	 * 
	 */
	public boolean add(BooleanLiteralSet s)
	{
		if(s==null) return false;
		if(!(s instanceof BooleanLiteralSet)) return false;
		for(IBooleanLiteral b : s)
			try
			{
				if(s.contains(b) && s.contains(b.complement())) 
						return false;
			} catch (BooleanLiteralException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if(this.contains(s)) return false;
		for(Object t : this)
			if(s.properlycontains((BooleanLiteralSet)t))
				return false;
		ArrayList<BooleanLiteralSet> removeList=new ArrayList<BooleanLiteralSet>();
		for(Object t : this)
			if(((BooleanLiteralSet)t).properlycontains(s))
				removeList.add((BooleanLiteralSet)t);
				//this.remove(t);
				
		this.removeAll(removeList);
		
		return super.add(s);
	}
	
	private void removeAll(ArrayList<BooleanLiteralSet> removeList)
	{
		for(BooleanLiteralSet b : removeList)
			this.remove(b);
	}

	public String toString()
	{
		String res="";
		for(Object bs : this)
			res+="\n"+((BooleanLiteralSet)bs).toString();
		return res;
	}
}

