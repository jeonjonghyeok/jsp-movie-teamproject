package movie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jdbc.JdbcUtil;
import movie.model.Movie;

public class MovieDao {

//	public Article insert(Connection conn, Article article) throws SQLException {
//		PreparedStatement pstmt = null;
//		Statement stmt = null;
//		ResultSet rs = null;
//		try {
//			pstmt = conn.prepareStatement("insert into article "
//					+ "(writer_id, writer_name, title, regdate, moddate, read_cnt) "
//					+ "values (?,?,?,?,?,0)");
//			pstmt.setString(1, article.getWriter().getId());
//			pstmt.setString(2, article.getWriter().getName());
//			pstmt.setString(3, article.getTitle());
//			pstmt.setTimestamp(4, toTimestamp(article.getRegDate()));
//			pstmt.setTimestamp(5, toTimestamp(article.getModifiedDate()));
//			int insertedCount = pstmt.executeUpdate();
//
//			if (insertedCount > 0) {
//				stmt = conn.createStatement();
//				rs = stmt.executeQuery("select last_insert_id() from article");
//				if (rs.next()) {
//					Integer newNo = rs.getInt(1);
//					return new Article(newNo,
//							article.getWriter(),
//							article.getTitle(),
//							article.getRegDate(),
//							article.getModifiedDate(),
//							0);
//				}
//			}
//			return null;
//		} finally {
//			JdbcUtil.close(rs);
//			JdbcUtil.close(stmt);
//			JdbcUtil.close(pstmt);
//		}
//	}
//
//	private Timestamp toTimestamp(Date date) {
//		return new Timestamp(date.getTime());
//	}

	public int selectCount(Connection conn) throws SQLException {
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select count(*) from movie");
			if (rs.next()) {
				return rs.getInt(1);
			}
			return 0;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}
	}

	public List<Movie> select(Connection conn) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("select MOVIE_ID,MOVIE_NAME from MOVIE " +
					"order by MOVIE_ID");

			rs = pstmt.executeQuery();
			List<Movie> result = new ArrayList<>();
			while (rs.next()) {
				result.add(convertMovie(rs));
			}
			return result;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}

	private Movie convertMovie(ResultSet rs) throws SQLException {
		return new Movie(rs.getInt("MOVIE_ID"),rs.getString("MOVIE_NAME"));
	}
//
//	private Date toDate(Timestamp timestamp) {
//		return new Date(timestamp.getTime());
//	}
	
	public Movie selectById(Connection conn, int no) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(
					"select MOVIE_ID,MOVIE_NAME from Movie where MOVIE_ID = ?");
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			Movie movie = null;
			if (rs.next()) {
				movie = convertMovie(rs);
			}
			return movie;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
	
//	public void increaseReadCount(Connection conn, int no) throws SQLException {
//		try (PreparedStatement pstmt = 
//				conn.prepareStatement(
//						"update article set read_cnt = read_cnt + 1 "+
//						"where article_no = ?")) {
//			pstmt.setInt(1, no);
//			pstmt.executeUpdate();
//		}
//	}
//	
//	public int update(Connection conn, int no, String title) throws SQLException {
//		try (PreparedStatement pstmt = 
//				conn.prepareStatement(
//						"update article set title = ?, moddate = now() "+
//						"where article_no = ?")) {
//			pstmt.setString(1, title);
//			pstmt.setInt(2, no);
//			return pstmt.executeUpdate();
//		}
//	}
//	public void delete(Connection conn, int no) throws SQLException {
//		try (PreparedStatement pstmt = 
//				conn.prepareStatement(
//						"delete from article where article_no=?"
//						)) {
//			pstmt.setInt(1, no);
//			pstmt.executeUpdate();
//		}
//	}
}
