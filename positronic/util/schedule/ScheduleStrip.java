package positronic.util.schedule;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

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
public class ScheduleStrip extends JPanel
{
	private static final long serialVersionUID = -6463006624156737432L;
	private JPanel jPanel2;
	private JPanel jPanel1;
	private JPanel datemarker;
	private JLabel jLabel1;
	private String taskLabel;
	private int xPosition;
	
	public ScheduleStrip(String taskLabel,int xPosition)
	{
		this.taskLabel=taskLabel;
		this.xPosition=xPosition;
		initGUI();
	}

	private void initGUI() {
		try {
			{
				this.setLayout(null);
				this.setPreferredSize(new java.awt.Dimension(642, 31));
				{
					jPanel1 = new JPanel();
					this.add(jPanel1);
					jPanel1.setBounds(0, 0, 178, 31);
					jPanel1.setBackground(new java.awt.Color(0,255,255));
					jPanel1.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
					{
						jLabel1 = new JLabel();
						jPanel1.add(jLabel1);
						jLabel1.setText(this.taskLabel);
						jLabel1.setPreferredSize(new java.awt.Dimension(163, 19));
						jLabel1.setFont(new java.awt.Font("Arial",0,14));
					}
				}
				{
					jPanel2 = new JPanel();
					this.add(jPanel2);
					jPanel2.setBounds(178, 0, 464, 31);
					jPanel2.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
					jPanel2.setLayout(null);
					{
						datemarker = new JPanel();
						jPanel2.add(datemarker);
						datemarker.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0,0,0)));
						datemarker.setBackground(new java.awt.Color(255,0,128));
						datemarker.setBounds(this.xPosition, 5, 5, 24);
					}
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
