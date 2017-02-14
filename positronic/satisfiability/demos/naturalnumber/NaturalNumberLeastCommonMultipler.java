package positronic.satisfiability.demos.naturalnumber;

/**
 * <p>Title: TBS</p>
 * <p>Description: TBS</p>
 * <p>Copyright (c) 2005</p>
 * <p>Company: Positronic Software</p>
 * @author Kerry Michael Soileau
 * @version 1.0
 */
import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;
import positronic.satisfiability.naturalnumber.INaturalNumber;
import positronic.satisfiability.naturalnumber.NaturalNumber;
import positronic.satisfiability.naturalnumber.NaturalNumberMultiplier;
import positronic.satisfiability.naturalnumber.NaturalNumberRelativelyPrimer;

/**
 * @todo test and demo this class
 *
 */
public class NaturalNumberLeastCommonMultipler extends Problem implements IProblem
{
  private static final long serialVersionUID = -3735577023728807900L;

	public NaturalNumberLeastCommonMultipler(INaturalNumber M, INaturalNumber N, INaturalNumber LCM) throws Exception
  {
		INaturalNumber K=new NaturalNumber();
		INaturalNumber L=new NaturalNumber();
		
		IProblem p=new Conjunction(
				new NaturalNumberMultiplier(M,K,LCM),
				new NaturalNumberMultiplier(N,L,LCM),
				new NaturalNumberRelativelyPrimer(K,L));
				
    this.setClauses(p.getClauses());
  }
}