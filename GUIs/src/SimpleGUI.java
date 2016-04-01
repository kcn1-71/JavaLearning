import javax.swing.*;
import java.awt.event.*;

public class SimpleGUI implements ActionListener {
	static int c = 0;
	JButton button;
	
	public static void main(String[] args) {
		SimpleGUI gui = new SimpleGUI();
		gui.go();

	}

	void go() {
		JFrame frame = new JFrame();
		button = new JButton("Never been clicked");

		button.addActionListener(this);

		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(button);
		frame.setSize(300, 300);
		frame.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		c++;
		button.setText("I've been clicked " + c + " times");
	}

}
