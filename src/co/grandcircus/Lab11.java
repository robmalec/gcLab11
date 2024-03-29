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

		for (int i = 1; i <= 100; i++) {
			movieList.add(MovieIO.getMovie(i));
		}

		Collections.sort(movieList, new Comparator<Movie>() {
			@Override
			public int compare(Movie m1, Movie m2) {
				String t1 = prepTitle(m1.getTitle());
				String t2 = prepTitle(m2.getTitle());

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
				if (m.getGenre() == chosenGenre) {
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
		String response = "";
		String responseMap[] = { "horror", "sci-fi", "drama", "animated" };
		while (true) {
			response = Validator
					.getString(scn,
							"What genre are you interested in?\nOptions:\n1: Horror\n2: Sci-fi\n3: Drama\n4: Animated")
					.toLowerCase();
			System.out.println("");
			try {
				response = responseMap[Integer.valueOf(response)];
			} catch (IndexOutOfBoundsException e) {
				response = "ya done fucked up.";
			} catch (Exception e) {

			}

			switch (response) {
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

	static String prepTitle(String title) {
		int firstSpace = title.indexOf(" ");
		if (firstSpace != -1) {
			String firstWord = title.substring(0, firstSpace).toLowerCase();
			if (firstWord.equals("the") || firstWord.equals("a") || firstWord.equals("an")) {
				return (title.substring(firstSpace + 1).toLowerCase());
			}
		}
		return title.toLowerCase();
	}
}
