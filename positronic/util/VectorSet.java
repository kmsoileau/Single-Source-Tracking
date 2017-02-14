package positronic.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;

/**
 * <p>Title: VectorSet</p>
 * <p>Description: Works just like java.util.Vector, except it will refuse to
 * add an element if it is equal to an element already appearing in the
 * VectorSet.</p>
 * <p>Copyright (c) 2003</p>
 * <p>Institution: NASA Johnson Space Center</p>
 * @author Kerry Michael Soileau
 * @version 1.3
 */

public class VectorSet<E> extends Vector<E> implements Set<E>
{
  private static final long serialVersionUID = 1L;
  
  //Simple demo --- may be deleted at will.
  public static void main(String[] args)
  {
    VectorSet<String> vectorSet1 = new VectorSet<String>();
    vectorSet1.add("Steve");
    vectorSet1.add("Kerry");
    vectorSet1.add("Julie");
    vectorSet1.add("Donna");
    vectorSet1.add("Kerry");
    vectorSet1.add("John");
    vectorSet1.add("Steve");
    vectorSet1.add("Kerry");
    vectorSet1.add(""+new Integer(32));
    vectorSet1.add(""+new Integer(33));
    vectorSet1.add("Donna");
    for(int i=0;i<vectorSet1.size();i++)
      System.out.println(vectorSet1.get(i));
    vectorSet1.add("Goob");
    ArrayList<String> abl=new ArrayList<String>(vectorSet1);
    vectorSet1.addAll(abl);
    System.out.println("================");
    for(int i=0;i<vectorSet1.size();i++)
      System.out.println(vectorSet1.get(i));
  }

/**
  * Constructs a new, empty VectorSet.
  */
  public VectorSet()
  {
  }

/**
  * Constructs a new set containing the elements in the specified
  * collection.
  *
  * @param c The elements that will comprise the new set.
  */
  public VectorSet(Collection<? extends E> c)
  {
    addAll(c);
  }

/**
  * Adds the specified element to this set if it is not already present.
  *
  * @param o element to be added to this set.
  * @return <tt>true</tt> if the set did not already contain the specified
  *         element.
  */
  public boolean add(E o)
  {
    for(int i=0;i<this.elementCount;i++)
    {
      Object obj=this.get(i);
      if(obj.equals(o))
        return false;
    }
    super.add(o);
    return true;
  }

  /**
	  * Adds all of the elements in the specified collection to this set.
	  *
	  * @param c elements to be added
	  * @return <tt>true</tt> if this set changed as a result of the call.
	  */
	
  public boolean addAll(Collection<? extends E> c)
	{
  	boolean changed=false;
		if (c.size() > 0)
    {
			Iterator<? extends E> it=c.iterator();
      while(it.hasNext())
      {
        E nextobj=it.next();
        boolean res=this.add(nextobj);
        if(res) changed=true;
      }
    }
    return changed;
	}

  /**
  * Adds the specified element to this set if it is not already present.
  *
  * @param o element to be added to this set.
  */
  public void addElement(E o)
  {
    for(int i=0;i<this.elementCount;i++)
    	if(this.get(i).equals(o))
        return;
    super.add(o);
  }
}