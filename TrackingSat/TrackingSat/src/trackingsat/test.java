package trackingsat;

class Package
{
	double rdR;
	double rdT;
	double rdotv;
	double vdR;
	double vdT;
	double vdv;
	
	public String toString()
	{
		return "Package [rdR=" + rdR + ", rdT=" + rdT + ", rdotv=" + rdotv
				+ ", vdR=" + vdR + ", vdT=" + vdT + ", vdv=" + vdv + "]";
	}
}

public class test
{
	public static Package doit(Vector rv,Vector vv,Vector Ru,Vector Tu,Vector Hu,Measurement meas)
	{
		Package ret=new Package();
		ret.rdotv=rv.dot(vv);
		double r=rv.norm();
		double v=vv.norm();
		ret.rdR=rdotR.eval(meas, r);
		ret.rdT=rdotT.eval(meas,r,ret.rdotv);
		ret.vdR=vdotR.eval(meas, r, ret.rdotv);
		ret.vdT=vdotT.eval(meas, r, ret.rdotv,v);
		ret.vdv=vdotv.eval(meas, r, ret.rdotv);
		
		return ret;
	}
	
	public static Package doit(double r,double v,Vector Ru,Vector Tu,Vector Hu,Measurement meas)
	{
		Package ret=new Package();
		ret.rdotv=trackingsat.rdotv.eval(meas, r, v);
		ret.rdR=rdotR.eval(meas, r);
		ret.rdT=rdotT.eval(meas,r,ret.rdotv);
		ret.vdR=vdotR.eval(meas, r, ret.rdotv);
		ret.vdT=vdotT.eval(meas, r, ret.rdotv,v);
		ret.vdv=vdotv.eval(meas, r, ret.rdotv);
		
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
		System.out.println(dt);
	}
}
