package positronic.awt.geometry;

public interface IEnclosure 
{
	Point closestPoint(Point[] pts);
	boolean containsAll(Point[] pts);
	Point[] getPoints();
	double[] getXpoints();
	double[] getYpoints();
	double leastDistance(Point p);
	double measure();
}
