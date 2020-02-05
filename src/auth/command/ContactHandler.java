package auth.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import auth.service.LoginFailException;
import auth.service.LoginService;
import auth.service.User;
import mvc.command.CommandHandler;

public class ContactHandler implements CommandHandler {

	private static final String FORM_VIEW = "/template/contact.jsp";

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) 
	throws Exception {
		return FORM_VIEW;
	}



	private String trim(String str) {
		return str == null ? null : str.trim();
	}
}
