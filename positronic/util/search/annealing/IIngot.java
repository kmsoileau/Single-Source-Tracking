package positronic.util.search.annealing;

public interface IIngot 
{
	void duplicate(IIngot o);
	double evaluate();
	void mutate();
	void show();
}
