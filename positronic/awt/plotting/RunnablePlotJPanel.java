package positronic.awt.plotting;


/**
 * <p>Title: RunnablePlotJPanel</p>
 * <p>Description: RunnablePlotJPanel</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Positronic Software</p>
 * @author Kerry Michael Soileau
 * @version 1.0
 */

abstract public class RunnablePlotJPanel extends AbstractPlotJPanel implements Runnable
{
	private static final long serialVersionUID = -58710557770676817L;
	private Thread panelThread;
	private int millis;

	public RunnablePlotJPanel()
	{
		this(100);
	}

	public RunnablePlotJPanel(int millis)
	{
		this.millis=millis;
		panelThread=new Thread(this);
		panelThread.start();
	}

	public void run()
	{
		while(true)
		{
			try
			{
				Thread.sleep(millis);
			}
			catch(java.lang.InterruptedException err)
			{
			}
			repaint();
		}
	}
}