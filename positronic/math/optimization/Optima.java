package positronic.math.optimization;

import positronic.math.IFunction2;

public class Optima 
{
	public static double[][] optima(double[][] pts, IFunction2 o)
	{
		int numberOfPoints=pts.length;
		double[] newX=new double[numberOfPoints];
		double[] newY=new double[numberOfPoints];
		double[][] result=new double[numberOfPoints][2];
		
		for(int i=0;i<numberOfPoints;i++)
		{
			double sum1=0.;
			for(int j=0;j<i;j++)
			{
				double sum=0.;
				for(int k=j;k<numberOfPoints;k++)
					sum+=o.f1(pts[k][0],pts[k][1]);
				
				sum1+=sum/(o.f(pts[numberOfPoints-1][0],pts[numberOfPoints-1][1])-o.f(pts[j][0], pts[j][1]));
			}
			
			double sum2=0.;
			for(int j=0;j<i;j++)
			{
				double sum=0.;
				for(int k=j;k<numberOfPoints;k++)
					sum+=o.f2(pts[k][0],pts[k][1]);
				
				sum2+=sum/(o.f(pts[numberOfPoints-1][0],pts[numberOfPoints-1][1])-o.f(pts[j][0], pts[j][1]));
			}
						
			newX[i]=pts[0][0]+1./numberOfPoints/numberOfPoints*sum1;
			newY[i]=pts[0][1]+1./numberOfPoints/numberOfPoints*sum2;	
		}
	
		double length=0.;
		for(int i=0;i<numberOfPoints-1;i++)
			length+=Math.sqrt((newX[i+1]-newX[i])*(newX[i+1]-newX[i])
					+(newY[i+1]-newY[i])*(newY[i+1]-newY[i]));
		for(int i=0;i<numberOfPoints;i++)
		{
			result[i][0]=(newX[i]-newX[0])/length + newX[0];
			result[i][1]=(newY[i]-newY[0])/length + newY[0];
		}
		return result;
	}
}
