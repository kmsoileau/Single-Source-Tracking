package trackingsat;

public class test
{
	public static void main(String[] args)
	{
		Vector rv=new Vector(.2,.4,.6);
		Vector vv=new Vector(-.4,.2,0.);
		Vector Ru=new Vector(0.5531092473661592, 0.5014195097738353, 0.6653184468329488);
		Vector Tu=new Vector(-0.14758384350290915, 0.844939121319505, -0.5140981330453669);
		Vector Hu=new Vector(-0.8199324177119414, 0.18616217790407796, 0.5413450599230224);
		Measurement meas=new Measurement(rv,vv,Ru,Tu);
		System.out.println(meas);
	}
}
