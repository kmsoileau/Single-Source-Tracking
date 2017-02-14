package positronic.awt.plotting;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/

public class RunnablePlotJPanelDemo extends JFrame 
{
	private static final long serialVersionUID = 2747270037344968206L;
	
	public static void main(String[] args) 
	{
		draw();
	}
	
	public static void draw()
	{
		SwingUtilities.invokeLater(new Runnable() 
		{
			public void run() 
			{
				RunnablePlotJPanelDemo inst = new RunnablePlotJPanelDemo();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	
	public RunnablePlotJPanelDemo() 
	{
		int sizeX=400;
		int sizeY=300;
		RunnablePlotJPanel runnablePlotJPanel=new RunnablePlotJPanel(1000)
		{
			private static final long serialVersionUID = 8202884634130117916L;

			public void update(Graphics g)
			{
				this.setGraphics2D(g);
				this.locate(10,10,170,70);
				this.scale(0.,7.,-1.,1.);
				this.pen(Color.magenta);
				//this.axes(.2,.2,0.,0.,35,85);
				this.axes(.2,.2,0.,0.,1,1);
				this.pen(Color.green);
				this.move(0.,0.);
				double f=Math.random();
				for(double x=0.;x<7;x+=.1)
					this.draw(x,Math.sin(x+f));
				this.pen(Color.blue);
				this.move(0.,0.);
				for(double x=0.;x<7;x+=.1)
					this.draw(x,Math.cos(x));
				this.pen(Color.black);
				this.frame();
			}
		};
		{
			BoxLayout thisLayout = new BoxLayout(getContentPane(), javax.swing.BoxLayout.Y_AXIS);
			getContentPane().setLayout(thisLayout);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().add(new JPanel());
			getContentPane().add(runnablePlotJPanel);
			getContentPane().add(new JPanel());
			pack();
			setSize(sizeX,sizeY);
		}
	}
}
