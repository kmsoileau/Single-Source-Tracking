package positronic.math.gametheory.julia;

import java.util.HashMap;

public class General extends JuliaGame
{
	public static void main(String[] args)
	{
		/**
		 * In the '50's Julia Robinson published an iterative method for 
		 * solving a two-person zero-sum game. Players A and B both make
		 * initial plays (probably at random). Each notes the other's
		 * play and calculates the best second play assuming the opponent
		 * makes the same play as at first. Now each player has a two
		 * member history of the other person's play. The third move of
		 * each is the optimal play assuming the opponent will select a
		 * move from the opponents current history of play, each move
		 * being equally likely. If play continues like this over larger 
		 * and larger histories, the play will converge to an optimal
		 * strategy for that game.
		 * 
		 * see Julia Robinson, An Iterative Method of Solving a Game, 
		 * The Annals of Mathematics, 2nd Ser., Vol. 54, No. 2 (Sep., 1951), 
		 * pp. 296-301
		 */
		General g=new General();
		IMove Blue1=new GeneralMove("Blue1",0,0,4);
		IMove Blue2=new GeneralMove("Blue2",0,1,3);
		IMove Blue3=new GeneralMove("Blue3",0,2,2);
		IMove Blue4=new GeneralMove("Blue4",0,3,1);
		IMove Blue5=new GeneralMove("Blue5",0,4,0);
		IMove Blue6=new GeneralMove("Blue6",1,0,3);
		IMove Blue7=new GeneralMove("Blue7",1,1,2);
		IMove Blue8=new GeneralMove("Blue8",1,2,1);
		IMove Blue9=new GeneralMove("Blue9",1,3,0);
		IMove Blue10=new GeneralMove("Blue10",2,0,2);
		IMove Blue11=new GeneralMove("Blue11",2,1,1);
		IMove Blue12=new GeneralMove("Blue12",3,0,1);
		IMove Blue13=new GeneralMove("Blue13",3,1,0);
		IMove Blue14=new GeneralMove("Blue14",4,0,0);
		IMove Blue15=new GeneralMove("Blue15",2,2,0);
		
		
		IMove Red1=new GeneralMove("Red1",0,0,4);
		IMove Red2=new GeneralMove("Red2",0,1,3);
		IMove Red3=new GeneralMove("Red3",0,2,2);
		IMove Red4=new GeneralMove("Red4",0,3,1);
		IMove Red5=new GeneralMove("Red5",0,4,0);
		IMove Red6=new GeneralMove("Red6",1,0,3);
		IMove Red7=new GeneralMove("Red7",1,1,2);
		IMove Red8=new GeneralMove("Red8",1,2,1);
		IMove Red9=new GeneralMove("Red9",1,3,0);
		IMove Red10=new GeneralMove("Red10",2,0,2);
		IMove Red11=new GeneralMove("Red11",2,1,1);
		IMove Red12=new GeneralMove("Red12",3,0,1);
		IMove Red13=new GeneralMove("Red13",3,1,0);
		IMove Red14=new GeneralMove("Red14",4,0,0);
		IMove Red15=new GeneralMove("Red15",2,2,0);
		
		g.bluemoves.add(Blue1);
		g.bluemoves.add(Blue2);
		g.bluemoves.add(Blue3);
		g.bluemoves.add(Blue4);
		g.bluemoves.add(Blue5);
		g.bluemoves.add(Blue6);
		g.bluemoves.add(Blue7);
		g.bluemoves.add(Blue8);
		g.bluemoves.add(Blue9);
		g.bluemoves.add(Blue10);
		g.bluemoves.add(Blue11);
		g.bluemoves.add(Blue12);
		g.bluemoves.add(Blue13);
		g.bluemoves.add(Blue14);
		g.bluemoves.add(Blue15);
		g.redmoves.add(Red1);
		g.redmoves.add(Red2);
		g.redmoves.add(Red3);
		g.redmoves.add(Red4);
		g.redmoves.add(Red5);
		g.redmoves.add(Red6);
		g.redmoves.add(Red7);
		g.redmoves.add(Red8);
		g.redmoves.add(Red9);
		g.redmoves.add(Red10);
		g.redmoves.add(Red11);
		g.redmoves.add(Red12);
		g.redmoves.add(Red13);
		g.redmoves.add(Red14);
		g.bluemoves.add(Red15);
		
		IMove ainit=g.selectAInitialMove();
		IMove binit=g.selectBInitialMove();
		History ahistory=new History();
		History bhistory=new History();
		ahistory.recordMove(ainit);
		bhistory.recordMove(binit);
		while(true)
		{
			IMove abestmove=g.getBestAMove(g.bluemoves,bhistory);
			IMove bbestmove=g.getBestBMove(g.redmoves,ahistory);
			ahistory.recordMove(abestmove);
			bhistory.recordMove(bbestmove);
			
			HashMap<IMove,Long> astats=new HashMap<IMove,Long>();
			for(IMove m:ahistory)
			{
				if(!astats.keySet().contains(m))
					astats.put(m,new Long(0));
				else
					astats.put(m,astats.get(m)+1);
			}
			HashMap<IMove,Long> bstats=new HashMap<IMove,Long>();
			for(IMove m:bhistory)
			{
				if(!bstats.keySet().contains(m))
					bstats.put(m,new Long(0));
				else
					bstats.put(m,bstats.get(m)+1);
			}
			System.out.println("*****************");
			long atotal=0;
			for(IMove m:astats.keySet())
				atotal+=astats.get(m).longValue();
			for(IMove m:astats.keySet())
			{
				System.out.flush();
				GeneralMove g1=(GeneralMove) m;
				System.out.println(m.getTitle()+"\t"+g1.toString()
						+"\t"+roundIt(1.*astats.get(m).longValue()/atotal,3));
			}
			long btotal=0;
			for(IMove m:bstats.keySet())
				btotal+=bstats.get(m).longValue();
			for(IMove m:bstats.keySet())
			{
				System.out.flush();
				GeneralMove g1=(GeneralMove) m;
				System.out.println(m.getTitle()
						+"\t"+g1.toString()
						+"\t"+roundIt(1.*bstats.get(m).longValue()/btotal,3));
			}
		}
	}
	
	public static double roundIt(double x, int d)
	{
		long a=(long) (x*Math.pow(10.,d*1.)+.5);
		return a/Math.pow(10.,d);
	}
	
	public General()
	{
	}
	
	public double getPayoff(IMove a, IMove b)
	{
		long ascore=0;
		long bscore=0;
		
		if(((GeneralMove)a).front1>((GeneralMove)b).front1)
			ascore++;
		else
			if(((GeneralMove)a).front1<((GeneralMove)b).front1)
				bscore++;
		if(((GeneralMove)a).front2>((GeneralMove)b).front2)
			ascore++;
		else
			if(((GeneralMove)a).front2<((GeneralMove)b).front2)
				bscore++;
		if(((GeneralMove)a).front3>((GeneralMove)b).front3)
			ascore++;
		else
			if(((GeneralMove)a).front3<((GeneralMove)b).front3)
				bscore++;
		return (double)(ascore-bscore);
	}
}

