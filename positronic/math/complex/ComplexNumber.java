package positronic.math.complex;

public class ComplexNumber
{
	public static ComplexNumber exp(ComplexNumber c)
	{
		return new ComplexNumber(Math.cos(c.imaginary),Math.sin(c.imaginary)).multipliedBy(Math.exp(c.real));
	}
	
	public static void main(String[] args)
	{
		for(double x=-1.;x<1.;x+=.05)
			for(double y=-1.;y<1.;y+=.05)
				System.out.println(x+"\t"+y+"\t"+new ComplexNumber(x,y).count());
	}
	
	public static ComplexNumber unity()
	{
		return new ComplexNumber(1.,0.);
	}
	
	/*public static void main(String[] args)
	{
		System.out.println(ComplexNumber.unity());
		ComplexNumber c1=new ComplexNumber(.3,1.2);
		System.out.println(c1);
		ComplexNumber c2=c1.toThe(3);
		System.out.println(c2);
		ComplexNumber c3=c1.reciprocal();
		System.out.println(c3);
		ComplexNumber c4=c1.dividedBy(c3);
		System.out.println(c4);
		ComplexNumber c5=c4.multipliedBy(c3);
		System.out.println(c5);
		ComplexNumber c6=ComplexNumber.exp(c1);
		System.out.println(c6);
		ComplexNumber c7=c1.reciprocal();
		System.out.println(c7);
		ComplexNumber c8=c7.reciprocal();
		System.out.println(c8);
	}*/
	
	private double real;
	
	private double imaginary;
	public ComplexNumber(double real, double imaginary)
	{
		this.real=real;
		this.imaginary=imaginary;
	}
	
	public ComplexNumber conjugate()
	{
		return new ComplexNumber(this.real,-this.imaginary);
	}
	
	public int count()
	{
		ComplexNumber curr=this;
		ComplexNumber old=null;
		double error=Double.MAX_VALUE;
		int count=0;
		while(error>.0001)
		{
			old=curr;
			curr=curr.multipliedBy(.5).plus(curr.reciprocal().multipliedBy(.5));
			error=curr.minus(old).modulus();
			count++;
		}
		return count;
	}
	
	public ComplexNumber dividedBy(ComplexNumber c)
	{
		return this.multipliedBy(c.reciprocal());
	}
	
	public ComplexNumber minus(ComplexNumber c)
	{
		return new ComplexNumber(this.real-c.real,this.imaginary-c.imaginary);
	}
	
	public double modulus()
	{
		return Math.sqrt(this.real*this.real+this.imaginary*this.imaginary);
	}
	
	public ComplexNumber multipliedBy(ComplexNumber c)
	{
		return new ComplexNumber(this.real*c.real-this.imaginary*c.imaginary,
				this.real*c.imaginary+this.imaginary*c.real);
	}
	
	public ComplexNumber multipliedBy(double x)
	{
		return new ComplexNumber(x*this.real,x*this.imaginary);
	}
	
	public ComplexNumber plus(ComplexNumber c)
	{
		return new ComplexNumber(this.real+c.real,this.imaginary+c.imaginary);
	}
	
	public ComplexNumber reciprocal()
	{
		double mag2=this.real*this.real+this.imaginary*this.imaginary;
		return this.conjugate().multipliedBy(1./mag2);
	}
	
	public String toString()
	{
		return this.real+(this.imaginary<0?"":"+")+this.imaginary+"i";
	}
	
	public ComplexNumber toThe(int n)
	{
		if(n>0) return this.multipliedBy(this.toThe(n-1));
		if(n<0) return this.dividedBy(this.toThe(n+1));
		return ComplexNumber.unity();
	}
}
