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

	public ArrayList<Member> getMemberList() {
		return memberList;
	}

	public MemberDAO() {
		String user = "root"; // c##tiger
		String pw = "1234";
		String url = "jdbc:mysql://localhost:3306/smartphonetp?characterEncoding=UTF-8&serverTimezone=UTC";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, pw); // ����
			// con =
			// DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/MySQL_DB_TEST?serverTimezone=UTC&useSSL=false","root","1234);
			st = con.createStatement(); // Creates a Statement object for sendingSQL statements to the database.

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// �α��� �� DB�� ���̵� �˻��ϰ� ��й�ȣ�� return ����
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

	public boolean doLoginMain(String id, String pw) {
		try {
			String dbPassWd = doLogin(id);
			if (dbPassWd.equals(pw) && dbPassWd.length() != 0) {
				Thread.sleep(100);
				System.out.print("�α��� ���Դϴ�.");
				Thread.sleep(100);
				System.out.print(".");
				Thread.sleep(100);
				System.out.print(".");
				Thread.sleep(100);
				System.out.print(".");
				Thread.sleep(100);
				System.out.println(".");
				Thread.sleep(100);
				System.out.println("�α��� ����!");
				return true;
			} else {
				Thread.sleep(100);
				System.out.print("�α��� ���Դϴ�.");
				Thread.sleep(100);
				System.out.print(".");
				Thread.sleep(100);
				System.out.print(".");
				Thread.sleep(100);
				System.out.print(".");
				Thread.sleep(100);
				System.out.println(".");
				Thread.sleep(100);
				System.out.println("�α��� ����!");
				return false;
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("ȸ�������� ��ġ���� �ʽ��ϴ�.");
		return false;

	}

	public void insertUserInfo(Member m) {
		String SQL = "insert into MEMBER values (?, ?, ?, ?, ? ,?)";
		try {
			pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, m.getId());
			pstmt.setString(2, m.getPassword());
			pstmt.setString(3, m.getEmailAddress());
			pstmt.setString(4, m.getPhoneNumber());
			pstmt.setString(5, m.getMemberName());
			pstmt.setString(6, m.getMemberAddress());
			pstmt.executeUpdate(); // Query Run
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void modifyMemberInfoPW(String id, String pwd) {
		String SQL = "Update MEMBER "
				+ "set PASSWD = ? "
				+ "where id = ?";
		try {
			pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, pwd);
			pstmt.setString(2, id);
			pstmt.executeUpdate(); // Query Run
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void modifyMemberInfoEmail(String id, String email) {
		String SQL = "Update MEMBER "
				+ "set MEM_EMAIL = ? "
				+ "where id = ?";
		try {
			pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, email);
			pstmt.setString(2, id);
			pstmt.executeUpdate(); // Query Run
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void modifyMemberInfoPhone(String id, String phone) {
		String SQL = "Update MEMBER "
				+ "set MEM_PHONE = ? "
				+ "where id = ?";
		try {
			pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, phone);
			pstmt.setString(2, id);
			pstmt.executeUpdate(); // Query Run
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}	
	public void modifyMemberInfoName(String id, String name) {
		String SQL = "Update MEMBER "
				+ "set MEM_NAME = ? "
				+ "where id = ?";
		try {
			pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, name);
			pstmt.setString(2, id);
			pstmt.executeUpdate(); // Query Run
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void modifyMemberInfoAddress(String id, String addr) {
		String SQL = "Update MEMBER "
				+ "set MEM_ADDR = ? "
				+ "where id = ?";
		try {
			pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, addr);
			pstmt.setString(2, id);
			pstmt.executeUpdate(); // Query Run
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}	
	
	public void deleteMember(String id) {
		String SQL = "Delete FROM MEMBER "
				+ "where id = ?";
		try {
			pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, id);
			pstmt.executeUpdate(); // Query Run
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void selectMember() {
		String SQL = "select * from member";
		try {
			memberList.clear();
			rs = st.executeQuery(SQL); // Query Run
			while (rs.next()) {
				String id = rs.getString("ID");
				String password = rs.getString("PASSWD");
				String memEmail = rs.getString("MEM_EMAIL");
				String phoneNum = rs.getString("MEM_PHONE");
				String memName = rs.getString("MEM_NAME");
				String memAddress = rs.getString("MEM_ADDR");
				Member em = new Member(id, password, memEmail, phoneNum, memName, memAddress);
				memberList.add(em);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void printMemberList() {
		for (int i = 0; i < memberList.size(); i++) {
			memberList.get(i).printMember();
		}
	}
	

	public void quit() {
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
