package positronic.math;
import java.util.ArrayList;

public class StepFunction
{
	public static StepFunction add(StepFunction p, StepFunction q)
	{
		StepFunction ret=new StepFunction();
		ret.setLeftDefault(p.getLeftDefault()+q.getLeftDefault());
		ret.setRightDefault(p.getRightDefault()+q.getRightDefault());
		
		for(int i=0;i<p.x.size();i++)
		{
			double xval=p.x.get(i).doubleValue();
			ret.addPoint(xval,p.y.get(i).doubleValue()+q.call(xval));
		}
		for(int i=0;i<q.x.size();i++)
		{
			double xval=q.x.get(i).doubleValue();
			ret.addPoint(xval,q.y.get(i).doubleValue()+p.call(xval));
		}
		return ret;
	}
	
	public static StepFunction mergemax(StepFunction p, StepFunction q)
	{
		StepFunction ret=new StepFunction();
		ret.setLeftDefault(Math.max(p.getLeftDefault(),q.getLeftDefault()));
		ret.setRightDefault(Math.max(p.getRightDefault(),q.getRightDefault()));
		
		for(int i=0;i<p.x.size();i++)
		{
			double xval=p.x.get(i).doubleValue();
			ret.addPoint(xval,Math.max(p.y.get(i).doubleValue(),q.call(xval)));
		}
		for(int i=0;i<q.x.size();i++)
		{
			double xval=q.x.get(i).doubleValue();
			ret.addPoint(xval,Math.max(q.y.get(i).doubleValue(),p.call(xval)));
		}
		return ret;
	}
	
	public static StepFunction mergemin(StepFunction p, StepFunction q)
	{
		StepFunction ret=new StepFunction();
		ret.setLeftDefault(Math.min(p.getLeftDefault(),q.getLeftDefault()));
		ret.setRightDefault(Math.min(p.getRightDefault(),q.getRightDefault()));
		
		for(int i=0;i<p.x.size();i++)
		{
			double xval=p.x.get(i).doubleValue();
			ret.addPoint(xval,Math.min(p.y.get(i).doubleValue(),q.call(xval)));
		}
		for(int i=0;i<q.x.size();i++)
		{
			double xval=q.x.get(i).doubleValue();
			ret.addPoint(xval,Math.min(q.y.get(i).doubleValue(),p.call(xval)));
		}
		return ret;
	}
	
	public static StepFunction scale(double c, StepFunction p)
	{
		StepFunction ret=new StepFunction();
		ret.setLeftDefault(c*p.getLeftDefault());
		ret.setRightDefault(c*p.getRightDefault());
		
		for(int i=0;i<p.x.size();i++)
		{
			double xval=p.x.get(i).doubleValue();
			ret.addPoint(xval,c*p.y.get(i).doubleValue());
		}
		return ret;
	}
	
	public static StepFunction subtract(StepFunction p, StepFunction q)
	{
		return StepFunction.add(p, StepFunction.scale(-1d,q));
	}
	
	private double leftDefault;
	private double rightDefault;
	private ArrayList<Double> x;
	private ArrayList<Double> y;
	
	public StepFunction()
	{
		this.setLeftDefault(0d);
		this.setRightDefault(0d);
		x=new ArrayList<Double>();
		y=new ArrayList<Double>();
	}
	
	public void addPoint(double xval, double yval)
	{
		for(int i=0;i<x.size();i++)
		{
			if(xval<((Double)x.get(i)).doubleValue())
			{
				x.add(i,new Double(xval));
				y.add(i,new Double(yval));
				return;
			}
		}
		x.add(new Double(xval));
		y.add(new Double(yval));
	}
	
	public double call(double t)
	{
		if(t<((Double)x.get(0)).doubleValue())
			return this.getLeftDefault();
		if(((Double)x.get(0)).doubleValue()==t)
			return ((Double)y.get(0)).doubleValue();
		for(int i=0;i<x.size();i++)
		{
			if(t<=((Double)x.get(i)).doubleValue())
				return ((Double)y.get(i-1)).doubleValue();
		}
		return this.getRightDefault();
	}
	
	public StepFunction copy()
	{
		StepFunction ret=new StepFunction();
		ret.setLeftDefault(this.getLeftDefault());
		ret.setRightDefault(this.getRightDefault());
		ret.getX().addAll(this.getX());
		ret.getY().addAll(this.getY());
		return ret;
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
