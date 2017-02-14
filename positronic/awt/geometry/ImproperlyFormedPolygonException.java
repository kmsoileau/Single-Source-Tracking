package positronic.awt.geometry;

public class ImproperlyFormedPolygonException extends Exception
{
	private static final long serialVersionUID = -6813055189231574401L;
	private String msg;

	public ImproperlyFormedPolygonException(String s)
	{
		super(s);
		this.msg=s;
	}
	
	public String getMessage()
	{
		return this.msg;
	}
}
