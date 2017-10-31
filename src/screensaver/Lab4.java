package screensaver;


import java.awt.BorderLayout;
import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Your Name <Ben Fulker FGCU.EDU>
 */
public class Lab4 extends JFrame {
    /** 
     * Creates a frame with only one component: ScreenSaver 
     */
    public Lab4(){
        super("Lab 4");

        setSize(600,600);
        ScreenSaver saver=new ScreenSaver();
        
        setLayout(new BorderLayout());
        add(saver, BorderLayout.CENTER);
    }
/** * Launches the application. * @param args */
    public static void main(String args[]) {    
    Lab4 lab4=new Lab4();
   
    lab4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );    
    lab4.setSize( 600, 600 ); 
    // set frame size    
    lab4.setResizable(true);     
    lab4.setVisible( true ); // display frame
    }
}
