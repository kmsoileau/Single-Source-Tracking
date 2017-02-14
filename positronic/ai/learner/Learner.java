package positronic.ai.learner;

import java.util.HashSet;
import java.util.Iterator;


/**
 * <p>Title: Learner Class</p>
 * <p>Description: A Learner object will learn any mapping from any metric space
 * into another metric space. Its probability of success and error tolerance can
 * be specified at the time of its construction</p>
 * <p>Copyright (c) 2004</p>
 * <p>Company: Positronic Software</p>
 * @author Kerry M. Soileau
 * @version 1.0
 */

/**
 *  January 26,2014
 * 	-	Sorted the methods alphabetically
 * 	-	Cleared some commented-out text.
 */

public class Learner extends HashSet<IPoint> implements ILearner,java.io.Serializable
{
	private static final long serialVersionUID = -7946804331220775391L;

	/**
  * The positive number which defines the desired probability of successful
  * performance by the <tt>Learner</tt> object. Note: in practice, there is no
  * point in specifying quality values of less than or equal to 0.5, or greater
  * than or equal to 1.0. Specifying a positive value less than 0.5 is
  * equivalent to specifying 0.5, and specifying a value greater than 1.0 is
  * practically equivalent to specifying 1.0.
  */
  private double quality;

  /**
  * The positive number defining successful performance by the learner object.
  * That is, if the distance between the correct answer and the learner's answer
  * is not greater than <code>tolerance</code>, then the learner's performance
  * in this case is considered successful. Otherwise, its performance is
  * considered unsuccessful.
  */
  private double tolerance;

  /**
  * Constructs a new instance of the <tt>Learner</tt> class with
  * <tt>tolerance=.01</tt> and <tt>quality=.99</tt>.
  */
  public Learner()
  {
    this(.01,.99);
  }

  /**
  * Constructs a new instance of the <tt>Learner</tt> class with specified
  * values of <tt>tolerance</tt> and <tt>quality</tt>.
  */
  public Learner(double tolerance, double quality)
  {
    super();
    this.tolerance=tolerance;
    this.quality=quality;
  }

  /**
  * Constructs a new instance of the <tt>Learner</tt> class with specified
  * values of <tt>tolerance</tt> and <tt>quality</tt>, initializing the
  * underlying <tt>HashSet</tt> using a specified <tt>Collection</tt> object.
  */
  public Learner(HashSet<IPoint> c, double tolerance, double quality)
  {
    super(c);
    this.tolerance=tolerance;
    this.quality=quality;
  }

  public boolean add(IPoint ip)
  {
    return super.add(ip);
  }

  /**
  * Dumps the underlying HashSet to <tt>System.out</tt>.
  */
  public void dump()
  {
    Iterator<?> it=super.iterator();
    while(it.hasNext())
      System.out.println(((IPoint)(it.next())).toString());
  }

  public double getQuality()
  {
    return this.quality;
  }

  public double getTolerance()
  {
    return this.tolerance;
  }

  public boolean remove(IPoint ip)
  {
    return super.remove(ip);
  }
}