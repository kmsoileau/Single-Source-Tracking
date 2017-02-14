package positronic.awt.geometry;

import java.util.List;

public interface IRegion 
{
	void clear() ;
	boolean contains(Point p);
	boolean exclude(IPolygon o); 
	IPolygon getExcluded(int i); 
	List<IPolygon> getExcludedPolygons(); 
	IPolygon getIncluded(int i); 
	List<IPolygon> getIncludedPolygons(); 
	boolean include(IPolygon o); 
	boolean isEmpty(); 
	boolean isExcluded(IPolygon o);
	boolean isIncluded(IPolygon o); 
	boolean remove(IPolygon o); 
	int size();
	IPolygon[] toExcludesArray();
	IPolygon[] toIncludesArray();
	String toString();
}

