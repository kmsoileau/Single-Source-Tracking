package positronic.awt;

import javax.swing.BoxLayout;
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
public class FlashingToggleButtonDemo extends javax.swing.JFrame 
{
	private static final long serialVersionUID = -5884900377251691419L;
	private FlashingToggleButton flashingToggleButton3;
	private FlashingToggleButton flashingToggleButton1;
	private FlashingToggleButton flashingToggleButton2;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) 
	{
		SwingUtilities.invokeLater(new Runnable() 
		{
			public void run() 
			{
				FlashingToggleButtonDemo inst = new FlashingToggleButtonDemo();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public FlashingToggleButtonDemo() 
	{
		super();
		initGUI();
	}
	
	private void initGUI() 
	{
		try 
		{
			BoxLayout thisLayout = new BoxLayout(getContentPane(), javax.swing.BoxLayout.Y_AXIS);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(thisLayout);
			{
				flashingToggleButton1 = new FlashingToggleButton();
				getContentPane().add(flashingToggleButton1);
				flashingToggleButton1.setText("jToggleButton1");
			}
			{
				flashingToggleButton2 = new FlashingToggleButton();
				getContentPane().add(flashingToggleButton2);
				flashingToggleButton2.setText("jToggleButton1");
			}
			{
				flashingToggleButton3 = new FlashingToggleButton();
				getContentPane().add(flashingToggleButton3);
				flashingToggleButton3.setText("jToggleButton1");
			}
			pack();
			setSize(400, 300);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
