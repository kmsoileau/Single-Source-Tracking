package positronic.awt.inside;

public class UnionOfConvexPolygons
{
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}
	
	public ConvexPolygon[] polygons;
	
	public UnionOfConvexPolygons(ConvexPolygon[] polygons)
	{
		this.polygons=new ConvexPolygon[polygons.length];
		for(int i=0;i<this.polygons.length;i++)
			this.polygons[i]=polygons[i];
	}
	
	public boolean contains(Point point)
	{
		for(ConvexPolygon cp : this.polygons)
			if(cp.contains(point))
				return true;
		
		return false;
	}
}
