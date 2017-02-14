/*
 * PartialSolutionException.java	1.0 05/10/25
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

public class PartialSolutionException extends Exception
{
	private static final long serialVersionUID = 1L;
	
  public PartialSolutionException(String s)
  {
    super(s);
  }
}