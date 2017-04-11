package trackingsat;

public class test
{
	public static void main(String[] args)
	{
		Vector rv=new Vector(.2,.4,.6);
		Vector vv=new Vector(-.4,.2,0.);
		double v=vv.norm();
		Vector Ru=new Vector(0.5531092473661592, 0.5014195097738353, 0.6653184468329488);
		Vector Tu=new Vector(-0.14758384350290915, 0.844939121319505, -0.5140981330453669);
		Vector Hu=new Vector(-0.8199324177119414, 0.18616217790407796, 0.5413450599230224);
		Measurement meas=new Measurement(rv,vv,Ru,Tu);
		System.out.println("meas="+meas);
		
		double rdotv=rv.dot(vv);
		System.out.println("rdotv="+rdotv);
		double r=rv.norm();
		System.out.println("r="+r);
		//rdR test
		double rdR=rdotR.eval(meas, r);
		System.out.println("rdR="+rdR);
		double rdRactual=rv.dot(Ru);
		System.out.println("rdRactual="+rdRactual);
		//rdT test
		double rdT=rdotT.eval(meas,r,rdotv);
		System.out.println("rdT="+rdT);
		double rdTactual=rv.dot(Tu);
		System.out.println("rdTactual="+rdTactual);
		//vdR test
		double vdR=vdotR.eval(meas, r, rdotv);
		System.out.println("vdR="+vdR);
		double vdRactual=vv.dot(Ru);
		System.out.println("vdRactual="+vdRactual);
		//vdT test
		double vdT=vdotT.eval(meas, r, rdotv,v);
		System.out.println("vdT="+vdT);
		double vdTactual=vv.dot(Tu);
		System.out.println("vdTactual="+vdTactual);
		//vdv test
		double vdv=vdotv.eval(meas, r, rdotv);
		System.out.println("vdv="+vdv);
		double vdvactual=vv.dot(vv);
		System.out.println("vdvactual="+vdvactual);
	}
}
