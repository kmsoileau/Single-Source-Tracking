package positronic.awt.graphics;

public class Controller 
{
	private Model model;
	private View view;
	
	public Controller() 
	{
	}

	public Model getModel() 
	{
		return model;
	}

	public View getView() 
	{
		return view;
	}

	public void modelChanged() 
	{
		view.repaint();
	}

	public void setModel(Model m) 
	{
		this.model=m;
		m.setController(this);
	}

	public void setView(View v) 
	{
		this.view=v;
		v.setController(this);
	}
}
