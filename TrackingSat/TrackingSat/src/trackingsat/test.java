package trackingsat;

import java.util.ArrayList;

class Package
{
	double rdR;
	double rdT;
	ArrayList<Double> rdotv;
	double vdR;
	double vdT;
	double vdv;
	
	public String toString()
	{
		return "rdR=" + rdR + "\nrdT=" + rdT + "\nrdotv=" + rdotv
				+ "\nvdR=" + vdR + "\nvdT=" + vdT + "\nvdv=" + vdv;
	}
}

public class test
{
	public static Package doit(double r,double v,Vector Ru,Vector Tu,Vector Hu,Measurement meas)
	{
		Package ret=new Package();
		trackingsat.rdotv.init(meas);
		ret.rdotv=trackingsat.rdotv.eval(meas, r, v);
		ret.rdR=trackingsat.rdotR.eval(meas, r);
		System.out.println("Predicted rdotv:"+ret.rdotv);
		//ret.rdT=trackingsat.rdotT.eval(meas,r,ret.rdotv);
		//ret.vdR=trackingsat.vdotR.eval(meas, r, ret.rdotv);
		//ret.vdT=trackingsat.vdotT.eval(meas, r, ret.rdotv,v);
		//ret.vdv=trackingsat.vdotv.eval(meas, r, ret.rdotv);
		
		return ret;
	}
	
	public static void main(String[] args)
	{
		Vector rv=new Vector(.2,.4,.65);
		Vector vv=new Vector(-.4,.2,0.1);
		Vector Ru=new Vector(0.5531092473661592, 0.5014195097738353, 0.6653184468329488);
		Vector Tu=new Vector(-0.14758384350290915, 0.844939121319505, -0.5140981330453669);
		Vector Hu=new Vector(-0.8199324177119414, 0.18616217790407796, 0.5413450599230224);
		Measurement meas=new Measurement(rv,vv,Ru,Tu);
		System.out.println("meas="+meas);
		
		Package dt=doit(rv.norm(),vv.norm(),Ru,Tu,Hu,meas);
		double rdRa=rv.dot(Ru);
		double rdTa=rv.dot(Tu);
		double rdotva=rv.dot(vv);
		double vdRa=vv.dot(Ru);
		double vdTa=vv.dot(Tu);
		double vdva=vv.dot(vv);
		System.out.println(dt);
		System.out.println(rdRa+","+rdTa+","+rdotva+","+vdRa+","+vdTa+","+vdva);
		System.out.println("Actual rdotv:"+rdotva);
	}
}
