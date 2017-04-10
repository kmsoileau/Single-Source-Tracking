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
	
	public String toString()
	{
		return "Vector [x=" + x + ", y=" + y + ", z=" + z + "]";
	}
}
