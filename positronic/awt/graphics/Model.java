package positronic.awt.graphics;

import java.util.ArrayList;

public class Model
{
	private ArrayList<Segment> segments;
	private Controller controller;

	public Model(Controller controller) 
	{
		this.segments=new ArrayList<Segment>();
	}

	void addPoint(Point p)
	{
		this.controller.modelChanged();
	}
	
	void addSegment(Segment p)
	{
		this.segments.add(p);
		this.controller.modelChanged();
	}

	void clearPoints()
	{
		this.controller.modelChanged();
	}

	void clearSegments()
	{
		segments.clear();
		controller.modelChanged();
	}
	
	void deletePoint(Point p)
	{
		this.controller.modelChanged();
	}
	
	void deleteSegment(Segment p)
	{
		segments.remove(p);
		controller.modelChanged();
	}
	
	public Controller getController() 
	{
		return controller;
	}
	
	public ArrayList<Segment> getSegments() 
	{
		return segments;
	}
	
	public void setController(Controller controller) 
	{
		this.controller = controller;
	}
	
	public void setSegments(ArrayList<Segment> segments) 
	{
		this.segments = segments;
	}
}
