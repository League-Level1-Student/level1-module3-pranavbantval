package extra;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ChuckleClicker implements ActionListener {
	JFrame f = new JFrame();
	JButton joke = new JButton();
	JButton punchline = new JButton();
	JPanel p = new JPanel();

	public static void main(String[] args) {
		new ChuckleClicker().makeButtons();
	}

	void makeButtons() {

		f.setVisible(true);
		joke.setText("joke");
		punchline.setText("punchline");
		joke.addActionListener(this);
		punchline.addActionListener(this);
		joke.setVisible(true);
		punchline.setVisible(true);
		p.add(punchline);
		p.add(joke);
		f.add(p);
		f.pack();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		// if (event.getSource() == joke);
	}
}
