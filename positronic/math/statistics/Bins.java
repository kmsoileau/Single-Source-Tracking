package positronic.math.statistics;

public class Bins 
{
	private Bin[] bins;

	public Bins(int numberBins, double a, double b, double[] data)
	{
		bins=new Bin[numberBins];
		
		for(int j=0;j<numberBins;j++)
			bins[j]=new Bin(a+j*(b-a)/numberBins,a+(j+1)*(b-a)/numberBins);
		this.sort(data);
	}
	
	public String excelOut()
	{
		String ret="";
		for(int i=0;i<this.size();i++)
			ret+=this.getBin(i).excelOut();
		return ret;
	}
	
	public Bin getBin(int n) 
	{
		return bins[n];
	}

	double mean() 
	{
		double ret=0.;
		for(int i=0;i<this.size();i++)
			ret+=this.bins[i].contents;
		return ret/this.size();
	}
	
	public double secondmoment()
	{
		double ret=0.;
		for(int i=0;i<this.size();i++)
			ret+=this.bins[i].contents*this.bins[i].contents;
		return ret/this.size();
	}
	
	public int size()
	{
		return this.bins.length;
	}
	
	public void sort(double[] data)
	{
		for(int i=0;i<data.length;i++)
			for(int j=0;j<this.size();j++)
				if(this.bins[j].lower<data[i] && data[i]<=this.bins[j].upper)
					this.bins[j].contents++;
	}
	
	public String toString()
	{
		String ret="(";
		for(int i=0;i<this.size();i++)
			ret+=this.getBin(i);
		ret+=":";
		return ret;
	}
	
	public double variance()
	{
		double m=this.mean();
		return this.secondmoment()-m*m;
	}
}
