import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.event.*;

public class SimpleGUISeveralFrames implements ActionListener {
	JFrame frame;
	JLabel label;
	JButton button1;
	JButton button2;

	public static void main(String[] args) {
		SimpleGUISeveralFrames gui = new SimpleGUISeveralFrames();
		gui.go();
	}

	void go() {		
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		label = new JLabel("label");
		
		button1 = new JButton("Change color");
		button2 = new JButton("Change label");
		button1.addActionListener(this);
		button2.addActionListener(this);
		
		DrawPanel drawPanel = new DrawPanel();
		
		frame.getContentPane().add(BorderLayout.EAST, button2);
		frame.getContentPane().add(BorderLayout.SOUTH, button1);
		frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
		frame.getContentPane().add(BorderLayout.WEST, label);
		frame.setSize(300, 300);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button1) frame.repaint();
		else if (e.getSource() == button2) label.setText("BOOOO");
	}

}
