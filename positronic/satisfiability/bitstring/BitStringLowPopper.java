/*
 * BitStringLowPopper.java	1.0 05/04/15
 *
 * Copyright 2004-2005 Positronic Software.
 *
 *
 */

package positronic.satisfiability.bitstring;

import positronic.satisfiability.elements.BitEqualizer;
import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;

public class BitStringLowPopper extends Problem implements IProblem
{
  private static final long serialVersionUID = 1L;

  public BitStringLowPopper(IBitString X, IBitString Y) throws Exception
  {
    if(X.size()!=Y.size()+1)
      this.setClauses(Problem.unsolvableProblem().getClauses());
    else
    {
      IProblem[] p=new IProblem[X.size()];
      int count=0;
      for(int i=0;i<p.length-1;i++)
        p[count++]=new BitEqualizer(X.getBooleanVariable(i+1),Y.getBooleanVariable(i));
      this.setClauses(new Conjunction(p).getClauses());
    }
  }
}