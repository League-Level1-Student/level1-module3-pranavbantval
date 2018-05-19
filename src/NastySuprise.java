import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class NastySuprise implements ActionListener {
	JFrame f = new JFrame();
	JPanel p = new JPanel();
	JButton trick = new JButton();
	JButton treat = new JButton();

	public static void main(String[] args) {
		NastySuprise n = new NastySuprise();
		n.privateUI();
	}

	public void privateUI() {

		f.setVisible(true);
		f.add(p);
		p.add(treat);
		p.add(trick);
		trick.setText("Trick");
		treat.setText("Treat");
		trick.addActionListener(this);
		treat.addActionListener(this);
		f.pack();
	}

	private void showPictureFromTheInternet(String URL) {
		try {
			URL url = new URL(URL);
			Icon icon = new ImageIcon(url);
			JLabel imageLabel = new JLabel(icon);
			JFrame frame = new JFrame();
			frame.add(imageLabel);
			frame.setVisible(true);
			frame.pack();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton buttonPressed = (JButton) e.getSource();

		if (trick == buttonPressed) {
			showPictureFromTheInternet("http://www.zarias.com/wp-content/uploads/2015/12/61-cute-puppies.jpg");
		} else if (treat == buttonPressed) {
			showPictureFromTheInternet("http://www.clker.com/cliparts/g/K/G/P/t/d/scary-ghost-hi.png");
		}
	}

}
