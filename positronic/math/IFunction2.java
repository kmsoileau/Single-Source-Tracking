package positronic.math;

public interface IFunction2 
{
	double f(double x, double y);	//A differentiable function
	double f1(double x, double y);	//Partial of f w/respect to x
	double f2(double x, double y);	//Partial of f w/respect to y
}
