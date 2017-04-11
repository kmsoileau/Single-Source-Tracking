package trackingsat;

public class Vector
{
	double x;
	
	double y;
	double z;
	public Vector(double x, double y, double z)
	{
		super();
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public double dot(Vector a)
	{
		return a.x*this.x+a.y*this.y+a.z*this.z;
	}
	
	public double norm()
	{
		return Math.sqrt(this.dot(this));
	}

	public String toString()
	{
		return "Vector [x=" + x + ", y=" + y + ", z=" + z + "]";
	}
}
