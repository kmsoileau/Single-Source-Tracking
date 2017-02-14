package positronic.awt;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.awt.image.RGBImageFilter;

public class Transparency extends Image
{
	Image image;
	
  public Transparency(Image im, final Color color)
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
    image=Toolkit.getDefaultToolkit().createImage(ip);
  }

	public Graphics getGraphics()
	{
		return image.getGraphics();
	}

	public int getHeight(ImageObserver observer)
	{
		return image.getHeight(observer);
	}

	public Object getProperty(String name, ImageObserver observer)
	{
		return image.getProperty(name, observer);
	}

	public ImageProducer getSource()
	{
		return image.getSource();
	}

	public int getWidth(ImageObserver observer)
	{
		return image.getWidth(observer);
	}
}

