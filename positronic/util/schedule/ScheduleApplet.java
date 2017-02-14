package positronic.util.schedule;

import java.applet.Applet;

import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class ScheduleApplet extends Applet 
{
	private static final long serialVersionUID = 3377716622271809540L;
	
	public static void main(String[] args) 
	{
		SwingUtilities.invokeLater(
				new Runnable() 
				{
					public void run() 
					{
						JFrame frame = new JFrame();
						frame.setTitle("Schedule Chart");
						ScheduleJApplet inst = new ScheduleJApplet();
						frame.getContentPane().add(inst);
						((JComponent)frame.getContentPane()).setPreferredSize(inst.getSize());
						frame.pack();
						frame.setVisible(true);
					}
				}
				);
	}
	
	private ScheduleStrip jPanel1;
	private ScheduleStrip jPanel4;
	private ScheduleStrip jPanel3;
	private ScheduleStrip jPanel2;
	
	public ScheduleApplet() 
	{
		super();
		initGUI();
	}
	
	private void initGUI() 
	{
		try 
		{
			BoxLayout thisLayout = new BoxLayout(this, javax.swing.BoxLayout.Y_AXIS);
			this.setLayout(thisLayout);
			this.setSize(846, 312);
			{
				jPanel1 = new ScheduleStrip("A",315);
				this.add(jPanel1);
				jPanel1.setBackground(new java.awt.Color(255,255,255));
			}
			{
				jPanel2 = new ScheduleStrip("B",215);
				this.add(jPanel2);
				jPanel2.setBackground(new java.awt.Color(255,255,255));
			}
			{
				jPanel3 = new ScheduleStrip("C",115);
				this.add(jPanel3);
				jPanel3.setBackground(new java.awt.Color(255,255,255));
			}
			{
				jPanel4 = new ScheduleStrip("D",11);
				this.add(jPanel4);
				jPanel4.setBackground(new java.awt.Color(255,255,255));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
