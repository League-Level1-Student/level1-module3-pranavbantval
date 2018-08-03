package extra;

import java.applet.AudioClip;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Random;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class WhackAMole implements ActionListener {
	JFrame f;
	JPanel p;
	Random r = new Random();
	JButton b;
	JButton mole;
	int score;
	int miss;
	int a;
	Date d = new Date();;

	public static void main(String[] args) {
		new WhackAMole().createUI();

	}

	public void createUI() {
		f = new JFrame();
		p = new JPanel();

		f.add(p);
		f.setVisible(true);
		f.setSize(500, 500);
		f.setTitle("Whack a mole for glory");
		a = r.nextInt(25) + 1;
		drawButtons(a);
	}

	void drawButtons(int x) {
		for (int i = 1; i < 26; i++) {
			if (x == i) {
				mole = new JButton("mole");
				mole.addActionListener(this);
				p.add(mole);
			} else {
				b = new JButton();
				b.addActionListener(this);
				p.add(b);
			}
		}

	}

	void speak(String words) {
		try {
			Runtime.getRuntime().exec("say " + words).waitFor();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton bp = (JButton) e.getSource();

		if (bp.equals(mole) && mole.getText().equals("mole")) {
			// playSound("oof.wav");

			f.dispose();
			createUI();

			score++;

			if (score == 10) {

				endGame(d, score);
			}
		} else {
			speak("You missed");
			f.dispose();
			createUI();

			miss++;
			if (score == 0 && miss == 5) {
				JOptionPane.showMessageDialog(null, "Get your eyes checked man");
			} else if (miss == 5) {
				endGame(d, score);

			}
		}
	}

	void playSound(String fileName) {
		AudioClip sound = JApplet.newAudioClip(getClass().getResource(fileName));
		sound.play();
	}

	void endGame(Date timeAtStart, int molesWhacked) {
		Date timeAtEnd = new Date();
		JOptionPane.showMessageDialog(null, "Your whack rate is "
				+ ((timeAtEnd.getTime() - timeAtStart.getTime()) / 1000.00 / molesWhacked) + " moles per second.");
	}
}
