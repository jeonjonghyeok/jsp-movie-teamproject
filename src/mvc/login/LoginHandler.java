package mvc.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;

public class LoginHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) {
		//req.setAttribute("login", "안녕하세요!");
		return "/WEB-INF/view/login/loginForm.jsp";
	}

}
