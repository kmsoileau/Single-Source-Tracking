package positronic.awt;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Title: PlotterPanel
 * Description: This bean provides a JPanel as a drawing region.
 * Copyright (c) 2003
 * Company: NASA Johnson Space Center OD/ISS Avionics Office
 * @author Kerry M. Soileau
 * @version 1.0
 */

public class PlotterPanel extends AbstractPlotPanel
{
  private static final long serialVersionUID = 1L;

	public void update(Graphics g)
  {
    setGraphics2D(g);
    clearRect(0,0,getWidth(),getHeight(),Color.cyan);

    locate(0,0,getWidth(),getHeight()-1);
    scale(0.,2.*Math.PI,0.,2.*Math.PI);
    pen(Color.blue);
    frame();
    move(0.,0.);

    for(double x=0.;x<2.*Math.PI;x+=.01)
      for(double y=0.;y<2.*Math.PI;y+=.01)
      if(3.*x-2.*y<1.)
      {
        float red=(float)((Math.sin(7.*x)*Math.sin(4.*y)+1.)/2.);
        float green=red;
        float blue=red;
        try
        {
          pen(new Color(red,green,blue));
        }
        catch(java.lang.IllegalArgumentException err)
        {
          //int h=0;
        }
        move(x,y);
        draw(x,y);
      }

    pen(Color.orange);
    drawCircle(.3,.5,1.2);
    draw("Duh",10,10);

    move(0.,0.);
    draw(1.,1.);
    pen(Color.green);
    axes(.5,.1);
  }
}