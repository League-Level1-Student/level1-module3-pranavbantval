import org.omg.Messaging.SyncScopeHelper;

public class MovieNetflixRunner {
public static void main(String[] args) {
	Movie m = new Movie("Lion King", 10);
	String title = "Lion King";
	int stars = 10;
	int compareQuantity = 10;
	Movie otherMovie = new Movie("Lion King 2",2);
	m.getTicketPrice();
	
	NetflixQueue n = new NetflixQueue();
	
	n.addMovie(otherMovie);
	n.addMovie(m);
	n.printMovies();
	System.out.println("The best movie is "+n.getBestMovie());
	System.out.println("The second best movie is "+n.getMovie(1));
}
}
