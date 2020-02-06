package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import jdbc.JdbcUtil;
import member.model.Member;

public class MemberDao {

	public Member selectById(Connection conn, String id) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(
					"select * from member where memberid = ?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			Member member = null;
			if (rs.next()) {
				member = new Member(
						rs.getString("memberCLIENT_ID"), 
						rs.getString("CLIENT_NAME"), 
						rs.getString("CLIENT_SSN"), 
						rs.getString("CLIENT_CTN"), 
						rs.getString("CLIENT_MAIL"), 
						rs.getString("CLIENT_PWD"),
						toDate(rs.getTimestamp("regdate")));
			}
			return member;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}

	private Date toDate(Timestamp date) {
		return date == null ? null : new Date(date.getTime());
	}

	public void insert(Connection conn, Member mem) throws SQLException {
		try (PreparedStatement pstmt = 
				conn.prepareStatement("insert into member values(?,?,?,?)")) {
			pstmt.setString(1, mem.getCLIENT_ID());
			pstmt.setString(2, mem.getCLIENT_NAME());
			pstmt.setString(3, mem.getCLIENT_SSN());
			pstmt.setString(4, mem.getCLIENT_CTN());
			pstmt.setString(5, mem.getCLIENT_MAIL());
			pstmt.setString(6, mem.getCLIENT_PWD());
			pstmt.setTimestamp(7, new Timestamp(mem.getRegDate().getTime()));
			pstmt.executeUpdate();
		}
	}

	public void update(Connection conn, Member member) throws SQLException {
		try (PreparedStatement pstmt = conn.prepareStatement(
				"update member set name = ?, password = ? where memberid = ?")) {
			pstmt.setString(1, member.getCLIENT_NAME());
			pstmt.setString(2, member.getCLIENT_PWD());
			pstmt.setString(3, member.getCLIENT_ID());
			pstmt.setString(4, member.getCLIENT_SSN());
			pstmt.setString(5, member.getCLIENT_CTN());
			pstmt.setString(6, member.getCLIENT_MAIL());
			pstmt.executeUpdate();
		}
	}
}
