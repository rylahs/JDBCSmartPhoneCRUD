package com.kk.smartPhoneApp.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.kk.smartPhoneApp.DTO.Member;

public class MemberDAO {
	private Connection con; // Connection
	private Statement st; // Query Run
	private ResultSet rs; // Query Result Set
	private PreparedStatement pstmt;
	private ArrayList<Member> memberList = new ArrayList<>();

	public MemberDAO() {
		String user = "root"; // c##tiger
		String pw = "1234";
		String url = "jdbc:mysql://localhost:3306/smartphonetp?characterEncoding=UTF-8&serverTimezone=UTC";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, pw); // 연결
			// con =
			// DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/MySQL_DB_TEST?serverTimezone=UTC&useSSL=false","root","1234);
			st = con.createStatement(); // Creates a Statement object for sendingSQL statements to the database.

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 로그인 시 DB에 아이디를 검색하고 비밀번호를 return 받음
	public String doLogin(String member_id) { 
		String SQL = "SELECT MEMBER.PASSWD FROM MEMBER WHERE ID=?";
		String passwd = "";
		try {
			pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, member_id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				passwd = rs.getString("passwd");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return passwd;
	}

	public void SelectMember() {
		String SQL = "select * from member";
		try {
			memberList.clear();
			rs = st.executeQuery(SQL); // Query Run
			while (rs.next()) {
				String id = rs.getString("ID");
				System.out.print("ID : " + id);

				String password = rs.getString("PASSWD");
				System.out.print("  PASSWORD : " + password);

				String memEmail = rs.getString("MEM_EMAIL");
				System.out.print("  E-MAIL : " + memEmail);

				String phoneNum = rs.getString("MEM_PHONE");
				System.out.print("  PHONE : " + phoneNum);

				String memName = rs.getString("MEM_NAME");
				System.out.print("  NAME : " + memName);

				String memAddress = rs.getString("MEM_ADDR");
				System.out.print("  ADDRESS : " + memAddress);

				System.out.println();
				Member em = new Member(id, password, memEmail, phoneNum, memName, memAddress);
				memberList.add(em);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean doLoginMain(String id, String pw) {
		try {
				String dbPassWd = doLogin(id);
			if (dbPassWd.equals(pw)&& dbPassWd.length() != 0) {
				Thread.sleep(100);
				System.out.print("로그인 중입니다.");
				Thread.sleep(100);
				System.out.print(".");
				Thread.sleep(100);
				System.out.print(".");
				Thread.sleep(100);
				System.out.print(".");
				Thread.sleep(100);
				System.out.println(".");
				Thread.sleep(100);
				System.out.println("로그인 성공!");
				return true;
			} else {
				Thread.sleep(100);
				System.out.print("로그인 중입니다.");
				Thread.sleep(100);
				System.out.print(".");
				Thread.sleep(100);
				System.out.print(".");
				Thread.sleep(100);
				System.out.print(".");
				Thread.sleep(100);
				System.out.println(".");
				Thread.sleep(100);
				System.out.println("로그인 실패!");
				return false;
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("회원정보가 일치하지 않습니다.");
		return false;

	}

	public void Quit() {
		try {
			rs.close();
			st.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
