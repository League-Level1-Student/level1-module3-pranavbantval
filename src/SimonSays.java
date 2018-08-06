
/*
 *    Copyright (c) The League of Amazing Programmers 2013-2018
 *    Level 1
 */

import java.awt.Component;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class SimonSays extends KeyAdapter {
	static Date timeAtEnd = new Date();
	// Complete steps 1 - 7 before you test
	// 1. Make a JFrame variable
	JFrame f;
	int points = 0;
	String word;
	HashMap<Integer, String> images = new HashMap<Integer, String>();
	private int imageIndex;
	private int tries = 0;
	private int simonSays = 0;
	static Date timeAtStart;
String a;
JLabel l;
	private void makeAlbum() {
		// 2. add 4 images which match keyboard keys like this: images.put(new
		// Integer(KeyEvent.VK_UP), "image.jpg");
		images.put(new Integer(KeyEvent.VK_UP), "pexels-photo-248797.jpeg");
		images.put(new Integer(KeyEvent.VK_DOWN), "CMS_Creative_164657191_Kingfisher.jpg");
		images.put(new Integer(KeyEvent.VK_LEFT), "img_lights.jpg");
		images.put(new Integer(KeyEvent.VK_RIGHT), "cat.jpg");
		// 3. Tell the user to "Press the matching key when 'Simon says' otherwise press
		// a different key"
		JOptionPane.showMessageDialog(null,
				"When Simon Says to press a key press it \n otherwise press a different key");
		// 4. call the method to show an image
		showImage();
		
	}

	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		// showImage();
		// 16. make a points variable to track the score. tell the user their score at
		// the end.

		// 17. if the keyCode matches the imageIndex and "Simon says..." increase their
		// score
		System.out.println(keyCode);
		System.out.println(imageIndex);
		System.out.println(this.simonSays);
		if (keyCode == imageIndex && this.simonSays == 1) {
			points++;
			speak("You were correct");

		}
		// 18. if the keyCode doesn't match the imageIndex and "Simon didn't say..."
		// increase their score
		else if (keyCode != imageIndex && this.simonSays == 0) {
			points++;
			speak("You were correct");
		}

		// 19. Use the speak method to tell the user if they were correct or not
		else {
			speak("You were not correct");
		}
		// 13. increment tries by 1
		tries = tries + 1;
		// 14. if tries is greater than 9 (or however many you want)
		if (tries > 5) {
			// 15. exit the program
			System.exit(0);
		}
		// 11. dispose of the frame
		f.remove(getNextRandomImage());
f.dispose();
		// 12. call the method to show an image
		showImage();
	}

	private void showImage() {
		// 5. initialize your frame to a new JFrame()
		f = new JFrame();
		// 6. set the frame to visible
		f.setVisible(true);
		// frame.add(getNextRandomImage()); //7. rename to the name of your frame
		f.add(getNextRandomImage());
		// 8. set the size of the frame
		f.setSize(500, 500);
		// 9. add a key listener to the frame
		f.addKeyListener(this);
		// 10. Use the speak method to either say "Simon says press this key" or "Press
		// this key"
		// Hint: use the simonSays int and a random number
		Random r = new Random();
		this.simonSays = r.nextInt(2);
		word = "";
		if (this.simonSays == 1) {
			word = "Simon says";
		} else if (this.simonSays == 0) {
			word = "";
		}
		if (imageIndex == 37) {
			word = word + "Press left arrow";
		} else if (imageIndex == 38) {
			word = word + "Press up arrow";
		} else if (imageIndex == 39) {
			word = word + "Press right arrow";
		} else if (imageIndex == 40) {
			word = word + "Press down arrow";
		}
		speak(word);
		JOptionPane.showMessageDialog(null, "You have "+Integer.toString(points)+" points");
	}

	private Component getNextRandomImage() {
		this.imageIndex = new Random().nextInt(4) + 37;
		return loadImage(images.get(imageIndex));
	}

	private JLabel loadImage(String fileName) {
		URL imageURL = getClass().getResource(fileName);
		Icon icon = new ImageIcon(imageURL);
		return new JLabel(icon);
	}

	void speak(String words) {
		try {
			 Runtime.getRuntime().exec("say " + words).waitFor();
			System.out.println(words);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	

	public static void main(String[] args) throws Exception {

		new SimonSays().makeAlbum();

	}

}

/*
 * 20. add a timer ~~~ where the code starts running ~~~ timeAtStart = new
 * Date();
 *
 * ~~~ where the code ends ~~~ Date timeAtEnd = new Date();
 * System.out.println((timeAtEnd.getTime()-timeAtStart.getTime())/1000);
 * System.exit(0);
 */
