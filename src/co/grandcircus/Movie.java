package co.grandcircus;

public class Movie {
	String title = "";
	MovieGenre genre = MovieGenre.DRAMA;
	
	public Movie() {
		
	}
	
	public Movie(String title, MovieGenre genre	) {
		this.title = title;
		this.genre = genre;
	}
	
	public Movie(String title, String genre) {
		this.title = title;
		switch (genre) {
		case "horror":
			this.genre = MovieGenre.HORROR;
		case "sci-fi":
			this.genre = MovieGenre.SCI_FI;
		case "drama":
			this.genre = MovieGenre.DRAMA;
		case "animated":
			this.genre = MovieGenre.ANIMATED;
		}
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public MovieGenre getGenre() {
		return genre;
	}
	
	public void setGenre(MovieGenre genre) {
		this.genre = genre;
	}
	
	
	
	/*
    public int compareTo(Movie compareTo) {
    	return this.title.compareTo(compareTo.getTitle());
    }
    */

	
}
