package positronic.awt;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 * Title: Plotter
 * Description: TBS
 * Copyright (c) 2001, 2002
 * Company: NASA Johnson Space Center OD/ISS Avionics Office
 * @author Kerry M. Soileau
 * @version 1.0
 */

public class Plotter
{
  //private Frame theFrame;
  private int penX;
  private int penY;
  private int[] locate_x=new int[2];
  private int[] locate_y=new int[2];
  private double _scalex1=0d,_scalex2=0d,_scaley1=0d,_scaley2=0d;
  private Graphics2D g2d;
  private double _a,_b,_c,_d;
  //public Point penLocation=new Point(0,0);

  public Plotter()
  {
    this.locate(0,0,350,100);
    //this.scale(0.,1.,0.,1.);
  }

  /*
  public Plotter(Frame theFrame)
  {
    this.theFrame=theFrame;
  }
  */

  /** Locate a physical area for graphing located at (a,b), width=c, height=d*/
  public void locate(int a, int b, int c, int d)
  {
    locate_x[0]=a;
    locate_x[1]=a+c;
    locate_y[0]=b;
    locate_y[1]=b+d;
    this.scale(0.,1.,0.,1.);
  }

  /** Draw a rectangle enclosing the located physical area */
  public void frame()
  {
    g2d.drawRect(locate_x[0],locate_y[0],locate_x[1]-locate_x[0],locate_y[1]-locate_y[0]);
  }

  /** Scale the located area

  (locate_x[0],locate_y[0])   *--------------*  (locate_x[1],locate_y[0])
                              |              |
                              |              |
                              |              |
  (locate_x[0],locate_y[1])   *--------------*  (locate_x[1],locate_y[1])

  */
  public void scale(double a, double b, double c, double d)
  {
    _scalex1=(locate_x[1]-locate_x[0])/(b-a);
    _scalex2=(locate_x[0]-locate_x[1])/(b-a)*a+locate_x[0];
    _scaley1=(locate_y[1]-locate_y[0])/(c-d);
    _scaley2=(locate_y[0]-locate_y[1])/(c-d)*d+locate_y[0];
    _a=a;
    _b=b;
    _c=c;
    _d=d;
  }

  /** Set the pen color. */
  public void pen(Color color)
  {
    g2d.setColor(color);
  }

  /** Draw a string at a given physical screen location. */
  public void draw(String s,int x,int y)
  {
    //g2d.drawString(x+"",x,y);
    g2d.drawString(s,x,y);
  }

  /** Move to a given scaled screen location.   */
  public void move(double a, double b)
  {
    int c,r;

    c=(int)(_scalex1*a+_scalex2);
    r=(int)(_scaley1*b+_scaley2);

    move_p(c,r);
  }

/** Draw a line from the last scaled point (move/draw)
   to a specified point                               */
  public void draw(double a, double b)
  {
    int c,r;

    c=(int)(_scalex1*a+_scalex2);
    r=(int)(_scaley1*b+_scaley2);

    draw_p(c,r);
    //this.penLocation.setLocation(c,r);
  }

  /** Draw a string at a given scaled screen location. */
  public void draw(String s,double x,double y)
  {
    int c,r;

    c=(int)(_scalex1*x+_scalex2);
    r=(int)(_scaley1*y+_scaley2);
    //g2d.drawString(x+"",c,r);
    g2d.drawString(s,c,r);
    //this.penLocation.setLocation(c,r);
  }

  /** Move to a given physical screen location. */
  public void move_p(int x, int y)
  {
    penX=x;
    penY=y;
    //this.penLocation.setLocation(x,y);
  }

  /** Draw a line from the last physical point (move/draw)
   to a specified physical point                               */
  public void draw_p(int x, int y)
  {
    g2d.drawLine(penX,penY, x, y);
    penX=x;
    penY=y;
    //this.penLocation.setLocation(x,y);
  }

  public void clearRect(int x,int y,int w, int h)
  {
    g2d.clearRect(x,y,w,h);
  }

  public void setGraphics2D(Graphics2D g)
  {
    this.g2d=g;
  }

  public void setGraphics2D(Graphics g)
  {
    this.g2d=(Graphics2D)g;
  }

  public void axes(double x_minor_tick,double y_minor_tick,double x_intersect,double y_intersect)
  {
    double x,y;
    double c1,r1,c2,r2;
    int e,g,f;

    if(x_intersect<_a) x_intersect=_a;
    if(x_intersect>_b) x_intersect=_b;
    if(y_intersect<_c) y_intersect=_c;
    if(y_intersect>_d) y_intersect=_d;

    x=x_intersect;
    y=y_intersect;

    while (x<_b)
    {
      c1=_scalex1*x+_scalex2;
      r1=_scaley1*y+_scaley2;
      c2=c1+_scalex1*x_minor_tick;
      if (c2>locate_x[1]) c2=locate_x[1];
      e=(int)c1;
      f=(int)r1;
      g=(int)c2;
      move_p(e,f);
      draw_p(g,f);
      f=f+2;
      if(f>locate_y[1]) f=locate_y[1];
      move_p(g,f);
      f=f-4;
      if(f<locate_y[0]) f=locate_y[0];
      draw_p(g,f);
      x=x+x_minor_tick;
    }

    x=x_intersect;
    y=y_intersect;

    while (x>_a)
    {
      c1=_scalex1*x+_scalex2;
      r1=_scaley1*y+_scaley2;
      c2=c1-_scalex1*x_minor_tick;
      if (c2<locate_x[0]) c2=locate_x[0];
      e=(int)c1;
      f=(int)r1;
      g=(int)c2;
      move_p(e,f);
      draw_p(g,f);
      f=f+2;
      if(f>locate_y[1]) f=locate_y[1];
      move_p(g,f);
      f=f-4;
      if(f<locate_y[0]) f=locate_y[0];
      draw_p(g,f);
      x=x-x_minor_tick;
    }

    x=x_intersect;
    y=y_intersect;

    while (y>_c)
    {
      c1=_scalex1*x+_scalex2;
      r1=_scaley1*y+_scaley2;
      r2=r1-_scaley1*y_minor_tick;
      if (r2>locate_y[1]) r2=locate_y[1];
      e=(int)c1;
      f=(int)r1;
      g=(int)r2;
      move_p(e,f);
      draw_p(e,g);
      e=e-4;
      if(e<locate_x[0]) e=locate_x[0];
      move_p(e,g);
      e=e+8;
      if(e>locate_x[1]) e=locate_x[1];
      draw_p(e,g);
      y=y-y_minor_tick;
    }

    x=x_intersect;
    y=y_intersect;

    while (y<_d)
    {
      c1=_scalex1*x+_scalex2;
      r1=_scaley1*y+_scaley2;
      r2=r1+_scaley1*y_minor_tick;
      if (r2<locate_y[0]) r2=locate_y[0];
      e=(int)c1;
      f=(int)r1;
      g=(int)r2;
      move_p(e,f);
      draw_p(e,g);
      e=e-4;
      if(e<locate_x[0]) e=locate_x[0];
      move_p(e,g);
      e=e+8;
      if(e>locate_x[1]) e=locate_x[1];
      draw_p(e,g);
      y=y+y_minor_tick;
    }
  }
  public int getPenX() {
    return penX;
  }
  public void setPenX(int penX) {
    this.penX = penX;
  }
  public int getPenY() {
    return penY;
  }
  public void setPenY(int penY) {
    this.penY = penY;
  }

  public void setBackground(Color c)
  {
    g2d.setBackground(c);
  }

  public void setForeground(Color c)
  {
    g2d.setColor(c);
  }

  public void fillRect(int a, int b, int c, int d)
  {
    g2d.fillRect(a,b,c,d);
  }

  public void drawCircle(double x, double y, double radius)
  {
    drawCircle(x,y,radius,360);
  }

  public void drawCircle(double x, double y, double radius, int divisions)
  {
    double oldangle=0.;
    for(double angle=0.;angle<2.*Math.PI;angle+=2.*Math.PI/divisions)
    {
      this.move(x+radius*Math.cos(oldangle),y+radius*Math.sin(oldangle));
      this.draw(x+radius*Math.cos(angle),y+radius*Math.sin(angle));
      oldangle=angle;
    }
    this.move(x+radius*Math.cos(oldangle),y+radius*Math.sin(oldangle));
    this.draw(x+radius*Math.cos(2.*Math.PI),y+radius*Math.sin(2.*Math.PI));
  }

  /*
  public Frame getFrame()
  {
    return theFrame;
  }
  */
}