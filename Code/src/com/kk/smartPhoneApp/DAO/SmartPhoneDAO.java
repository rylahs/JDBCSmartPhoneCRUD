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
				int productNum = rs.getInt("Product_Num");
				String name = rs.getString("Name");
				String model = rs.getString("Model");
				int price = rs.getInt("Price");
				String company = rs.getString("Company");
				double screen = rs.getDouble("Screen");
				String resolution = rs.getString("Resolution");
				int scanRate = rs.getInt("Scan_Rate");
				int ram = rs.getInt("Ram");
				int disk = rs.getInt("Disk");
				int camera = rs.getInt("Camera");
				int battery = rs.getInt("Battery");
				int weight = rs.getInt("Weight");
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
