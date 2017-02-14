package positronic.util.onepass;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;
import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class OnePassApplet extends Applet 
{
	private static final long serialVersionUID = -952467706254305872L;
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new JFrame();
				OnePassApplet inst = new OnePassApplet();
				frame.getContentPane().add(inst);
				frame.setPreferredSize(inst.getSize());
				frame.pack();
				frame.setVisible(true);
			}
		});
	}
	
	private Panel jPanel1;
	private Button jButton1;
	private Label jLabel3;
	private Panel jPanel5;
	private TextField jTextField3;
	private Panel jPanel4;
	private Panel jPanel3;
	private TextField jTextField2;
	private TextField jTextField1;
	private Label jLabel1;
	private Panel jPanel2;
	
	public OnePassApplet() 
	{
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setSize(new Dimension(400, 190));
			{
				jPanel1 = new Panel();
				this.add(jPanel1);
				{
					jLabel1 = new Label();
					jPanel1.add(jLabel1);
					jLabel1.setText("OnePass Password Generator 1.0");
				}
				{
					jLabel3 = new Label();
					jPanel1.add(jLabel3);
					jLabel3.setText("by Kerry M. Soileau");
				}
			}
			{
				jPanel2 = new Panel();
				FlowLayout jPanel2Layout = new FlowLayout();
				jPanel2.setLayout(jPanel2Layout);
				this.add(jPanel2);
				{
					jTextField1 = new TextField();
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
				jPanel3 = new Panel();
				this.add(jPanel3);
				{
					jTextField2 = new TextField();
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
				jPanel4 = new Panel();
				FlowLayout jPanel4Layout = new FlowLayout();
				this.add(jPanel4);
				jPanel4.setLayout(jPanel4Layout);
				{
					jTextField3 = new TextField();
					jPanel4.add(jTextField3);
					jTextField3.setText("generated password");
					jTextField3.setEditable(false);
					jTextField3.setBackground(new java.awt.Color(0,255,128));
				}
			}
			{
				jPanel5 = new Panel();
				this.add(jPanel5);
				jPanel5.setBounds(241, -21, 10, 10);
				{
					jButton1 = new Button();
					jPanel5.add(jButton1);
					jButton1.setLabel("Generate Password");
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
