package positronic.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;

public class URL
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
	
	private java.net.URL url;
	 
	public URL(java.net.URL url)
	{
		this.url=url;
	}

	public URL(String urlString) throws MalformedURLException
	{
		this(new java.net.URL(urlString));
	}
	
	public java.net.URL getUrl()
	{
		return url;
	}
	 
	public String readAll() throws IOException
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(this.url.openStream()));
		String inputLine;
		String total="";
		while ((inputLine = in.readLine()) != null)
		    total+=inputLine;
		in.close();
		return total;
	}
}
