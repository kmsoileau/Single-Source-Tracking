package positronic.satisfiability.interval;

import positronic.satisfiability.elements.IBooleanVariable;
import positronic.satisfiability.elements.IClause;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;
import positronic.satisfiability.exceptions.IntervalException;
import positronic.satisfiability.naturalnumber.INaturalNumber;
import positronic.satisfiability.naturalnumber.NaturalNumber;
/**
 * An Interval represents either the empty set or a set of 
 * the form {a,a+1,a+2,...,b-1,b} if a<=b and both are 
 * natural numbers. This is denoted [a..b]. If a>b, then the 
 * resulting Interval is the empty set. Any set [a..b] with 
 * a>b represents the empty set.
 *
 * In one way to use this class, one passes INaturalNumbers X 
 * and Y to the appropriate constructor. The Interval object 
 * produced may be manipulated using any of the methods 
 * provided by the Problem class.
 *
 * @author  Kerry Michael Soileau
 * <blockquote><pre>
 * ksoileau@yahoo.com
 * http://kerrysoileau.com/index.html
 * </pre></blockquote>
 * @version 1.0, 07/09/10
 * @see IBooleanVariable
 * @see IClause
 * @see IProblem
 * @see Problem
 */

public class Interval implements IInterval
{
	private INaturalNumber left;
	private INaturalNumber right;
	
	public Interval() throws Exception
	{
		this(new NaturalNumber(),new NaturalNumber());
	}
	
	public Interval(INaturalNumber a, INaturalNumber b) throws IntervalException
	{
		if(a==null && b==null)
			throw new IntervalException("A null INaturalNumber was passed to a constructor.");
		this.left=a;
		this.right=b;
	}
	
	public Interval(long m,long n) throws Exception
	{
		this(new NaturalNumber(m),new NaturalNumber(n));
	}
	
	public INaturalNumber getLeft() 
	{
		return left;
	}

	public INaturalNumber getRight() 
	{
		return right;
	}

	public void setLeft(INaturalNumber left) 
	{
		this.left = left;
	}

	public void setRight(INaturalNumber right) 
	{
		this.right = right;
	}
	
	public String toString()
  {
    return "$"+this.getLeft()+".."+this.getRight()+"$";
  }
}
