package positronic.math;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JFrame;

import positronic.awt.plotting.AbstractPlotPanel;

public class PolygonalFunction
{
	public static PolygonalFunction add(PolygonalFunction p, PolygonalFunction q)
	{
		PolygonalFunction ret=new PolygonalFunction();
		ret.setLeftDefault(p.getLeftDefault()+q.getLeftDefault());
		ret.setRightDefault(p.getRightDefault()+q.getRightDefault());
		
		for(int i=0;i<p.getX().size();i++)
		{
			double xval=p.getX().get(i).doubleValue();
			ret.addPoint(xval,p.getY().get(i).doubleValue()+q.call(xval));
		}
		for(int i=0;i<q.getX().size();i++)
		{
			double xval=q.getX().get(i).doubleValue();
			ret.addPoint(xval,q.getY().get(i).doubleValue()+p.call(xval));
		}
		return ret;
	}
	
	public static void main(String[] args)
	{
		PolygonalFunction pp=new PolygonalFunction();
		for(double x=-5.;x<5.;x+=.01)
			pp.addPoint(x,Math.exp(1.8-x-x*x));
		
		
		PolygonalFunctionPlotterPanel plot=new PolygonalFunctionPlotterPanel();
		
		plot.setPolygonalFunction(pp);
		JFrame j=new JFrame("Polygonal Function Demo");
		j.setSize(600,600);
		j.add(plot);
		j.setVisible(true);
		
		for(double x=0.;x<=10.;x+=.1)
		{
			System.out.println(x+"\t"+pp.call(x));
		}
		System.out.println(pp.x);
		double firstX=pp.x.get(pp.nextPoint(Double.NEGATIVE_INFINITY));
		double lastX=pp.x.get(pp.previousPoint(Double.POSITIVE_INFINITY));
		double secondX=pp.x.get(pp.nextPoint(firstX));
		double nextToLastX=pp.x.get(pp.previousPoint(lastX));
		
		System.out.println("first X is "+firstX);
		System.out.println("second X is "+secondX);
		System.out.println("next to last X is "+nextToLastX);
		System.out.println("last X is "+lastX);
		double firstIntegral=.5*(pp.call(firstX)+pp.call(secondX))*(secondX-firstX);
		System.out.println("firstIntegral is "+firstIntegral);
		System.out.println("firstIntegral is "+pp.integrate(firstX,secondX));
	}
	
	public static PolygonalFunction mergemax(PolygonalFunction p, PolygonalFunction q)
	{
		PolygonalFunction ret=new PolygonalFunction();
		ret.setLeftDefault(Math.max(p.getLeftDefault(),q.getLeftDefault()));
		ret.setRightDefault(Math.max(p.getRightDefault(),q.getRightDefault()));
		
		for(int i=0;i<p.getX().size();i++)
		{
			double xval=p.getX().get(i).doubleValue();
			ret.addPoint(xval,Math.max(p.getY().get(i).doubleValue(),q.call(xval)));
		}
		for(int i=0;i<q.getX().size();i++)
		{
			double xval=q.getX().get(i).doubleValue();
			ret.addPoint(xval,Math.max(q.getY().get(i).doubleValue(),p.call(xval)));
		}
		return ret;
	}
	
	public static PolygonalFunction mergemin(PolygonalFunction p, PolygonalFunction q)
	{
		PolygonalFunction ret=new PolygonalFunction();
		ret.setLeftDefault(Math.min(p.getLeftDefault(),q.getLeftDefault()));
		ret.setRightDefault(Math.min(p.getRightDefault(),q.getRightDefault()));
		
		for(int i=0;i<p.getX().size();i++)
		{
			double xval=p.getX().get(i).doubleValue();
			ret.addPoint(xval,Math.min(p.getY().get(i).doubleValue(),q.call(xval)));
		}
		for(int i=0;i<q.getX().size();i++)
		{
			double xval=q.getX().get(i).doubleValue();
			ret.addPoint(xval,Math.min(q.getY().get(i).doubleValue(),p.call(xval)));
		}
		return ret;
	}
	
	public static PolygonalFunction scale(double c, PolygonalFunction p)
	{
		PolygonalFunction ret=new PolygonalFunction();
		ret.setLeftDefault(c*p.getLeftDefault());
		ret.setRightDefault(c*p.getRightDefault());
		
		for(int i=0;i<p.getX().size();i++)
		{
			double xval=p.getX().get(i).doubleValue();
			ret.addPoint(xval,c*p.getY().get(i).doubleValue());
		}
		return ret;
	}
	
	/*public static void main(String[] args)
	{
		
		PolygonalFunction pp=new PolygonalFunction();
		pp.addPoint(1./10,0.);
		pp.addPoint(1./10,-3./10);
		pp.addPoint(3./10,-3./10);
		pp.addPoint(3./10,0.);
		
		pp.addPoint(5./10,0.);
		pp.addPoint(5./10,4./10);
		pp.addPoint(9./10,4./10);
		pp.addPoint(9./10,0.);
		
		PolygonalFunction pp3=PolygonalFunction.scale(.1,pp);
		JFrame j=new JFrame("Kerry");
		j.setSize(600,600);
		j.setVisible(true);
		PolygonalFunctionPlotterPanel plot=new PolygonalFunctionPlotterPanel();
		j.add(plot);
		plot.setPolygonalFunction(pp3);
		
		for(double x=0.;x<=10.;x+=.1)
		{
			System.out.println(x+"\t"+pp3.call(x));
		}
	}*/
	
	public static PolygonalFunction subtract(PolygonalFunction p, PolygonalFunction q)
	{
		return PolygonalFunction.add(p, PolygonalFunction.scale(-1d,q));
	}
	
	public static PolygonalFunction translate(PolygonalFunction p, double a)
	{
		PolygonalFunction ret=new PolygonalFunction();
		ret.setLeftDefault(p.getLeftDefault());
		ret.setRightDefault(p.getRightDefault());
		for(int i=0;i<p.getX().size();i++)
		{
			double xval=p.getX().get(i).doubleValue();
			ret.addPoint(xval+a,p.getY().get(i).doubleValue());
		}
		return ret;
	}
	
	private double leftDefault;
	
	private double rightDefault;
	
	private ArrayList<Double> x;
	private ArrayList<Double> y;
	public PolygonalFunction()
	{
		this.setLeftDefault(0d);
		this.setRightDefault(0d);
		x=new ArrayList<Double>();
		y=new ArrayList<Double>();
	}
	public void addPoint(double xval, double yval)
	{
		int place=alreadyMapped(xval);
		if(place!=-1)
		{
			y.set(place, new Double(yval));
			return;
		}
		for(int i=0;i<x.size();i++)
		{
			if(xval<x.get(i).doubleValue())
			{
				x.add(i,new Double(xval));
				y.add(i,new Double(yval));
				return;
			}
		}
		x.add(new Double(xval));
		y.add(new Double(yval));
	}
	public int alreadyMapped(double xval)
	{
		for(int i=0;i<x.size();i++)
			if(xval==x.get(i).doubleValue())
				return i;
		return -1;
	}
	
	public double call(double t)
	{
		if(x.size()==0)
		{
			System.exit(-1);
		}
		if(t<x.get(0).doubleValue())
			return this.getLeftDefault();
		if(x.get(0).doubleValue()==t)
			return y.get(0).doubleValue();
		for(int i=0;i<x.size();i++)
		{
			if(t<=x.get(i).doubleValue())
			{
				double lowerAbscissa=x.get(i-1).doubleValue();
				double upperAbscissa=x.get(i).doubleValue();
				double lowerOrdinate=y.get(i-1).doubleValue();
				double upperOrdinate=y.get(i).doubleValue();
				return lowerOrdinate
				+(upperOrdinate-lowerOrdinate)
				/(upperAbscissa-lowerAbscissa)*(t-lowerAbscissa);
			}
		}
		return this.getRightDefault();
	}
	
	public PolygonalFunction copy()
	{
		PolygonalFunction ret=new PolygonalFunction();
		ret.setLeftDefault(this.getLeftDefault());
		ret.setRightDefault(this.getRightDefault());
		ret.getX().addAll(this.getX());
		ret.getY().addAll(this.getY());
		return ret;
	}
	
	public double firstX()
	{
		return this.x.get(this.nextPoint(Double.NEGATIVE_INFINITY));
	}
	
	public double getLeftDefault()
	{
		return leftDefault;
	}
	
	public double getRightDefault()
	{
		return rightDefault;
	}
	
	public ArrayList<Double> getX()
	{
		return x;
	}
	
	public ArrayList<Double> getY()
	{
		return y;
	}

	public double integrate(double a, double b)
	{
		System.out.println("Integrating from "+a+" to "+b);
		if(b<a)
			return 0.;
		if(a==b)
			return(0d);
		if(x.size()<2)
			return(0d);
		if(a<this.firstX())return 
		integrate(a,Math.min(b,this.firstX()))
		+integrate(Math.min(b,this.firstX()),b);
		if(this.lastX()<b)return integrate(a,this.lastX())
		+integrate(this.lastX(),b);
		System.out.println("a is "+a+" and nextpoint is "+this.nextPoint(a));
		return .5*(this.call(a)+this.call(this.nextPoint(a)))*(this.nextPoint(a)-a)
		+integrate(this.nextPoint(a),b);
	}

	public double integrateWedge(double x1, double x2, double y1, double y2)
	{
		if(x2<x1)
			return -integrateWedge(x2,x1,y2,y1);
		if(x1==x2)
			return 0d;
		return (x2-x1)*1/2*(y1+y2);
	}
	
	/*public boolean isDefined(double x)
	{
		if(x<firstX())
			return false;
		if(lastX()<x)
			return false;
		return true;
	}*/
	
	/*public double integrate(double a, double b)
	{
		//Simpson's Rule implementation
	}*/
	
	public double lastX()
	{
		return this.x.get(this.previousPoint(Double.POSITIVE_INFINITY));
	}
	
	public int nextPoint(double a)
	{
		int i=0;
		while(i<x.size() && x.get(i).doubleValue()<=a)
				i++;
		if(i==0)
			return 0;
		else
			if(i<x.size())
				return i;
			else
				return Integer.MAX_VALUE;
	}

	public int previousPoint(double a)
	{
		int i=x.size()-1;
		while(i>=0 && x.get(i).doubleValue()>=a)
				i--;
		if(i==x.size()-1)
			return x.size()-1;
		else
			if(i>=0)
				return i;
			else
				return Integer.MIN_VALUE;
	}
	
	public void setLeftDefault(double t)
	{
		this.leftDefault=t;
	}

	public void setRightDefault(double t)
	{
		this.rightDefault=t;
	}

	public void setX(ArrayList<Double> x)
	{
		this.x = x;
	}
	
	public void setY(ArrayList<Double> y)
	{
		this.y = y;
	}
}

class PolygonalFunctionPlotterPanel extends AbstractPlotPanel
{
  private static final long serialVersionUID = 1L;
  private PolygonalFunction p;

  public PolygonalFunction getPolygonalFunction()
	{
		return p;
	}

	public void setPolygonalFunction(PolygonalFunction p)
	{
		this.p = p;
	}

	public void update(Graphics g)
  {
    setGraphics2D(g);
    clearRect(0,0,getWidth(),getHeight(),Color.yellow);

    //locate(0,0,getWidth(),getHeight()-1);
    locate(10,10,590,590);
    frame();
    scale(-10.,10.,-10.,10.);
    axes(.1,.1,0.,0.);
    pen(Color.red);
    
    move(-10.,getPolygonalFunction().call(-10.));
		
    for(double x=-10.;x<10.;x+=.0001)
    {
    	move(x,getPolygonalFunction().call(x));
			draw(x,getPolygonalFunction().call(x));
    }
  }
}
