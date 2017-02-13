/**
 * @author Bill Lyons billyons@gmail.com
 */

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Screensaver {

    protected static ScreensaverPanel panel;

    public static void main(String[] args){
        ScreensaverFrame frame = new ScreensaverFrame();
        panel = new ScreensaverPanel();
        frame.add(panel);
        panel.addMouseListener(new MouseControl());
        panel.addKeyListener(new KeyboardControl());
        panel.setFocusable(true);
        panel.setDoubleBuffered(true);

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gfxdevice = ge.getDefaultScreenDevice();
        if(gfxdevice.isFullScreenSupported()){
            try{
                gfxdevice.setFullScreenWindow(frame);
            } catch(Exception e) {
                System.out.println("Unable to initialize fullscreen mode, proceeding in window.");
                gfxdevice.setFullScreenWindow(null);
            }
        } else {
            System.out.println("Unable to initialize fullscreen mode, proceeding in window.");
        }

        Timer timer = new Timer(33, new TimerListener());
        Timer fps = new Timer(1, new FPSListener());
        timer.start();
        fps.start();
    }

}

class TimerListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
        Screensaver.panel.nextFrame();
    }
}

class FPSListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
        Screensaver.panel.countFPS();
    }
}

class KeyboardControl implements KeyListener{
    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        //System.out.println("A key was pressed.");
        switch (e.getKeyCode()){
            case KeyEvent.VK_UP: Screensaver.panel.setAccel(0.05); break;
            case KeyEvent.VK_DOWN: Screensaver.panel.setAccel(-0.05); break;
            case KeyEvent.VK_SPACE: System.exit(0); break;
            default:
        }
    }

    public void keyReleased(KeyEvent e) {
        Screensaver.panel.setAccel(0);
    }
}

class MouseControl implements MouseListener{

    public void mouseClicked(MouseEvent e) {

    }

    public void mousePressed(MouseEvent e) {
        System.exit(0);
    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }

}