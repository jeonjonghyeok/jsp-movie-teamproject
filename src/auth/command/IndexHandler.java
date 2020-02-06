package auth.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import auth.service.LoginService;
import movie.dao.MovieDao;
import movie.model.Movie;
import movie.service.MovieContentNotFoundException;
import movie.service.MovieData;
import movie.service.MovieNotFoundException;
import movie.service.MovieService;
import mvc.command.CommandHandler;

public class IndexHandler implements CommandHandler {

	private static final String FORM_VIEW = "/template/index.jsp";
	private LoginService loginService = new LoginService();
	private MovieDao movieDao = new MovieDao();
	private MovieService movieService = new MovieService();
	int total;
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) 
	throws Exception {
		try {
			total = movieService.selectCount();
			List<Movie> movie = movieService.getMovieList();
			
			req.setAttribute("movieList", movie);
		return FORM_VIEW;
		}catch (MovieNotFoundException | MovieContentNotFoundException e) {
			req.getServletContext().log("no movie", e);
			res.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}

	}


	private String trim(String str) {
		return str == null ? null : str.trim();
	}
}
