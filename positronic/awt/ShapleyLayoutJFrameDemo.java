package positronic.awt;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;

/**
 * This code was edited or generated using CloudGarden's Jigloo SWT/Swing GUI
 * Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose
 * whatever) then you should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details. Use of Jigloo implies
 * acceptance of these licensing terms. A COMMERCIAL LICENSE HAS NOT BEEN
 * PURCHASED FOR THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED LEGALLY FOR
 * ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
public class ShapleyLayoutJFrameDemo extends javax.swing.JFrame {
	private static final long serialVersionUID = -1842425909687736308L;
	private JPanel jPanel1;
	private JPanel jPanel5;
	private JPanel jPanel4;
	private JPanel jPanel3;
	private JPanel jPanel2;

	/**
	 * Auto-generated main method to display this JFrame
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				ShapleyLayoutJFrameDemo inst = new ShapleyLayoutJFrameDemo();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

	public ShapleyLayoutJFrameDemo() {
		super();
		initGUI();
	}

	private void initGUI() {
		try {
			ShapleyLayout thisLayout = new ShapleyLayout();
			getContentPane().setLayout(thisLayout);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				jPanel1 = new JPanel();
				getContentPane().add(jPanel1);
				jPanel1.setBorder(BorderFactory
						.createEtchedBorder(BevelBorder.LOWERED));
			}
			{
				jPanel2 = new JPanel();
				getContentPane().add(jPanel2);
				jPanel2.setBorder(BorderFactory
						.createEtchedBorder(BevelBorder.LOWERED));
			}
			{
				jPanel3 = new JPanel();
				getContentPane().add(jPanel3);
				jPanel3.setBorder(BorderFactory
						.createEtchedBorder(BevelBorder.LOWERED));
			}
			{
				jPanel4 = new JPanel();
				getContentPane().add(jPanel4);
				jPanel4.setBorder(BorderFactory
						.createEtchedBorder(BevelBorder.LOWERED));
			}
			{
				jPanel5 = new JPanel();
				getContentPane().add(jPanel5);
				jPanel5.setBorder(BorderFactory
						.createEtchedBorder(BevelBorder.LOWERED));
			}

			// pack();
			setSize(400, 300);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
