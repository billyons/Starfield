/**
 * @author Bill Lyons billyons@gmail.com
 */

import javax.swing.*;

public class ScreensaverFrame extends JFrame{

	private static final long serialVersionUID = 1L;

	public ScreensaverFrame(){
        setTitle("Space Screensaver");
        setSize(800,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setUndecorated(true);
        setVisible(true);
    }

}