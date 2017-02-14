package positronic.util.search.jiglet.demos.regions;

import positronic.awt.geometry.Polygons;
import positronic.awt.geometry.PositronicPolygon;

public class RegionsPositronicPolygonArray extends Polygons
{
	public static double evaluate(PositronicPolygon[] polygons)
	{
		Polygons pgs=new Polygons(polygons);
		return -1d*pgs.countRegions();
	}
	
	public RegionsPositronicPolygonArray(int dimension)
	{
		super(dimension);
	}
	
	public RegionsPositronicPolygonArray(PositronicPolygon[] polygons)
	{
		super(polygons);
	}
}

