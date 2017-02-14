package positronic.util.search.annealet.demos.worms;

import positronic.awt.geometry.EquilateralTriangle;
import positronic.awt.geometry.ImproperlyFormedPolygonException;
import positronic.awt.geometry.Point;
import positronic.util.search.annealet.IIngot;

public class Ingot extends EquilateralTriangle implements IIngot
{
	public static Point[] testPointSet=null;

	public static void main(String[] args)
	{
		try 
		{
			for(int i=0;i<1000;i++)
			{
				IIngot tri = new Ingot(
						new Point(2*Math.random()-1,2*Math.random()-1),
						new Point(2*Math.random()-1,2*Math.random()-1));
				System.out.println("\n"+tri);
				System.out.println("\n"+tri.evaluate());
				tri.mutate();
				System.out.println("\n"+tri);
				System.out.println("\n"+tri.evaluate());
				System.out.println("\n");
			}
		}
		catch (ImproperlyFormedPolygonException e) 
		{
			e.printStackTrace();
		}
	}
	
	public Ingot() throws ImproperlyFormedPolygonException
	{
		super(new Point(-1./Math.tan(Math.random()),-1./Math.tan(Math.random())),
				new Point(-1./Math.tan(Math.random()),-1./Math.tan(Math.random())));
	}
	
	public Ingot(EquilateralTriangle e) throws ImproperlyFormedPolygonException 
	{
		super(e);
	}
	
	public Ingot(Point p1, Point p2) throws ImproperlyFormedPolygonException 
	{
		super(p1, p2);
	}

	public void duplicate(IIngot incumbent)
	{
		double[] xs=((EquilateralTriangle)incumbent).getXpoints();
		double[] ys=((EquilateralTriangle)incumbent).getYpoints();
		double[] txs=super.getXpoints();
		double[] tys=super.getYpoints();
		for(int i=0;i<txs.length;i++)
		{
			txs[i]=xs[i];
			tys[i]=ys[i];
		}
	}
	
	public double evaluate() 
	{
		return super.inclusionScore(testPointSet);
	}

	/*public void mutate()
	{
		try 
		{
			Point p1=new Point(-1./Math.tan(Math.random()),-1./Math.tan(Math.random()));
			Point p2=new Point(-1./Math.tan(Math.random()),-1./Math.tan(Math.random()));
			IIngot newingot=new Ingot(p1,p2);
			this.duplicate(newingot);
		} 
		catch (ImproperlyFormedPolygonException e) 
		{
			e.printStackTrace();
		}
	}*/
	
	public void mutate()
	{
		double peri=this.perimeter()/10;
		try 
		{
			Point[] pts=this.getPoints();
			Point p1=new Point(pts[0].x+peri*(2*Math.random()-1),pts[0].y+peri*(2*Math.random()-1));
			Point p2=new Point(pts[1].x+peri*(2*Math.random()-1),pts[1].y+peri*(2*Math.random()-1));
			IIngot newingot=new Ingot(p1,p2);
			this.duplicate(newingot);
		} 
		catch (ImproperlyFormedPolygonException e) 
		{
			e.printStackTrace();
		}
	}

	public void show() 
	{
		System.out.println(this.toString());
	}
}
