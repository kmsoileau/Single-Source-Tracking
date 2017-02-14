package positronic.awt.plotting;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Panel;


/**
 * Title: AbstractPlotPanel Description: This bean provides a skeleton for a
 * Panel as a drawing region. Copyright (c) 2003 Company: NASA Johnson Space
 * Center OD/ISS Avionics Office
 * 
 * @author Kerry M. Soileau
 * @version 1.0
 */

public abstract class AbstractPlotPanel extends Panel 
{
  private static final long serialVersionUID = -5538517117223729025L;
	private int _penX;
  private int _penY;
  private int[] _locate_x = new int[2];
  private int[] _locate_y = new int[2];
  private double _scalex1, _scalex2, _scaley1, _scaley2;
  private Graphics2D _g2d;
  private double _a, _b, _c, _d;

  public AbstractPlotPanel() 
  {
      this.locate(0, 0, 100, 100);
  }

  public void axes(double x_tick, double y_tick) 
  {
      axes(x_tick, y_tick, 0., 0., 2, 2);
  }

  public void axes(double x_tick, double y_tick, double x_intersect,
          double y_intersect) 
  {
      axes(x_tick, y_tick, x_intersect, y_intersect, 2, 2);
  }

  public void axes(double x_tick, double y_tick, double x_intersect,
          double y_intersect, int x_tick_size, int y_tick_size) 
  {
      double x;
      double y;
      double c1;
      double r1;
      double c2;
      double r2;
      int e;
      int g;
      int f;

      if (x_intersect < _a)
          x_intersect = _a;
      if (x_intersect > _b)
          x_intersect = _b;
      if (y_intersect < _c)
          y_intersect = _c;
      if (y_intersect > _d)
          y_intersect = _d;

      x = x_intersect;
      y = y_intersect;

      while (x < _b) {
          c1 = _scalex1 * x + _scalex2;
          r1 = _scaley1 * y + _scaley2;
          c2 = c1 + _scalex1 * x_tick;
          if (c2 > _locate_x[1])
              c2 = _locate_x[1];
          e = (int) c1;
          f = (int) r1;
          g = (int) c2;
          move_p(e, f);
          draw_p(g, f);
          f += x_tick_size;
          if (f > _locate_y[1])
              f = _locate_y[1];
          move_p(g, f);
          f += -2 * x_tick_size;
          if (f < _locate_y[0])
              f = _locate_y[0];
          draw_p(g, f);
          x += x_tick;
      }

      x = x_intersect;
      y = y_intersect;

      while (x > _a) 
      {
          c1 = _scalex1 * x + _scalex2;
          r1 = _scaley1 * y + _scaley2;
          c2 = c1 - _scalex1 * x_tick;
          if (c2 < _locate_x[0])
              c2 = _locate_x[0];
          e = (int) c1;
          f = (int) r1;
          g = (int) c2;
          move_p(e, f);
          draw_p(g, f);
          f += x_tick_size;
          if (f > _locate_y[1])
              f = _locate_y[1];
          move_p(g, f);
          f += -2 * x_tick_size;
          if (f < _locate_y[0])
              f = _locate_y[0];
          draw_p(g, f);
          x += -x_tick;
      }

      x = x_intersect;
      y = y_intersect;

      while (y > _c) 
      {
          c1 = _scalex1 * x + _scalex2;
          r1 = _scaley1 * y + _scaley2;
          r2 = r1 - _scaley1 * y_tick;
          if (r2 > _locate_y[1])
              r2 = _locate_y[1];
          e = (int) c1;
          f = (int) r1;
          g = (int) r2;
          move_p(e, f);
          draw_p(e, g);
          e += -y_tick_size;
          if (e < _locate_x[0])
              e = _locate_x[0];
          move_p(e, g);
          e += 2 * y_tick_size;
          if (e > _locate_x[1])
              e = _locate_x[1];
          draw_p(e, g);
          y += -y_tick;
      }

      x = x_intersect;
      y = y_intersect;

      while (y < _d) 
      {
          c1 = _scalex1 * x + _scalex2;
          r1 = _scaley1 * y + _scaley2;
          r2 = r1 + _scaley1 * y_tick;
          if (r2 < _locate_y[0])
              r2 = _locate_y[0];
          e = (int) c1;
          f = (int) r1;
          g = (int) r2;
          move_p(e, f);
          draw_p(e, g);
          e += -y_tick_size;
          if (e < _locate_x[0])
              e = _locate_x[0];
          move_p(e, g);
          e += 2 * y_tick_size;
          if (e > _locate_x[1])
              e = _locate_x[1];
          draw_p(e, g);
          y += y_tick;
      }
  }

  /**
   * Using the specified color, make all points inside the specified rectangle
   * the same color.
   */
  public void clearRect(int x, int y, int w, int h, Color c) 
  {
      _g2d.setBackground(c);
      _g2d.clearRect(x, y, w, h);
  }

  /** Draw a line from the last scaled point (move/draw) to a specified point. */
  public void draw(double a, double b) 
  {
      int c, r;

      c = (int) (_scalex1 * a + _scalex2);
      r = (int) (_scaley1 * b + _scaley2);

      draw_p(c, r);
  }

  /** Draw a string at a given scaled screen location. */
  public void draw(String s, double x, double y) 
  {
      int c, r;

      c = (int) (_scalex1 * x + _scalex2);
      r = (int) (_scaley1 * y + _scaley2);
      _g2d.drawString(s, c, r);
  }

  /** Draw a string at a given physical screen location. */
  public void draw(String s, int x, int y) 
  {
      _g2d.drawString(s, x, y);
  }

  /**
   * Draw a line from the last physical point (move/draw) to a specified
   * physical point.
   */
  public void draw_p(int x, int y) 
  {
      _g2d.drawLine(_penX, _penY, x, y);
      _penX = x;
      _penY = y;
  }

  public void drawCircle(double x, double y, double radius) 
  {
      drawCircle(x, y, radius, 360);
  }

  public void drawCircle(double x, double y, double radius, int divisions) 
  {
      double oldangle = 0.;
      for (double angle = 0.; angle < 2. * Math.PI; angle += 2. * Math.PI
              / divisions) {
          this.move(x + radius * Math.cos(oldangle), y + radius
                  * Math.sin(oldangle));
          this.draw(x + radius * Math.cos(angle), y + radius
                  * Math.sin(angle));
          oldangle = angle;
      }
      this.move(x + radius * Math.cos(oldangle), y + radius
              * Math.sin(oldangle));
      this.draw(x + radius * Math.cos(2. * Math.PI), y + radius
              * Math.sin(2. * Math.PI));
  }

  public void fillRect(int a, int b, int c, int d) 
  {
      _g2d.fillRect(a, b, c, d);
  }

  /**
   * Using the current pen color, draw the rectangular boundary of the located
   * physical area.
   */
  public void frame() 
  {
      _g2d.drawRect(_locate_x[0], _locate_y[0], _locate_x[1] - _locate_x[0],
              _locate_y[1] - _locate_y[0]);
  }

  public int get_penX() 
  {
      return _penX;
  }

  public int get_penY() 
  {
      return _penY;
  }

  public Graphics2D getGraphics2D() 
  {
      return this._g2d;
  }

  /**
   * Define a rectangular physical area for graphing. The rectangle is located
   * at (a,b), and has width c and height d.
   */
  public void locate(int a, int b, int c, int d) {
      _locate_x[0] = a;
      _locate_x[1] = a + c;
      _locate_y[0] = b;
      _locate_y[1] = b + d;
      this.scale(0., 1., 0., 1.);
  }

  /** Move to a given scaled screen location. */
  public void move(double a, double b) 
  {
      int c, r;

      c = (int) (_scalex1 * a + _scalex2);
      r = (int) (_scaley1 * b + _scaley2);

      move_p(c, r);
  }

  /** Move to a given physical screen location. */
  public void move_p(int x, int y) 
  {
      _penX = x;
      _penY = y;
  }

  public void paint(Graphics g) 
  {
      update(g);
  }

  /** Set the pen color. */
  public void pen(Color color) 
  {
      _g2d.setColor(color);
  }

  public void run() 
  {
      while(true) 
      {
          try 
          {
              Thread.sleep(10);
          } 
          catch (java.lang.InterruptedException err) 
          {
          }
          repaint();
      }
  }

  /** Scale the located area. */
  // (_locate_x[0],_locate_y[0]) *--------------* (_locate_x[1],_locate_y[0])
  // | |
  // | |
  // | |
  // (_locate_x[0],_locate_y[1]) *--------------* (_locate_x[1],_locate_y[1])
  public void scale(double a, double b, double c, double d) 
  {
      _scalex1 = (_locate_x[1] - _locate_x[0]) / (b - a);
      _scalex2 = (_locate_x[0] - _locate_x[1]) / (b - a) * a + _locate_x[0];
      _scaley1 = (_locate_y[1] - _locate_y[0]) / (c - d);
      _scaley2 = (_locate_y[0] - _locate_y[1]) / (c - d) * d + _locate_y[0];
      _a = a;
      _b = b;
      _c = c;
      _d = d;
  }

  public void set_penX(int _penX) 
  {
      this._penX = _penX;
  }

  public void set_penY(int _penY) 
  {
      this._penY = _penY;
  }

  /**
   * Set the Graphics2D object equal to the Graphics2D cast of the Graphics
   * object g.
   */
  public void setGraphics2D(Graphics g) 
  {
      this._g2d = (Graphics2D) g;
  }

  /** Set the Graphics2D object equal to the Graphics2D object g. */
  public void setGraphics2D(Graphics2D g) 
  {
      this._g2d = g;
  }

  public abstract void update(Graphics g);
}