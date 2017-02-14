package positronic.awt.graphics;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Stroke;

public class Segment 
{
	private Point p1;
	private Point p2;
	private Color penColor;
	private Stroke stroke;

	public Segment(Point p1, Point p2) 
	{
		this(p1,p2,Color.black);
	}

	public Segment(Point p1, Point p2, Color p) 
	{
		this(p1,p2,p,new BasicStroke());
	}
	
	public Segment(Point p1, Point p2, Color p, Stroke s) 
	{
		this.p1 = p1;
		this.p2 = p2;
		this.penColor=p;
		this.stroke=s;
	}
	
	public Point getP1() 
	{
		return p1;
	}

	public Point getP2() 
	{
		return p2;
	}

	public Color getPenColor() 
	{
		return penColor;
	}

	public Stroke getStroke() 
	{
		return this.stroke;
	}

	public void setP1(Point p1)
	{
		this.p1 = p1;
	}

	public void setP2(Point p2) 
	{
		this.p2 = p2;
	}
	
	public void setPenColor(Color penColor) 
	{
		this.penColor = penColor;
	}
	
	public void setStroke(Stroke stroke) 
	{
		this.stroke = stroke;
	}

	public String toString()
	{
		return "$"+p1+","+p2+"]$"+penColor;
	}
}
