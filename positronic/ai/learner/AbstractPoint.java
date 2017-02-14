package positronic.ai.learner;

import java.util.Iterator;

/**
 * <p>Title: AbstractPoint Object</p>
 * <p>Copyright (c) 2004</p>
 * <p>Company: Positronic Software</p>
 * @author Kerry M. Soileau
 * @version 1.0
 */

public abstract class AbstractPoint implements IPoint
{
  private IImage image;

  /**
  * Returns the <tt>IPoint</tt> object, in the collection traversed by the
  * <tt>Iterator</tt>, which is closest to <tt>this</tt>.
  */
  public IPoint consult(ILearner lrn)
  {
    Iterator<IPoint> it=lrn.iterator();
    if(it==null) return null;
    return this.nearestPoint(it);
  }

  /**
  * Removes <tt>this</tt> from a <tt>ILearner</tt> object, effectively
  * "forgetting" the training effect due to <tt>this</tt>.
  * @param lrn the <tt>ILearner</tt> object to be modified.
  */
  public boolean forget(ILearner lrn)
  {
    return lrn.remove(this);
  }

  public IImage getImage()
  {
    return image;
  }

  /**
  * Adds a <tt>IPoint</tt> object to the <tt>ILearner</tt> object,
  * effectively "remembering" that object.
  * @param lrn the <tt>ILearner</tt> object to be "informed."
  */

  public boolean learn(ILearner lrn)
  {
    return lrn.add(this);
  }

  /**
  * Returns the <tt>IPoint</tt> object, in the collection traversed by the
  * <tt>Iterator</tt>, which is closest to <tt>this</tt>.
  */
  public IPoint nearestPoint(Iterator<IPoint> it)
  {
    IPoint np=null;
    double leastDistance=Double.MAX_VALUE;
    while(it.hasNext())
    {
      IPoint currentPoint=(IPoint)(it.next());
      double distancePointToCurrent=this.distance(currentPoint);
      if(distancePointToCurrent<leastDistance)
      {
        np=currentPoint;
        leastDistance=distancePointToCurrent;
      }
    }
    return np;
  }

  public void setImage(IImage im)
  {
    this.image=im;
  }

  /**
  * The <tt>IPoint</tt> object in the <tt>ILearner</tt> object which is
  * closest to the <tt>IPoint</tt> parameter <tt>point</tt> is determined.
  * If the distance from its <tt>IImage</tt> member to the <tt>IImage</tt>
  * member of <tt>this</tt> is greater than <tt>tolerance</tt>, then
  * <tt>this</tt> is learned. If not, <tt>this</tt> is forgotten with
  * probability <code>1/quality-1</code>. This probability is chosen so that the
  * size of the <tt>ILearner</tt> object will reach equilibrium when the
  * <tt>ILearner</tt> object performs successfully with probability
  * <tt>quality</tt>.
  */
  public void train(ILearner lrn)
  {
    if(lrn.size()==0)
    {
      this.learn(lrn);
      //lrn.learn(this);
      return;
    }

    IPoint res=this.consult(lrn);

    if(this.getImage().distance(res.getImage())>lrn.getTolerance())
      //lrn.learn(this);
      this.learn(lrn);
    else
      if(Math.random()<=1./lrn.getQuality()-1.)
        //lrn.forget(res);
        ((AbstractPoint)res).forget(lrn);
  }
}