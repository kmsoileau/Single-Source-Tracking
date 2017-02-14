package positronic.awt.inside;


public class ConvexPolygon
{
	public static void main(String[] args)
	{
		ConvexPolygon cp=new ConvexPolygon(
				new Edge[]{
						new Edge(new Point(0.,0.),new Point(.5,.5)),
						new Edge(new Point(.5,.5),new Point(1.,0.)),
						new Edge(new Point(1.,0.),new Point(2.,1.)),
						new Edge(new Point(2.,1.),new Point(-1.,2.)),
						new Edge(new Point(-1.,2.),new Point(0.,0.))
						});
		for(double x=-1.;x<3.;x+=.05)
			for(double y=-1.;y<3.;y+=.05)
			{
				Point p=new Point(x,y);
				if(cp.contains(p))
					System.out.println(x+"\t"+y);
			}
	}
	
	public Edge[] edges;
	
	public ConvexPolygon(Edge[] edges)
	{
		this.edges=new Edge[edges.length];
		for(int i=0;i<edges.length;i++)
			this.edges[i]=edges[i];
	}
	
	/**
	 * Here "contains" lies within or on the boundary of the ConvexPolygon.
	 * @param point This is the point being tested for inclusion.
	 * @return boolean
	 */
	public boolean contains(Point point)
	{
		for(Edge e : this.edges)
			if(!point.isToTheLeftOf(e))
				return false;
		
		return true;
	}
}

