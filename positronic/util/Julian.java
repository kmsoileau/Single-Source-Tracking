package positronic.util;

import java.util.Calendar;

public class Julian
{
	private double date;
	
	public double value()
	{
		return date;
	}

	/**
	 * Returns the Julian day number that begins at noon of
	 * this day, Positive year signifies A.D., negative year B.C.
	 * Remember that the year after 1 B.C. was 1 A.D.
	 *
	 * ref :
	 *  Numerical Recipes in C, 2nd ed., Cambridge University Press 1992
	 */
	
	// Gregorian Calendar adopted Oct. 15, 1582 (2299161)
	public static int JGREG= 15 + 31*(10+12*1582);
	public static double HALFSECOND = 0.5;
	  
	/**
	 * Converts a Julian day to a calendar date
	 * ref :
	 * Numerical Recipes in C, 2nd ed., Cambridge University Press 1992
	 */
	public static int[] fromJulian(double injulian) 
	{
		int jalpha,ja,jb,jc,jd,je,year,month,day;
		ja = (int) injulian;
		if (ja>= JGREG) 
		{    
			jalpha = (int) (((ja - 1867216) - 0.25) / 36524.25);
			ja = ja + 1 + jalpha - jalpha / 4;
		}
	 
		jb = ja + 1524;
		jc = (int) (6680.0 + ((jb - 2439870) - 122.1) / 365.25);
		jd = 365 * jc + jc / 4;
		je = (int) ((jb - jd) / 30.6001);
		day = jb - jd - (int) (30.6001 * je);
		month = je - 1;
		if (month > 12) month = month - 12;
		year = jc - 4715;
		if (month > 2) year--;
		if (year <= 0) year--;
	 
		return new int[] {year, month, day};
	}
		
	public static void main(String args[]) 
	{
		System.out.println("Julian date for May 23, 1968 : "
				+ new Julian( new int[] {1968, 5, 23 } ).date);
		int results[] = fromJulian(new Julian(new int[] {1968, 5, 23 }).date);
		System.out.println("... back to calendar : " + results[0] + " "
	       + results[1] + " " + results[2]);
	       
		double todayJulian = new Julian().date;
		System.out.println("Julian date for today : " + todayJulian);
		results = fromJulian(todayJulian);
		System.out.println("... back to calendar : " + results[0] + " " + results[1]
	        + " " + results[2]);
	       
		double date1 = new Julian(new int[]{2005,1,1}).date;
		double date2 = new Julian(new int[]{2005,1,31}).date;    
		System.out.println("Between 2005-01-01 and 2005-01-31 : "
				+ (date2 - date1) + " days");
	 }
		
	public Julian()
	{
		this(Calendar.getInstance());
	}
	  
	public Julian(Calendar caldate)
	{
		this(new int[]{caldate.get(Calendar.YEAR), caldate.get(Calendar.MONTH)+1, 
				caldate.get(Calendar.DATE)});
	}
	 
	public Julian(int year, int month, int day)
	{
		int julianYear = year;
		if (year < 0) julianYear++;
		int julianMonth = month;
		if (month > 2) 
			julianMonth++;
		else 
		{
			julianYear--;
			julianMonth += 13;
		}
	   
		double julian = (java.lang.Math.floor(365.25 * julianYear)
				+ java.lang.Math.floor(30.6001*julianMonth) + day + 1720995.0);
		if (day + 31 * (month + 12 * year) >= JGREG) 
		{
			// change over to Gregorian calendar
			int ja = (int)(0.01 * julianYear);
			julian += 2 - ja + (0.25 * ja);
		}
		this.date=java.lang.Math.floor(julian);
	}
	 
	public Julian(int[] ymd) 
	{
		this(ymd[0],ymd[1],ymd[2]);
	}
}
