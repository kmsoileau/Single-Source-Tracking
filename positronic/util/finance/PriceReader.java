package positronic.util.finance;

import positronic.util.StringTokenizer;
import positronic.util.URL;

public class PriceReader 
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
		StringTokenizer st=new StringTokenizer(total,">");
		st.runPast("Last Trade:");
		st.runPast("<span");
		String nextToken=st.nextToken();
		int pos=nextToken.indexOf('<');
		return Float.parseFloat(nextToken.substring(0,pos));
	}
}
