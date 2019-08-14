package adminService.model.dao;

import static common.JDBCTemplate.*;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import board.model.vo.Board;
import owner.model.vo.Owner;
import ownerService.model.vo.Incruit;

public class ManageBoardDao {
	
	private Properties prop = new Properties();
	
	public ManageBoardDao() {
		
		String fileName = ManageBoardDao.class.getResource("/sql/adminService/adminService_query.properties").getPath();
		
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public ArrayList<Board> selectBoardReportList(Connection conn) {
		
		ArrayList<Board> list = null;	
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("selectBoardReportList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {

				list.add(new Board(
									rs.getInt("TNUM"),
									rs.getString("TITLE"),
									rs.getInt("ENUM"),
									rs.getString("ENAME"),
									rs.getDate("UPDATEDATE"),
									rs.getString("BBODY"),
									rs.getString("PHOTO"),
									rs.getInt("REPORT"),
									rs.getString("INVALIDPOST"),
									rs.getString("ISNOTICE"),
									rs.getInt("BOARDCOUNT")
									));
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return list;
		
	}
	
	public ArrayList<Comment> selectCommentReportList(Connection conn) {
		
		ArrayList<Comment> list = null;	
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("selectCommentReportList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				// 댓글은 신고없는지?
				list.add(new Comment(
									rs.getInt("TNUM"),
								
									));
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return list;
		
	}

}
