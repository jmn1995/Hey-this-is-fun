
package heythisisfun;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;


public class HelloWorld2D extends Applet implements Runnable {
   
    int x = 150;
    int y = 50;
    int r = 50;
    
    int horizontalSpeed = 3;
    int verticalSpeed = 3;
    
    Thread animator;
    
    volatile boolean Stop;

  
    public void paint(Graphics g) {
       
        setBackground(Color.BLACK);
        g.setColor(Color.WHITE);
        
        g.fillOval(x - r, y - r, r * 2, r * 2);
    
       
        g.drawString("1st Project! Many more to come!", (r + x), (r + y));
      
    
    }
    
    public void animate() {
        
        Rectangle range = getBounds();
        if ((x - r + horizontalSpeed < 0) || (x + r + horizontalSpeed > range.width))
            horizontalSpeed = -horizontalSpeed;
        if ((y - r + verticalSpeed < 0) || (y + r + verticalSpeed > range.height))
            verticalSpeed = -verticalSpeed;
        
           x += horizontalSpeed;
           y += verticalSpeed;
           
           repaint();
    }
    
    public void run() {
        while (!Stop) {
            animate();
            try {
                Thread.sleep(35);
            }
            catch (InterruptedException e) {
        }   
    }
}
    
public void start() {
    animator = new Thread(this);
    Stop = false;
    animator.start();
}

public void stop() {
    
    Stop = true;
}
}
