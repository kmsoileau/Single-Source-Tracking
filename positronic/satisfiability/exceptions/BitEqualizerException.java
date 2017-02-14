/*
 * BitEqualizerException.java	1.0 05/10/20
 *
 * Copyright 2005 Positronic Software.
 *
 *
 */
package positronic.satisfiability.exceptions;

/**
 * @author  Kerry Michael Soileau
 * <blockquote><pre>
 * ksoileau@yahoo.com
 * http://kerrysoileau.com/index.html
 * </pre></blockquote>
 * @version 1.0, 05/10/20
 * @see Exception
 * @see String
 */

public class BitEqualizerException extends Exception
{
	private static final long serialVersionUID = 1L;
	
  public BitEqualizerException(String s)
  {
    super(s);
  }
}