package positronic.awt.geometry;

import positronic.math.statistics.Bins;

/**
 * @author Kerry Soileau
 *
 */
public class StandardEquilateralTriangle extends EquilateralTriangle
{
	public static boolean isInside(double x, double y)
	{
		if(y<0.)
			return false;
		double q = Math.sqrt(3.);
		if(y<=q*x && y<=q*(1.-x))
			return true;
		return false;
	}
	
	public static void main(String[] args)
	{
		/*for(int i=0;i<200;i++)
		{
			Point p=randomPoint();
			System.out.println(p.x+"\t"+p.y);
		}*/
		double[] p=new double[100000];
		for(int i=0;i<100000;i++)
			p[i] = randomInteriorPolygonalPath(10).length();
		
		Bins b=new Bins(100,0.,7.,p);
		System.out.println(b.excelOut());
	}
	
	
	/**
	 * @return Returns a uniformly distributed random point from the inside of
	 * the StandardEquilateralTriangle. That is, the probability of selecting a point
	 * in a subset of area A is directly proportional to the area of A.
	 */
	public static Point randomPoint()
	{
		double u1=Math.random();
		double u2=Math.random();
		double sqrt3=Math.sqrt(3.);
		double y=1/2.*sqrt3*(1.-Math.sqrt(1.-u2));
		double x=y/sqrt3+(1.-2.*y/sqrt3)*u1;
		return new Point(x,y);
	}
	
	public static PolygonalPath randomInteriorPolygonalPath(int points)
	{
		Point[] p=new Point[points];
		for(int i=0;i<points;i++)
			p[i]=randomPoint();
		return new PolygonalPath(p);
	}
	
	public StandardEquilateralTriangle() throws ImproperlyFormedPolygonException
	{
		super(new Point(0.,0.),new Point(1.,0.));
	}
}
