package positronic.util.search;

public interface IVertex 
{
	int dimension();
	IVertex duplicate();
	double evaluate();
	int getCoordinate(int i);
	IVertex jiggle();
	void setCoordinate(int i,int n);
	String toString();
}
