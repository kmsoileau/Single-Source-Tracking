package positronic.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class BufferedURLReader extends BufferedReader
	{
		public BufferedURLReader(String URLString) throws IOException
		{
			this(new URL(URLString));
		}
		
		public BufferedURLReader(URL yahoo) throws IOException
		{
			super(new InputStreamReader(yahoo.openStream()));
		}
	}