package positronic.util.annealing;

public interface IIngot 
{
	void copy(IIngot o);
	double evaluate();
	void mutate();
	void show();
}
