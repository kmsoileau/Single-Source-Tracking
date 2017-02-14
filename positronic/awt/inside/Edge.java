package positronic.awt.inside;


public class Edge extends positronic.awt.Edge
{
	public double discriminant;
	
	public Edge(Point start, Point finish)
	{
		super(start,finish);
		this.discriminant=this.finish.x*this.start.y-this.finish.y*this.start.x;
	}
}
