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
		System.out.println("검색이 완료되었습니다.");
		System.out.println("프로그램 메인으로 돌아갑니다.");
	}
	
	public void printGoPrev() {
		System.out.println("이전으로 돌아갑니다.");
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
				System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
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
				System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
			}
		}
		return inputInteger;
	}
	
	// Search Menu
	
	public void printSearchQuestion() {
		System.out.print("검색어를 입력해주세요 : ");
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
		// Search by Integer (모두 이상으로 구현)
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
			System.out.println("잘못된 값의 입력입니다.");
		}
	}
	
	public void insertSmartPhone(SmartPhone sm) {
		smartDao.insertSmartPhoneInfo(sm);
	}
}
