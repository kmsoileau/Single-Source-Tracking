package positronic.satisfiability.bitstringgroup;

import java.util.ArrayList;

import positronic.satisfiability.bitstring.BitString;
import positronic.satisfiability.bitstring.IBitString;

public class BitStringBinaryOperatorTable implements IBitStringBinaryOperatorTable
{
	private ArrayList<IBitString> elements;
	private String name;
	private static int sequence;
	private GroupRule[] rules;
	
	public BitStringBinaryOperatorTable(ArrayList<IBitString> elements) throws Exception
	{
		this("BitStringBinaryOperatorTable$"+(++sequence),elements);
	}
	
	public BitStringBinaryOperatorTable(String name, ArrayList<IBitString> elements) throws Exception
	{
		this.name=name;
		this.elements=elements;
		int numberElements=this.elements.size();
		int bitStringSize=this.elements.get(0).size();
		rules=new GroupRule[numberElements*numberElements];
		for(int i=0;i<rules.length;i++)
		{
			rules[i]=new GroupRule(
					new BitString(name+"-left$"+i,bitStringSize),
					new BitString(name+"-right$"+i,bitStringSize),
					new BitString(name+"-result$"+i,bitStringSize));
		}
	}
	
	public IBitString getLeft(int i)
	{
		return this.rules[i].getLeftElement();
	}

	public String getName()
	{
		return this.name;
	}

	public IBitString getResult(int i)
	{
		return this.rules[i].getResultElement();
	}

	public IBitString getRight(int i)
	{
		return this.rules[i].getRightElement();
	}

	public void setLeft(int i, IBitString X)
	{
		this.rules[i].setLeftElement(X);
	}

	public void setResult(int i, IBitString X)
	{
		this.rules[i].setResultElement(X);
	}

	public void setRight(int i, IBitString X)
	{
		this.rules[i].setRightElement(X);
	}

	public int size()
	{
		return this.rules.length;
	}
}

/*public class BitStringBinaryOperatorTable implements IBitStringBinaryOperatorTable
{
private ArrayList<IBitString> leftElement;
private ArrayList<IBitString> rightElement;
private ArrayList<IBitString> resultElement;
private String name;
private static int sequence;

public BitStringBinaryOperatorTable(int equations, int bitStringSize) throws Exception
{
	this("BitStringBinaryOperatorTable$"+(++sequence),equations,bitStringSize);
}

public BitStringBinaryOperatorTable(String name, int equations, int bitStringSize) throws Exception
{
	this.name=name;
	leftElement=new ArrayList<IBitString>(equations);
	for(int i=0;i<equations;i++)
		leftElement.add(new BitString(name+"-left$"+i,bitStringSize));
	rightElement=new ArrayList<IBitString>(equations);
	for(int i=0;i<equations;i++)
		rightElement.add(new BitString(name+"-right$"+i,bitStringSize));
	resultElement=new ArrayList<IBitString>(equations);
	for(int i=0;i<equations;i++)
		resultElement.add(new BitString(name+"-result$"+i,bitStringSize));
}

public IBitString getLeft(int i)
{
	return this.leftElement.get(i);
}

public String getName()
{
	return this.name;
}

public IBitString getResult(int i)
{
	return this.resultElement.get(i);
}

public IBitString getRight(int i)
{
	return rightElement.get(i);
}

public void setLeft(int i, IBitString X)
{
	this.leftElement.set(i,X);
}

public void setResult(int i, IBitString X)
{
	this.resultElement.set(i,X);
}

public void setRight(int i, IBitString X)
{
	this.rightElement.set(i,X);
}

public int size()
{
	return this.leftElement.size();
}
}*/