package positronic.satisfiability.bitstringgroup;

import positronic.satisfiability.bitstring.BitString;
import positronic.satisfiability.bitstring.IBitString;

public class GroupRule
{
	private IBitString leftElement;
	private IBitString rightElement;

	private IBitString resultElement;
	public GroupRule(IBitString leftElement,IBitString rightElement,IBitString resultElement) throws Exception
	{
		this.leftElement=new BitString(leftElement);
		this.rightElement=new BitString(rightElement);
		this.resultElement=new BitString(resultElement);
	}
	
	public IBitString getLeftElement()
	{
		return leftElement;
	}

	public IBitString getResultElement()
	{
		return resultElement;
	}

	public IBitString getRightElement()
	{
		return rightElement;
	}

	public void setLeftElement(IBitString leftElement)
	{
		this.leftElement = leftElement;
	}

	public void setResultElement(IBitString resultElement)
	{
		this.resultElement = resultElement;
	}

	public void setRightElement(IBitString rightElement)
	{
		this.rightElement = rightElement;
	}
}
