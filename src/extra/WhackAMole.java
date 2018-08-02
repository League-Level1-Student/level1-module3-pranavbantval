package extra;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class WhackAMole implements ActionListener {
	JFrame f = new JFrame();
	JPanel p = new JPanel();
	Random r = new Random();
	JButton b;

	public static void main(String[] args) {
		new WhackAMole().createUI();
	}

	public void createUI() {
		f.add(p);
		f.setVisible(true);
		f.setSize(500, 500);
		f.setTitle("Whack a mole for glory");
		int a = r.nextInt(25) + 1;
		drawButtons(a);
	}

	void drawButtons(int x) {
		for (int i = 1; i < 25; i++) {
			if (x == i) {
				b = new JButton("mole");
				b.addActionListener(this);
				p.add(b);
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
		if (bp.equals(b) && b.getText().equals("mole")) {

		}
	}
}
