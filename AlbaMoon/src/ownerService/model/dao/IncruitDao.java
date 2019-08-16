package ownerService.model.dao;

import static common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import ownerService.model.vo.Filter;
import emp.model.vo.Emp;
import empService.model.vo.Resume;
import ownerService.model.vo.Appliant;
import ownerService.model.vo.Incruit;


public class IncruitDao {
	
	private Properties prop = new Properties();
	
	public IncruitDao() {
		
		String fileName = IncruitDao.class.getResource("/sql/ownerService/ownerService_query.properties").getPath();
		
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public int enrollIncruit(Connection conn, Incruit incruit) {

		int result = 0;

		PreparedStatement pstmt = null;

		String sql = prop.getProperty("enrollIncruit");

		try {
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, resume.getResumeTitle());
//			pstmt.setInt(2, resume.getEmpNum());
//			pstmt.setString(3, resume.getDistrict());
//			pstmt.setString(4, resume.getType());
//			pstmt.setString(5, resume.getComment());
//			pstmt.setString(6, resume.사진경로);
//			pstmt.setString(7, resume.getDesireForm());
//			pstmt.setInt(8, resume.getDesireIncome());
//			pstmt.setString(9, resume.getOpenSet());
//			pstmt.setString(10, resume.getEdu());
			
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
		
	}
	
	public ArrayList<Incruit> selectIncruitList(Connection conn, int oNum) {
		
		ArrayList<Incruit> list = null;
		Incruit incruit = null;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("selectIncruitList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, oNum);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
//				incruit = new Incruit(
//									rs.getInt("USER_NO"),
//									rs.getString("user_id"),
//									rs.getString("user_pwd"),
//									rs.getString("user_name"),
//									rs.getString("phone"),
//									rs.getString("email"),
//									rs.getString("address"),
//									rs.getString("interest"),
//									rs.getDate("enroll_date"),
//									rs.getDate("modify_date"),
//									rs.getString("status")
//									);
				list.add(incruit);
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return list;
		
	}
	
	public ArrayList<Appliant> selectManageEmp(Connection conn, int oNum){
		
		ArrayList<Appliant> list = null;
		Emp emp = null;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("selectManageEmp");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, oNum);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
//				incruit = new Incruit(
//									rs.getInt("USER_NO"),
//									rs.getString("user_id"),
//									rs.getString("user_pwd"),
//									rs.getString("user_name"),
//									rs.getString("phone"),
//									rs.getString("email"),
//									rs.getString("address"),
//									rs.getString("interest"),
//									rs.getDate("enroll_date"),
//									rs.getDate("modify_date"),
//									rs.getString("status")
//									);
				list.add(emp);
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return list;
		
		
	}
	
	public int deleteIncruit(Connection conn, int incruitNum) {

		int result = 0;

		PreparedStatement pstmt = null;

		String sql = prop.getProperty("deleteIncruit");

		try {
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, resume.getResumeTitle());
//			pstmt.setInt(2, resume.getEmpNum());
//			pstmt.setString(3, resume.getDistrict());
//			pstmt.setString(4, resume.getType());
//			pstmt.setString(5, resume.getComment());
//			pstmt.setString(6, resume.사진경로);
//			pstmt.setString(7, resume.getDesireForm());
//			pstmt.setInt(8, resume.getDesireIncome());
//			pstmt.setString(9, resume.getOpenSet());
//			pstmt.setString(10, resume.getEdu());
			
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
		
	}
	
	public int empPassYn(Connection conn, int applyNum, String passOrFail) {
		
		int result = 0;

		PreparedStatement pstmt = null;

		String sql = prop.getProperty("empPassYn");

		try {
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, resume.getResumeTitle());
//			pstmt.setInt(2, resume.getEmpNum());
//			pstmt.setString(3, resume.getDistrict());
//			pstmt.setString(4, resume.getType());
//			pstmt.setString(5, resume.getComment());
//			pstmt.setString(6, resume.사진경로);
//			pstmt.setString(7, resume.getDesireForm());
//			pstmt.setInt(8, resume.getDesireIncome());
//			pstmt.setString(9, resume.getOpenSet());
//			pstmt.setString(10, resume.getEdu());
			
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
		
		
	}
	
	public ArrayList<Resume> selectSearchResumeList(Connection conn, Filter filter) {
		
		ArrayList<Resume> list = null;
		Resume resume = null;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("selectSearchResumeList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, filter);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
//				resume = new Resume(
//									rs.getInt("USER_NO"),
//									rs.getString("user_id"),
//									rs.getString("user_pwd"),
//									rs.getString("user_name"),
//									rs.getString("phone"),
//									rs.getString("email"),
//									rs.getString("address"),
//									rs.getString("interest"),
//									rs.getDate("enroll_date"),
//									rs.getDate("modify_date"),
//									rs.getString("status")
//									);
				list.add(resume);
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
