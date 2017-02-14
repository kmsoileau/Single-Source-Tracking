package positronic.math;

import positronic.satisfiability.exceptions.NumberException;

/**
 * <p>Title: INumber interface</p>
 * <p>Description: This interface must be implemented by any 
 * implementation of the Number class.</p>
 * <p>Copyright (c) 2004-2005</p>
 * <p>Company: Positronic Software</p>
 * @author Kerry Michael Soileau
 * @version 1.01
 */

public interface INumber
{
  public boolean equals(Object anObject);
  public boolean getBit(int i) throws NumberException;
  public boolean[] getBitArray();
  public String getName();
  public int getSize();
  public void setBit(int i, boolean b) throws NumberException;
  public void setBitArray(boolean[] bitArray) throws NumberException;
  public void setName(String name);
  public void setOverflow(boolean overflow);
}