package positronic.util.onepass;

import java.net.MalformedURLException;
import java.net.UnknownHostException;

public class OnePass
{
	private static final String alphabet=Messages.getString("OnePass.Alphanumerics");
	private static final int SEED=1024*1023;
	
	/**
	 * For the purposes of this class, a "strong password" is defined as
	 * an alphanumeric string having the following attributes:
	 * It is at least 8 characters long.
	 * It contains at least:
	 * 		one uppercase alpha character [A-Z]
	 * 		one lowercase alpha character [a-z]
	 * 		one numeric character [0-9]
	 * 		one special character from this set:
	 * 			` ! @ $ % ^ & * ( ) - _ = + [ ] ; : ' , < . > / ?
	 * 	It does NOT:
	 * 		contain spaces
	 * 		begin with an exclamation [!]
	 * 		begin with a question mark [?]
	 * 
	 */
	
	/*public static long ipIndex(String URL) throws UnknownHostException
	{
		byte[] ipAddr = InetAddress.getByName(URL).getAddress();
	    int[] ipAddrInt=new int[ipAddr.length];
	    
	    for (int i=0; i<ipAddr.length; i++)
	    	ipAddrInt[i]=(ipAddr[i]&0xFF);
	    
	    long tot=ipAddrInt[0];
	    for(int i=1;i<ipAddr.length;i++)
	    	tot=256*tot+ipAddrInt[i];
	    
	    return tot;
	}*/
	
	public static void main(String[] args) throws MalformedURLException, UnknownHostException
	{
		System.out.println(OnePass.strongPassGen(261291190,"http://www.yahoo.com/"));
		System.out.println(OnePass.strongPassGen(261291191,"http://www.yahoo.com/"));
		System.out.println(OnePass.strongPassGen(261291192,"http://www.yahoo.com/"));
		System.out.println(OnePass.strongPassGen(261291193,"http://www.yahoo.com/"));
		System.out.println(OnePass.strongPassGen(261291194,"http://www.yahoo.com/"));
		System.out.println(OnePass.strongPassGen(261291195,"http://www.yahoo.com/"));
		System.out.println(OnePass.strongPassGen(261291196,"http://www.yahoo.com/"));
		System.out.println(OnePass.strongPassGen(261291197,"http://www.yahoo.com/"));
		System.out.println(OnePass.strongPassGen(261291198,"http://www.yahoo.com/"));
		System.out.println(OnePass.strongPassGen(261291199,"http://www.yahoo.com/"));
		
		System.out.println(OnePass.strongPassGen(261291190,"http://visiontoamerica.org/9158/election-officials-investigating-group-that-exposed-voter-fraud/"));
		System.out.println(OnePass.strongPassGen(261291191,"http://visiontoamerica.org/9158/election-officials-investigating-group-that-exposed-voter-fraud/"));
		System.out.println(OnePass.strongPassGen(261291192,"http://visiontoamerica.org/9158/election-officials-investigating-group-that-exposed-voter-fraud/"));
		System.out.println(OnePass.strongPassGen(261291193,"http://visiontoamerica.org/9158/election-officials-investigating-group-that-exposed-voter-fraud/"));
		System.out.println(OnePass.strongPassGen(261291194,"http://visiontoamerica.org/9158/election-officials-investigating-group-that-exposed-voter-fraud/"));
		System.out.println(OnePass.strongPassGen(261291195,"http://visiontoamerica.org/9158/election-officials-investigating-group-that-exposed-voter-fraud/"));
		System.out.println(OnePass.strongPassGen(261291196,"http://visiontoamerica.org/9158/election-officials-investigating-group-that-exposed-voter-fraud/"));
		System.out.println(OnePass.strongPassGen(261291197,"http://visiontoamerica.org/9158/election-officials-investigating-group-that-exposed-voter-fraud/"));
		System.out.println(OnePass.strongPassGen(261291198,"http://visiontoamerica.org/9158/election-officials-investigating-group-that-exposed-voter-fraud/"));
		System.out.println(OnePass.strongPassGen(261291199,"http://visiontoamerica.org/9158/election-officials-investigating-group-that-exposed-voter-fraud/"));
	}
	
	/**
	 * Generate a candidate strong password from a long (your master PIN)
	 * and a String (the URL of the site using the password.) 
	 */
	public static String passGen(long personal,String URL) throws MalformedURLException, UnknownHostException
	{
		long rem=personal*URLindex(URL);
		String out="";
	    while(rem>0)
	    {
	    	out+=alphabet.charAt((int)(rem % alphabet.length()));
	    	rem/=alphabet.length();
	    }
	    return out;
	}
	
	/**
	 * Generate a strong password by testing a sequence of passwords until
	 * one satisfying all strong password constraints is found. 
	 */
	public static String strongPassGen(long personal, String URL) throws MalformedURLException, UnknownHostException
	{
		String current=Messages.getString("OnePass.0");
		int seq=1;
		for(int i=0;i<seq;i++)
		{
			while(personal++ < Long.MAX_VALUE)
			{
				current=OnePass.passGen(personal,URL);
				if(!Criteria.doesntBeginWithExclamation(current))
					continue;
				if(!Criteria.doesntBeginWithQuestionMark(current))
					continue;
				if(!Criteria.atLeastNCharacters(8,current))
					continue;
				if(!Criteria.atLeastOneNumericCharacter(current))
					continue;
				if(!Criteria.atLeastOneSpecialCharacter(current))
					continue;
				if(!Criteria.atLeastOneUppercase(current))
					continue;
				if(!Criteria.atLeastOneLowercase(current))
					continue;
				if(!Criteria.atLeastOneAlphaCharacter(current))
					continue;
				
				break;
			}
		}
		return current;
	}
	
	static int URLindex(String urlString)
	{
		if(urlString.isEmpty())
			return 0;
		return SEED*(int)(urlString.charAt(0))+URLindex(urlString.substring(1));
	}
}
