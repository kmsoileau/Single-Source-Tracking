package positronic.awt;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;

import javax.swing.JPanel;
/**
 * <p>Title: JIconPanel</p>
 * <p>Description: A JPanel with a desired image as background.</p>
 * <p>Copyright (c) 2005</p>
 * <p>Company: Positronic Software</p>
 * @author Kerry M. Soileau
 * @version 1.0 2005/06/29
 */

public class JIconPanel extends JPanel
{
  private static final long serialVersionUID = 1L;
	private String fileName;
  private int iconHeight;
  private int iconWidth;
  private Image img;
  //If the graphic is in gif format, the following two fields allow the
  //definition of a transparent color.
  private Color transparentColor;
  private boolean transparency;

  public String getFileName()
  {
    return fileName;
  }

  public int getIconHeight()
  {
    return iconHeight;
  }

  public int getIconWidth()
  {
    return iconWidth;
  }

  public Color getTransparentColor() {
    return transparentColor;
  }

  public boolean isTransparency() {
    return transparency;
  }
  public void paint(Graphics g)
  {
    super.paint(g);

    if(img==null)
    {
      img = Toolkit.getDefaultToolkit().getImage(this.fileName);
      if(this.isTransparency())
        img = new Transparency(img, this.getTransparentColor());
      this.iconHeight=img.getHeight(this);
      this.iconWidth=img.getWidth(this);
    }

    try
    {
      MediaTracker tracker = new MediaTracker(this);
      tracker.addImage(img, 0);
      tracker.waitForID(0);
    }
    catch (Exception e)
    {}

    this.iconHeight=img.getHeight(this);
    this.iconWidth=img.getWidth(this);
    this.setBounds(this.getX(),this.getY(),img.getWidth(this),img.getHeight(this));

    ((Graphics2D)g).drawImage(img, 0, 0, null);
  }
  public void setFileName(String fileName)
  {
    this.fileName = fileName;
  }
  public void setTransparency(boolean transparency) {
    this.transparency = transparency;
  }
  public void setTransparentColor(Color transparentColor) {
    this.transparentColor = transparentColor;
  }
}

/*class Transparency
{
public static Image makeColorTransparent(Image im, final Color color)
{
  ImageFilter filter = new RGBImageFilter()
  {
    // the color we are looking for... Alpha bits are set to opaque
    public int markerRGB = color.getRGB() | 0xFF000000;

    public final int filterRGB(int x, int y, int rgb)
    {
      if ( ( rgb | 0xFF000000 ) == markerRGB )
      {
        // Mark the alpha bits as zero - transparent
        return 0x00FFFFFF & rgb;
      }
      else
      {
        // nothing to do
        return rgb;
      }
    }
  };

  ImageProducer ip = new FilteredImageSource(im.getSource(), filter);
  return Toolkit.getDefaultToolkit().createImage(ip);
}
}
*/

