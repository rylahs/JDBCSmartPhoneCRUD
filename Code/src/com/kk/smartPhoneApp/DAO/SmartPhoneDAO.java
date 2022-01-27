package com.kk.smartPhoneApp.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.kk.smartPhoneApp.DTO.SmartPhone;

public class SmartPhoneDAO {
	private Connection con; // Connection
	private Statement st; // Query Run
	private PreparedStatement pstmt;
	private ResultSet rs; // Query Result Set
	private ArrayList<SmartPhone> smartPhoneList = new ArrayList<>();
	private String DBRowName[] = {"Product_Num", "name", "Model", "Price", "Company", "Screen", "Resolution","Scan_Rate", "Ram", "Disk", "Camera", "Battery", "Weight"};
	public SmartPhoneDAO() {
		String user = "root"; // c##tiger
		String pw = "1234";
		String url = "jdbc:mysql://localhost:3306/smartphonetp?characterEncoding=UTF-8&serverTimezone=UTC";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, pw); // ¿¬°á
			st = con.createStatement(); // Creates a Statement object for sendingSQL statements to the database.

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void selectSmartPhone() {
		String SQL = "select * from smartphone";
		try {
			smartPhoneList.clear();
			rs = st.executeQuery(SQL); // Query Run
			while (rs.next()) {
				int productNum = rs.getInt(DBRowName[0]);
				String name = rs.getString(DBRowName[1]);
				String model = rs.getString(DBRowName[2]);
				int price = rs.getInt(DBRowName[3]);
				String company = rs.getString(DBRowName[4]);
				double screen = rs.getDouble(DBRowName[5]);
				String resolution = rs.getString(DBRowName[6]);
				int scanRate = rs.getInt(DBRowName[7]);
				int ram = rs.getInt(DBRowName[8]);
				int disk = rs.getInt(DBRowName[9]);
				int camera = rs.getInt(DBRowName[10]);
				int battery = rs.getInt(DBRowName[11]);
				int weight = rs.getInt(DBRowName[12]);
				SmartPhone smData = new SmartPhone(productNum, name, model, price, company, screen, resolution, scanRate, ram, disk, camera, battery, weight);
				smartPhoneList.add(smData);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void printSmartPhoneList() {
		for (int i = 0; i < smartPhoneList.size(); i++) {
			smartPhoneList.get(i).pritSmartPhone();
		}
	}
	
	public void searchByOneKeyWordsStringLike(String searchByString, int searchSmartPhoneMenuNum) {
		String SQL = "select * from smartphone where " + DBRowName[searchSmartPhoneMenuNum - 1] + " like ?";
		
		try {
			smartPhoneList.clear();
			pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, "%"+searchByString+"%");
			rs = pstmt.executeQuery(); // Query Run
			while(rs.next()) {
				int productNum = rs.getInt(DBRowName[0]);
				String name = rs.getString(DBRowName[1]);
				String model = rs.getString(DBRowName[2]);
				int price = rs.getInt(DBRowName[3]);
				String company = rs.getString(DBRowName[4]);
				double screen = rs.getDouble(DBRowName[5]);
				String resolution = rs.getString(DBRowName[6]);
				int scanRate = rs.getInt(DBRowName[7]);
				int ram = rs.getInt(DBRowName[8]);
				int disk = rs.getInt(DBRowName[9]);
				int camera = rs.getInt(DBRowName[10]);
				int battery = rs.getInt(DBRowName[11]);
				int weight = rs.getInt(DBRowName[12]);
				SmartPhone smData = new SmartPhone(productNum, name, model, price, company, screen, resolution, scanRate, ram, disk, camera, battery, weight);
				smartPhoneList.add(smData);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void searchByOneKeyWordsInteger(int searchByInt, int searchSmartPhoneMenuNum) {
		String SQL = "select * from smartphone where " + DBRowName[searchSmartPhoneMenuNum - 1] + " >= ?";
		
		try {
			smartPhoneList.clear();
			pstmt = con.prepareStatement(SQL);
			pstmt.setInt(1, searchByInt);
			rs = pstmt.executeQuery(); // Query Run
			while(rs.next()) {
				int productNum = rs.getInt(DBRowName[0]);
				String name = rs.getString(DBRowName[1]);
				String model = rs.getString(DBRowName[2]);
				int price = rs.getInt(DBRowName[3]);
				String company = rs.getString(DBRowName[4]);
				double screen = rs.getDouble(DBRowName[5]);
				String resolution = rs.getString(DBRowName[6]);
				int scanRate = rs.getInt(DBRowName[7]);
				int ram = rs.getInt(DBRowName[8]);
				int disk = rs.getInt(DBRowName[9]);
				int camera = rs.getInt(DBRowName[10]);
				int battery = rs.getInt(DBRowName[11]);
				int weight = rs.getInt(DBRowName[12]);
				SmartPhone smData = new SmartPhone(productNum, name, model, price, company, screen, resolution, scanRate, ram, disk, camera, battery, weight);
				smartPhoneList.add(smData);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void searchByOneKeyWordsDouble(double searchByDouble, int searchSmartPhoneMenuNum) {
		String SQL = "select * from smartphone where " + DBRowName[searchSmartPhoneMenuNum - 1] + " >= ?";
		
		try {
			smartPhoneList.clear();
			pstmt = con.prepareStatement(SQL);
			pstmt.setDouble(1, searchByDouble);
			rs = pstmt.executeQuery(); // Query Run
			while(rs.next()) {
				int productNum = rs.getInt(DBRowName[0]);
				String name = rs.getString(DBRowName[1]);
				String model = rs.getString(DBRowName[2]);
				int price = rs.getInt(DBRowName[3]);
				String company = rs.getString(DBRowName[4]);
				double screen = rs.getDouble(DBRowName[5]);
				String resolution = rs.getString(DBRowName[6]);
				int scanRate = rs.getInt(DBRowName[7]);
				int ram = rs.getInt(DBRowName[8]);
				int disk = rs.getInt(DBRowName[9]);
				int camera = rs.getInt(DBRowName[10]);
				int battery = rs.getInt(DBRowName[11]);
				int weight = rs.getInt(DBRowName[12]);
				SmartPhone smData = new SmartPhone(productNum, name, model, price, company, screen, resolution, scanRate, ram, disk, camera, battery, weight);
				smartPhoneList.add(smData);
			}
		} catch (SQLException e) {
			e.printStackTrace();
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
