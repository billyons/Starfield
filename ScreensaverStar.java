/**
 * @author Bill Lyons billyons@gmail.com
 */
import java.awt.Graphics;
import java.util.Random;

public class ScreensaverStar {

    protected double x;
    protected double y;
    protected double angle;
    protected double speed;
    protected double diameter;

    public ScreensaverStar(int width, int height, Random rand){
        x = width/2;
        y = height/2;
        angle = rand.nextDouble()*Math.PI*2;
        speed = 1+(rand.nextDouble()*rand.nextDouble())/1.1;
        diameter = 1.3+(rand.nextDouble()*rand.nextDouble())/1.5;
    }

    public void advance(){
        x+=speed*Math.cos(angle);
        y-=speed*Math.sin(angle);
        speed=Math.pow(speed, 1.04);
        diameter=diameter+(Math.pow(diameter, 0.4)-1)*(speed/45);
    }

    public void draw(Graphics g){
        g.fillOval((int)(x-(diameter/2)), (int)(y-(diameter/2)), (int)diameter, (int)diameter);
    }

}
