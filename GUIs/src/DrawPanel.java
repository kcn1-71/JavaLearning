import javax.swing.*;
import java.awt.*;

public class DrawPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void paintComponent(Graphics g){
		
		/*Image image = new ImageIcon("catZilla.jpg").getImage();
		g.drawImage(image, 3, 4, this);*/
		
		int red = (int) (Math.random() * 255);
		int green= (int) (Math.random() * 255);
		int blue = (int) (Math.random() * 255);
		g.setColor(new Color(red,green,blue));
		g.fillRect(20, 50, 100, 20);
		g.fillRect(30, 50, 20, 100);
		
	}
}
