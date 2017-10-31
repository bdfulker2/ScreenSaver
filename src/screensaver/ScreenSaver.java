/**
 * This program is a screen saver program of a 6 sided rectangular spiral. Its
 * radius starts out at 10 and grows by 13 pixels every for every time the 
 * numOfPoints % 3 = 0. The spirals points starts out being drawn every second
 * but the speed will increase or decrease based on the users mouse wheel clicks
 * the user spins the mouse wheel up or away it will speed up Its speed is will
 * stop growing at 40 miliseconds. If the user rolls the mouse towards himself
 * it will increase to a maximum of 10,000 milesecnds or 10 seconds. 
 *
 */
package screensaver;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Your Name <EIN = 815021596>
 * extends JPanel
 * implements MouseWheelListener
 * implements ActionListener
 */
public class ScreenSaver extends JPanel implements MouseWheelListener, ActionListener {
    private int x[]=new int[60];         //number of x coordinate points
    private int y[]=new int[60];         //number of y coordinate points
    private int numOfPoints=0;           //numOfPoints counter
    private int radius=10;               //starting readius
    private int delay=1000;              //starting delay drawing speed
    private Timer timer=null;            //Time set to null initially
    private double centerX=-1;           
    private double centerY=-1;
    
   
    public ScreenSaver(){
      
        addMouseWheelListener(this);          //adds MouseWheelListener to panel
        
        timer = new Timer(delay, this);       //initial timer
        // the interval is 1000 milliseconds
        timer.start();                        //starts the timer
    }


    //
    @Override
    public void paintComponent(Graphics g){
        g.clearRect(0,0,(int)getSize().getWidth(),(int)getSize().getHeight());
        /*insert your code here */
       
                                 //increases the radius when numOfPOints % 3 = 0
        if(numOfPoints % 3 ==0)     
            radius +=13;
        if(numOfPoints == 59) //on the last of 60 points reset raduis to 10
            radius = 10;        //to resarte
            
        g.drawPolyline(x, y, numOfPoints);      //draw the polyLine
    }
        

    public void addAPoint() {
        if(centerX < 0) centerX = (int)getSize().getWidth()/2;
        if(centerY < 0) centerY = (int)getSize().getHeight()/2;
        
        double xX=centerX+Math.cos(numOfPoints*Math.PI/3)*radius;
        double yY=centerY+Math.sin(numOfPoints*Math.PI/3)*radius;
        
        // saving the point for display each new point is saved here in this.x[]
        //and in this.y[]
        this.x[numOfPoints] = (int)xX;
        this.y[numOfPoints] = (int)yY;
    }
   /** e.getWheelRotation()returns the number of "clicks" the mouse wheel was
    * rotated. Negative values if the mouse wheel was rotated up/away from the 
    * user, and positive values if the mouse wheel was rotated down/ towards the 
    * user. On every notch away I decrease the delay by 20 MS but once the user
    * speeds the delay I have it stop decreasing at a delay of 40MS. If the user
    * spins the wheel towards him it increases by 20 MS and is capped at 10000
    * MS or 10 S. it then updates the 
    */
    /* update delay*/
    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
       
        int notches = e.getWheelRotation();
        
        if(notches <0)
        {
            delay = delay - 20;
            System.out.println("mouse wheel up  = " +e.getWheelRotation());
            if(delay <= 40) {
                delay = 40;
            }
        }
        else
        {
            delay = delay + 20; 
            System.out.println("mouse wheel up  = " +e.getWheelRotation());
            if(delay >= 10000) {
                delay = 10000;
            }
        }
        timer.setDelay(delay);
        timer.restart();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        addAPoint();
        numOfPoints = (numOfPoints + 1) % 60;
        repaint();
    }
}
	
