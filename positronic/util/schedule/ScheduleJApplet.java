package positronic.util.schedule;

import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;


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
public class ScheduleJApplet extends javax.swing.JApplet {
	private static final long serialVersionUID = 3377716622271809540L;
	private ScheduleStrip jPanel1;
	private ScheduleStrip jPanel4;
	private ScheduleStrip jPanel3;
	private ScheduleStrip jPanel2;

	/**
	* Auto-generated main method to display this 
	* JApplet inside a new JFrame.
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new JFrame();
				ScheduleJApplet inst = new ScheduleJApplet();
				frame.getContentPane().add(inst);
				((JComponent)frame.getContentPane()).setPreferredSize(inst.getSize());
				frame.pack();
				frame.setVisible(true);
			}
		});
	}
	
	public ScheduleJApplet() 
	{
		super();
		initGUI();
	}
	
	private void initGUI() 
	{
		try 
		{
			BoxLayout thisLayout = new BoxLayout(getContentPane(), javax.swing.BoxLayout.Y_AXIS);
			getContentPane().setLayout(thisLayout);
			this.setSize(846, 312);
			{
				jPanel1 = new ScheduleStrip("A",315);
				getContentPane().add(jPanel1);
				jPanel1.setBackground(new java.awt.Color(255,255,255));
			}
			{
				jPanel2 = new ScheduleStrip("B",215);
				getContentPane().add(jPanel2);
				jPanel2.setBackground(new java.awt.Color(255,255,255));
			}
			{
				jPanel3 = new ScheduleStrip("C",115);
				getContentPane().add(jPanel3);
				jPanel3.setBackground(new java.awt.Color(255,255,255));
			}
			{
				jPanel4 = new ScheduleStrip("D",11);
				getContentPane().add(jPanel4);
				jPanel4.setBackground(new java.awt.Color(255,255,255));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
