package positronic.awt;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
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
public class CheckBoxJApplet extends JApplet 
{
	private static final long serialVersionUID = 6695339003704393422L;

	/**
	* Auto-generated main method to display this 
	* JApplet inside a new JFrame.
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new JFrame();
				CheckBoxJApplet inst = new CheckBoxJApplet();
				frame.getContentPane().add(inst);
				((JComponent)frame.getContentPane()).setPreferredSize(inst.getSize());
				frame.pack();
				frame.setVisible(true);
			}
		});

	}
	private JButton jButton1;
	private JCheckBox jCheckBox2;
	private JCheckBox jCheckBox6;
	private JCheckBox jCheckBox5;
	private JCheckBox jCheckBox4;
	private JCheckBox jCheckBox3;
	private JPanel jPanel1;

	private JCheckBox jCheckBox1;
	
	public CheckBoxJApplet() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			BoxLayout thisLayout = new BoxLayout(getContentPane(), javax.swing.BoxLayout.Y_AXIS);
			getContentPane().setLayout(thisLayout);
			this.setSize(291, 400);
			{
				jPanel1 = new JPanel();
				BoxLayout jPanel1Layout = new BoxLayout(jPanel1, javax.swing.BoxLayout.Y_AXIS);
				jPanel1.setLayout(jPanel1Layout);
				getContentPane().add(jPanel1);
				jPanel1.setPreferredSize(new java.awt.Dimension(127, 100));
				{
					jCheckBox1 = new JCheckBox();
					jPanel1.add(jCheckBox1);
					jCheckBox1.setText("jCheckBox1");
					jCheckBox1.addItemListener(new ItemListener() {
						public void itemStateChanged(ItemEvent evt) {
							if(evt.getStateChange()==ItemEvent.SELECTED)
								System.out.println("Item selected: "+((JCheckBox)evt.getSource()).getText());
							else
								System.out.println("Item deselected: "+((JCheckBox)evt.getSource()).getText());
							
							
							
						}
					});
				}
				{
					jCheckBox2 = new JCheckBox();
					jPanel1.add(jCheckBox2);
					jCheckBox2.setLayout(null);
					jCheckBox2.setText("jCheckBox2");
					jCheckBox2.setPreferredSize(new java.awt.Dimension(191, 20));
					jCheckBox2.addItemListener(new ItemListener() {
						public void itemStateChanged(ItemEvent evt) {
							if(evt.getStateChange()==ItemEvent.SELECTED)
								System.out.println("Item selected: "+((JCheckBox)evt.getSource()).getText());
							else
								System.out.println("Item deselected: "+((JCheckBox)evt.getSource()).getText());
							
							
							
						}
					});
				}
				{
					jCheckBox3 = new JCheckBox();
					jPanel1.add(jCheckBox3);
					jCheckBox3.setText("jCheckBox3");
					jCheckBox3.setLayout(null);
					jCheckBox3.addItemListener(new ItemListener() {
						public void itemStateChanged(ItemEvent evt) {
							if(evt.getStateChange()==ItemEvent.SELECTED)
								System.out.println("Item selected: "+((JCheckBox)evt.getSource()).getText());
							else
								System.out.println("Item deselected: "+((JCheckBox)evt.getSource()).getText());
							
							
							
						}
					});
				}
				{
					jCheckBox4 = new JCheckBox();
					jPanel1.add(jCheckBox4);
					jCheckBox4.setText("jCheckBox4");
					jCheckBox4.setLayout(null);
					jCheckBox4.addItemListener(new ItemListener() {
						public void itemStateChanged(ItemEvent evt) {
							if(evt.getStateChange()==ItemEvent.SELECTED)
								System.out.println("Item selected: "+((JCheckBox)evt.getSource()).getText());
							else
								System.out.println("Item deselected: "+((JCheckBox)evt.getSource()).getText());
							
							
							
						}
					});
				}
				{
					jCheckBox5 = new JCheckBox();
					jPanel1.add(jCheckBox5);
					jCheckBox5.setText("jCheckBox5");
					jCheckBox5.setLayout(null);
					jCheckBox5.addItemListener(new ItemListener() {
						public void itemStateChanged(ItemEvent evt) {
							if(evt.getStateChange()==ItemEvent.SELECTED)
								System.out.println("Item selected: "+((JCheckBox)evt.getSource()).getText());
							else
								System.out.println("Item deselected: "+((JCheckBox)evt.getSource()).getText());
							
							
							
						}
					});
				}
				{
					jCheckBox6 = new JCheckBox();
					jPanel1.add(jCheckBox6);
					jCheckBox6.setText("jCheckBox6");
					jCheckBox6.setLayout(null);
					jCheckBox6.addItemListener(new ItemListener() {
						public void itemStateChanged(ItemEvent evt) {
							if(evt.getStateChange()==ItemEvent.SELECTED)
								System.out.println("Item selected: "+((JCheckBox)evt.getSource()).getText());
							else
								System.out.println("Item deselected: "+((JCheckBox)evt.getSource()).getText());
							
							
							
						}
					});
				}
			}
			{
				jButton1 = new JButton();
				getContentPane().add(jButton1);
				jButton1.setText("Refresh");
				jButton1.addMouseListener(new MouseAdapter() {
					public void mouseReleased(MouseEvent mevt)
					{
						System.out.println("Mouse released");
					}
				});
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

