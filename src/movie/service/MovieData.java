package movie.service;

import movie.model.Movie;

public class MovieData {

	private Movie movie;

	public MovieData(Movie movie) {
		this.movie = movie;
	}

	public Movie getMovie() {
		return movie;
	}

}
