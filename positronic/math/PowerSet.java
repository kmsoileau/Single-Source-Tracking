package positronic.math;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Vector;
/**
 * An Iterator over the power set of a collection. The power set of a collection
 * is the set of all subsets of that collection.
 *
 * To use this class, one passes a collection to one of the constructors. The
 * PowerSet object produced is an Iterator, and one may use its hasNext and next
 * methods to produce all nonempty subsets of the given collection. Strictly
 * speaking, the power set of a collection includes the null or empty set, but
 * for practical reasons this class does not produce this set. Each application
 * of the next method produces an instance of the ArrayList class; this instance
 * contains a subset of the given collection.
 *
 * @author  Kerry Michael Soileau
 * <blockquote><pre>
 * ksoileau@yahoo.com
 * http://kerrysoileau.com/index.html
 * </pre></blockquote>
 * @version 1.2, 05/04/11
 * @see ArrayList
 * @see Collection
 * @see Iterator
 */
public class PowerSet implements Iterator<ArrayList<Object>>
{
  //Demo:
  public static void main(String[] args)
  {
    PowerSet powerSet1 = new PowerSet(new Object[]{"a","a'","b","b'"});
    System.out.println(powerSet1);
  }
  
  private Object[] array;
  private boolean[] membership;

  public PowerSet(ArrayList<?> a)
  {
    this(a.toArray());
  }
  
  public PowerSet(Collection<?> c)
  {
    this(c.toArray());
  }

  public PowerSet(Object[] array)
  {
    this.array=array;
    if(array!=null)
      this.membership=new boolean[this.array.length];
  }

  public PowerSet(Vector<?> a)
  {
    this(a.toArray());
  }

  /**
   * Returns <tt>true</tt> if the PowerSet has more subsets. (In other
   * words, returns <tt>true</tt> if <tt>next</tt> would return a subset
   * rather than throwing an exception.)
   *
   * @return <tt>true</tt> if the PowerSet has more subsets.
   */
  public boolean hasNext()
  {
    if(this.membership!=null)
    {
      for(int i=0;i<this.membership.length;i++)
        if(!this.membership[i])
          return true;
    }
    return false;
  }

  /**
   * Returns the next subset in the PowerSet.
   *
   * @return the next subset in the PowerSet.
   * @exception NoSuchElementException PowerSet has no more subsets.
   */
  public ArrayList<Object> next()
  {
    boolean ok=false;
    for(int i=0;i<this.membership.length;i++)
      if(!this.membership[i])
      {
        ok=true;
        break;
      }
    if(!ok)
      throw(new NoSuchElementException("The next method was called when no more objects remained."));
    else
    {
      int n=0;
      this.membership[0]=!this.membership[0];
      boolean carry=!this.membership[0];
      while(n+1<this.membership.length)
      {
        n++;
        if(carry)
        {
          this.membership[n]=!this.membership[n];
          carry=!this.membership[n];
        }
        else break;
      }
      ArrayList<Object> vec=new ArrayList<Object>();
      for(int i=0;i<this.membership.length;i++)
        if(this.membership[i])
          vec.add(this.array[i]);

      return vec;
    }
  }
  
  /**
   *
   * Not supported by this class.
   *
   * @exception UnsupportedOperationException because the <tt>remove</tt>
   *		  operation is not supported by this Iterator.
   */
  public void remove()
  {
    throw new UnsupportedOperationException(
      "The PowerSet class does not support the remove method.");
  }

  public String toString()
  {
  	PowerSet work=new PowerSet(this.array);
  	String ret="{\n";
  	while(work.hasNext())
      ret+=work.next()+"\n";
  	return ret+"}";
  }
}