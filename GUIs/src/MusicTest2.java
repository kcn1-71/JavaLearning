import java.awt.*;
import javax.sound.midi.*;
import javax.swing.*;

public class MusicTest2 implements ControllerEventListener {

	static JFrame frame = new JFrame();
	static MyDrawPanel p1;

	public static void main(String[] args) {

		MusicTest2 mt = new MusicTest2();
		mt.go();

	}

	public void setUpGui() {
		p1 = new MyDrawPanel();
		frame.setContentPane(p1);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(30, 30, 300, 300);
		frame.setVisible(true);
	}

	public void go() {

		setUpGui();

		try {

			Sequencer sequencer = MidiSystem.getSequencer();
			sequencer.open();

			sequencer.addControllerEventListener(p1, new int[] { 127 });

			Sequence seq = new Sequence(Sequence.PPQ, 4);
			Track track = seq.createTrack();

			int r = 0;
			for (int i = 5; i < 150; i += 4) {
				r = (int) ((Math.random() * 50) + 1);

				track.add(makeSample(144, 1, r, 100, i));

				track.add(makeSample(176, 1, 127, 0, i));

				track.add(makeSample(128, 1, r, 100, i + 2));
			}

			sequencer.setSequence(seq);
			sequencer.setTempoInBPM(120);
			sequencer.start();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void controlChange(ShortMessage event) {
		System.out.print("la");
	}

	public static MidiEvent makeSample(int comd, int chan, int one, int two, int tick) {
		MidiEvent sample = null;
		try {
			ShortMessage a = new ShortMessage();
			a.setMessage(comd, chan, one, two);
			sample = new MidiEvent(a, tick);
		} catch (Exception ex) {
		}
		return sample;
	}

	class MyDrawPanel extends JPanel implements ControllerEventListener {

		private static final long serialVersionUID = 1L;
		boolean msg = false;

		@Override
		public void controlChange(ShortMessage event) {
			msg = true;
			repaint();
		}

		public void paintComponent(Graphics g) {
			if (msg) {
				Graphics2D g2 = (Graphics2D) g;

				int red = (int) (Math.random() * 255);
				int green = (int) (Math.random() * 255);
				int blue = (int) (Math.random() * 255);
				g2.setColor(new Color(red, green, blue));

				int height = (int) ((Math.random() * 120) + 10);
				int width = (int) ((Math.random() * 120) + 10);
				int x = (int) ((Math.random() * 100) + 10);
				int y = (int) ((Math.random() * 100) + 10);
				g2.fillRect(x, y, width, height);

				msg = false;
			}
		}

	}
}
