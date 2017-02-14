package positronic.awt;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ShapleyLayout implements LayoutManager, java.io.Serializable
{
	private static final long serialVersionUID = -4785407023257437832L;

	public void addLayoutComponent(String name, Component comp)
	{
		// TODO Auto-generated method stub
	}

	/*public void layoutContainer(Container parent)
	{
		int nmembers = parent.getComponentCount();
		System.out.println("There are "+nmembers+" components.");
		List<Component> compList=Arrays.asList(parent.getComponents());
		Collections.shuffle(compList);
		
		Dimension nextAvailableCorner=new Dimension(0,0);
		for(int i = 0 ; i < nmembers ; i++) 
		{
			Component m = compList.get(i);
			if (m.isVisible()) 
			{
				Dimension d = m.getPreferredSize();
				m.setSize(d.width, d.height);
			}
		}
	}*/
	
	public void layoutContainer(Container parent)
	{
		int nmembers = parent.getComponentCount();
		System.out.println("There are "+nmembers+" components.");
		List<Component> compList=Arrays.asList(parent.getComponents());
		Collections.shuffle(compList);
		
		for(Component m : compList) 
		{
			if(m.isVisible()) 
			{
				Dimension d = m.getPreferredSize();
				m.setSize(d.width, d.height);
				m.setLocation((int)(Math.random()*100.),(int)(Math.random()*100.));
				System.out.println("Setting "+m+" to size "+m.getSize());
			}
		}
	}
	
	
	public Dimension minimumLayoutSize(Container parent)
	{
		// TODO Auto-generated method stub
		return null;
	}

	public Dimension preferredLayoutSize(Container parent)
	{
		// TODO Auto-generated method stub
		return null;
	}

	public void removeLayoutComponent(Component comp)
	{
		// TODO Auto-generated method stub
	}
}
