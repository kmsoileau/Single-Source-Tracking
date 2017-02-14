package positronic.util.search.jiglet;

public interface IVertex 
{
	int dimension();
	IVertex duplicate();
	double evaluate();
	int getCoordinate(int i);
	void setCoordinate(int i,int n);
	String toString();
}
