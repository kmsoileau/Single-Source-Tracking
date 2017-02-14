package positronic.awt.graphics;

import java.awt.Color;

import javax.swing.JFrame;

public class Graphics 
{
	private JFrame frame;
	private Controller c;
	private double startX=0.;
	private double startY=0.;
	
	public Graphics()
	{
		this("Graphics");
	}
	
	public Graphics(int width, int height)
	{
		this("Graphics",width,height);
	}
	
	public Graphics(String name)
	{
		this(name,400,300);
	}
	
	public Graphics(String name, int width, int height) 
	{
		frame = new JFrame(name);
        frame.setSize(width,height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c=new Controller();
        c.setModel(new Model(c));
        c.setView(new View(frame.getWidth(),frame.getHeight()));
	}
	
	public void clear()
	{
		c.getModel().clearSegments();
	}
	
	public void draw(double x2, double y2)
	{
		draw(startX,startY,x2,y2);
	}
	
	public void draw(double x1, double y1, double x2, double y2)
	{
		c.getModel().addSegment(new Segment(new Point(x1,y1),new Point(x2,y2),this.c.getView().getPen(),this.c.getView().getStroke()));
		this.move(x2,y2);
	}
	
	public void frame() 
	{
		c.getView().frame();
	}

	public void locate(int i, int j, int k, int l) 
	{
		c.getView().locate(i,j,k,l);
	}

	public void move(double x2, double y2)
	{
		startX=x2;
		startY=y2;
	}

	public void refresh()
	{
		c.getView().repaint();
	}

	public void scale(double d, double e, double f, double g) 
	{
		c.getView().scale(d,e,f,g);
	}

	public void setPen(Color c)
	{
		this.c.getView().setPen(c);
	}
	
	public void setStroke(double d) 
	{
		c.getView().setStroke(d);
	}
	
	public void show() 
	{
		this.frame.getContentPane().add(c.getView());
        this.frame.setVisible(true);
	}
}
