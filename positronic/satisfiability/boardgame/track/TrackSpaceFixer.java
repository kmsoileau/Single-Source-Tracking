package positronic.satisfiability.boardgame.track;

import positronic.satisfiability.bitstring.BitStringEqualizer;
import positronic.satisfiability.bitstring.IBitString;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;
import positronic.satisfiability.exceptions.TrackSpaceFixerException;

public class TrackSpaceFixer extends Problem implements IProblem
{
	private static final long serialVersionUID = 1491342551068515159L;

	public TrackSpaceFixer(ITrack source, int location, IBitString bstring) throws Exception
	{
	    if(source==null)
	      throw new TrackSpaceFixerException("Passed a null ITrack to constructor.");
	    
	    this.setClauses(new BitStringEqualizer(source.space(location),bstring).getClauses());
	}
}