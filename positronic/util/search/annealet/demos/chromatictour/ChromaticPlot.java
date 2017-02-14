package positronic.util.search.annealet.demos.chromatictour;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import positronic.awt.geometry.Point;
import positronic.util.search.annealet.IIngot;


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
public class ChromaticPlot extends JFrame {
	private static final long serialVersionUID = 2747270037344968206L;
	private JPanel jPanel1;
	private JPanel jPanel3;
	private JPanel jPanel2;
	private IIngot best;
	
	
	public ChromaticPlot(IIngot best)
	{
		super();
		this.best=best;
		initGUI();
	}
	
	
	
	private void initGUI() {
		try {
			BoxLayout thisLayout = new BoxLayout(getContentPane(), javax.swing.BoxLayout.Y_AXIS);
			getContentPane().setLayout(thisLayout);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				jPanel1 = new JPanel();
				getContentPane().add(jPanel1);
			}
			{
				jPanel2 = new ChromaticPlotJPanel(1000)
				{
					private static final long serialVersionUID = 8202884634130117916L;

					public void update(Graphics g)
					{
						this.setGraphics2D(g);
						this.clearRect(10,10,300,300, Color.white);
						this.locate(10,10,300,300);
						this.scale(-2.,2.,-2.,2.);
						this.pen(Color.magenta);
						this.axes(.2,.2,0.,0.,1,1);
						this.pen(Color.black);
						this.move(0.,0.);
						for(Point p : (Ingot)best)
						{
							this.move(p.x,p.y);
							this.draw(p.x,p.y);
						}
						this.pen(Color.black);
						this.frame();
					}
				};
				getContentPane().add(jPanel2);
			}
			{
				jPanel3 = new JPanel();
				getContentPane().add(jPanel3);
			}
			pack();
			this.setLocation(0,0);
			setSize(40, 300);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
