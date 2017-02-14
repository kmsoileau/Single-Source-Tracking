package positronic.satisfiability.rectangle;

import positronic.satisfiability.interval.IInterval;
import positronic.satisfiability.interval.Interval;

public class Rectangle implements IRectangle
{
	private IInterval horizontal;
	private IInterval vertical;
	
	public Rectangle() throws Exception
	{
		this(new Interval(),new Interval());
	}
	
	public Rectangle(long h1,long h2,long v1,long v2) throws Exception
	{
		this(new Interval(h1,h2),new Interval(v1,v2));
	}
	
	public Rectangle(IInterval horizontal, IInterval vertical)
	{
		this.setHorizontal(horizontal);
		this.setVertical(vertical);
	}
	
	/**
	 * @see positronic.satisfiability.rectangle.IRectangle#getHorizontal()
	 */
	public IInterval getHorizontal()
	{
		return horizontal;
	}

	/**
	 * @see positronic.satisfiability.rectangle.IRectangle#getVertical()
	 */
	public IInterval getVertical()
	{
		return vertical;
	}

	/** 
	 * @see positronic.satisfiability.rectangle.IRectangle#setHorizontal(positronic.satisfiability.interval.IInterval)
	 */
	public void setHorizontal(IInterval horizontal)
	{
		this.horizontal = horizontal;
	}

	/**
	 * @see positronic.satisfiability.rectangle.IRectangle#setVertical(positronic.satisfiability.interval.IInterval)
	 */
	public void setVertical(IInterval vertical)
	{
		this.vertical = vertical;
	}

	/**
	 * @see positronic.satisfiability.rectangle.IRectangle#toString()
	 */
	public String toString()
  {
    return "$"+this.getHorizontal()+"x"+this.getVertical()+"$";
  }
}
