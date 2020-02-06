package movie.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import movie.dao.MovieDao;
import movie.service.MovieContentNotFoundException;
import movie.service.MovieData;
import movie.service.MovieNotFoundException;
import movie.service.MovieService;
import mvc.command.CommandHandler;

public class ReserveHandler implements CommandHandler {

	private static final String FORM_VIEW = "/template/reserve.jsp";
	private MovieDao movieDao = new MovieDao();
	private MovieService movieService = new MovieService();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) 
	throws Exception {
//		String noVal = req.getParameter("no");
//		int MovieNum = Integer.parseInt(noVal);
//		MovieNum=1;
		try {
			MovieData movieData = movieService.getMovie(1);
			req.setAttribute("movieData", movieData);
		return FORM_VIEW;
		}catch (MovieNotFoundException | MovieContentNotFoundException e) {
			req.getServletContext().log("no movie", e);
			res.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
	}

}
