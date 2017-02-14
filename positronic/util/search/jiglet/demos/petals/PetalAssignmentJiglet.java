package positronic.util.search.jiglet.demos.petals;

import positronic.util.search.jiglet.IVertex;
import positronic.util.search.jiglet.Jiglet;

public class PetalAssignmentJiglet extends Jiglet
{
	//20,18,19,16,23,13,21,10,22,17,24,15,2,12,3,7,5,9,6,14,4,8,1,11
	//19,18,22,12,24,13,21,15,23,17,20,14,2,7,5,10,6,9,3,11,4,8,1,16
	//21,17,24,16,20,15,22,12,23,11,19,18,1,10,2,9,3,13,4,7,6,14,5,8
	//23,18,19,12,21,17,20,15,22,11,24,16,1,10,3,14,5,8,2,9,6,13,4,7
	//24,16,19,11,21,14,22,18,20,17,23,13,6,9,5,15,1,12,3,8,4,10,2,7
	//24,15,23,17,21,16,22,12,20,18,19,11,2,7,6,8,4,9,1,13,5,10,3,14
	//21,11,24,14,20,17,22,16,23,18,19,13,5,12,2,10,4,9,6,7,1,8,3,15
	
	public static void main(String[] args) 
	{
		for(int i=0;i<100000;i++)
		{
			PetalAssignmentJiglet hss=new PetalAssignmentJiglet();
			hss.setTrials(10000);
			hss.start();
			/*Rotary<Integer> r=new Rotary<Integer>();
			for(int n=0;n<hss.currentVertex.dimension();n++)
				r.addAt(null,hss.currentVertex.getCoordinate(n));
			System.out.println(r);*/
			
		}
	}
	
	protected IVertex explore() 
	{
		IVertex output=currentVertex.duplicate();
		int coord1=(int)(output.dimension()*Math.random());
		int coord2=(int)(output.dimension()*Math.random());
		int dum=output.getCoordinate(coord1);
		output.setCoordinate(coord1,output.getCoordinate(coord2));
		output.setCoordinate(coord2,dum);
		return output;
	}

	protected void init() 
	{
		currentVertex=new PetalAssignmentVertex(24);
		int[] nums=new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24};
		for(int i=0;i<24;i++)
			currentVertex.setCoordinate(i, nums[i]);
	}

	protected boolean perTrial() 
	{
		if(currentVertex.evaluate()!=0)
			return true;
		else
		{
			//System.out.println("Solution found!");
			System.out.println(currentVertex);
			return false;
		}
	}

	protected void wrapup() 
	{
		//System.out.println("Finis");
	}
}



