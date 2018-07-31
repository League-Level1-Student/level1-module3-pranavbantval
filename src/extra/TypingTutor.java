package extra;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TypingTutor implements KeyListener {
	JFrame f = new JFrame();
	JLabel l = new JLabel();
	JPanel p = new JPanel();
	String letter;
	char currentLetter;

	public static void main(String[] args) {
		new TypingTutor().type();
	}

	char generateRandomLetter() {
		Random r = new Random();
		return (char) (r.nextInt(26) + 'a');
	}

	void type() {

		f.setTitle("Type or die");
		f.add(p);
		p.add(l);
		l.setVisible(true);
		f.addKeyListener(this);

		currentLetter = generateRandomLetter();
		letter = Character.toString(currentLetter);
		l.setText(letter);
		l.setFont(l.getFont().deriveFont(28.0f));
		l.setHorizontalAlignment(JLabel.CENTER);
		f.setVisible(true);
		f.pack();

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyChar() == currentLetter) {
			f.getContentPane().setBackground(Color.GREEN);
			System.out.println("correct");
		} else {
			f.setBackground(Color.RED);
			System.out.println("no");
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		currentLetter = generateRandomLetter();
		letter = Character.toString(currentLetter);
		l.setText(letter);
	}
}
