package com.dev.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.dev.vo.MemberVO;

// service 에서 받은 VO 모델을 DB로 처리하기 위한 클래스 
public class MemberDAO {
	// 객체를 단 한개만 만들기 위한
	private static MemberDAO dao = new MemberDAO();
	
	// 디폴트 생성자 접근 제한자 지정
	private MemberDAO() {}
	
	// 단 한개의 객체 반환
	public static MemberDAO getInstance() {
		return dao;
	}
	
	private Connection connect() {
		Connection con = null;
		String dbUrl = "jdbc:mysql://localhost/test?characterEncoding=UTF-8&serverTimezone=UTC";
		String user = "root";
		String passwd = "1234";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(dbUrl, user, passwd);
		} catch (ClassNotFoundException e) {
			System.out.print("MemberDAO-connect:ClassNotFound " + e);
		} catch (SQLException e) {
			System.out.print("MemberDAO-connect:SQL " + e);
		}
		
		return con;
	}
	
	private void close(Connection con, PreparedStatement pstmt) {
		if(pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				System.out.print("pstmt.close error " + e);
			}
		}
		if(con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.print("con.close error " + e);
			}
		}
	}
	
	private void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
		if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				System.out.print("rs.close error " + e);
			}
		}
		
		close(con,pstmt);
	}
	
	public void memberInsert(MemberVO member) {
		Connection con = connect();
		String sql = "insert into member values(?, ?, ?);";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPwd());
			pstmt.setString(3, member.getName());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.print("MemberDAO-Insert error " + e);
		} finally {
			close(con, pstmt);
		}
	}
	
	public MemberVO memberSearch(String id) {
		Connection con = connect();
		String sql = "select * from member where id=?;";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberVO member = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				member = new MemberVO();
				member.setId(rs.getString("id"));
				member.setPwd(rs.getString("pwd"));
				member.setName(rs.getString("name"));
			}
		} catch (SQLException e) {
			System.out.print("MemberDAO-Search error " + e);
		} finally {
			close(con, pstmt, rs);
		}
		
		return member;
	}
	
	public void memberUpdate(MemberVO member) {
		Connection con = connect();
		String sql = "update member set pwd=?, name=? where id=?;";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getPwd());
			pstmt.setString(2, member.getName());
			pstmt.setString(3, member.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.print("MemberDAO-Update error " + e);
		} finally {
			close(con, pstmt);
		}
	}
	
	public void memberDelete(String id) {
		Connection con = connect();
		String sql = "delete from member where id=?;";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.print("MemberDAO-Delete error " + e);
		} finally {
			close(con, pstmt);
		}
	}
	
	public ArrayList<MemberVO> memberList() {
		Connection con = connect();
		String sql = "select * from member;";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<MemberVO> List = new ArrayList<MemberVO>();
		MemberVO member = null;
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				member = new MemberVO();
				member.setId(rs.getString("id"));
				member.setPwd(rs.getString("pwd"));
				member.setName(rs.getString("name"));
				List.add(member);
			}
		} catch (SQLException e) {
			System.out.print("MemberDAO-List error " + e);
		} finally {
			close(con, pstmt, rs);
		}
		
		return List;
	}
}
