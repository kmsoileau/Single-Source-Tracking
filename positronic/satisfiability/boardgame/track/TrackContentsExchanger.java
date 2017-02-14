package positronic.satisfiability.boardgame.track;

import positronic.satisfiability.bitstring.BitStringEqualizer;
import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;
import positronic.satisfiability.exceptions.TrackSpaceException;

public class TrackContentsExchanger extends Problem implements IProblem
{
	private static final long serialVersionUID = 5268830240080992310L;

	public TrackContentsExchanger(ITrack oldsource, ITrack newsource,int i, int j) throws Exception
	{
	    if(oldsource==null)
	      throw new TrackSpaceException("Passed a null ITrack to constructor.");
	    if(newsource==null)
		      throw new TrackSpaceException("Passed a null ITrack to constructor.");
	    
	    this.setClauses(new Conjunction(
	    		new BitStringEqualizer(oldsource.space(i),newsource.space(j)),
	    		new BitStringEqualizer(oldsource.space(j),newsource.space(i))).getClauses());
	}
}