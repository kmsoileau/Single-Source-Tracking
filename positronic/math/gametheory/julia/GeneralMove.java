package positronic.math.gametheory.julia;

public class GeneralMove extends Move implements IMove 
{
	public GeneralMove(String name, int front1, int front2, int front3) 
	{
		super(name, front1, front2, front3);
	}

	public String toString()
	{
		return "("+front1+","+front2+","+front3+")";
		
	}
}