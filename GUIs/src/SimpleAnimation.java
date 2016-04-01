import javax.swing.*;
import java.awt.*;

public class SimpleAnimation {
	int xPos = 30;
	int yPos = 30;

	public static void main(String[] args) {
		SimpleAnimation gui = new SimpleAnimation();
		gui.go();
	}

	void go() {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		InnerDrawPanel innerDrawPanel = new InnerDrawPanel();

		frame.getContentPane().add(innerDrawPanel);
		frame.setSize(350, 350);
		frame.setVisible(true);
		
		int i = 0;
		int move = 1;
		while (true){
			if (i > 300 - 100) move = -1;
			else if (i - 10 < 0) move = 1;
			xPos += move;
			yPos += move;
			i+=move;
			innerDrawPanel.repaint();
			try{
				Thread.sleep(10);
			}catch(Exception ex){ }
		}
		
	}

	class InnerDrawPanel extends JPanel {
		private static final long serialVersionUID = 1L;

		public void paintComponent(Graphics g) {
			g.setColor(Color.white);
			g.fillRect(0, 0, this.getWidth(), this.getHeight());
			
			/*int red = (int) (Math.random() * 255);
			int green = (int) (Math.random() * 255);
			int blue = (int) (Math.random() * 255);*/
			g.setColor(
					Color.black
					//new Color(red, green, blue)
					);
			g.fillRect(xPos, yPos, 50, 50);
		}

	}

}
