package co.grandcircus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;



public class Lab11 {
	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		
		List<Movie> movieList = new ArrayList<>();
		
		movieList.add(new Movie("Hereditary", MovieGenre.HORROR));
		movieList.add(new Movie("The Conjuring", MovieGenre.HORROR));
		movieList.add(new Movie("Poltergeist", MovieGenre.HORROR));
		
		movieList.add(new Movie("Primer", MovieGenre.SCI_FI));
		movieList.add(new Movie("Moon", MovieGenre.SCI_FI));
		
		movieList.add(new Movie("The Big Lebowski", MovieGenre.DRAMA));
		movieList.add(new Movie("The Shawshank Redemption", MovieGenre.DRAMA));
		movieList.add(new Movie("Memento", MovieGenre.DRAMA));
		
		movieList.add(new Movie("Rango", MovieGenre.ANIMATED));
		movieList.add(new Movie("Wall-e", MovieGenre.ANIMATED));
		
		Collections.sort(movieList, new Comparator<Movie>() {
		    @Override
		    public int compare(Movie m1, Movie m2) {
		    	String t1 = stripThe(m1.getTitle());
		    	String t2 = stripThe(m2.getTitle());
		    	
		        return t1.compareTo(t2);
		    }
		});
		char cont = 'y';
		
		System.out.println("Welcome to the Movie List Application!");
		System.out.println("");	
		System.out.println("There are " + movieList.size() + " movies in this list.");
		
		
		MovieGenre chosenGenre = null;

		// While loop
		while (cont == 'y') {
			chosenGenre = getGenreFromUser();
			
			for (Movie m : movieList) {
				if (m.getGenre() == chosenGenre)
				{
					System.out.println(m.getTitle());
				}
			}

			System.out.println("Do you want to continue?  (yes/no)");
			cont = scn.next().charAt(0);
		}

		// Indication that the program has ended
		System.out.println("Goodbye.");
		scn.close();
	}
	
	static MovieGenre getGenreFromUser() {
		while (true) {
			switch (Validator.getString(scn, "What genre are you interested in?\nOptions: Horror, Sci-fi, Drama, Animated").toLowerCase()) {
			case "horror":
				return MovieGenre.HORROR;
			case "sci-fi":
				return MovieGenre.SCI_FI;
			case "drama":
				return MovieGenre.DRAMA;
			case "animated":
				return MovieGenre.ANIMATED;
				default:
					System.out.println("Unfortunately, that's not an option.  Please try again.");
					break;
			}
		}
	}
	
	static String stripThe(String title) {
		int firstSpace = title.indexOf(" ");
		if ((firstSpace != -1) && (title.substring(0, firstSpace).toLowerCase().equals("the"))) {
			return (title.substring(firstSpace));
		}
		else {
			return title;
		}
	}
}
