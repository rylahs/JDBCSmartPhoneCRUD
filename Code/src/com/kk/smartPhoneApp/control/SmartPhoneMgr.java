package com.kk.smartPhoneApp.control;

import java.util.Scanner;

import com.kk.smartPhoneApp.DAO.SmartPhoneDAO;

public class SmartPhoneMgr {
	SmartPhoneDAO smartDao = new SmartPhoneDAO();
	Scanner sc = new Scanner(System.in); // Scanner
	
	public void smartPhoneView() {
		smartDao.selectSmartPhone();
		smartDao.printSmartPhoneList();
	}
	
}
