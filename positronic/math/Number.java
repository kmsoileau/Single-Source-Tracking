package positronic.math;

import positronic.satisfiability.exceptions.NumberException;


/**
 * <p>Title: TBS</p>
 * <p>Description: TBS</p>
 * <p>Copyright (c) 2004</p>
 * <p>Company: Positronic Software</p>
 * @author Kerry Michael Soileau
 * @version 1.0
 */

public class Number implements INumber
{
  public static void main(String[] args) throws NumberException
  {
    Number number1 = new Number(2401l);
    Number number2 = new Number(number1,12);
    System.out.println(number1.toString());
    System.out.println(number2.toString());
  }
  
  private boolean[] bitArray;
  private String name;

  private boolean overflow;

  public Number(boolean[] bitArray, boolean overflow) throws NumberException
  {
    this("",bitArray,overflow);
    this.setName(super.toString());
  }

  public Number(long n) throws NumberException
  {
  	this("",n);
    this.setName(super.toString());
  }

  public Number(Number n, int padsize) throws NumberException
  {
    this("",n,padsize);
    this.setName(super.toString());
  }

  public Number(String name, boolean[] bitArray, boolean overflow) throws NumberException
  {
  	if(bitArray==null)
  		throw new NumberException("A null bitArray was passed to a constructor.");
    this.setBitArray(bitArray);
    this.setOverflow(overflow);
    this.setName(name);
  }

  public Number(String name, long n) throws NumberException
  {
  	if(n<0)
  		throw new NumberException("A negative long was passed to a constructor.");
    
    if(n==0)
    {
      this.setBitArray(new boolean[1]);
      this.setOverflow(false);
      this.setName(name);
    }
    if(n>0)
    {
      int size=(int)(Math.log(n)/Math.log(2))+1;
      this.setBitArray(new boolean[size]);
      this.setOverflow(false);
      int count=0;
      long current=n;
      while(current>0)
      {
        long bit=current-2*(long)(current/2);
        if(bit==1)
          this.setBit(count,true);
        else
          this.setBit(count,false);
        current=(long)(current/2);
        count++;
      }
      this.setName(name);
    }
  }

  public Number(String name, Number n, int padsize) throws NumberException
  {
  	if(n==null)
  		throw new NumberException("A null Number was passed to a constructor.");
  	if(padsize<0)
  		throw new NumberException("A negative int was passed to a constructor.");
    if(n.getSize()<padsize)
    {
      this.setBitArray(new boolean[padsize]);
      for(int i=0;i<n.getSize();i++)
        this.setBit(i,n.getBit(i));
    }
    else
    {
      this.setBitArray(new boolean[n.getSize()]);
      for(int i=0;i<n.getSize();i++)
        this.setBit(i,n.getBit(i));
    }
    this.setName(name);
  }

  public boolean equals(Number n)
  {
  	if(n==null)
  		return false; //this is never equal to null.
    if(!(n instanceof Number))
      return false;
    else
      return(this.getName().compareTo(n.getName())==0);
  }

  public boolean getBit(int i) throws NumberException
  {
  	if(i<0 || i>this.getSize()-1)
  		throw new NumberException("Attempted to index out of range in method getBit.");
    return this.getBitArray()[i];
  }

  public boolean[] getBitArray()
  {
    return bitArray;
  }

  public String getName()
  {
    return name;
  }

  public int getSize()
  {
    return this.bitArray.length;
  }

  public boolean isOverflow()
  {
    return overflow;
  }

  public void setBit(int i, boolean b) throws NumberException
  {
  	if(i<0 || i>this.getSize()-1)
  		throw new NumberException("Attempted to index out of range in method setBit.");
    this.getBitArray()[i]=b;
  }

  public void setBitArray(boolean[] bitArray) throws NumberException
  {
  	if(bitArray==null)
  		throw new NumberException("A null boolean[] was passed to a constructor.");
    this.bitArray = bitArray;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public void setOverflow(boolean overflow)
  {
    this.overflow = overflow;
  }

  public String toString()
  {
    String res="<";
    res+=(name+"=");
    for(int i=this.getSize()-1;i>=0;i--)
    {
      try
			{
				if(this.getBit(i))
				  res+="1";
				else
				  res+="0";
			} catch (NumberException e)
			{
				e.printStackTrace();
			}
    }
    res+=">";
    return res;
  }
}