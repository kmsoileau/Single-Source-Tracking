package positronic.awt.geometry;

public interface IPoint 
{
	double[] coordinates();
	double distance(Point p);
	boolean equals(Object o);
	double getX();
	double getY();
	String toString();
}
