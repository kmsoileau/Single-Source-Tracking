package positronic.awt.geometry;

import java.util.ArrayList;

public class Region implements IRegion
{
	public static void main(String[] args) throws ImproperlyFormedPolygonException 
	{
		IRegion r=new Region("Test",
				new IPolygon[]
						{
							new PositronicPolygon(
									new Point[]
									{
										new Point(1,-4),
										new Point(6,-2),
										new Point(6,5),
										new Point(2,6),
										new Point(-3,2)
									})
						},
				new IPolygon[]
						{
							new PositronicPolygon(
									new Point[]
									{
										new Point(3,1),
										new Point(-3,6),
										new Point(-8,-1),
										new Point(-3,-4)
									})
						});
			for(int i=0;i<10000;i++)
			{
				double x=16*Math.random()-8;
				double y=16*Math.random()-8;
				if(r.contains(new Point(x,y)))
					System.out.println(x+"\t"+y);
			}

	}
	
	private ArrayList<IPolygon> includedPolygons;
	private ArrayList<IPolygon> excludedPolygons;
	private String name;

	public Region(String string, IPolygon[] includedPolys, IPolygon[] excludedPolys) 
	{
		this.name=string;
		
		if(includedPolys!=null)
		{
			this.includedPolygons=new ArrayList<IPolygon>();
			for(IPolygon p : includedPolys)
				this.include(p);
		}
		if(excludedPolys!=null)
		{
			this.excludedPolygons=new ArrayList<IPolygon>();
			for(IPolygon p : excludedPolys)
				this.exclude(p);
		}
	}
	
	public void clear() 
	{
		if(this.includedPolygons!=null)
			this.includedPolygons.clear();
		if(this.excludedPolygons!=null)
			this.excludedPolygons.clear();
	}

	//A Point lying in both an included Polygon and an excluded Polygon will be considered
	//to be outside the Region.
	public boolean contains(Point p) 
	{
		if(this.size()==0)
			return false;
		if(this.excludedPolygons!=null)
			for(IPolygon pp : this.excludedPolygons)
				if(pp.contains(p))
					return false;
		if(this.includedPolygons!=null)
			for(IPolygon pp : this.includedPolygons)
				if(pp.contains(p))
					return true;
		return false;
	}
	
	public boolean exclude(IPolygon o) 
	{
		return this.excludedPolygons.add(o);
	}

	public IPolygon getExcluded(int i) 
	{
		return this.excludedPolygons.get(i);
	}
	
	public ArrayList<IPolygon> getExcludedPolygons() 
	{
		return excludedPolygons;
	}

	public IPolygon getIncluded(int i) 
	{
		return this.includedPolygons.get(i);
	}

	public ArrayList<IPolygon> getIncludedPolygons() 
	{
		return includedPolygons;
	}

	public boolean include(IPolygon o) 
	{
		return this.includedPolygons.add(o);
	}

	public boolean isEmpty() 
	{
		return this.includedPolygons.isEmpty() || this.excludedPolygons.isEmpty();
	}

	public boolean isExcluded(IPolygon o) 
	{
		return this.excludedPolygons.contains(o);
	}
	
	public boolean isIncluded(IPolygon o) 
	{
		return this.includedPolygons.contains(o);
	}

	public boolean remove(IPolygon o) 
	{
		return this.includedPolygons.remove(o) || this.excludedPolygons.remove(o);
	}

	public int size() 
	{
		int size=0;
		if(this.includedPolygons!=null)
			size+=this.includedPolygons.size();
		if(this.excludedPolygons!=null)
			size+=this.excludedPolygons.size();
		return size;
	}
	
	public IPolygon[] toExcludesArray() 
	{
		if(this.excludedPolygons!=null)
			return (IPolygon[])this.excludedPolygons.toArray(new IPolygon[0]);
		return null;
	}	

	public IPolygon[] toIncludesArray() 
	{
		if(this.includedPolygons!=null)
			return (IPolygon[])this.includedPolygons.toArray(new IPolygon[0]);
		return null;
	}
	
	public String toString() 
	{
		return this.name;
	}	
}
