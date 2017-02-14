package positronic.awt;
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
public class RunnablePlotJPanelDemo extends JFrame {
	private static final long serialVersionUID = 2747270037344968206L;
	private JPanel jPanel1;
	private JPanel jPanel3;
	private JPanel jPanel2;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				RunnablePlotJPanelDemo inst = new RunnablePlotJPanelDemo();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public RunnablePlotJPanelDemo() {
		super();
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
				jPanel2 = new RunnablePlotJPanel(1000)
				{
					private static final long serialVersionUID = 8202884634130117916L;

					public void update(Graphics g)
					{
						this.setGraphics2D(g);
						this.locate(10,10,170,70);
						
						this.pen(Color.green);
						this.scale(0.,7.,-1.,1.);
						this.axes(.1,.1,0.,0.);
						this.move(0.,0.);
						for(double x=0.;x<7;x+=.1)
							this.draw(x,Math.sin(x));
						this.pen(Color.blue);
						this.move(0.,0.);
						for(double x=0.;x<7;x+=.1)
							this.draw(x,Math.cos(x));
						this.pen(Color.red);
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
			setSize(400, 300);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
