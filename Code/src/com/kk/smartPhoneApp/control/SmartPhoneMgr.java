package com.kk.smartPhoneApp.control;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.kk.smartPhoneApp.DAO.SmartPhoneDAO;
import com.kk.smartPhoneApp.DTO.SmartPhone;
import com.kk.smartPhoneApp.view.SearchSmartPhoneMenu;

public class SmartPhoneMgr {
	SmartPhoneDAO smartDao = new SmartPhoneDAO();
	Scanner sc = new Scanner(System.in); // Scanner
	
	public void smartPhoneView() {
		smartDao.selectSmartPhone();
		smartDao.printSmartPhoneList();
	}
	
	public void printSearchCompleteMsg() {
		System.out.println("�˻��� �Ϸ�Ǿ����ϴ�.");
		System.out.println("���α׷� �������� ���ư��ϴ�.");
	}
	
	public void printGoPrev() {
		System.out.println("�������� ���ư��ϴ�.");
	}
	
	public String inputString() {
		return sc.nextLine();
	}
	
	public int inputInteger() {
		int inputInteger = 0;

		while (true) {
			try {
				inputInteger = sc.nextInt();
				sc.nextLine();
				break;
			} catch (InputMismatchException e) {
				sc = new Scanner(System.in);
				System.out.println("�߸��� �Է��Դϴ�. �ٽ� �Է����ּ���.");
			}
		}
		return inputInteger;
	}
	
	public double inputDouble() {
		double inputInteger = 0;

		while (true) {
			try {
				inputInteger = sc.nextDouble();
				sc.nextLine();
				break;
			} catch (InputMismatchException e) {
				sc = new Scanner(System.in);
				System.out.println("�߸��� �Է��Դϴ�. �ٽ� �Է����ּ���.");
			}
		}
		return inputInteger;
	}
	
	// Search Menu
	
	public void printSearchQuestion() {
		System.out.print("�˻�� �Է����ּ��� : ");
	}
	
	
	
	public void smartPhoneSearch(int searchSmartPhoneMenuNum) {
		// Search by String 
		if (searchSmartPhoneMenuNum == SearchSmartPhoneMenu.SEARCH_MENU_NAME ||
			searchSmartPhoneMenuNum == SearchSmartPhoneMenu.SEARCH_MENU_MODEL ||
			searchSmartPhoneMenuNum == SearchSmartPhoneMenu.SEARCH_MENU_COMPANY ||
			searchSmartPhoneMenuNum == SearchSmartPhoneMenu.SEARCH_MENU_RESOLUTION) {
			printSearchQuestion();
			String searchByString = inputString();
			smartDao.searchByOneKeyWordsStringLike(searchByString, searchSmartPhoneMenuNum);
			smartDao.printSmartPhoneList();
		}
		// Search by Integer (��� �̻����� ����)
		else if (searchSmartPhoneMenuNum == SearchSmartPhoneMenu.SEARCH_MENU_PRICE ||
				 searchSmartPhoneMenuNum == SearchSmartPhoneMenu.SEARCH_MENU_SCANRATE ||
				 searchSmartPhoneMenuNum == SearchSmartPhoneMenu.SEARCH_MENU_RAM ||
				 searchSmartPhoneMenuNum == SearchSmartPhoneMenu.SEARCH_MENU_DISK ||
				 searchSmartPhoneMenuNum == SearchSmartPhoneMenu.SEARCH_MENU_CAMERA ||
				 searchSmartPhoneMenuNum == SearchSmartPhoneMenu.SEARCH_MENU_BATTERY ||
				 searchSmartPhoneMenuNum == SearchSmartPhoneMenu.SEARCH_MENU_WEIGHT) {
			printSearchQuestion();
			int searchByInteger = inputInteger();
			smartDao.searchByOneKeyWordsInteger(searchByInteger, searchSmartPhoneMenuNum);
			smartDao.printSmartPhoneList();
		}
		// Search by Double
		else if (searchSmartPhoneMenuNum == SearchSmartPhoneMenu.SEARCH_MENU_SCREEN) {
			printSearchQuestion();
			double searchByDouble = inputDouble();
			smartDao.searchByOneKeyWordsDouble(searchByDouble, searchSmartPhoneMenuNum);
			smartDao.printSmartPhoneList();
		}
		else {
			System.out.println("�߸��� ���� �Է��Դϴ�.");
		}
	}
	
	public void insertSmartPhone(SmartPhone sm) {
		smartDao.insertSmartPhoneInfo(sm);
	}
}
