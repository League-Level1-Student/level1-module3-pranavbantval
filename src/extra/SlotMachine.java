package extra;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SlotMachine implements ActionListener {
	JFrame f = new JFrame();
	JPanel p = new JPanel();
	JButton b = new JButton();
	int a;
	Random r = new Random();
	BufferedImage fruitImage;

	public static void main(String[] args) {
		new SlotMachine().createUI();
	}

	public void createUI() {
		f.add(p);
		p.add(b);
		b.setText("Spin");
		b.addActionListener(this);
		f.setSize(2000, 2000);
		f.setVisible(true);
	}

	void showImage(String imageName) {
		try {
			fruitImage = ImageIO.read(getClass().getResource(imageName));
		} catch (Exception e) {
			System.err.println("Couldn't find this image: " + imageName);
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton bp = (JButton) e.getSource();
		if (bp.equals(b)) {
			for (int i = 0; i < 3; i++) {
				a = r.nextInt(3);
				if (a == 0) {
					showImage("cherry.png");
				} else if (a == 1) {
					showImage("Lemon.png");
				} else if (a == 2) {
					showImage("orange.jpg");
				}
			}
		}
	}
}
