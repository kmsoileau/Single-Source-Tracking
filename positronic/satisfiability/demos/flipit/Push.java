package positronic.satisfiability.demos.flipit;

import positronic.satisfiability.bittable.IBitTable;
import positronic.satisfiability.elements.BitEqualizer;
import positronic.satisfiability.elements.BitUnequalizer;
import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.Disjunction;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;

public class Push extends Problem implements IProblem
{
	private static final long serialVersionUID = -6335954784365998133L;

	public Push(IBitTable preboard, IBitTable postboard) throws Exception
	{
		IProblem ret=new Disjunction(
				new IProblem[]{
				new Pusher00(preboard, postboard),
				new Pusher01(preboard, postboard),
				new Pusher02(preboard, postboard),
				new Pusher10(preboard, postboard),
				new Pusher11(preboard, postboard),
				new Pusher12(preboard, postboard),
				new Pusher20(preboard, postboard),
				new Pusher21(preboard, postboard),
				new Pusher22(preboard, postboard)});
		this.setClauses(ret.getClauses());
	}
}

class Pusher00 extends Problem implements IProblem
{
	private static final long serialVersionUID = -3203333630355171194L;

	public Pusher00(IBitTable preboard, IBitTable postboard) throws Exception
	{
		IProblem ret00=new BitUnequalizer(preboard.getBooleanVariable(0,0),postboard.getBooleanVariable(0,0));
		IProblem ret01=new BitUnequalizer(preboard.getBooleanVariable(0,1),postboard.getBooleanVariable(0,1));
		IProblem ret02=new BitEqualizer(preboard.getBooleanVariable(0,2),postboard.getBooleanVariable(0,2));
		IProblem ret10=new BitUnequalizer(preboard.getBooleanVariable(1,0),postboard.getBooleanVariable(1,0));
		IProblem ret11=new BitUnequalizer(preboard.getBooleanVariable(1,1),postboard.getBooleanVariable(1,1));
		IProblem ret12=new BitEqualizer(preboard.getBooleanVariable(1,2),postboard.getBooleanVariable(1,2));
		IProblem ret20=new BitEqualizer(preboard.getBooleanVariable(2,0),postboard.getBooleanVariable(2,0));
		IProblem ret21=new BitEqualizer(preboard.getBooleanVariable(2,1),postboard.getBooleanVariable(2,1));
		IProblem ret22=new BitEqualizer(preboard.getBooleanVariable(2,2),postboard.getBooleanVariable(2,2));
		IProblem p=new Conjunction(new IProblem[]{ret00,ret01,ret02,ret10,ret11,ret12,ret20,ret21,ret22});
		this.setClauses(p.getClauses());
	}
}

class Pusher01 extends Problem implements IProblem
{
	private static final long serialVersionUID = 3754440448599549768L;

	public Pusher01(IBitTable preboard, IBitTable postboard) throws Exception
	{
		IProblem ret00=new BitUnequalizer(preboard.getBooleanVariable(0,0),postboard.getBooleanVariable(0,0));
		IProblem ret01=new BitUnequalizer(preboard.getBooleanVariable(0,1),postboard.getBooleanVariable(0,1));
		IProblem ret02=new BitUnequalizer(preboard.getBooleanVariable(0,2),postboard.getBooleanVariable(0,2));
		IProblem ret10=new BitUnequalizer(preboard.getBooleanVariable(1,0),postboard.getBooleanVariable(1,0));
		IProblem ret11=new BitUnequalizer(preboard.getBooleanVariable(1,1),postboard.getBooleanVariable(1,1));
		IProblem ret12=new BitUnequalizer(preboard.getBooleanVariable(1,2),postboard.getBooleanVariable(1,2));
		IProblem ret20=new BitEqualizer(preboard.getBooleanVariable(2,0),postboard.getBooleanVariable(2,0));
		IProblem ret21=new BitEqualizer(preboard.getBooleanVariable(2,1),postboard.getBooleanVariable(2,1));
		IProblem ret22=new BitEqualizer(preboard.getBooleanVariable(2,2),postboard.getBooleanVariable(2,2));
		IProblem p=new Conjunction(new IProblem[]{ret00,ret01,ret02,ret10,ret11,ret12,ret20,ret21,ret22});
		this.setClauses(p.getClauses());
	}
}

class Pusher02 extends Problem implements IProblem
{
	private static final long serialVersionUID = 4635832533075468139L;

	public Pusher02(IBitTable preboard, IBitTable postboard) throws Exception
	{
		IProblem ret00=new BitEqualizer(preboard.getBooleanVariable(0,0),postboard.getBooleanVariable(0,0));
		IProblem ret01=new BitUnequalizer(preboard.getBooleanVariable(0,1),postboard.getBooleanVariable(0,1));
		IProblem ret02=new BitUnequalizer(preboard.getBooleanVariable(0,2),postboard.getBooleanVariable(0,2));
		IProblem ret10=new BitEqualizer(preboard.getBooleanVariable(1,0),postboard.getBooleanVariable(1,0));
		IProblem ret11=new BitUnequalizer(preboard.getBooleanVariable(1,1),postboard.getBooleanVariable(1,1));
		IProblem ret12=new BitUnequalizer(preboard.getBooleanVariable(1,2),postboard.getBooleanVariable(1,2));
		IProblem ret20=new BitEqualizer(preboard.getBooleanVariable(2,0),postboard.getBooleanVariable(2,0));
		IProblem ret21=new BitEqualizer(preboard.getBooleanVariable(2,1),postboard.getBooleanVariable(2,1));
		IProblem ret22=new BitEqualizer(preboard.getBooleanVariable(2,2),postboard.getBooleanVariable(2,2));
		IProblem p=new Conjunction(new IProblem[]{ret00,ret01,ret02,ret10,ret11,ret12,ret20,ret21,ret22});
		this.setClauses(p.getClauses());
	}
}

class Pusher10 extends Problem implements IProblem
{
	private static final long serialVersionUID = -4913863570881799243L;

	public Pusher10(IBitTable preboard, IBitTable postboard) throws Exception
	{
		IProblem ret00=new BitUnequalizer(preboard.getBooleanVariable(0,0),postboard.getBooleanVariable(0,0));
		IProblem ret01=new BitUnequalizer(preboard.getBooleanVariable(0,1),postboard.getBooleanVariable(0,1));
		IProblem ret02=new BitEqualizer(preboard.getBooleanVariable(0,2),postboard.getBooleanVariable(0,2));
		IProblem ret10=new BitUnequalizer(preboard.getBooleanVariable(1,0),postboard.getBooleanVariable(1,0));
		IProblem ret11=new BitUnequalizer(preboard.getBooleanVariable(1,1),postboard.getBooleanVariable(1,1));
		IProblem ret12=new BitEqualizer(preboard.getBooleanVariable(1,2),postboard.getBooleanVariable(1,2));
		IProblem ret20=new BitUnequalizer(preboard.getBooleanVariable(2,0),postboard.getBooleanVariable(2,0));
		IProblem ret21=new BitUnequalizer(preboard.getBooleanVariable(2,1),postboard.getBooleanVariable(2,1));
		IProblem ret22=new BitEqualizer(preboard.getBooleanVariable(2,2),postboard.getBooleanVariable(2,2));
		IProblem p=new Conjunction(new IProblem[]{ret00,ret01,ret02,ret10,ret11,ret12,ret20,ret21,ret22});
		this.setClauses(p.getClauses());
	}
}

class Pusher11 extends Problem implements IProblem
{
	private static final long serialVersionUID = -1374459592236735237L;

	public Pusher11(IBitTable preboard, IBitTable postboard) throws Exception
	{
		IProblem ret00=new BitUnequalizer(preboard.getBooleanVariable(0,0),postboard.getBooleanVariable(0,0));
		IProblem ret01=new BitUnequalizer(preboard.getBooleanVariable(0,1),postboard.getBooleanVariable(0,1));
		IProblem ret02=new BitUnequalizer(preboard.getBooleanVariable(0,2),postboard.getBooleanVariable(0,2));
		IProblem ret10=new BitUnequalizer(preboard.getBooleanVariable(1,0),postboard.getBooleanVariable(1,0));
		IProblem ret11=new BitUnequalizer(preboard.getBooleanVariable(1,1),postboard.getBooleanVariable(1,1));
		IProblem ret12=new BitUnequalizer(preboard.getBooleanVariable(1,2),postboard.getBooleanVariable(1,2));
		IProblem ret20=new BitUnequalizer(preboard.getBooleanVariable(2,0),postboard.getBooleanVariable(2,0));
		IProblem ret21=new BitUnequalizer(preboard.getBooleanVariable(2,1),postboard.getBooleanVariable(2,1));
		IProblem ret22=new BitUnequalizer(preboard.getBooleanVariable(2,2),postboard.getBooleanVariable(2,2));
		IProblem p=new Conjunction(new IProblem[]{ret00,ret01,ret02,ret10,ret11,ret12,ret20,ret21,ret22});
		this.setClauses(p.getClauses());
	}
}

class Pusher12 extends Problem implements IProblem
{
	private static final long serialVersionUID = -893499767755988040L;

	public Pusher12(IBitTable preboard, IBitTable postboard) throws Exception
	{
		IProblem ret00=new BitEqualizer(preboard.getBooleanVariable(0,0),postboard.getBooleanVariable(0,0));
		IProblem ret01=new BitUnequalizer(preboard.getBooleanVariable(0,1),postboard.getBooleanVariable(0,1));
		IProblem ret02=new BitUnequalizer(preboard.getBooleanVariable(0,2),postboard.getBooleanVariable(0,2));
		IProblem ret10=new BitEqualizer(preboard.getBooleanVariable(1,0),postboard.getBooleanVariable(1,0));
		IProblem ret11=new BitUnequalizer(preboard.getBooleanVariable(1,1),postboard.getBooleanVariable(1,1));
		IProblem ret12=new BitUnequalizer(preboard.getBooleanVariable(1,2),postboard.getBooleanVariable(1,2));
		IProblem ret20=new BitEqualizer(preboard.getBooleanVariable(2,0),postboard.getBooleanVariable(2,0));
		IProblem ret21=new BitUnequalizer(preboard.getBooleanVariable(2,1),postboard.getBooleanVariable(2,1));
		IProblem ret22=new BitUnequalizer(preboard.getBooleanVariable(2,2),postboard.getBooleanVariable(2,2));
		IProblem p=new Conjunction(new IProblem[]{ret00,ret01,ret02,ret10,ret11,ret12,ret20,ret21,ret22});
		this.setClauses(p.getClauses());
	}
}

class Pusher20 extends Problem implements IProblem
{
	private static final long serialVersionUID = -1182969792807485538L;

	public Pusher20(IBitTable preboard, IBitTable postboard) throws Exception
	{
		IProblem ret00=new BitEqualizer(preboard.getBooleanVariable(0,0),postboard.getBooleanVariable(0,0));
		IProblem ret01=new BitEqualizer(preboard.getBooleanVariable(0,1),postboard.getBooleanVariable(0,1));
		IProblem ret02=new BitEqualizer(preboard.getBooleanVariable(0,2),postboard.getBooleanVariable(0,2));
		IProblem ret10=new BitUnequalizer(preboard.getBooleanVariable(1,0),postboard.getBooleanVariable(1,0));
		IProblem ret11=new BitUnequalizer(preboard.getBooleanVariable(1,1),postboard.getBooleanVariable(1,1));
		IProblem ret12=new BitEqualizer(preboard.getBooleanVariable(1,2),postboard.getBooleanVariable(1,2));
		IProblem ret20=new BitUnequalizer(preboard.getBooleanVariable(2,0),postboard.getBooleanVariable(2,0));
		IProblem ret21=new BitUnequalizer(preboard.getBooleanVariable(2,1),postboard.getBooleanVariable(2,1));
		IProblem ret22=new BitEqualizer(preboard.getBooleanVariable(2,2),postboard.getBooleanVariable(2,2));
		IProblem p=new Conjunction(new IProblem[]{ret00,ret01,ret02,ret10,ret11,ret12,ret20,ret21,ret22});
		this.setClauses(p.getClauses());
	}
}

class Pusher21 extends Problem implements IProblem
{
	private static final long serialVersionUID = 7843175583367268770L;

	public Pusher21(IBitTable preboard, IBitTable postboard) throws Exception
	{
		IProblem ret00=new BitEqualizer(preboard.getBooleanVariable(0,0),postboard.getBooleanVariable(0,0));
		IProblem ret01=new BitEqualizer(preboard.getBooleanVariable(0,1),postboard.getBooleanVariable(0,1));
		IProblem ret02=new BitEqualizer(preboard.getBooleanVariable(0,2),postboard.getBooleanVariable(0,2));
		IProblem ret10=new BitUnequalizer(preboard.getBooleanVariable(1,0),postboard.getBooleanVariable(1,0));
		IProblem ret11=new BitUnequalizer(preboard.getBooleanVariable(1,1),postboard.getBooleanVariable(1,1));
		IProblem ret12=new BitUnequalizer(preboard.getBooleanVariable(1,2),postboard.getBooleanVariable(1,2));
		IProblem ret20=new BitUnequalizer(preboard.getBooleanVariable(2,0),postboard.getBooleanVariable(2,0));
		IProblem ret21=new BitUnequalizer(preboard.getBooleanVariable(2,1),postboard.getBooleanVariable(2,1));
		IProblem ret22=new BitUnequalizer(preboard.getBooleanVariable(2,2),postboard.getBooleanVariable(2,2));
		IProblem p=new Conjunction(new IProblem[]{ret00,ret01,ret02,ret10,ret11,ret12,ret20,ret21,ret22});
		this.setClauses(p.getClauses());
	}
}

class Pusher22 extends Problem implements IProblem
{
	private static final long serialVersionUID = -5647544539710112521L;

	public Pusher22(IBitTable preboard, IBitTable postboard) throws Exception
	{
		IProblem ret00=new BitEqualizer(preboard.getBooleanVariable(0,0),postboard.getBooleanVariable(0,0));
		IProblem ret01=new BitEqualizer(preboard.getBooleanVariable(0,1),postboard.getBooleanVariable(0,1));
		IProblem ret02=new BitEqualizer(preboard.getBooleanVariable(0,2),postboard.getBooleanVariable(0,2));
		IProblem ret10=new BitEqualizer(preboard.getBooleanVariable(1,0),postboard.getBooleanVariable(1,0));
		IProblem ret11=new BitUnequalizer(preboard.getBooleanVariable(1,1),postboard.getBooleanVariable(1,1));
		IProblem ret12=new BitUnequalizer(preboard.getBooleanVariable(1,2),postboard.getBooleanVariable(1,2));
		IProblem ret20=new BitEqualizer(preboard.getBooleanVariable(2,0),postboard.getBooleanVariable(2,0));
		IProblem ret21=new BitUnequalizer(preboard.getBooleanVariable(2,1),postboard.getBooleanVariable(2,1));
		IProblem ret22=new BitUnequalizer(preboard.getBooleanVariable(2,2),postboard.getBooleanVariable(2,2));
		IProblem p=new Conjunction(new IProblem[]{ret00,ret01,ret02,ret10,ret11,ret12,ret20,ret21,ret22});
		this.setClauses(p.getClauses());
	}
}

