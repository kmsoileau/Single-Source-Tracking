package positronic.awt;

/**
 * <p>Title: FlashingToggleButton</p>
 * <p>Description: Works just like javax.swing.JToggleButton, except it will flash
 * at a user-specified interval given in milliseconds.</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Institution: NASA Johnson Space Center</p>
 * @author Kerry M. Soileau
 * @version 1.0
 */
import java.awt.Color;
import java.awt.event.MouseEvent;

public class FlashingToggleButton extends javax.swing.JToggleButton implements Runnable
{
	private static final long serialVersionUID = 1L;
	private Thread flashThread;
	private int flickerInterval;
	private boolean flicker;

	/**
  	* Constructs a new FlashingToggleButton which when in the "pressed" condition flashes once each 500 milliseconds.
  	*
  	* @param flickerInterval The flashing interval in milliseconds.
  	*/
  	public FlashingToggleButton()
  	{
    	this(500);
  	}

  	/**
  	* Constructs a new FlashingToggleButton which when in the "pressed" condition flashes at a regular rate.
  	*
  	* @param flickerInterval The flashing interval in milliseconds.
  	*/
  	public FlashingToggleButton(int flickerInterval)
  	{
    	this.setFlickerInterval(flickerInterval);
    	flicker=this.isSelected();
    	flashThread=new Thread(this);
    	flashThread.setDaemon(true);
    	flashThread.start();
    	try 
    	{
    		jbInit();
    	}
    	catch(Exception e) 
    	{
    		e.printStackTrace();
    	}
  	}

  public void run()
  {
	  Color defaultForeground=this.getForeground();
	  Color defaultBackground=this.getBackground();
	  while(true)
	  {
		  if(flicker)
		  {
			  Color c=this.getForeground();
			  this.setForeground(this.getBackground());
			  this.setBackground(c);
			  try
			  {
				  Thread.sleep(flickerInterval);
			  }
			  catch(java.lang.InterruptedException err)
			  {
			  }
		  }
		  else
		  {
			  this.setForeground(defaultForeground);
			  this.setBackground(defaultBackground);
		  }
	  }
  }

  public int getFlickerInterval()
  {
	  return this.flickerInterval;
  }

  public void setFlickerInterval(int f)
  {
	  this.flickerInterval=f;
  }

  public static void main(String[] args)
  {
	  //FlashingToggleButton flashingToggleButton1 = new FlashingToggleButton();
  }

  private void jbInit() throws Exception
  {
	  this.addMouseListener(new java.awt.event.MouseAdapter()
	  {
		  public void mouseReleased(MouseEvent e)
		  {
			  this_mouseReleased(e);
		  }
	  });
  }

  void this_mouseReleased(MouseEvent e)
  {
	  flicker=!flicker;
  }
}