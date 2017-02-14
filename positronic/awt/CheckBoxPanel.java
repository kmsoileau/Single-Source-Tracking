package positronic.awt;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.Component;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.SwingUtilities;

public class CheckBoxPanel extends java.awt.Panel 
{
	private static final long serialVersionUID = 2612576637358180491L;

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Frame frame = new Frame();
				CheckBoxPanel inst = new CheckBoxPanel();
				frame.add(inst);
				((Component)frame).setPreferredSize(inst.getSize());
				frame.pack();
				frame.setVisible(true);
			}
		});

	}
	private Button jButton1;
	private Checkbox jCheckbox2;
	private Checkbox jCheckbox6;
	private Checkbox jCheckbox5;
	private Checkbox jCheckbox4;
	private Checkbox jCheckbox3;
	private Panel jPanel1;

	private Checkbox jCheckbox1;
	
	public CheckBoxPanel() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			BoxLayout thisLayout = new BoxLayout(this, javax.swing.BoxLayout.Y_AXIS);
			this.setLayout(thisLayout);
			this.setSize(291, 400);
			{
				jPanel1 = new Panel();
				BoxLayout jPanel1Layout = new BoxLayout(jPanel1, javax.swing.BoxLayout.Y_AXIS);
				jPanel1.setLayout(jPanel1Layout);
				this.add(jPanel1);
				jPanel1.setPreferredSize(new java.awt.Dimension(127, 100));
				{
					jCheckbox1 = new Checkbox();
					jPanel1.add(jCheckbox1);
					jCheckbox1.setLabel("jCheckbox1");
					jCheckbox1.addItemListener(new ItemListener() {
						public void itemStateChanged(ItemEvent evt) {
							if(evt.getStateChange()==ItemEvent.SELECTED)
								System.out.println("Item selected: "+((Checkbox)evt.getSource()).getLabel());
							else
								System.out.println("Item deselected: "+((Checkbox)evt.getSource()).getLabel());
						}
					});
				}
				{
					jCheckbox2 = new Checkbox();
					jPanel1.add(jCheckbox2);
					//jCheckbox2.setLayout(null);
					jCheckbox2.setLabel("jCheckbox2");
					jCheckbox2.setPreferredSize(new java.awt.Dimension(191, 20));
					jCheckbox2.addItemListener(new ItemListener() {
						public void itemStateChanged(ItemEvent evt) {
							if(evt.getStateChange()==ItemEvent.SELECTED)
								System.out.println("Item selected: "+((Checkbox)evt.getSource()).getLabel());
							else
								System.out.println("Item deselected: "+((Checkbox)evt.getSource()).getLabel());
							
							
							
						}
					});
				}
				{
					jCheckbox3 = new Checkbox();
					jPanel1.add(jCheckbox3);
					jCheckbox3.setLabel("jCheckbox3");
					//jCheckbox3.setLayout(null);
					jCheckbox3.addItemListener(new ItemListener() {
						public void itemStateChanged(ItemEvent evt) {
							if(evt.getStateChange()==ItemEvent.SELECTED)
								System.out.println("Item selected: "+((Checkbox)evt.getSource()).getLabel());
							else
								System.out.println("Item deselected: "+((Checkbox)evt.getSource()).getLabel());
							
							
							
						}
					});
				}
				{
					jCheckbox4 = new Checkbox();
					jPanel1.add(jCheckbox4);
					jCheckbox4.setLabel("jCheckbox4");
					//jCheckbox4.setLayout(null);
					jCheckbox4.addItemListener(new ItemListener() {
						public void itemStateChanged(ItemEvent evt) {
							if(evt.getStateChange()==ItemEvent.SELECTED)
								System.out.println("Item selected: "+((Checkbox)evt.getSource()).getLabel());
							else
								System.out.println("Item deselected: "+((Checkbox)evt.getSource()).getLabel());
							
							
							
						}
					});
				}
				{
					jCheckbox5 = new Checkbox();
					jPanel1.add(jCheckbox5);
					jCheckbox5.setLabel("jCheckbox5");
					//jCheckbox5.setLayout(null);
					jCheckbox5.addItemListener(new ItemListener() {
						public void itemStateChanged(ItemEvent evt) {
							if(evt.getStateChange()==ItemEvent.SELECTED)
								System.out.println("Item selected: "+((Checkbox)evt.getSource()).getLabel());
							else
								System.out.println("Item deselected: "+((Checkbox)evt.getSource()).getLabel());
							
							
							
						}
					});
				}
				{
					jCheckbox6 = new Checkbox();
					jPanel1.add(jCheckbox6);
					jCheckbox6.setLabel("jCheckbox6");
					//jCheckbox6.setLayout(null);
					jCheckbox6.addItemListener(new ItemListener() {
						public void itemStateChanged(ItemEvent evt) {
							if(evt.getStateChange()==ItemEvent.SELECTED)
								System.out.println("Item selected: "+((Checkbox)evt.getSource()).getLabel());
							else
								System.out.println("Item deselected: "+((Checkbox)evt.getSource()).getLabel());
							
							
							
						}
					});
				}
			}
			{
				jButton1 = new Button();
				this.add(jButton1);
				jButton1.setLabel("Refresh");
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