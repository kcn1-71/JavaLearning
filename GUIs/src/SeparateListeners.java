import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.*;

public class SeparateListeners {
	JFrame frame;
	JLabel label;

	public static void main(String[] args) {
		SeparateListeners gui = new SeparateListeners();
		gui.go();
	}

	void go() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		label = new JLabel("label");
		DrawPanel drawPanel = new DrawPanel();

		JButton button1 = new JButton("Change color");
		JButton button2 = new JButton("Change label");
		button1.addActionListener((new Button1Listener()));
		button2.addActionListener((new Button2Listener()));

		frame.getContentPane().add(BorderLayout.EAST, button2);
		frame.getContentPane().add(BorderLayout.SOUTH, button1);
		frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
		frame.getContentPane().add(BorderLayout.WEST, label);
		frame.setSize(300, 300);
		frame.setVisible(true);
	}

	class Button2Listener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			label.setText("BOO");			
		}	
	}

	class Button1Listener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			frame.repaint();
			label.setText("YAA");
		}
	}

}
