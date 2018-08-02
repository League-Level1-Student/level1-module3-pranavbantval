package extra;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PigLatin implements ActionListener {
	JFrame f = new JFrame();
	JPanel p = new JPanel();
	JTextField t = new JTextField();
	JButton b = new JButton();
	JTextField tf = new JTextField(20);
	String a;

	public static void main(String[] args) {
		new PigLatin().createUI();
	}

	public void createUI() {
		f.add(p);
		p.add(b);
		p.add(t);
		p.add(tf);
		f.setVisible(true);
		f.setTitle("Pig Latin Translator");
		b.setText("Translate");
		t.setText("Enter text here");
		f.pack();
		b.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton ButtonPressed = (JButton) e.getSource();
		if (ButtonPressed.equals(b)) {
			PigLatinTranslator tr = new PigLatinTranslator();
			a = t.getText();
			tf.setText(tr.translate(a));
		}
	}
}

class PigLatinTranslator {

	/**
	 * Method to test whether a character is a letter or not.
	 * 
	 * @param c
	 *            The character to test
	 * @return True if it's a letter
	 */
	private static boolean isLetter(char c) {
		return ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z'));
	}

	/**
	 * Method to translate one word into pig latin.
	 * 
	 * @param word
	 *            The word in english
	 * @return The pig latin version
	 */
	private static String pigWord(String word) {
		int split = firstVowel(word);
		return word.substring(split) + "-" + word.substring(0, split) + "ay";
	}

	/**
	 * Method to translate a sentence word by word.
	 * 
	 * @param s
	 *            The sentence in English
	 * @return The pig latin version
	 */
	public String translate(String s) {
		String latin = "";
		int i = 0;
		while (i < s.length()) {

			// Take care of punctuation and spaces
			while (i < s.length() && !isLetter(s.charAt(i))) {
				latin = latin + s.charAt(i);
				i++;
			}

			// If there aren't any words left, stop.
			if (i >= s.length())
				break;

			// Otherwise we're at the beginning of a word.
			int begin = i;
			while (i < s.length() && isLetter(s.charAt(i))) {
				i++;
			}
			// Now we're at the end of a word, so translate it.
			int end = i;
			latin = latin + pigWord(s.substring(begin, end));
		}
		return latin;
	}

	/**
	 * Method to find the index of the first vowel in a word.
	 * 
	 * @param word
	 *            The word to search
	 * @return The index of the first vowel
	 */
	private static int firstVowel(String word) {
		word = word.toLowerCase();
		for (int i = 0; i < word.length(); i++)
			if (word.charAt(i) == 'a' || word.charAt(i) == 'e' || word.charAt(i) == 'i' || word.charAt(i) == 'o'
					|| word.charAt(i) == 'u')
				return i;
		return 0;
	}
}