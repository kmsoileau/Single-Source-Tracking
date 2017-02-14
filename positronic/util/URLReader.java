package positronic.util;

import java.util.StringTokenizer;

public class URLReader 
{
	public static void main(String[] args) throws Exception 
	{
		System.out.println(quote("MSFT"));
	}
	
	public static float quote(String stockSymbol) throws Exception
	{
		//URL yahoo = new URL("http://finance.yahoo.com/q?s="+stockSymbol);
		//BufferedReader in = new BufferedReader(new InputStreamReader(yahoo.openStream()));
		BufferedURLReader in = new BufferedURLReader("http://finance.yahoo.com/q?s="+stockSymbol);
		String inputLine;
		String total="";
		while ((inputLine = in.readLine()) != null)
		    total+=inputLine;
		in.close();
		StringTokenizer st=new StringTokenizer(total,"<");
		String result="";
		while(st.hasMoreTokens())
		{
			String nextToken=st.nextToken();
				if(nextToken.contains("b>")&&nextToken.contains(".")&&!nextToken.contains("otherwise"))
				{
					result=nextToken.substring(2);
					break;
				}
		}
		return Float.parseFloat(result);
	}
}
