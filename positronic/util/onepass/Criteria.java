package positronic.util.onepass;

public class Criteria 
{
	public static boolean atLeastNCharacters(int n, String URL)
	{
		return (URL.length()>=n);
	}
	
	public static boolean atLeastOneAlphaCharacter(String URL)
	{
		String alpha=Messages.getString("OnePass.Alphabetics");
		for(int i=0;i<alpha.length();i++)
			if(URL.contains(alpha.subSequence(i,i+1)))
				return true;
		return false;
	}
	
	public static boolean atLeastOneLowercase(String URL)
	{
		String lower=Messages.getString("OnePass.Lowercase");
		for(int i=0;i<lower.length();i++)
			if(URL.contains(lower.subSequence(i,i+1)))
				return true;
		return false;
	}
	
	public static boolean atLeastOneNumericCharacter(String URL)
	{
		String alpha=Messages.getString("OnePass.Numerics");
		for(int i=0;i<alpha.length();i++)
			if(URL.contains(alpha.subSequence(i,i+1)))
				return true;
		return false;
	}
	
	public static boolean atLeastOneSpecialCharacter(String URL)
	{
		String special=Messages.getString("OnePass.SpecialCharacters");
		for(int i=0;i<special.length();i++)
			if(URL.contains(special.subSequence(i,i+1)))
				return true;
		return false;
	}
	
	public static boolean atLeastOneUppercase(String URL)
	{
		String upper=Messages.getString("OnePass.Uppercase");
		for(int i=0;i<upper.length();i++)
			if(URL.contains(upper.subSequence(i,i+1)))
				return true;
		return false;
	}
	
	public static boolean doesntBeginWithExclamation(String URL)
	{
		return !URL.startsWith("!");
	}
	
	public static boolean doesntBeginWithQuestionMark(String URL)
	{
		return !URL.startsWith("?");
	}
}
