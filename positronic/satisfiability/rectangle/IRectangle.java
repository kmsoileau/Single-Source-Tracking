package positronic.satisfiability.rectangle;

import positronic.satisfiability.interval.IInterval;

public interface IRectangle
{

	public abstract IInterval getHorizontal();

	public abstract IInterval getVertical();

	public abstract void setHorizontal(IInterval horizontal);

	public abstract void setVertical(IInterval vertical);

	public abstract String toString();

}