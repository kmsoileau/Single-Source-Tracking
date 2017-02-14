package positronic.util;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BoxLayout;
import javax.swing.JApplet;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import positronic.util.finance.PriceReader;

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
public class StockAlarm extends JApplet
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1517864350214328741L;
	private JTextField StockID;
	private JLabel TripValueLabel;
	private JTextField TripValue;
	private JLabel StockLabel;

	private void initGUI() {
		try {
			{
				BoxLayout thisLayout = new BoxLayout(getContentPane(), javax.swing.BoxLayout.Y_AXIS);
				getContentPane().setLayout(thisLayout);
				this.setSize(86, 93);
				{
					StockLabel = new JLabel();
					getContentPane().add(StockLabel);
					StockLabel.setText("Stock ID");
					StockLabel.setPreferredSize(new java.awt.Dimension(54, 14));
					StockLabel.setHorizontalAlignment(SwingConstants.CENTER);
				}
				{
					StockID = new JTextField();
					getContentPane().add(StockID);
					StockID.setText("MSFT");
					StockID.setHorizontalAlignment(SwingConstants.CENTER);
					StockID.setPreferredSize(new java.awt.Dimension(51, 21));
					StockID.addKeyListener(new KeyAdapter() {

						public void keyReleased(KeyEvent e)
						{
							// TODO Auto-generated method stub
							super.keyReleased(e);
							if(e.getKeyCode()==10)/*Return*/
							{
								
							}
						}
					});
				}
				{
					TripValueLabel = new JLabel();
					getContentPane().add(TripValueLabel);
					TripValueLabel.setText("Trip Value");
					TripValueLabel.setHorizontalAlignment(SwingConstants.CENTER);
				}
				{
					TripValue = new JTextField();
					getContentPane().add(TripValue);
					TripValue.setText("30.00");
					TripValue.setHorizontalAlignment(SwingConstants.CENTER);
					TripValue.addKeyListener(new KeyAdapter() {
						public void keyReleased(KeyEvent e)
						{
							// TODO Auto-generated method stub
							super.keyReleased(e);
							if(e.getKeyCode()==10)/*Return*/
							{
								try
								{
									System.out.println(PriceReader.quote(StockID.getText()));
								} catch (Exception e1)
								{
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								
							}
						}
					});
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public StockAlarm()
	{
		super();
		initGUI();
	}
	
	
}
