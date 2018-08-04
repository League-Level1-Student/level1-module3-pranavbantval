
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class SlotMachine implements ActionListener {
	JFrame f = new JFrame();
	JPanel p = new JPanel();
	JButton b = new JButton();
	JLabel l;
	JLabel ll;
	JLabel lll;
	int a;
	int win;
	int win2;
	int win3;
	Random r = new Random();

	public static void main(String[] args) {

		new SlotMachine().createUI();

	}

	public void createUI() {

		f.add(p);
		p.add(b);

		b.setText("Spin");
		b.addActionListener(this);
		f.setSize(1500, 1500);
		f.setVisible(true);
		f.pack();
	}

	private JLabel createLabelImage(String fileName) {
		URL imageURL = getClass().getResource(fileName);
		if (imageURL == null) {
			System.err.println("Could not find image " + fileName);
			return new JLabel();
		}
		Icon icon = new ImageIcon(imageURL);
		JLabel imageLabel = new JLabel(icon);
		return imageLabel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton bp = (JButton) e.getSource();
		if (bp.equals(b)) {
			for (int i = 0; i < 3; i++) {
				a = r.nextInt(1);
				if (a == 0) {
					System.out.println("works0");
					l = createLabelImage("cherry.png"+"");
					p.add(l);
					l.setVisible(true);
					win++;
				} else if (a == 1) {
					ll = createLabelImage("Lemon.jpg"+"");
					p.add(ll);
					ll.setVisible(true);
					System.out.println("works1");win2++;
				} else if (a == 2) {
					lll = createLabelImage("orange.jpg"+"");
					p.add(lll);
					lll.setVisible(true);
					System.out.println("works2");
					win3++;
				}
			}
			if(win==3||win2==3||win3==3) {
				JOptionPane.showMessageDialog(null, "YOU WON");
			}
			
			
		f.pack();
		}
	}
}
