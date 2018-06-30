/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mario;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JApplet;

/**
 *
 * @author kevinyamamoto
 */
public class Mario extends JApplet implements Runnable{
    Thread thread;
    /**
     * @param args the command line arguments
     */

    
    @Override
    public void init(){
        setSize(600,600);
        setBackground(Color.white);
        setFocusable(true);
        System.out.println("Hello Worldi");
        
    }

    @Override
    public void run() {
        Thread game = Thread.currentThread();
        System.out.println("Hello Worldr");
        while(thread == game){
            repaint();
            try{
                thread.sleep(25);
            }   catch(InterruptedException e){
                break;
            }
        }
    }
    
    
    @Override
    public void paint(Graphics g){
        g.setColor(Color.white);
        System.out.println("Hello Worldp");
        g.drawString("It's a me, Mario", 300,300);
    }
    
    @Override
    public void start(){
        thread = new Thread(this);
        thread.setPriority(Thread.MIN_PRIORITY);
        thread.start();
       
    }
    
    
}

