package positronic.awt.graphics;

import java.awt.Color;

public class FrameDemo 
{
    private static void createAndShowGUI() 
    {
		Graphics g=new Graphics("Graphics Demo",600,600);
		g.show();
        g.locate(40,40,540,520);
        g.scale(-150.,150.,-150.,150.);
        
        g.setPen(Color.red);
        g.setStroke(2.0);
    	
        double x=100.;
        double y=0.;
        double vX=3.;
        double vY=-13;
        double K=25000.;
        double dt=.001;
        
        g.move(x,y);
        for(double t=0.;t<27.3;t+=dt)
        {
        	g.draw(x,y);
        	double accel=-K/(x*x+y*y);
        	double accelX=accel*x/Math.sqrt(x*x+y*y);
        	double accelY=accel*y/Math.sqrt(x*x+y*y);
        	x+=(vX*dt+1/2*accelX*dt*dt);
        	y+=(vY*dt+1/2*accelY*dt*dt);
        	vX+=accelX*dt;
        	vY+=accelY*dt;
        }
        g.setPen(Color.blue);
        g.setStroke(4.);
        g.frame();
    }
 
    public static void main(String[] args) 
    {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() 
        {
            public void run() 
            {
                createAndShowGUI();
            }
        });
    }
}