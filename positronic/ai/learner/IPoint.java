package positronic.ai.learner;

/**
 * <p>Title: IPoint Interface</p>
 * <p>Copyright (c) 2004</p>
 * <p>Company: Positronic Software</p>
 * @author Kerry M. Soileau
 * @version 1.0
 */

public interface IPoint
{
  IPoint consult(ILearner lrn);
  double distance(IPoint a);
  IImage getImage();
  void setImage(IImage im);
  String toString();
  void train(ILearner lrn);
}