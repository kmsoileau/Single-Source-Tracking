package positronic.ai.learner;

import java.util.Iterator;

/**
 * <p>Title: ILearner Interface</p>
 * <p>Copyright (c) 2005</p>
 * <p>Company: Positronic Software</p>
 * @author Kerry M. Soileau
 * @version 1.0
 */

public interface ILearner
{
  boolean add(IPoint ip);
  double getQuality();
  double getTolerance();
  Iterator<IPoint> iterator();
  boolean remove(IPoint ip);
  int size();
}