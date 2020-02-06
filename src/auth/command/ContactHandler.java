package auth.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import auth.service.LoginService;
import mvc.command.CommandHandler;

public class ContactHandler implements CommandHandler {

	private static final String FORM_VIEW = "/template/contact.jsp";
	private LoginService loginService = new LoginService();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) 
	throws Exception {
		return processForm(req,res);
	}
	
	private String processForm(HttpServletRequest req, HttpServletResponse res) {
		return FORM_VIEW;
	}



	private String trim(String str) {
		return str == null ? null : str.trim();
	}
}
