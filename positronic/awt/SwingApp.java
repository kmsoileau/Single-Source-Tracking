package positronic.awt;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;

public class SwingApp extends JFrame 
{
	private static final long serialVersionUID = 7568787538662743813L;
	
	public static void main(String[] args) 
	{
		SwingApp inst = new SwingApp();
		inst.setVisible(true);
	}

	private JMenuItem helpMenuItem;
	private JMenu jMenu5;
	private JMenuItem deleteMenuItem;
	private JSeparator jSeparator1;
	private JMenuItem pasteMenuItem;
	private Canvas canvas2;
	private JPanel jPanel4;
	private JPanel jPanel3;
	private Canvas canvas1;
	private JPanel jPanel2;
	private JPanel jPanel1;
	private JMenuItem copyMenuItem;
	private JMenuItem cutMenuItem;
	private JMenu jMenu4;
	private JMenuItem exitMenuItem;
	private JSeparator jSeparator2;
	private JMenuItem closeFileMenuItem;
	private JMenuItem saveAsMenuItem;
	private JMenuItem saveMenuItem;
	private JMenuItem openFileMenuItem;
	private JMenuItem newFileMenuItem;
	private JMenu jMenu3;
	private JMenuBar jMenuBar1;
	private Canvas canvas3;
	
	{
		try 
		{
			javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
		} 
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public SwingApp() 
	{
		super();
		initGUI();
	}
	
	private void initGUI() 
	{
		try 
		{
			{
				jPanel3 = new JPanel();
				GridLayout jPanel3Layout = new GridLayout(1, 1);
				jPanel3Layout.setHgap(5);
				jPanel3Layout.setVgap(5);
				jPanel3Layout.setColumns(1);
				jPanel3.setLayout(jPanel3Layout);
				getContentPane().add(jPanel3, BorderLayout.CENTER);
				{
					jPanel1 = new JPanel();
					jPanel3.add(jPanel1);
					{
						canvas1 = new Canvas() 
						{
							private static final long serialVersionUID = -593672134695509928L;

							public void paint(Graphics g) 
							{
								Graphics2D g2d = (Graphics2D) g;
								g2d.clearRect(0, 0, this.getWidth(), this.getHeight());
								g2d.fillPolygon(new int[] { 20, 40, 70 }, new int[] { 34, 14,
										77 }, 3);
								for (double i = .1; i < 6.3; i += .2) {
									g2d.rotate(.1, 67, 67);
									g2d.fillPolygon(new int[] { 20, 40, 70 }, new int[] { 34, 14,
											77 }, 3);
								}
							}
						};
						jPanel1.add(canvas1);
						canvas1.setPreferredSize(new java.awt.Dimension(109, 152));
					}
				}
				{
					jPanel2 = new JPanel();
					jPanel3.add(jPanel2);
					{
						canvas2 = new Canvas() 
						{
							private static final long serialVersionUID = 4206037674691045974L;

							public void paint(Graphics g) {
								Graphics2D g2d = (Graphics2D) g;
								g2d.clearRect(0, 0, this.getWidth(), this.getHeight());
								g2d.fillPolygon(new int[] { 20, 40, 70 }, new int[] { 34, 14,
										77 }, 3);
							}
						};
						jPanel2.add(canvas2);
						canvas2.setPreferredSize(new java.awt.Dimension(109, 152));
					}
				}
				{
					jPanel4 = new JPanel();
					jPanel3.add(jPanel4);
					{
						canvas3 = new Canvas() 
						{
							private static final long serialVersionUID = 8692051825176120884L;

							public void paint(Graphics g) {
								Graphics2D g2d = (Graphics2D) g;
								g2d.clearRect(0, 0, this.getWidth(), this.getHeight());
								g2d.fillPolygon(new int[] { 20, 40, 70 }, new int[] { 34, 14,
										77 }, 3);
								for (double i = .1; i < 6.3; i += .2) {
									g2d.rotate(.1, 67, 67);
									g2d.fillPolygon(new int[] { 20, 40, 70 }, new int[] { 34, 14,
											77 }, 3);
								}
							}
						};
						jPanel4.add(canvas3);
						canvas3.setPreferredSize(new java.awt.Dimension(109, 152));
					}
				}
			}
			setSize(400, 300);
			{
				jMenuBar1 = new JMenuBar();
				setJMenuBar(jMenuBar1);
				{
					jMenu3 = new JMenu();
					jMenuBar1.add(jMenu3);
					jMenu3.setText("File");
					{
						newFileMenuItem = new JMenuItem();
						jMenu3.add(newFileMenuItem);
						newFileMenuItem.setText("New");
					}
					{
						openFileMenuItem = new JMenuItem();
						jMenu3.add(openFileMenuItem);
						openFileMenuItem.setText("Open");
					}
					{
						saveMenuItem = new JMenuItem();
						jMenu3.add(saveMenuItem);
						saveMenuItem.setText("Save");
					}
					{
						saveAsMenuItem = new JMenuItem();
						jMenu3.add(saveAsMenuItem);
						saveAsMenuItem.setText("Save As ...");
					}
					{
						closeFileMenuItem = new JMenuItem();
						jMenu3.add(closeFileMenuItem);
						closeFileMenuItem.setText("Close");
					}
					{
						jSeparator2 = new JSeparator();
						jMenu3.add(jSeparator2);
					}
					{
						exitMenuItem = new JMenuItem();
						jMenu3.add(exitMenuItem);
						exitMenuItem.setText("Exit");
					}
				}
				{
					jMenu4 = new JMenu();
					jMenuBar1.add(jMenu4);
					jMenu4.setText("Edit");
					{
						cutMenuItem = new JMenuItem();
						jMenu4.add(cutMenuItem);
						cutMenuItem.setText("Cut");
					}
					{
						copyMenuItem = new JMenuItem();
						jMenu4.add(copyMenuItem);
						copyMenuItem.setText("Copy");
					}
					{
						pasteMenuItem = new JMenuItem();
						jMenu4.add(pasteMenuItem);
						pasteMenuItem.setText("Paste");
					}
					{
						jSeparator1 = new JSeparator();
						jMenu4.add(jSeparator1);
					}
					{				
						deleteMenuItem = new JMenuItem();
						jMenu4.add(deleteMenuItem);
						deleteMenuItem.setText("Delete");
					}
				}
				{
					jMenu5 = new JMenu();
					jMenuBar1.add(jMenu5);
					jMenu5.setText("Help");
					{
						helpMenuItem = new JMenuItem();
						jMenu5.add(helpMenuItem);
						helpMenuItem.setText("Help");
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
