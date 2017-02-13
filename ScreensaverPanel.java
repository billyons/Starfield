/**
 * @author Bill Lyons billyons@gmail.com
 */

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.Random;

public class ScreensaverPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private LinkedList<ScreensaverStar> stars;
    private Random rand = new Random();
    private int fps = 1;
    //Tweak this field to change the number of stars that appear.
    //There will be approximately 100 stars on a 800x600 screen per stardensity.
    //Recommended value is 3-4.
    private double stardensity = 4;
    private int newstars;
    private double acceleration = 0;

    public ScreensaverPanel(){
        stars = new LinkedList<ScreensaverStar>();
    }

    public void nextFrame(){
        stardensity+= acceleration;
        newstars = (int)(rand.nextDouble()*(2.3)*stardensity+0.5);
        //System.out.println(newstars);
        for(int i=1; i<=newstars; i++){
            stars.add(new ScreensaverStar(getWidth(), getHeight(), rand));
        }
        //System.out.println(fps);
        repaint();
    }

    public void countFPS(){
        fps++;
        //System.out.println(fps);
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        g.setColor(Color.black);
        g.fillRect(0, 0, getWidth(), getHeight());
        //System.out.println("Drawing black rectangle.");

        g.setColor(Color.white);
        
        drawStars(g);
        g.drawString("Starfield density (adjust with up/down arrows): "
                +((int)((stardensity+0.00001)*100))/100.0, 1, 11);
        g.drawString("Stars generated this frame: "+newstars, 1, getHeight()-3);
        g.drawString("Frames per second: "+fps, getWidth()-136, 11);
        g.drawString("Press space or click to exit.", (getWidth()/2)-90, getHeight()-3);
        fps=1;
    }

    private void drawStars(Graphics g){
        int i = 0;
        g.drawString("Stars: "+stars.size(), getWidth()-75, getHeight()-3);
        while(i < stars.size()){
            ScreensaverStar star = (ScreensaverStar)stars.get(i);

            star.draw(g);
            star.advance();
            if(star.x < 0 || star.y < 0 || star.x > getWidth() || star.y > getHeight()){
                stars.remove(i);
            } else {
                i++;
            }

        }
    }

    public void setAccel(double newaccel){
        acceleration = newaccel;
    }

}
