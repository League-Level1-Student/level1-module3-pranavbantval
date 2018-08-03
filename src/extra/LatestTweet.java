/*
 * package extra;
 * 
 * import java.awt.event.ActionEvent; import java.awt.event.ActionListener;
 * 
 * import javax.swing.JButton; import javax.swing.JFrame; import
 * javax.swing.JPanel; import javax.swing.JTextField;
 * 
 * import twitter4j.Query; import twitter4j.QueryResult; import
 * twitter4j.Twitter; import twitter4j.TwitterFactory; import
 * twitter4j.auth.AccessToken;
 * 
 * public class LatestTweet implements ActionListener { JFrame f = new JFrame();
 * JButton b = new JButton(); JTextField t = new JTextField(); JPanel p = new
 * JPanel(); String a; String tweet;
 * 
 * public static void main(String[] args) { new LatestTweet().createUI(); }
 * 
 * public void createUI() { f.add(p); p.add(t); p.add(b);
 * b.setText("Search Twitterverse"); f.setVisible(true);
 * t.setText("Type something to search"); f.setTitle("The tweet retriever");
 * b.addActionListener(this); f.pack(); }
 * 
 * private String getLatestTweet(String searchingFor) {
 * 
 * Twitter twitter = new TwitterFactory().getInstance();
 * 
 * AccessToken accessToken = new
 * AccessToken("2453751158-IVD2VGZsvwZiRKxNe3Gs2lMjg30nvSkV1xSuPFf",
 * "vBa5PjKfuMTK1LLBG51nCUI9r5d6Ph5cAHrS73spg6Nvu");
 * 
 * twitter.setOAuthConsumer("YqeZdD2hYxOKv4QOkmp0i2djN",
 * "6XUB1r8KXBvd8Pk9HHW3NgphMxHvHWBLAr5TihnckMU0ttyGST");
 * 
 * twitter.setOAuthAccessToken(accessToken);
 * 
 * Query query = new Query(searchingFor); try { QueryResult result =
 * twitter.search(query); return result.getTweets().get(0).getText(); } catch
 * (Exception e) { System.err.print(e.getMessage()); return
 * "What the heck is that?"; } }
 * 
 * @Override public void actionPerformed(ActionEvent e) { // TODO Auto-generated
 * method stub
 * 
 * JButton ButtonPressed = (JButton) e.getSource(); if (ButtonPressed.equals(b))
 * { a = t.getText(); tweet = getLatestTweet(a); System.out.println(tweet); } }
 * }
 */