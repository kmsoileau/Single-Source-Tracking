package positronic.satisfiability.interval;

import positronic.satisfiability.naturalnumber.INaturalNumber;

public interface IInterval
{
	public INaturalNumber getLeft();
	public INaturalNumber getRight();
	public void setLeft(INaturalNumber left);
	public void setRight(INaturalNumber right); 
	public String toString();
}
