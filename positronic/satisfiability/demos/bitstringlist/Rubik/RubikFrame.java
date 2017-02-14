package positronic.satisfiability.demos.bitstringlist.Rubik;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JPanel;

import positronic.satisfiability.bitstringlist.Rubik.RubikStatus;

public class RubikFrame extends JFrame
{
	private static final long serialVersionUID = -8516435334945743988L;
	public static final Color RUBIK_RED=new java.awt.Color(255,0,0);
	public static final Color RUBIK_YELLOW=new java.awt.Color(255,255,128);
	public static final Color RUBIK_BLUE=new java.awt.Color(0,128,255);
	public static final Color RUBIK_ORANGE=new java.awt.Color(255,128,0);
	public static final Color RUBIK_GREEN=new java.awt.Color(98,167,88);
	public static final Color RUBIK_WHITE=new java.awt.Color(255,255,255);
	
	public static void main(String[] args) throws Exception
	{
		RubikFrame r=new RubikFrame();	
		r.setVisible(true);
	}
	
	private HashMap<Integer,JPanel> map=new HashMap<Integer,JPanel>();
	private JPanel face01;
	private JPanel face02;
	private JPanel face03;
	private JPanel face04;
	private JPanel face05;
	private JPanel face06;
	private JPanel face07;
	private JPanel face08;
	private JPanel face09;
	private JPanel face10;
	private JPanel face11;
	private JPanel face12;
	private JPanel face13;
	private JPanel face14;
	private JPanel face15;
	private JPanel face16;
	private JPanel face17;
	private JPanel face18;
	private JPanel face19;
	private JPanel face20;
	private JPanel face21;
	private JPanel face22;
	private JPanel face23;
	private JPanel face24;
	private JPanel face25;
	private JPanel face26;
	private JPanel face27;
	private JPanel face28;
	private JPanel face29;
	private JPanel face30;
	private JPanel face31;
	private JPanel face32;
	private JPanel face33;
	private JPanel face34;
	private JPanel face35;
	private JPanel face36;
	private JPanel face37;
	private JPanel face38;
	private JPanel face39;
	private JPanel face40;
	private JPanel face41;
	private JPanel face42;
	private JPanel face43;
	private JPanel face44;
	private JPanel face45;
	private JPanel face46;
	private JPanel face47;
	private JPanel face48;
	private JPanel faceBlue;
	private JPanel faceGreen;
	private JPanel faceOrange;
	private JPanel faceRed;
	private JPanel faceWhite;
	private JPanel faceYellow;
	
	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public RubikFrame() 
	{
		this("RubikFrame");
	}
	
	public RubikFrame(RubikStatus rs) throws Exception 
	{
		this("RubikFrame",rs);
	}
	
	public RubikFrame(String title) 
	{
		super(title);
		initGUI();
		this.initializeCube();
	}
	
	public RubikFrame(String title, RubikStatus rs) throws Exception 
	{
		super(title);
		initGUI();
		this.initializeCube();
		this.doRubikFrame(rs);
	}
	
	public void doRubikFrame(RubikStatus rStatus) throws Exception
	{
		for(int face=1;face<=48;face++)
		{
			if(rStatus.getFace(face).toBits().compareTo("000")==0)
				this.setFaceColor(face, RUBIK_YELLOW);
			if(rStatus.getFace(face).toBits().compareTo("001")==0)
				this.setFaceColor(face, RUBIK_RED);
			if(rStatus.getFace(face).toBits().compareTo("010")==0)
				this.setFaceColor(face, RUBIK_BLUE);
			if(rStatus.getFace(face).toBits().compareTo("011")==0)
				this.setFaceColor(face, RUBIK_ORANGE);
			if(rStatus.getFace(face).toBits().compareTo("100")==0)
				this.setFaceColor(face, RUBIK_GREEN);
			if(rStatus.getFace(face).toBits().compareTo("101")==0)
				this.setFaceColor(face, RUBIK_WHITE);
		}
	}
	
	private void initGUI() 
	{
		try 
		{
			{
				this.setSize(678, 397);
			}
			{
				GridBagLayout thisLayout = new GridBagLayout();
				thisLayout.rowWeights = new double[] {0.1, 0.1, 0.1, 0.1,0.1, 0.1, 0.1, 0.1,0.1};
				thisLayout.rowHeights = new int[] {7, 7, 7, 7, 7, 7, 7, 7, 7};
				thisLayout.columnWeights = new double[] {0.1, 0.1, 0.1, 0.1,0.1, 0.1, 0.1, 0.1,0.1, 0.1, 0.1,0.1};
				
				thisLayout.columnWidths = new int[] {7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7};
				getContentPane().setLayout(thisLayout);
				getContentPane().setBackground(new java.awt.Color(0,0,0));
				///this.setTitle("Rubik Solver");
				{
					face09 = new JPanel();
					getContentPane().add(face09, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
					face09.setBackground(RUBIK_RED);
					face09.addMouseListener(new MouseAdapter() {
						public void mouseReleased(MouseEvent evt) {
							System.out.println("jPanel1.mouseReleased, event="+evt);
							//TODO add your code for jPanel1.mouseReleased
						}
					});
				}
				{
					face10 = new JPanel();
					getContentPane().add(face10, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
					face10.setBackground(RUBIK_RED);
					face10.addMouseListener(new MouseAdapter() {
						public void mouseReleased(MouseEvent evt) {
							System.out.println("jPanel2.mouseReleased, event="+evt);
							//TODO add your code for jPanel2.mouseReleased
						}
					});
				}
				{
					face11 = new JPanel();
					getContentPane().add(face11, new GridBagConstraints(2, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
					face11.setBackground(RUBIK_RED);
					face11.addMouseListener(new MouseAdapter() {
						public void mouseReleased(MouseEvent evt) {
							System.out.println("jPanel3.mouseReleased, event="+evt);
							//TODO add your code for jPanel3.mouseReleased
						}
					});
				}
				{
					faceRed = new JPanel();
					getContentPane().add(faceRed, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
					faceRed.setBackground(RUBIK_RED);
					faceRed.addMouseListener(new MouseAdapter() {
						public void mouseReleased(MouseEvent evt) {
							System.out.println("jPanel4.mouseReleased, event="+evt);
							//TODO add your code for jPanel4.mouseReleased
						}
					});
				}
				{
					face21 = new JPanel();
					getContentPane().add(face21, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
					face21.setBackground(RUBIK_RED);
					face21.addMouseListener(new MouseAdapter() {
						public void mouseReleased(MouseEvent evt) {
							System.out.println("jPanel5.mouseReleased, event="+evt);
							//TODO add your code for jPanel5.mouseReleased
						}
					});
				}
				{
					face22 = new JPanel();
					getContentPane().add(face22, new GridBagConstraints(2, 4, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
					face22.setBackground(RUBIK_RED);
					face22.addMouseListener(new MouseAdapter() {
						public void mouseReleased(MouseEvent evt) {
							System.out.println("jPanel6.mouseReleased, event="+evt);
							//TODO add your code for jPanel6.mouseReleased
						}
					});
				}
				{
					face29 = new JPanel();
					getContentPane().add(face29, new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
					face29.setBackground(RUBIK_RED);
					face29.addMouseListener(new MouseAdapter() {
						public void mouseReleased(MouseEvent evt) {
							System.out.println("jPanel7.mouseReleased, event="+evt);
							//TODO add your code for jPanel7.mouseReleased
						}
					});
				}
				{
					face30 = new JPanel();
					getContentPane().add(face30, new GridBagConstraints(1, 5, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
					face30.setBackground(RUBIK_RED);
					face30.addMouseListener(new MouseAdapter() {
						public void mouseReleased(MouseEvent evt) {
							System.out.println("jPanel8.mouseReleased, event="+evt);
							//TODO add your code for jPanel8.mouseReleased
						}
					});
				}
				{
					face31 = new JPanel();
					getContentPane().add(face31, new GridBagConstraints(2, 5, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
					face31.setBackground(RUBIK_RED);
					face31.addMouseListener(new MouseAdapter() {
						public void mouseReleased(MouseEvent evt) {
							System.out.println("jPanel9.mouseReleased, event="+evt);
							//TODO add your code for jPanel9.mouseReleased
						}
					});
				}
				{
					face12 = new JPanel();
					getContentPane().add(face12, new GridBagConstraints(3, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
					face12.setBackground(RUBIK_BLUE);
					face12.addMouseListener(new MouseAdapter() {
						public void mouseReleased(MouseEvent evt) {
							System.out.println("jPanel10.mouseReleased, event="+evt);
							//TODO add your code for jPanel10.mouseReleased
						}
					});
				}
				{
					face13 = new JPanel();
					getContentPane().add(face13, new GridBagConstraints(4, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
					face13.setBackground(RUBIK_BLUE);
					face13.addMouseListener(new MouseAdapter() {
						public void mouseReleased(MouseEvent evt) {
							System.out.println("jPanel11.mouseReleased, event="+evt);
							//TODO add your code for jPanel11.mouseReleased
						}
					});
				}
				{
					face14 = new JPanel();
					getContentPane().add(face14, new GridBagConstraints(5, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
					face14.setBackground(RUBIK_BLUE);
					face14.addMouseListener(new MouseAdapter() {
						public void mouseReleased(MouseEvent evt) {
							System.out.println("jPanel12.mouseReleased, event="+evt);
							//TODO add your code for jPanel12.mouseReleased
						}
					});
				}
				{
					face23 = new JPanel();
					getContentPane().add(face23, new GridBagConstraints(3, 4, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
					face23.setBackground(RUBIK_BLUE);
					face23.addMouseListener(new MouseAdapter() {
						public void mouseReleased(MouseEvent evt) {
							System.out.println("jPanel13.mouseReleased, event="+evt);
							//TODO add your code for jPanel13.mouseReleased
						}
					});
				}
				{
					faceBlue = new JPanel();
					getContentPane().add(faceBlue, new GridBagConstraints(4, 4, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
					faceBlue.setBackground(RUBIK_BLUE);
					faceBlue.addMouseListener(new MouseAdapter() {
						public void mouseReleased(MouseEvent evt) {
							System.out.println("jPanel14.mouseReleased, event="+evt);
							//TODO add your code for jPanel14.mouseReleased
						}
					});
				}
				{
					face24 = new JPanel();
					getContentPane().add(face24, new GridBagConstraints(5, 4, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
					face24.setBackground(RUBIK_BLUE);
					face24.addMouseListener(new MouseAdapter() {
						public void mouseReleased(MouseEvent evt) {
							System.out.println("jPanel15.mouseReleased, event="+evt);
							//TODO add your code for jPanel15.mouseReleased
						}
					});
				}
				{
					face32 = new JPanel();
					getContentPane().add(face32, new GridBagConstraints(3, 5, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
					face32.setBackground(RUBIK_BLUE);
					face32.addMouseListener(new MouseAdapter() {
						public void mouseReleased(MouseEvent evt) {
							System.out.println("jPanel16.mouseReleased, event="+evt);
							//TODO add your code for jPanel16.mouseReleased
						}
					});
				}
				{
					face33 = new JPanel();
					getContentPane().add(face33, new GridBagConstraints(4, 5, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
					face33.setBackground(RUBIK_BLUE);
					face33.addMouseListener(new MouseAdapter() {
						public void mouseReleased(MouseEvent evt) {
							System.out.println("jPanel17.mouseReleased, event="+evt);
							//TODO add your code for jPanel17.mouseReleased
						}
					});
				}
				{
					face34 = new JPanel();
					getContentPane().add(face34, new GridBagConstraints(5, 5, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
					face34.setBackground(RUBIK_BLUE);
					face34.addMouseListener(new MouseAdapter() {
						public void mouseReleased(MouseEvent evt) {
							System.out.println("jPanel18.mouseReleased, event="+evt);
							//TODO add your code for jPanel18.mouseReleased
						}
					});
				}
				{
					face01 = new JPanel();
					getContentPane().add(face01, new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
					face01.setBackground(RUBIK_YELLOW);
					face01.addMouseListener(new MouseAdapter() {
						public void mouseReleased(MouseEvent evt) {
							System.out.println("jPanel19.mouseReleased, event="+evt);
							//TODO add your code for jPanel19.mouseReleased
						}
					});
				}
				{
					face02 = new JPanel();
					getContentPane().add(face02, new GridBagConstraints(4, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
					face02.setBackground(RUBIK_YELLOW);
					face02.addMouseListener(new MouseAdapter() {
						public void mouseReleased(MouseEvent evt) {
							System.out.println("jPanel20.mouseReleased, event="+evt);
							//TODO add your code for jPanel20.mouseReleased
						}
					});
				}
				{
					face03 = new JPanel();
					getContentPane().add(face03, new GridBagConstraints(5, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
					face03.setBackground(RUBIK_YELLOW);
					face03.addMouseListener(new MouseAdapter() {
						public void mouseReleased(MouseEvent evt) {
							System.out.println("jPanel21.mouseReleased, event="+evt);
							//TODO add your code for jPanel21.mouseReleased
						}
					});
				}
				{
					face04 = new JPanel();
					getContentPane().add(face04, new GridBagConstraints(3, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
					face04.setBackground(RUBIK_YELLOW);
					face04.addMouseListener(new MouseAdapter() {
						public void mouseReleased(MouseEvent evt) {
							System.out.println("jPanel22.mouseReleased, event="+evt);
							//TODO add your code for jPanel22.mouseReleased
						}
					});
				}
				{
					faceYellow = new JPanel();
					getContentPane().add(faceYellow, new GridBagConstraints(4, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
					faceYellow.setBackground(RUBIK_YELLOW);
					faceYellow.addMouseListener(new MouseAdapter() {
						public void mouseReleased(MouseEvent evt) {
							System.out.println("jPanel23.mouseReleased, event="+evt);
							//TODO add your code for jPanel23.mouseReleased
						}
					});
				}
				{
					face05 = new JPanel();
					getContentPane().add(face05, new GridBagConstraints(5, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
					face05.setBackground(RUBIK_YELLOW);
					face05.addMouseListener(new MouseAdapter() {
						public void mouseReleased(MouseEvent evt) {
							System.out.println("jPanel24.mouseReleased, event="+evt);
							//TODO add your code for jPanel24.mouseReleased
						}
					});
				}
				{
					face06 = new JPanel();
					getContentPane().add(face06, new GridBagConstraints(3, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
					face06.setBackground(RUBIK_YELLOW);
					face06.addMouseListener(new MouseAdapter() {
						public void mouseReleased(MouseEvent evt) {
							System.out.println("jPanel25.mouseReleased, event="+evt);
							//TODO add your code for jPanel25.mouseReleased
						}
					});
				}
				{
					face07 = new JPanel();
					getContentPane().add(face07, new GridBagConstraints(4, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
					face07.setBackground(RUBIK_YELLOW);
					face07.addMouseListener(new MouseAdapter() {
						public void mouseReleased(MouseEvent evt) {
							System.out.println("jPanel26.mouseReleased, event="+evt);
							//TODO add your code for jPanel26.mouseReleased
						}
					});
				}
				{
					face08 = new JPanel();
					getContentPane().add(face08, new GridBagConstraints(5, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
					face08.setBackground(RUBIK_YELLOW);
					face08.addMouseListener(new MouseAdapter() {
						public void mouseReleased(MouseEvent evt) {
							System.out.println("jPanel27.mouseReleased, event="+evt);
							//TODO add your code for jPanel27.mouseReleased
						}
					});
				}
				{
					face41 = new JPanel();
					getContentPane().add(face41, new GridBagConstraints(3, 6, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
					face41.setBackground(RUBIK_WHITE);
					face41.addMouseListener(new MouseAdapter() {
						public void mouseReleased(MouseEvent evt) {
							System.out.println("jPanel28.mouseReleased, event="+evt);
							//TODO add your code for jPanel28.mouseReleased
						}
					});
				}
				{
					face42 = new JPanel();
					getContentPane().add(face42, new GridBagConstraints(4, 6, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
					face42.setBackground(RUBIK_WHITE);
					face42.addMouseListener(new MouseAdapter() {
						public void mouseReleased(MouseEvent evt) {
							System.out.println("jPanel29.mouseReleased, event="+evt);
							//TODO add your code for jPanel29.mouseReleased
						}
					});
				}
				{
					face43 = new JPanel();
					getContentPane().add(face43, new GridBagConstraints(5, 6, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
					face43.setBackground(RUBIK_WHITE);
					face43.addMouseListener(new MouseAdapter() {
						public void mouseReleased(MouseEvent evt) {
							System.out.println("jPanel30.mouseReleased, event="+evt);
							//TODO add your code for jPanel30.mouseReleased
						}
					});
				}
				{
					face44 = new JPanel();
					getContentPane().add(face44, new GridBagConstraints(3, 7, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
					face44.setBackground(RUBIK_WHITE);
					face44.addMouseListener(new MouseAdapter() {
						public void mouseReleased(MouseEvent evt) {
							System.out.println("jPanel31.mouseReleased, event="+evt);
							//TODO add your code for jPanel31.mouseReleased
						}
					});
				}
				{
					faceWhite = new JPanel();
					getContentPane().add(faceWhite, new GridBagConstraints(4, 7, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
					faceWhite.setBackground(RUBIK_WHITE);
					faceWhite.addMouseListener(new MouseAdapter() {
						public void mouseReleased(MouseEvent evt) {
							System.out.println("jPanel32.mouseReleased, event="+evt);
							//TODO add your code for jPanel32.mouseReleased
						}
					});
				}
				{
					face45 = new JPanel();
					getContentPane().add(face45, new GridBagConstraints(5, 7, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
					face45.setBackground(RUBIK_WHITE);
					face45.addMouseListener(new MouseAdapter() {
						public void mouseReleased(MouseEvent evt) {
							System.out.println("jPanel33.mouseReleased, event="+evt);
							//TODO add your code for jPanel33.mouseReleased
						}
					});
				}
				{
					face46 = new JPanel();
					getContentPane().add(face46, new GridBagConstraints(3, 8, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
					face46.setBackground(RUBIK_WHITE);
					face46.addMouseListener(new MouseAdapter() {
						public void mouseReleased(MouseEvent evt) {
							System.out.println("jPanel34.mouseReleased, event="+evt);
							//TODO add your code for jPanel34.mouseReleased
						}
					});
				}
				{
					face47 = new JPanel();
					getContentPane().add(face47, new GridBagConstraints(4, 8, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
					face47.setBackground(RUBIK_WHITE);
					face47.addMouseListener(new MouseAdapter() {
						public void mouseReleased(MouseEvent evt) {
							System.out.println("jPanel35.mouseReleased, event="+evt);
							//TODO add your code for jPanel35.mouseReleased
						}
					});
				}
				{
					face48 = new JPanel();
					getContentPane().add(face48, new GridBagConstraints(5, 8, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
					face48.setBackground(RUBIK_WHITE);
					face48.addMouseListener(new MouseAdapter() {
						public void mouseReleased(MouseEvent evt) {
							System.out.println("jPanel36.mouseReleased, event="+evt);
							//TODO add your code for jPanel36.mouseReleased
						}
					});
				}
				{
					face15 = new JPanel();
					getContentPane().add(face15, new GridBagConstraints(6, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
					face15.setBackground(RUBIK_ORANGE);
					face15.addMouseListener(new MouseAdapter() {
						public void mouseReleased(MouseEvent evt) {
							System.out.println("jPanel37.mouseReleased, event="+evt);
							//TODO add your code for jPanel37.mouseReleased
						}
					});
				}
				{
					face16 = new JPanel();
					getContentPane().add(face16, new GridBagConstraints(7, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
					face16.setBackground(RUBIK_ORANGE);
					face16.addMouseListener(new MouseAdapter() {
						public void mouseReleased(MouseEvent evt) {
							System.out.println("jPanel38.mouseReleased, event="+evt);
							//TODO add your code for jPanel38.mouseReleased
						}
					});
				}
				{
					face17 = new JPanel();
					getContentPane().add(face17, new GridBagConstraints(8, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
					face17.setBackground(RUBIK_ORANGE);
					face17.addMouseListener(new MouseAdapter() {
						public void mouseReleased(MouseEvent evt) {
							System.out.println("jPanel39.mouseReleased, event="+evt);
							//TODO add your code for jPanel39.mouseReleased
						}
					});
				}
				{
					face25 = new JPanel();
					getContentPane().add(face25, new GridBagConstraints(6, 4, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
					face25.setBackground(RUBIK_ORANGE);
					face25.addMouseListener(new MouseAdapter() {
						public void mouseReleased(MouseEvent evt) {
							System.out.println("jPanel40.mouseReleased, event="+evt);
							//TODO add your code for jPanel40.mouseReleased
						}
					});
				}
				{
					faceOrange = new JPanel();
					getContentPane().add(faceOrange, new GridBagConstraints(7, 4, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
					faceOrange.setBackground(RUBIK_ORANGE);
					faceOrange.addMouseListener(new MouseAdapter() {
						public void mouseReleased(MouseEvent evt) {
							System.out.println("jPanel41.mouseReleased, event="+evt);
							//TODO add your code for jPanel41.mouseReleased
						}
					});
				}
				{
					face26 = new JPanel();
					getContentPane().add(face26, new GridBagConstraints(8, 4, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
					face26.setBackground(RUBIK_ORANGE);
					face26.addMouseListener(new MouseAdapter() {
						public void mouseReleased(MouseEvent evt) {
							System.out.println("jPanel42.mouseReleased, event="+evt);
							//TODO add your code for jPanel42.mouseReleased
						}
					});
				}
				{
					face35 = new JPanel();
					getContentPane().add(face35, new GridBagConstraints(6, 5, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
					face35.setBackground(RUBIK_ORANGE);
					face35.addMouseListener(new MouseAdapter() {
						public void mouseReleased(MouseEvent evt) {
							System.out.println("jPanel43.mouseReleased, event="+evt);
							//TODO add your code for jPanel43.mouseReleased
						}
					});
				}
				{
					face36 = new JPanel();
					getContentPane().add(face36, new GridBagConstraints(7, 5, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
					face36.setBackground(RUBIK_ORANGE);
					face36.addMouseListener(new MouseAdapter() {
						public void mouseReleased(MouseEvent evt) {
							System.out.println("jPanel44.mouseReleased, event="+evt);
							//TODO add your code for jPanel44.mouseReleased
						}
					});
				}
				{
					face37 = new JPanel();
					getContentPane().add(face37, new GridBagConstraints(8, 5, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
					face37.setBackground(RUBIK_ORANGE);
					face37.addMouseListener(new MouseAdapter() {
						public void mouseReleased(MouseEvent evt) {
							System.out.println("jPanel45.mouseReleased, event="+evt);
							//TODO add your code for jPanel45.mouseReleased
						}
					});
				}
				{
					face18 = new JPanel();
					getContentPane().add(face18, new GridBagConstraints(9, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
					face18.setBackground(RUBIK_GREEN);
					face18.addMouseListener(new MouseAdapter() {
						public void mouseReleased(MouseEvent evt) {
							System.out.println("jPanel46.mouseReleased, event="+evt);
							//TODO add your code for jPanel46.mouseReleased
						}
					});
				}
				{
					face19 = new JPanel();
					getContentPane().add(face19, new GridBagConstraints(10, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
					face19.setBackground(RUBIK_GREEN);
					face19.addMouseListener(new MouseAdapter() {
						public void mouseReleased(MouseEvent evt) {
							System.out.println("jPanel47.mouseReleased, event="+evt);
							//TODO add your code for jPanel47.mouseReleased
						}
					});
				}
				{
					face20 = new JPanel();
					getContentPane().add(face20, new GridBagConstraints(11, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
					face20.setBackground(RUBIK_GREEN);
					face20.addMouseListener(new MouseAdapter() {
						public void mouseReleased(MouseEvent evt) {
							System.out.println("jPanel48.mouseReleased, event="+evt);
							//TODO add your code for jPanel48.mouseReleased
						}
					});
				}
				{
					face27 = new JPanel();
					getContentPane().add(face27, new GridBagConstraints(9, 4, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
					face27.setBackground(RUBIK_GREEN);
					face27.addMouseListener(new MouseAdapter() {
						public void mouseReleased(MouseEvent evt) {
							System.out.println("jPanel49.mouseReleased, event="+evt);
							//TODO add your code for jPanel49.mouseReleased
						}
					});
				}
				{
					faceGreen = new JPanel();
					getContentPane().add(faceGreen, new GridBagConstraints(10, 4, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
					faceGreen.setBackground(RUBIK_GREEN);
					faceGreen.addMouseListener(new MouseAdapter() {
						public void mouseReleased(MouseEvent evt) {
							System.out.println("jPanel50.mouseReleased, event="+evt);
							//TODO add your code for jPanel50.mouseReleased
						}
					});
				}
				{
					face28 = new JPanel();
					getContentPane().add(face28, new GridBagConstraints(11, 4, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
					face28.setBackground(RUBIK_GREEN);
					face28.addMouseListener(new MouseAdapter() {
						public void mouseReleased(MouseEvent evt) {
							System.out.println("jPanel51.mouseReleased, event="+evt);
							//TODO add your code for jPanel51.mouseReleased
						}
					});
				}
				{
					face38 = new JPanel();
					getContentPane().add(face38, new GridBagConstraints(9, 5, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
					face38.setBackground(RUBIK_GREEN);
					face38.addMouseListener(new MouseAdapter() {
						public void mouseReleased(MouseEvent evt) {
							System.out.println("jPanel52.mouseReleased, event="+evt);
							//TODO add your code for jPanel52.mouseReleased
						}
					});
				}
				{
					face39 = new JPanel();
					getContentPane().add(face39, new GridBagConstraints(10, 5, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
					face39.setBackground(RUBIK_GREEN);
					face39.addMouseListener(new MouseAdapter() {
						public void mouseReleased(MouseEvent evt) {
							System.out.println("jPanel53.mouseReleased, event="+evt);
							//TODO add your code for jPanel53.mouseReleased
						}
					});
				}
				{
					face40 = new JPanel();
					getContentPane().add(face40, new GridBagConstraints(11, 5, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
					face40.setBackground(RUBIK_GREEN);
					face40.addMouseListener(new MouseAdapter() {
						public void mouseReleased(MouseEvent evt) {
							System.out.println("jPanel54.mouseReleased, event="+evt);
							//TODO add your code for jPanel54.mouseReleased
						}
					});
				}
			}
			{
				this.setSize(594, 439);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void initializeCube()
	{
		this.map.put(new Integer(1), this.face01);
		this.map.put(new Integer(2), this.face02);
		this.map.put(new Integer(3), this.face03);
		this.map.put(new Integer(4), this.face04);
		this.map.put(new Integer(5), this.face05);
		this.map.put(new Integer(6), this.face06);
		this.map.put(new Integer(7), this.face07);
		this.map.put(new Integer(8), this.face08);
		this.map.put(new Integer(9), this.face09);
		this.map.put(new Integer(10), this.face10);
		this.map.put(new Integer(11), this.face11);
		this.map.put(new Integer(12), this.face12);
		this.map.put(new Integer(13), this.face13);
		this.map.put(new Integer(14), this.face14);
		this.map.put(new Integer(15), this.face15);
		this.map.put(new Integer(16), this.face16);
		this.map.put(new Integer(17), this.face17);
		this.map.put(new Integer(18), this.face18);
		this.map.put(new Integer(19), this.face19);
		this.map.put(new Integer(20), this.face20);
		this.map.put(new Integer(21), this.face21);
		this.map.put(new Integer(22), this.face22);
		this.map.put(new Integer(23), this.face23);
		this.map.put(new Integer(24), this.face24);
		this.map.put(new Integer(25), this.face25);
		this.map.put(new Integer(26), this.face26);
		this.map.put(new Integer(27), this.face27);
		this.map.put(new Integer(28), this.face28);
		this.map.put(new Integer(29), this.face29);
		this.map.put(new Integer(30), this.face30);
		this.map.put(new Integer(31), this.face31);
		this.map.put(new Integer(32), this.face32);
		this.map.put(new Integer(33), this.face33);
		this.map.put(new Integer(34), this.face34);
		this.map.put(new Integer(35), this.face35);
		this.map.put(new Integer(36), this.face36);
		this.map.put(new Integer(37), this.face37);
		this.map.put(new Integer(38), this.face38);
		this.map.put(new Integer(39), this.face39);
		this.map.put(new Integer(40), this.face40);
		this.map.put(new Integer(41), this.face41);
		this.map.put(new Integer(42), this.face42);
		this.map.put(new Integer(43), this.face43);
		this.map.put(new Integer(44), this.face44);
		this.map.put(new Integer(45), this.face45);
		this.map.put(new Integer(46), this.face46);
		this.map.put(new Integer(47), this.face47);
		this.map.put(new Integer(48), this.face48);
	}

	public void setFaceColor(int faceNumber, Color color)
	{
		this.map.get(new Integer(faceNumber)).setBackground(color);
	}
}
