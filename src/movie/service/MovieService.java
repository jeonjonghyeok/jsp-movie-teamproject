package movie.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import jdbc.connection.ConnectionProvider;
import movie.dao.MovieDao;
import movie.model.Movie;

public class MovieService {

	
	private MovieDao movieDao = new MovieDao();

	public List<Movie> getMovieList() {
		try (Connection conn = ConnectionProvider.getConnection()) {
			int total = movieDao.selectCount(conn);
			List<Movie> content = movieDao.select(conn);
			return content;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public int selectCount() {
		try (Connection conn = ConnectionProvider.getConnection()) {
			int total = movieDao.selectCount(conn);
			return total;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public MovieData getMovie(int MovieNum) {
		try (Connection conn = ConnectionProvider.getConnection()){
			Movie movie = movieDao.selectById(conn, MovieNum);
			if (movie == null) {
				throw new MovieNotFoundException();
			}
			return new MovieData(movie);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
}
