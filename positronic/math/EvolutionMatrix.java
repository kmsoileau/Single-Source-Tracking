package positronic.math;

import positronic.math.vectoranalysis.Vector;

public class EvolutionMatrix 
{
	public static void main(String[] args) 
	{
		double m00=0.;
		double m01=0.;
		double m02=0.;
		double m10=0.;
		double m11=0.;
		double m12=0.;
		double m20=0.;
		double m21=0.;
		double m22=0.;
		int N=10000;
		for(int trials=0;trials<N;trials++)
		{
			Vector v1=new Vector(new double[]{Math.random(),Math.pow(Math.random(),2.),Math.random()});
			Vector v2=new Vector(new double[]{Math.random(),Math.random(),Math.pow(Math.random(),3.)});
			m00+=v1.get(0)*v2.get(0);
			m01+=v1.get(0)*v2.get(1);
			m02+=v1.get(0)*v2.get(2);
			m10+=v1.get(1)*v2.get(0);
			m11+=v1.get(1)*v2.get(1);
			m12+=v1.get(1)*v2.get(2);
			m20+=v1.get(2)*v2.get(0);
			m21+=v1.get(2)*v2.get(1);
			m22+=v1.get(2)*v2.get(2);
		}
		m00/=N;
		m01/=N;
		m02/=N;
		m10/=N;
		m11/=N;
		m12/=N;
		m20/=N;
		m21/=N;
		m22/=N;
		System.out.println(m00+"\t"+m01+"\t"+m02);
		System.out.println(m10+"\t"+m11+"\t"+m12);
		System.out.println(m20+"\t"+m21+"\t"+m22);
	}

}
