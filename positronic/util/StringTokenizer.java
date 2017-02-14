package positronic.util;

public class StringTokenizer extends java.util.StringTokenizer
{
	public static void main(String[] args) throws Exception 
	{
		System.out.println("MSFT\t"+quote("MSFT"));
		System.out.println("APA\t"+quote("APA"));
	}
	
	public static float quote(String stockSymbol) throws Exception
	{
		URL yahoo = new URL("http://finance.yahoo.com/q?s="+stockSymbol);
		String total=yahoo.readAll();
		StringTokenizer st=new StringTokenizer(total,">/");
		st.runPast("Last Trade:");
		st.runPast("<span");
		String nextToken=st.nextToken();
		int pos=nextToken.indexOf('<');
		return Float.parseFloat(nextToken.substring(0,pos));
	}
	
	public StringTokenizer(String str, String delim)
	{
		super(str, delim);
	}
	
	public String runPast(String x)
	{
		while(super.hasMoreTokens())
		{
			String nextToken=super.nextToken();
			if(nextToken.length()>=x.length())
				if(nextToken.substring(0,x.length()).compareTo(x)==0)
					return nextToken;
		}
		return null;
	}
}
