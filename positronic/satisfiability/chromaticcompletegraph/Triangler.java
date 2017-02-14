package positronic.satisfiability.chromaticcompletegraph;

/*
 * Triangler.java	1.0 10/03/13
 *
 * Copyright 2010 Positronic Software.
 *
 *
 */
 /**
 *
 * @author  Kerry Michael Soileau
 * <blockquote><pre>
 * ksoileau@yahoo.com
 * http://kerrysoileau.com/index.html
 * </pre></blockquote>
 * @version 1.0, 10/03/13
 * @see BitString
 */

import positronic.satisfiability.bitstring.BitStringEqualizer;
import positronic.satisfiability.bitstring.IBitString;
import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.Disjunction;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;

public class Triangler extends Problem implements IProblem
{
	private static final long serialVersionUID = 1065276574564736957L;

	public Triangler(IChromaticCompleteGraph ccg, IBitString bs1, IBitString bs2, IBitString bs3) throws Exception
	{
		IProblem prob=null;
		for(int i=0;i<ccg.getEdges().size();i++)
			for(int j=0;j<ccg.getEdges().size();j++)
				for(int k=0;k<ccg.getEdges().size();k++)
					prob=new Disjunction(prob,new Conjunction(new IProblem[]
					{
							new BitStringEqualizer(ccg.getEdges().get(i).firstpoint,bs1),
							new BitStringEqualizer(ccg.getEdges().get(i).secondpoint,bs2),
							new BitStringEqualizer(ccg.getEdges().get(j).firstpoint,bs2),
							new BitStringEqualizer(ccg.getEdges().get(j).secondpoint,bs3),
							new BitStringEqualizer(ccg.getEdges().get(k).firstpoint,bs3),
							new BitStringEqualizer(ccg.getEdges().get(k).secondpoint,bs1)
					}));
		this.setClauses(prob.getClauses());
	}
}