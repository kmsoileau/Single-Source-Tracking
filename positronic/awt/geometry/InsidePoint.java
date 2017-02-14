package positronic.awt.geometry;

public class InsidePoint extends Point
{
	public static void main(String[] args)
	{
		LineSegment[] edges=
				new LineSegment[]{
						new LineSegment(new InsidePoint(0.,0.),new InsidePoint(.5,.5)),
						new LineSegment(new InsidePoint(.5,.5),new InsidePoint(1.,0.)),
						new LineSegment(new InsidePoint(1.,0.),new InsidePoint(2.,1.)),
						new LineSegment(new InsidePoint(2.,1.),new InsidePoint(-1.,2.)),
						new LineSegment(new InsidePoint(-1.,2.),new InsidePoint(0.,0.))
						};
		for(double x=-1.;x<3.;x+=.1)
			for(double y=-1.;y<3.;y+=.1)
			{
				InsidePoint p=new InsidePoint(x,y);
				System.out.println(p.x+"\t"+p.y+"\t"+p.index(edges));
			}
	}
	
	public InsidePoint(double x, double y)
	{
		super(x,y);
	}

	public int index(LineSegment[] LineSegments)
	{
		int ret=0;
		for(int i=0;i<LineSegments.length;i++)
		{
			if(this.isToTheLeftOf(LineSegments[i]))
				ret=2*ret+1;
			else
				ret=2*ret;
		}
		return ret;
	}
	
	public boolean isToTheLeftOf(LineSegment LineSegment)
	{
		return (LineSegment.getFinish().x-LineSegment.getStart().x)*this.y-(LineSegment.getFinish().y-LineSegment.getStart().y)*this.x>=LineSegment.getDiscriminant();
	}
}

