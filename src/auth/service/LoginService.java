package auth.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.connection.ConnectionProvider;
import member.dao.MemberDao;
import member.model.Member;

public class LoginService {

	private MemberDao memberDao = new MemberDao();

	public User login(String CLIENT_ID, String CLIENT_PWD) {
		try (Connection conn = ConnectionProvider.getConnection()) {
			Member member = memberDao.selectById(conn, CLIENT_ID);
			if (member == null) {
				throw new LoginFailException();
			}
			if (!member.matchCLIENT_PWD(CLIENT_PWD)) {
				throw new LoginFailException();
			}
			return new User(member.getCLIENT_ID(), member.getCLIENT_NAME());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
