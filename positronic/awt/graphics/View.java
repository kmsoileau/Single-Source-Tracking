package positronic.awt.graphics;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.geom.Line2D;

import javax.swing.JPanel;

public class View extends JPanel
{
	private static final long serialVersionUID = -7661576751727013802L;
	
	private double leftX;
	private double rightX;
	private double bottomY;
	private double topY;
	
	private int pleftX;
	private int prightX;
	private int pbottomY;
	private int ptopY;
	
	private Controller c;

	private Color penColor=Color.black;
	private Stroke stroke=new BasicStroke();
	
	public View(int width, int height)
    {
    	super.setSize(width, height);
    }

	public Point computeScaledPoint(Point p) 
	{
		double px=(p.getX()-this.leftX)/(this.rightX-this.leftX)*(this.prightX-this.pleftX)+this.pleftX;
		double py=(this.topY-p.getY())/(this.topY-this.bottomY)*(-this.ptopY+this.pbottomY)+this.ptopY;
		return new Point(px,py);
	}

	public void frame()
    {
    	c.getModel().addSegment(new Segment(new Point(leftX,bottomY),new Point(rightX,bottomY),this.c.getView().getPen(),this.c.getView().getStroke()));
    	c.getModel().addSegment(new Segment(new Point(rightX,bottomY),new Point(rightX,topY),this.c.getView().getPen(),this.c.getView().getStroke()));
    	c.getModel().addSegment(new Segment(new Point(rightX,topY),new Point(leftX,topY),this.c.getView().getPen(),this.c.getView().getStroke()));
    	c.getModel().addSegment(new Segment(new Point(leftX,topY),new Point(leftX,bottomY),this.c.getView().getPen(),this.c.getView().getStroke()));
    }

	public Controller getController() 
	{
		return c;
	}
	
	public Color getPen() 
    {
		return penColor; 
	}

	public Stroke getStroke() 
	{
		return this.stroke;
	}

	public void locate(int pleftX,int ptopY,int prightX,int pbottomY)
	{
		this.pleftX=pleftX;
		this.pbottomY=pbottomY;
		this.prightX=prightX;
		this.ptopY=ptopY;
	}
    
    public void paint(Graphics g) 
	{
	    Graphics2D g2 = (Graphics2D) g;
	    g2.setPaint(getPen());
	    g2.setStroke(this.stroke);
	    
	    for(Segment s : c.getModel().getSegments())
		{
			Point scaled1=this.computeScaledPoint(s.getP1());
			Point scaled2=this.computeScaledPoint(s.getP2());
			g2.setColor(s.getPenColor());
			g2.setStroke(s.getStroke());
			g2.draw(new Line2D.Double(scaled1.getX(), scaled1.getY(), scaled2.getX(), scaled2.getY()));
		}
	  }

	public void scale(double leftX,double rightX,double bottomY,double topY)
	{
		this.leftX=leftX;
		this.bottomY=bottomY;
		this.rightX=rightX;
		this.topY=topY;
	}
    
    public void setController(Controller c) 
	{
		this.c = c;
	}
    
    public void setPen(Color color) 
	{
		penColor=color;
	}

	public void setStroke(double d) 
	{
		this.stroke=new BasicStroke((float)d);
	}
}