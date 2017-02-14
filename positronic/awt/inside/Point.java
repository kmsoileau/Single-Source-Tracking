package positronic.awt.inside;

public class Point extends positronic.awt.Point
{
	public Point(double x, double y)
	{
		super(x,y);
	}

	public boolean isToTheLeftOf(positronic.awt.inside.Edge edge)
	{
		return (edge.finish.x-edge.start.x)*this.y-(edge.finish.y-edge.start.y)*this.x>=edge.discriminant;
	}
}

