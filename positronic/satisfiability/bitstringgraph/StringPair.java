package positronic.satisfiability.bitstringgraph;

public class StringPair
{
	String one;
	String other;
	
	public StringPair(String one, String other)
	{
		this.one=one;
		this.other=other;
	}

	public String getOne()
	{
		return one;
	}

	public void setOne(String one)
	{
		this.one = one;
	}

	public String getOther()
	{
		return other;
	}

	public void setOther(String other)
	{
		this.other = other;
	}
}
