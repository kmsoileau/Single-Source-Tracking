package positronic.awt.inside;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import positronic.awt.RunnablePlotPanel;


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
public class NewJFrame extends javax.swing.JFrame {
	private static final long serialVersionUID = 4145311925837936256L;
	private MyPlotPanel jPanel1;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				NewJFrame inst = new NewJFrame();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public NewJFrame() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				jPanel1 = new MyPlotPanel();
				getContentPane().add(jPanel1, BorderLayout.CENTER);
			}
			pack();
			setSize(400, 300);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

class MyPlotPanel extends RunnablePlotPanel
{
	private static final long serialVersionUID = 3155114310964164849L;

	@Override
	public void update(Graphics g)
	{
		this.setGraphics2D(g);
		this.setBackground(Color.BLUE);
		this.setForeground(Color.WHITE);
		this.draw("Kerry", 43,45);
		this.move_p(56,134);
		this.draw_p(157,39);
	}
	
}
