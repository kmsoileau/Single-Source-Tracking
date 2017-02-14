package positronic.util.search.jiglet.demos.regions;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Set;

import javax.swing.JPanel;

import positronic.awt.geometry.ImproperlyFormedPolygonException;
import positronic.awt.geometry.Point;
import positronic.awt.geometry.Polygons;
import positronic.awt.geometry.PositronicPolygon;
import positronic.awt.plotting.RunnablePlotJPanel;

public class RegionsPositronicPolygonJiglet extends PositronicPolygonJiglet
{
	public static void main(String[] args)
	{
		RegionsPositronicPolygonJiglet hcs=new RegionsPositronicPolygonJiglet();
		hcs.setTrials(100000);
		hcs.start();
	}
	
	@SuppressWarnings("unused")
	private JPanel jPanel;
	private PositronicPolygon[] lastGoodVertex;
	
	protected PositronicPolygon[] explore()
	{
		PositronicPolygon[] ret=new PositronicPolygon[4];
		
		boolean keeptrying=true;
		
		while(keeptrying)
		{
			keeptrying=false;
			try 
			{
				ret[0]=new PositronicPolygon(
						new double[]{Math.random(),Math.random(),Math.random()},
						new double[]{Math.random(),Math.random(),Math.random()});
			}
			catch (ImproperlyFormedPolygonException e1) 
			{
				keeptrying=true;
			}
		}
		
		keeptrying=true;
		while(keeptrying)
		{
			keeptrying=false;
			try 
			{
				ret[1]=new PositronicPolygon(
						new double[]{Math.random(),Math.random(),Math.random(),Math.random()},
						new double[]{Math.random(),Math.random(),Math.random(),Math.random()});
			}
			catch (ImproperlyFormedPolygonException e1) 
			{
				keeptrying=true;
			}
		}
		
		keeptrying=true;
		while(keeptrying)
		{
			keeptrying=false;
			try 
			{
				ret[2]=new PositronicPolygon(
						new double[]{Math.random(),Math.random(),Math.random(),Math.random()},
						new double[]{Math.random(),Math.random(),Math.random(),Math.random()});
			}
			catch (ImproperlyFormedPolygonException e1) 
			{
				keeptrying=true;
			}
		}
		
		keeptrying=true;
		while(keeptrying)
		{
			keeptrying=false;
			try 
			{
				ret[3]=new PositronicPolygon(
						new double[]{Math.random(),Math.random(),Math.random(),Math.random()},
						new double[]{Math.random(),Math.random(),Math.random(),Math.random()});
			}
			catch (ImproperlyFormedPolygonException e1) 
			{
				keeptrying=true;
			}
		}
		
		Polygons ppp=new Polygons(ret);
		Set<Point> edgeCrossings=ppp.edgeIntersections();
		System.out.println(edgeCrossings);
		
		return ret;
	}
	
	protected void init()
	{
		this.jPanel = new RunnablePlotJPanel(1000)
		{
			private static final long serialVersionUID = -6351494134783104682L;

			public void update(Graphics g)
			{
				this.setGraphics2D(g);
				this.locate(10,10,170,70);
				this.scale(0.,7.,-1.,1.);
				this.pen(Color.magenta);
				this.axes(.2,.2,0.,0.,1,1);
				this.pen(Color.green);
				this.move(0.,0.);
				for(double x=0.;x<7;x+=.1)
					this.draw(x,Math.sin(x));
				this.pen(Color.blue);
				this.move(0.,0.);
				for(double x=0.;x<7;x+=.1)
					this.draw(x,Math.cos(x));
				this.pen(Color.black);
				this.frame();
			}
		};
		super.currentVertex=explore();
	}

	protected boolean perTrial()
	{
		if(lastGoodVertex==null)
			lastGoodVertex=super.currentVertex;
		if(lastGoodVertex!=super.currentVertex)
		{
			lastGoodVertex=super.currentVertex;
			System.out.print("ListLinePlot[{");
			//for(PositronicPolygon polygon : lastGoodVertex)
			for(int i=0;i<lastGoodVertex.length-1;i++)
				System.out.println(lastGoodVertex[i]+",");
			System.out.println(lastGoodVertex[lastGoodVertex.length-1]);
			System.out.println("}$");
			/*
			ListLinePlot[{{{1, 2}, {3, 4}, {3, 1}, {1, 2}}, {{-1, 2}, {-3, 
			    4}, {-3, 1}, {-1, 2}},
			  {{10, 2}, {-3, 4}, {-3, 1}, {10, 2}},
			  {{-1, -2}, {-3, -4}, {-3, -1}, {-1, -2}}}]
			  */
			System.out.println(RegionsPositronicPolygonArray.evaluate(lastGoodVertex));
		}
		
		return true;
	}

	protected void wrapup()
	{
		System.out.println("Finished!");
	}
}
