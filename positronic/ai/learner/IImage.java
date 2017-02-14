package positronic.ai.learner;


/**
 * <p>Title: IImage Interface</p>
 * <p>Copyright (c) 2004</p>
 * <p>Company: Positronic Software</p>
 * @author Kerry M. Soileau
 * @version 1.0
 */

public interface IImage
{
	double distance(IImage p1);
	IValue getValue();
	String toString();
}