package positronic.awt;

/**
 * <p>Title: RunnablePlotPanel</p>
 * <p>Description: RunnablePlotPanel</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: Positronic Software</p>
 * @author Kerry Michael Soileau
 * @version 1.0
 */

abstract public class RunnablePlotPanel extends positronic.awt.AbstractPlotJPanel implements Runnable
{
	private static final long serialVersionUID = -58710557770676817L;
	private Thread panelThread;
	private int millis;

	public RunnablePlotPanel()
	{
		this(100);
	}

	public RunnablePlotPanel(int millis)
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