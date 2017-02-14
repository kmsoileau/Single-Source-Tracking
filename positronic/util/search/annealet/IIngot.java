package positronic.util.search.annealet;

public interface IIngot 
{
	void duplicate(IIngot o);
	double evaluate();
	void mutate();
	void show();
}
