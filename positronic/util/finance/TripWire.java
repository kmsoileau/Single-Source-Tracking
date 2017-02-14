package positronic.util.finance;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

class Stock
{
	JTextField tfStock;
	JLabel lLastQuote;
	JTextField tfTrip;
	double previousValue;
	
	Stock(JLabel lastQuote, double previousValue, JTextField tfStock,
			JTextField tfTrip)
	{
		super();
		lLastQuote = lastQuote;
		this.previousValue = previousValue;
		this.tfStock = tfStock;
		this.tfTrip = tfTrip;
	}

	void silenceAlarm()
	{
		this.tfStock.setBackground(Color.white);
	}
	
	void soundAlarm(Color color)
	{
		this.tfStock.setBackground(color);
	}
}

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
public class TripWire extends JFrame implements Runnable
{
	private static final long serialVersionUID = -7040948643847455849L;
	//private static final long QUOTECYCLEINMILLIS = 60000;
	
	public static void main(String[] args) 
	{
		SwingUtilities.invokeLater(new Runnable() 
		{
			public void run() 
			{
				Properties props = new Properties();
				props.setProperty("QUOTECYCLEINMILLIS", "60000");
				props.setProperty("stock1", "MSFT");
				props.setProperty("stock2", "APA");
				props.setProperty("stock3", "DWRI");
				props.setProperty("stock4", "SSY");
				props.setProperty("stock5", "IBM");
				props.setProperty("stock6", "ADVS");
				props.setProperty("stock7", "MELI");
				props.setProperty("stock8", "GOLD");
				props.setProperty("stock9", "APC");
				props.setProperty("tripvalue1", "20");
				props.setProperty("tripvalue2", "84");
				props.setProperty("tripvalue3", "1");
				props.setProperty("tripvalue4", "2");
				props.setProperty("tripvalue5", "1");
				props.setProperty("tripvalue6", "30");
				props.setProperty("tripvalue7", "20");
				props.setProperty("tripvalue8", "26");
				props.setProperty("tripvalue9", "48");
				TripWire inst = new TripWire(props);
				
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

	private Stock stock1;
	private Stock stock2;
	private Stock stock3;
	private Stock stock4;
	private Stock stock5;
	private Stock stock6;
	private Stock stock7;
	private Stock stock8;
	private Stock stock9;
	private JLabel lStock;
	private JTextField tfTrip9;
	private JTextField tfTrip8;

	private JTextField tfTrip7;
	private JTextField tfTrip6;
	private JTextField tfTrip5;
	private JTextField tfTrip4;
	private JTextField tfTrip3;
	private JTextField tfTrip2;
	private JTextField tfTrip1;
	private JLabel lLastQuote9;
	private JLabel lLastQuote8;
	private JLabel lLastQuote7;
	private JLabel lLastQuote6;
	private JLabel lLastQuote5;
	private JLabel lLastQuote4;
	private JLabel lLastQuote;
	private JLabel lLastQuote3;
	private JLabel lLastQuote2;
	private JLabel lLastQuote1;
	private JToggleButton jToggleButton8;
	private JToggleButton jToggleButton7;
	private JToggleButton jToggleButton6;
	private JToggleButton jToggleButton5;
	private JToggleButton jToggleButton4;
	private JToggleButton jToggleButton3;
	private JToggleButton jToggleButton2;
	private JToggleButton jToggleButton1;
	private JToggleButton tbAlarm1;
	private JTextField tfStock9;
	private JTextField tfStock8;
	private JTextField tfStock7;
	private JTextField tfStock6;
	private JTextField tfStock5;
	private JTextField tfStock4;
	private JTextField tfStock3;
	private JTextField tfStock2;
	private JTextField tfStock1;
	private JLabel lAlarm;
	private JLabel lTrip;
	private boolean keepRunning=true;
	private Properties properties;
	
	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private TripWire(Properties props) 
	{
		super();
		this.properties=props;
		readPrefs("prefs.dat");
		initGUI();
		stock1=new Stock(this.lLastQuote1,Double.MAX_VALUE,this.tfStock1,this.tfTrip1);
		stock2=new Stock(this.lLastQuote2,Double.MAX_VALUE,this.tfStock2,this.tfTrip2);
		stock3=new Stock(this.lLastQuote3,Double.MAX_VALUE,this.tfStock3,this.tfTrip3);
		stock4=new Stock(this.lLastQuote4,Double.MAX_VALUE,this.tfStock4,this.tfTrip4);
		stock5=new Stock(this.lLastQuote5,Double.MAX_VALUE,this.tfStock5,this.tfTrip5);
		stock6=new Stock(this.lLastQuote6,Double.MAX_VALUE,this.tfStock6,this.tfTrip6);
		stock7=new Stock(this.lLastQuote7,Double.MAX_VALUE,this.tfStock7,this.tfTrip7);
		stock8=new Stock(this.lLastQuote8,Double.MAX_VALUE,this.tfStock8,this.tfTrip8);
		stock9=new Stock(this.lLastQuote9,Double.MAX_VALUE,this.tfStock9,this.tfTrip9);
		
		//Read in stored stock names, trip values and alarm settings if any
		//Update GUI
		//Work cycle:
		//For any non null stock names, update LAST QUOTE, storing previous in PREVIOUS QUOTE
		//For any non null stock names with ALARM SETTING=ON:
		//	If TRIP VALUE lies between nontrivial PREVIOUS QUOTE and LAST QUOTE, 
		//		ring alarm and reset ALARM SETTING to OFF
		//Repeat cycle indefinitely
		
		Thread updateThread=new Thread(this);
		updateThread.setDaemon(true);
		updateThread.start();
	}

	private void doStock(Stock stock)
	{
		if(stock.tfStock.getText().length()==0)
			stock.lLastQuote.setText("");
		
		if(stock.tfStock.getText().length()>0)
		{
			double currentQuote=Double.MAX_VALUE;
			try
			{
				double tripValue=new DecimalFormat("#0.00").parse(stock.tfTrip.getText()).doubleValue();
				currentQuote=Math.round(100.*PriceReader.quote(stock.tfStock.getText()))/100.;
				stock.previousValue=new DecimalFormat("#0.00").parse(stock.lLastQuote.getText()).doubleValue();
				//System.out.println(stock.previousValue);
				//if(currentQuote<1.e308)
					stock.lLastQuote.setText(new DecimalFormat("#0.00").format(currentQuote));
				//else
				//	stock.lLastQuote.setText("#0.00");
				stock.lLastQuote.repaint();
				if(this.liesBetween(tripValue, currentQuote, stock.previousValue))
					if(currentQuote<stock.previousValue)
						stock.soundAlarm(Color.RED);
					else
						stock.soundAlarm(Color.GREEN);
			} catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	
	private void finishUp()
	{
		try
		{
			this.properties.setProperty("stock1", this.tfStock1.getText());
			this.properties.setProperty("stock2", this.tfStock2.getText());
			this.properties.setProperty("stock3", this.tfStock3.getText());
			this.properties.setProperty("stock4", this.tfStock4.getText());
			this.properties.setProperty("stock5", this.tfStock5.getText());
			this.properties.setProperty("stock6", this.tfStock6.getText());
			this.properties.setProperty("stock7", this.tfStock7.getText());
			this.properties.setProperty("stock8", this.tfStock8.getText());
			this.properties.setProperty("stock9", this.tfStock9.getText());
			this.properties.setProperty("tripvalue1", this.tfTrip1.getText());
			this.properties.setProperty("tripvalue2", this.tfTrip2.getText());
			this.properties.setProperty("tripvalue3", this.tfTrip3.getText());
			this.properties.setProperty("tripvalue4", this.tfTrip4.getText());
			this.properties.setProperty("tripvalue5", this.tfTrip5.getText());
			this.properties.setProperty("tripvalue6", this.tfTrip6.getText());
			this.properties.setProperty("tripvalue7", this.tfTrip7.getText());
			this.properties.setProperty("tripvalue8", this.tfTrip8.getText());
			this.properties.setProperty("tripvalue9", this.tfTrip9.getText());
	
			this.properties.storeToXML(new FileOutputStream("prefs.xml"), "output");
		} catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void initGUI() 
	{
		try 
		{
			//setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			GridBagLayout thisLayout = new GridBagLayout();
			this.setTitle("TripWire Copyright © 2009 Positronic Software");
			thisLayout.rowWeights = new double[] {0.1, 0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1};
			thisLayout.rowHeights = new int[] {7, 7, 7, 7, 7, 7, 7, 7, 7, 7};
			thisLayout.columnWeights = new double[] {0.1, 0.1, 0.1, 0.1};
			thisLayout.columnWidths = new int[] {7, 7, 7, 7};
			getContentPane().setLayout(thisLayout);
			getContentPane().setBackground(new java.awt.Color(192,192,192));
			{
				lStock = new JLabel();
				getContentPane().add(lStock, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
				lStock.setText("STOCK");
			}
			{
				lLastQuote = new JLabel();
				getContentPane().add(lLastQuote, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
				lLastQuote.setText("LAST QUOTE");
			}
			{
				lTrip = new JLabel();
				getContentPane().add(lTrip, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
				lTrip.setText("TRIP VALUE");
			}
			{
				lAlarm = new JLabel();
				getContentPane().add(lAlarm, new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
				lAlarm.setText("ALARM SETTING");
			}
			{
				tfStock1 = new JTextField();
				getContentPane().add(tfStock1, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 3, 0, 0), 0, 0));
				tfStock1.setText(this.properties.getProperty("stock1", ""));
				tfStock1.setHorizontalAlignment(SwingConstants.CENTER);
				tfStock1.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						if(evt.getClickCount()==2)
							stock1.silenceAlarm();
					}
				});
			}
			{
				tfStock2 = new JTextField();
				getContentPane().add(tfStock2, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 3, 0, 0), 0, 0));
				tfStock2.setText(this.properties.getProperty("stock2", ""));
				tfStock2.setAutoscrolls(false);
				tfStock2.setHorizontalAlignment(SwingConstants.CENTER);
				tfStock2.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						if(evt.getClickCount()==2)
							stock2.silenceAlarm();
					}
				});
			}
			{
				tfStock3 = new JTextField();
				getContentPane().add(tfStock3, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 3, 0, 0), 0, 0));
				tfStock3.setText(this.properties.getProperty("stock3", ""));
				tfStock3.setHorizontalAlignment(SwingConstants.CENTER);
				tfStock3.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						if(evt.getClickCount()==2)
							stock3.silenceAlarm();
					}
				});
			}
			{
				tfStock4 = new JTextField();
				getContentPane().add(tfStock4, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 3, 0, 0), 0, 0));
				tfStock4.setText(this.properties.getProperty("stock4", ""));
				tfStock4.setHorizontalAlignment(SwingConstants.CENTER);
				tfStock4.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						if(evt.getClickCount()==2)
							stock4.silenceAlarm();
					}
				});
			}
			{
				tfStock5 = new JTextField();
				getContentPane().add(tfStock5, new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 3, 0, 0), 0, 0));
				tfStock5.setText(this.properties.getProperty("stock5", ""));
				tfStock5.setHorizontalAlignment(SwingConstants.CENTER);
				tfStock5.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						if(evt.getClickCount()==2)
							stock5.silenceAlarm();
					}
				});
			}
			{
				tfStock6 = new JTextField();
				getContentPane().add(tfStock6, new GridBagConstraints(0, 6, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 3, 0, 0), 0, 0));
				tfStock6.setText(this.properties.getProperty("stock6", ""));
				tfStock6.setHorizontalAlignment(SwingConstants.CENTER);
				tfStock6.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						if(evt.getClickCount()==2)
							stock6.silenceAlarm();
					}
				});
			}
			{
				tfStock7 = new JTextField();
				getContentPane().add(tfStock7, new GridBagConstraints(0, 7, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 3, 0, 0), 0, 0));
				tfStock7.setText(this.properties.getProperty("stock7", ""));
				tfStock7.setHorizontalAlignment(SwingConstants.CENTER);
				tfStock7.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						if(evt.getClickCount()==2)
							stock7.silenceAlarm();
					}
				});
			}
			{
				tfStock8 = new JTextField();
				getContentPane().add(tfStock8, new GridBagConstraints(0, 8, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 3, 0, 0), 0, 0));
				tfStock8.setText(this.properties.getProperty("stock8", ""));
				tfStock8.setHorizontalAlignment(SwingConstants.CENTER);
				tfStock8.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						if(evt.getClickCount()==2)
							stock8.silenceAlarm();
					}
				});
			}
			{
				tfStock9 = new JTextField();
				getContentPane().add(tfStock9, new GridBagConstraints(0, 9, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 3, 0, 0), 0, 0));
				tfStock9.setText(this.properties.getProperty("stock9", ""));
				tfStock9.setHorizontalAlignment(SwingConstants.CENTER);
				tfStock9.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						if(evt.getClickCount()==2)
							stock9.silenceAlarm();
					}
				});
			}
			{
				tbAlarm1 = new JToggleButton();
				getContentPane().add(tbAlarm1, new GridBagConstraints(3, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
				tbAlarm1.setText("OFF");
				tbAlarm1.setSelected(true);
			}
			{
				jToggleButton1 = new JToggleButton();
				getContentPane().add(jToggleButton1, new GridBagConstraints(3, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
				jToggleButton1.setText("OFF");
				jToggleButton1.setEnabled(true);
				jToggleButton1.setSelected(true);
			}
			{
				jToggleButton2 = new JToggleButton();
				getContentPane().add(jToggleButton2, new GridBagConstraints(3, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
				jToggleButton2.setText("OFF");
				jToggleButton2.setEnabled(true);
				jToggleButton2.setSelected(true);
			}
			{
				jToggleButton3 = new JToggleButton();
				getContentPane().add(jToggleButton3, new GridBagConstraints(3, 4, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
				jToggleButton3.setText("OFF");
				jToggleButton3.setEnabled(true);
				jToggleButton3.setSelected(true);
			}
			{
				jToggleButton4 = new JToggleButton();
				getContentPane().add(jToggleButton4, new GridBagConstraints(3, 5, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
				jToggleButton4.setText("OFF");
				jToggleButton4.setEnabled(true);
				jToggleButton4.setSelected(true);
			}
			{
				jToggleButton5 = new JToggleButton();
				getContentPane().add(jToggleButton5, new GridBagConstraints(3, 6, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
				jToggleButton5.setText("OFF");
				jToggleButton5.setEnabled(true);
				jToggleButton5.setSelected(true);
			}
			{
				jToggleButton6 = new JToggleButton();
				getContentPane().add(jToggleButton6, new GridBagConstraints(3, 7, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
				jToggleButton6.setText("OFF");
				jToggleButton6.setEnabled(true);
				jToggleButton6.setSelected(true);
			}
			{
				jToggleButton7 = new JToggleButton();
				getContentPane().add(jToggleButton7, new GridBagConstraints(3, 8, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
				jToggleButton7.setText("OFF");
				jToggleButton7.setEnabled(true);
				jToggleButton7.setSelected(true);
			}
			{
				jToggleButton8 = new JToggleButton();
				getContentPane().add(jToggleButton8, new GridBagConstraints(3, 9, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
				jToggleButton8.setText("OFF");
				jToggleButton8.setEnabled(true);
				jToggleButton8.setSelected(true);
			}
			{
				lLastQuote1 = new JLabel();
				getContentPane().add(lLastQuote1, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
				lLastQuote1.setText(""+Double.MAX_VALUE);
				lLastQuote1.setHorizontalAlignment(SwingConstants.CENTER);
				lLastQuote1.setFont(new java.awt.Font("Tahoma",1,14));
				lLastQuote1.setForeground(new java.awt.Color(255,255,128));
			}
			{
				lLastQuote2 = new JLabel();
				getContentPane().add(lLastQuote2, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
				lLastQuote2.setText(""+Double.MAX_VALUE);
				lLastQuote2.setHorizontalAlignment(SwingConstants.CENTER);
				lLastQuote2.setFont(new java.awt.Font("Tahoma",1,14));
				lLastQuote2.setForeground(new java.awt.Color(255,255,128));
				lLastQuote2.setBackground(new java.awt.Color(255,128,0));
			}
			{
				lLastQuote3 = new JLabel();
				getContentPane().add(lLastQuote3, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
				lLastQuote3.setText(""+Double.MAX_VALUE);
				lLastQuote3.setHorizontalAlignment(SwingConstants.CENTER);
				lLastQuote3.setFont(new java.awt.Font("Tahoma",1,14));
				lLastQuote3.setForeground(new java.awt.Color(255,255,128));
				lLastQuote3.setBackground(new java.awt.Color(255,128,0));
			}
			{
				lLastQuote4 = new JLabel();
				getContentPane().add(lLastQuote4, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
				lLastQuote4.setText(""+Double.MAX_VALUE);
				lLastQuote4.setHorizontalAlignment(SwingConstants.CENTER);
				lLastQuote4.setFont(new java.awt.Font("Tahoma",1,14));
				lLastQuote4.setForeground(new java.awt.Color(255,255,128));
				lLastQuote4.setBackground(new java.awt.Color(255,128,0));
			}
			{
				lLastQuote5 = new JLabel();
				getContentPane().add(lLastQuote5, new GridBagConstraints(1, 5, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
				lLastQuote5.setText(""+Double.MAX_VALUE);
				lLastQuote5.setHorizontalAlignment(SwingConstants.CENTER);
				lLastQuote5.setFont(new java.awt.Font("Tahoma",1,14));
				lLastQuote5.setForeground(new java.awt.Color(255,255,128));
				lLastQuote5.setBackground(new java.awt.Color(255,128,0));
			}
			{
				lLastQuote6 = new JLabel();
				getContentPane().add(lLastQuote6, new GridBagConstraints(1, 6, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
				lLastQuote6.setText(""+Double.MAX_VALUE);
				lLastQuote6.setHorizontalAlignment(SwingConstants.CENTER);
				lLastQuote6.setFont(new java.awt.Font("Tahoma",1,14));
				lLastQuote6.setForeground(new java.awt.Color(255,255,128));
				lLastQuote6.setBackground(new java.awt.Color(255,128,0));
			}
			{
				lLastQuote7 = new JLabel();
				getContentPane().add(lLastQuote7, new GridBagConstraints(1, 7, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
				lLastQuote7.setText(""+Double.MAX_VALUE);
				lLastQuote7.setHorizontalAlignment(SwingConstants.CENTER);
				lLastQuote7.setFont(new java.awt.Font("Tahoma",1,14));
				lLastQuote7.setForeground(new java.awt.Color(255,255,128));
				lLastQuote7.setBackground(new java.awt.Color(255,128,0));
			}
			{
				lLastQuote8 = new JLabel();
				getContentPane().add(lLastQuote8, new GridBagConstraints(1, 8, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
				lLastQuote8.setText(""+Double.MAX_VALUE);
				lLastQuote8.setHorizontalAlignment(SwingConstants.CENTER);
				lLastQuote8.setFont(new java.awt.Font("Tahoma",1,14));
				lLastQuote8.setForeground(new java.awt.Color(255,255,128));
				lLastQuote8.setBackground(new java.awt.Color(255,128,0));
			}
			{
				lLastQuote9 = new JLabel();
				getContentPane().add(lLastQuote9, new GridBagConstraints(1, 9, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
				lLastQuote9.setText(""+Double.MAX_VALUE);
				lLastQuote9.setHorizontalAlignment(SwingConstants.CENTER);
				lLastQuote9.setFont(new java.awt.Font("Tahoma",1,14));
				lLastQuote9.setForeground(new java.awt.Color(255,255,128));
				lLastQuote9.setBackground(new java.awt.Color(255,128,0));
			}
			{
				tfTrip1 = new JTextField();
				getContentPane().add(tfTrip1, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
				tfTrip1.setText(this.properties.getProperty("tripvalue1", "0.00"));
				tfTrip1.setHorizontalAlignment(SwingConstants.CENTER);
				tfTrip1.setFont(new java.awt.Font("Tahoma",0,14));
			}
			{
				tfTrip2 = new JTextField();
				getContentPane().add(tfTrip2, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
				tfTrip2.setFont(new java.awt.Font("Tahoma",0,14));
				tfTrip2.setHorizontalAlignment(SwingConstants.CENTER);
				tfTrip2.setText(this.properties.getProperty("tripvalue2", "0.00"));
			}
			{
				tfTrip3 = new JTextField();
				getContentPane().add(tfTrip3, new GridBagConstraints(2, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
				tfTrip3.setFont(new java.awt.Font("Tahoma",0,14));
				tfTrip3.setHorizontalAlignment(SwingConstants.CENTER);
				tfTrip3.setText(this.properties.getProperty("tripvalue3", "0.00"));
			}
			{
				tfTrip4 = new JTextField();
				getContentPane().add(tfTrip4, new GridBagConstraints(2, 4, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
				tfTrip4.setFont(new java.awt.Font("Tahoma",0,14));
				tfTrip4.setHorizontalAlignment(SwingConstants.CENTER);
				tfTrip4.setText(this.properties.getProperty("tripvalue4", "0.00"));
			}
			{
				tfTrip5 = new JTextField();
				getContentPane().add(tfTrip5, new GridBagConstraints(2, 5, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
				tfTrip5.setFont(new java.awt.Font("Tahoma",0,14));
				tfTrip5.setHorizontalAlignment(SwingConstants.CENTER);
				tfTrip5.setText(this.properties.getProperty("tripvalue5", "0.00"));
			}
			{
				tfTrip6 = new JTextField();
				getContentPane().add(tfTrip6, new GridBagConstraints(2, 6, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
				tfTrip6.setFont(new java.awt.Font("Tahoma",0,14));
				tfTrip6.setHorizontalAlignment(SwingConstants.CENTER);
				tfTrip6.setText(this.properties.getProperty("tripvalue6", "0.00"));
			}
			{
				tfTrip7 = new JTextField();
				getContentPane().add(tfTrip7, new GridBagConstraints(2, 7, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
				tfTrip7.setFont(new java.awt.Font("Tahoma",0,14));
				tfTrip7.setHorizontalAlignment(SwingConstants.CENTER);
				tfTrip7.setText(this.properties.getProperty("tripvalue7", "0.00"));
			}
			{
				tfTrip8 = new JTextField();
				getContentPane().add(tfTrip8, new GridBagConstraints(2, 8, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
				tfTrip8.setFont(new java.awt.Font("Tahoma",0,14));
				tfTrip8.setHorizontalAlignment(SwingConstants.CENTER);
				tfTrip8.setText(this.properties.getProperty("tripvalue8", "0.00"));
			}
			{
				tfTrip9 = new JTextField();
				getContentPane().add(tfTrip9, new GridBagConstraints(2, 9, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
				tfTrip9.setFont(new java.awt.Font("Tahoma",0,14));
				tfTrip9.setHorizontalAlignment(SwingConstants.CENTER);
				tfTrip9.setText(this.properties.getProperty("tripvalue9", "0.00"));
			}
			pack();
			setSize(400, 300);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private boolean liesBetween(double x,double a,double b)
	{
		if(a==Double.MAX_VALUE || b==Double.MAX_VALUE)
			return false;
		if(a==b)
			return (x==a);
		if(a<b)
			return (a<=x)&&(x<=b);
		return liesBetween(x,b,a);
	}
	
	protected void processWindowEvent(WindowEvent e) 
	{
		super.processWindowEvent(e);
    if (e.getID() == WindowEvent.WINDOW_CLOSING) 
    {
    	setVisible(false);
    	finishUp();
    	System.exit(0);
    }
	}
	
	public void run()
	{
		while(keepRunning)
		{
			doStock(stock1);
			doStock(stock2);
			doStock(stock3);
			doStock(stock4);
			doStock(stock5);
			doStock(stock6);
			doStock(stock7);
			doStock(stock8);
			doStock(stock9);
			
			sleep();
		}
	}
	
	private void sleep()
	{
		try
		{
			String cycle=this.properties.getProperty("QUOTECYCLEINMILLIS", "60000");
			Thread.sleep((long)Double.parseDouble(cycle));
		} catch (InterruptedException e1)
		{
			e1.printStackTrace();
		}
	}

	private void readPrefs(String string)
	{
		// TODO Auto-generated method stub
		
	}
}


