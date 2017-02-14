package positronic.awt.geometry;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import positronic.awt.plotting.RunnablePlotJPanel;


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
public class PolygonDrawer extends JFrame 
{
	private static final long serialVersionUID = -4504615437576886437L;
	PositronicPolygon florida;
	
	public static void main(String[] args) 
	{
		SwingUtilities.invokeLater(new Runnable() 
		{
			public void run() 
			{
				PolygonDrawer inst;
				try 
				{
					inst = new PolygonDrawer();
					inst.setLocationRelativeTo(null);
					inst.setVisible(true);
				} catch (ImproperlyFormedPolygonException e)
				{
					e.printStackTrace();
				}
			}
		});
	}
	
	private JPanel jPanel1;
	private JPanel jPanel3;

	private JPanel jPanel2;
	
	public PolygonDrawer() throws ImproperlyFormedPolygonException 
	{
		super();
		florida=new PositronicPolygon(
				new Point[]
						{
							new Point(-85.58316717,30.99637542),
							new Point(-85.054802,31.000585),
							new Point(-84.78992591,30.70859708),
							new Point(-84.374905,30.689794),
							new Point(-83.80892924,30.66179622),
							new Point(-83.309455,30.634417),
							new Point(-82.877259,30.609024),
							new Point(-82.374844,30.579004),
							new Point(-82.04116428,30.39684058),
							new Point(-81.979061,30.776415),
							new Point(-81.59364838,30.7254589),
							new Point(-81.407008,30.42204),
							new Point(-81.29464546,29.92728925),
							new Point(-81.123896,29.474465),
							new Point(-80.88283647,29.0181457),
							new Point(-80.60647176,28.62300417),
							new Point(-80.58834626,28.1722922),
							new Point(-80.38088553,27.73148587),
							new Point(-80.19928802,27.26302172),
							new Point(-80.031362,26.796339),
							new Point(-80.07639938,26.305257),
							new Point(-80.12410608,25.80766221),
							new Point(-80.3054434,25.55950369),
							new Point(-80.508113,25.206719),
							new Point(-80.900066,25.162034),
							new Point(-81.12141,25.33875),
							new Point(-81.346078,25.721473),
							new Point(-81.672633,25.856654),
							new Point(-81.83176743,26.28814703),
							new Point(-82.11199628,26.54084972),
							new Point(-82.06657523,26.88237004),
							new Point(-82.24234946,26.77345047),
							new Point(-82.46889,27.113612),
							new Point(-82.73249503,27.52114603),
							new Point(-82.457543,27.752571),
							new Point(-82.533218,27.870701),
							new Point(-82.567919,27.883701),
							new Point(-82.73847906,27.67776367),
							new Point(-82.79414595,28.00515882),
							new Point(-82.677839,28.434367),
							new Point(-82.64486126,28.88925245),
							new Point(-82.887211,29.161741),
							new Point(-83.17676228,29.34634687),
							new Point(-83.448194,29.675254),
							new Point(-83.79995745,29.97872551),
							new Point(-84.237014,30.08556),
							new Point(-84.470323,29.924524),
							new Point(-84.9016356,29.73597221),
							new Point(-85.29074,29.684081),
							new Point(-85.36380001,29.69352595),
							new Point(-85.54404626,29.9986536),
							new Point(-85.92444477,30.23880535),
							new Point(-86.41288265,30.38039478),
							new Point(-86.9192924,30.37067511),
							new Point(-87.419859,30.297128),
							new Point(-87.407877,30.456396),
							new Point(-87.572043,30.800532),
							new Point(-87.34783697,30.9982541),
							new Point(-86.872989,30.997631),
							new Point(-86.364907,30.994455),
							new Point(-86.052462,30.993247),
							new Point(-84.884632,29.652248),
							new Point(-84.81335154,29.68702848),
							new Point(-85.083719,29.679019),
							new Point(-85.156415,29.679628),
							new Point(-82.82152056,28.00647708),
							new Point(-82.26723546,26.68610528),
							new Point(-82.063114,26.425459),
							new Point(-82.22940532,26.61040358),
							new Point(-80.27374931,25.31008276),
							new Point(-80.57314595,24.95343594),
							new Point(-80.444887,25.092966),
							new Point(-80.249774,25.39340228),
							new Point(-80.81208943,24.82975811),
							new Point(-81.03429,24.727341),
							new Point(-80.92004707,24.77882222),
							new Point(-81.35631306,24.75526521),
							new Point(-81.54645,24.614895),
							new Point(-81.65573549,24.61629521),
							new Point(-81.40003247,24.74750425),
							new Point(-81.249799,24.673357)
						});
		initGUI();
	}
	
	private void initGUI() 
	{
		try {
			BoxLayout thisLayout = new BoxLayout(getContentPane(), javax.swing.BoxLayout.Y_AXIS);
			getContentPane().setLayout(thisLayout);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				jPanel1 = new JPanel();
				getContentPane().add(jPanel1);
			}
			{
				jPanel2 = new RunnablePlotJPanel(1000)
				{
					private static final long serialVersionUID = 8202884634130117916L;

					public void update(Graphics g)
					{
						this.setGraphics2D(g);
						this.locate(5,5,300,300);
						this.scale(-85,-80,24,32);
						this.pen(Color.magenta);
						for(int i=0;i<florida.getNumberOfVertices();i++)
							this.draw(florida.getXpoints()[i],florida.getYpoints()[i]);
						this.pen(Color.black);
						this.frame();
					}
				};
				getContentPane().add(jPanel2);
			}
			{
				jPanel3 = new JPanel();
				getContentPane().add(jPanel3);
			}
			pack();
			setSize(500, 500);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
