/*
 * ThreeBitAdder.java	1.11 04/11/24
 *
 * Copyright 2004-2005 Positronic Software.
 *
 *
 */

package positronic.satisfiability.elements;

/**
 * An extension of the IProblem class which performs an add with carry of three
 * BooleanVariables.
 *
 * To use this class, one passes BooleanVariables w, x, y, z and c to the
 * constructor. The ThreeBitAdder object produced is a IProblem, and one may
 * manipulate it using any of the methods provided by the IProblem class.
 *
 * For example, when the IProblem instance p defined by
 *
 * IProblem p=new ThreeBitAdder(w,x,y,z,c);
 *
 * is satisfied, the following truth equation will be satisfied:
 *
 * z == w + x + y (without carry)
 * c == (carry bit)
 *
 * @author  Kerry Michael Soileau
 * ksoileau@yahoo.com
 * http://kerrysoileau.com/index.html
 * @version 1.11, 04/11/24
 * @see IBooleanVariable
 * @see IClause
 * @see IProblem
 * @see String
 */

public class ThreeBitAdder extends Problem implements IProblem
{
	private static final long serialVersionUID = -4604462419237049087L;

	public ThreeBitAdder(IBooleanVariable w, IBooleanVariable x, IBooleanVariable y, IBooleanVariable z, IBooleanVariable c) throws Exception
  {
    this.setClauses(new IClause[]
    {
      //Clause.newClause().or(w).or(x).or(y).or(z).or(c),
      Clause.newClause().or(w).or(x).or(y).or(z).orNot(c),
      Clause.newClause().or(w).or(x).or(y).orNot(z).or(c),
      Clause.newClause().or(w).or(x).or(y).orNot(z).orNot(c),
      Clause.newClause().or(w).or(x).orNot(y).or(z).or(c),
      Clause.newClause().or(w).or(x).orNot(y).or(z).orNot(c),
      //Clause.newClause().or(w).or(x).orNot(y).orNot(z).or(c),
      Clause.newClause().or(w).or(x).orNot(y).orNot(z).orNot(c),
      Clause.newClause().or(w).orNot(x).or(y).or(z).or(c),
      Clause.newClause().or(w).orNot(x).or(y).or(z).orNot(c),
      //Clause.newClause().or(w).orNot(x).or(y).orNot(z).or(c),
      Clause.newClause().or(w).orNot(x).or(y).orNot(z).orNot(c),
      Clause.newClause().or(w).orNot(x).orNot(y).or(z).or(c),
      //Clause.newClause().or(w).orNot(x).orNot(y).or(z).orNot(c),
      Clause.newClause().or(w).orNot(x).orNot(y).orNot(z).or(c),
      Clause.newClause().or(w).orNot(x).orNot(y).orNot(z).orNot(c),
      Clause.newClause().orNot(w).or(x).or(y).or(z).or(c),
      Clause.newClause().orNot(w).or(x).or(y).or(z).orNot(c),
      //Clause.newClause().orNot(w).or(x).or(y).orNot(z).or(c),
      Clause.newClause().orNot(w).or(x).or(y).orNot(z).orNot(c),
      Clause.newClause().orNot(w).or(x).orNot(y).or(z).or(c),
      //Clause.newClause().orNot(w).or(x).orNot(y).or(z).orNot(c),
      Clause.newClause().orNot(w).or(x).orNot(y).orNot(z).or(c),
      Clause.newClause().orNot(w).or(x).orNot(y).orNot(z).orNot(c),
      Clause.newClause().orNot(w).orNot(x).or(y).or(z).or(c),
      //Clause.newClause().orNot(w).orNot(x).or(y).or(z).orNot(c),
      Clause.newClause().orNot(w).orNot(x).or(y).orNot(z).or(c),
      Clause.newClause().orNot(w).orNot(x).or(y).orNot(z).orNot(c),
      Clause.newClause().orNot(w).orNot(x).orNot(y).or(z).or(c),
      Clause.newClause().orNot(w).orNot(x).orNot(y).or(z).orNot(c),
      Clause.newClause().orNot(w).orNot(x).orNot(y).orNot(z).or(c),
      //Clause.newClause().orNot(w).orNot(x).orNot(y).orNot(z).orNot(c)
    });
  }
}