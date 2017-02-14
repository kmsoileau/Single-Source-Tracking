package positronic.awt.geometry;

public interface IPolygon 
{
	boolean contains(double x, double y);
	boolean contains(IPoint p);
	int getNumberOfVertices();
	double[] getXpoints();
	double[] getYpoints();
	void setXpoints(double[] xpoints);
	void setYpoints(double[] ypoints);
	String toString();
}
