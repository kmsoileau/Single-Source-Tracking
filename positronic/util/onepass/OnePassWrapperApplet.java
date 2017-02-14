package positronic.util.onepass;

import java.applet.Applet;
import java.net.MalformedURLException;
import java.net.UnknownHostException;

public class OnePassWrapperApplet extends Applet
{
	private static final long serialVersionUID = 197194367882175660L;

	public static String strongPassGen(long personal,String URL) throws MalformedURLException, UnknownHostException
	{
		return OnePass.strongPassGen(personal, URL);
	}
}
