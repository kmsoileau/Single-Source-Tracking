package positronic.util.onepass;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;
import java.net.UnknownHostException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class OnePassJApplet extends javax.swing.JApplet 
{
	private static final long serialVersionUID = -952467706254305872L;
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new JFrame();
				OnePassJApplet inst = new OnePassJApplet();
				frame.getContentPane().add(inst);
				((JComponent)frame.getContentPane()).setPreferredSize(inst.getSize());
				frame.pack();
				frame.setVisible(true);
			}
		});
	}
	
	private JPanel jPanel1;
	private JButton jButton1;
	private JLabel jLabel3;
	private JPanel jPanel5;
	private JTextField jTextField3;
	private JPanel jPanel4;
	private JPanel jPanel3;
	private JTextField jTextField2;
	private JTextField jTextField1;
	private JLabel jLabel1;
	private JPanel jPanel2;
	
	public OnePassJApplet() 
	{
		super();
		initGUI();
	}
	
	private void initGUI() 
	{
		try {
			BoxLayout thisLayout = new BoxLayout(getContentPane(), javax.swing.BoxLayout.Y_AXIS);
			getContentPane().setLayout(thisLayout);
			setSize(new Dimension(400, 190));
			{
				jPanel1 = new JPanel();
				getContentPane().add(jPanel1);
				{
					jLabel1 = new JLabel();
					jPanel1.add(jLabel1);
					jLabel1.setText("OnePass Password Generator 1.0");
				}
				{
					jLabel3 = new JLabel();
					jPanel1.add(jLabel3);
					jLabel3.setText("by Kerry M. Soileau");
				}
			}
			{
				jPanel2 = new JPanel();
				FlowLayout jPanel2Layout = new FlowLayout();
				jPanel2.setLayout(jPanel2Layout);
				getContentPane().add(jPanel2);
				{
					jTextField1 = new JTextField();
					jPanel2.add(jTextField1);
					jTextField1.setText("enter personal number");
					jTextField1.addMouseListener(new MouseAdapter() {

						@Override
						public void mouseReleased(MouseEvent e)
						{
							// TODO Auto-generated method stub
							//super.mouseReleased(e);
							jTextField1.setText("");
						}
					});
				}
			}
			{
				jPanel3 = new JPanel();
				getContentPane().add(jPanel3);
				{
					jTextField2 = new JTextField();
					jPanel3.add(jTextField2);
					jTextField2.setText("enter URL of site");
					jTextField2.setPreferredSize(new java.awt.Dimension(345, 21));
					jTextField2.addMouseListener(new MouseAdapter() {

						@Override
						public void mouseReleased(MouseEvent e)
						{
							// TODO Auto-generated method stub
							//super.mouseReleased(e);
							jTextField2.setText("");
						}
					});
				}
			}
			{
				jPanel4 = new JPanel();
				FlowLayout jPanel4Layout = new FlowLayout();
				getContentPane().add(jPanel4);
				jPanel4.setLayout(jPanel4Layout);
				{
					jTextField3 = new JTextField();
					jPanel4.add(jTextField3);
					jTextField3.setText("generated password");
					jTextField3.setHorizontalAlignment(SwingConstants.CENTER);
					jTextField3.setEditable(false);
				}
			}
			{
				jPanel5 = new JPanel();
				getContentPane().add(jPanel5);
				jPanel5.setBounds(241, -21, 10, 10);
				{
					jButton1 = new JButton();
					jPanel5.add(jButton1);
					jButton1.setText("Generate Password");
					jButton1.setBounds(113, 33, 165, 21);
					jButton1.addMouseListener(new MouseAdapter() {
						
						public void mouseReleased(MouseEvent e)
						{
							// TODO Auto-generated method stub
							//super.mouseReleased(e);
							try
							{
								jTextField3.setText(OnePass.strongPassGen(Long.parseLong(jTextField1.getText()),jTextField2.getText()));
							} catch (MalformedURLException e1)
							{
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (UnknownHostException e1)
							{
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					});
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
