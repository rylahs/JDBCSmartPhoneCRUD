package com.kk.smartPhoneApp.control;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.kk.smartPhoneApp.DAO.SmartPhoneDAO;
import com.kk.smartPhoneApp.DTO.SmartPhone;
import com.kk.smartPhoneApp.view.ModifySmartPhoneAll;
import com.kk.smartPhoneApp.view.ModifySmartPhoneMenu;
import com.kk.smartPhoneApp.view.SearchSmartPhoneMenu;

public class SmartPhoneMgr {
	SmartPhoneDAO smartDao = new SmartPhoneDAO();
	ModifySmartPhoneAll modSmartPhoneAll = new ModifySmartPhoneAll();
	Scanner sc = new Scanner(System.in); // Scanner

	public void viewSmartPhone() {
		smartDao.selectSmartPhone();
		smartDao.printSmartPhoneList();
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

	public void searchSmartPhone(int searchSmartPhoneMenuNum) {
		// Search by String
		if (searchSmartPhoneMenuNum == SearchSmartPhoneMenu.SEARCH_MENU_NAME
				|| searchSmartPhoneMenuNum == SearchSmartPhoneMenu.SEARCH_MENU_MODEL
				|| searchSmartPhoneMenuNum == SearchSmartPhoneMenu.SEARCH_MENU_COMPANY
				|| searchSmartPhoneMenuNum == SearchSmartPhoneMenu.SEARCH_MENU_RESOLUTION) {
			printSearchQuestion();
			String searchByString = inputString();
			smartDao.searchByOneKeyWordsStringLike(searchByString, searchSmartPhoneMenuNum);
			smartDao.printSmartPhoneList();
		}
		// Search by Integer (모두 이상으로 구현)
		else if (searchSmartPhoneMenuNum == SearchSmartPhoneMenu.SEARCH_MENU_PRICE
				|| searchSmartPhoneMenuNum == SearchSmartPhoneMenu.SEARCH_MENU_SCANRATE
				|| searchSmartPhoneMenuNum == SearchSmartPhoneMenu.SEARCH_MENU_RAM
				|| searchSmartPhoneMenuNum == SearchSmartPhoneMenu.SEARCH_MENU_DISK
				|| searchSmartPhoneMenuNum == SearchSmartPhoneMenu.SEARCH_MENU_CAMERA
				|| searchSmartPhoneMenuNum == SearchSmartPhoneMenu.SEARCH_MENU_BATTERY
				|| searchSmartPhoneMenuNum == SearchSmartPhoneMenu.SEARCH_MENU_WEIGHT) {
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
		} else {
			System.out.println("잘못된 값의 입력입니다.");
		}
	}

	// Search
	public void insertSmartPhone(SmartPhone sm) {
		smartDao.insertSmartPhoneInfo(sm);
	}

	public void printSearchCompleteMsg() {
		System.out.println("검색이 완료되었습니다.");
		System.out.println("프로그램 메인으로 돌아갑니다.");
	}

	public void printModifyIndexQuestion() {
		System.out.print("수정할 데이터를 선택해주세요 : ");
	}

	public void printModifyValueQuestion() {
		System.out.print("수정할 값을 입력해주세요 : ");
	}

	public void printModifyCompleteMsg() {
		System.out.println("수정이 완료되었습니다.");
		System.out.println("프로그램 메인으로 돌아갑니다.");
	}

	public int ModifySelectProductNum() {
		printModifyIndexQuestion();
		int listSize = smartDao.getSmartListsize();
		boolean listisFind = false;
		int modifyIdx = -1;
		if (listSize == 0) {
			System.out.println("스마트폰 데이터가 없습니다.");
			return -1;
		} else {
			modifyIdx = inputInteger();

			for (int i = 0; i < smartDao.getSmartPhoneList().size(); i++)	{
				if (modifyIdx == smartDao.getSmartPhoneList().get(i).getProduct_Num()) {
					listisFind = true;
				}
			}

		}
		if (listisFind)
			return modifyIdx;
		else {
			System.out.println("찾으려는 Prod_Num은 존재하지 않습니다. 다른 번호를 선택해주세요.");
			return -1;
		}
	}

	public void modifySmartPhone(int modifySelectMode) {
		// 수정할 데이터를 탐색하는 영역 (ROW)
		int modifyIndex = ModifySelectProductNum();
		if (modifyIndex == -1) {
			System.out.println("Error");
			return;
		} else {
			// 데이터 수정 영역
			if (modifySelectMode == ModifySmartPhoneMenu.MODIFY_MOD_ALL) {
				SmartPhone modifyData = modSmartPhoneAll.modifyData();
				smartDao.modifySmartPhoneOnePointByString(modifyIndex, modifyData.getName(), ModifySmartPhoneMenu.MODIFY_MOD_NAME);
				smartDao.modifySmartPhoneOnePointByString(modifyIndex, modifyData.getModel(), ModifySmartPhoneMenu.MODIFY_MOD_MODEL);
				smartDao.modifySmartPhoneOnePointByInteger(modifyIndex, modifyData.getPrice(), ModifySmartPhoneMenu.MODIFY_MOD_PRICE);
				smartDao.modifySmartPhoneOnePointByString(modifyIndex, modifyData.getCompany(), ModifySmartPhoneMenu.MODIFY_MOD_COMPANY);
				smartDao.modifySmartPhoneOnePointByDouble(modifyIndex, modifyData.getScreen(), ModifySmartPhoneMenu.MODIFY_MOD_SCREEN);
				smartDao.modifySmartPhoneOnePointByString(modifyIndex, modifyData.getResolution(), ModifySmartPhoneMenu.MODIFY_MOD_RESOLUTION);
				smartDao.modifySmartPhoneOnePointByInteger(modifyIndex, modifyData.getScan_Rate(), ModifySmartPhoneMenu.MODIFY_MOD_SCANRATE);
				smartDao.modifySmartPhoneOnePointByInteger(modifyIndex, modifyData.getRam(), ModifySmartPhoneMenu.MODIFY_MOD_RAM);
				smartDao.modifySmartPhoneOnePointByInteger(modifyIndex, modifyData.getDisk(), ModifySmartPhoneMenu.MODIFY_MOD_DISK);
				smartDao.modifySmartPhoneOnePointByInteger(modifyIndex, modifyData.getCamera(), ModifySmartPhoneMenu.MODIFY_MOD_CAMERA);
				smartDao.modifySmartPhoneOnePointByInteger(modifyIndex, modifyData.getBattery(), ModifySmartPhoneMenu.MODIFY_MOD_BATTERY);
				smartDao.modifySmartPhoneOnePointByInteger(modifyIndex, modifyData.getWeight(), ModifySmartPhoneMenu.MODIFY_MOD_WEIGHT);
			} else if (modifySelectMode == ModifySmartPhoneMenu.MODIFY_MOD_NAME
					|| modifySelectMode == ModifySmartPhoneMenu.MODIFY_MOD_MODEL
					|| modifySelectMode == ModifySmartPhoneMenu.MODIFY_MOD_COMPANY
					|| modifySelectMode == ModifySmartPhoneMenu.MODIFY_MOD_RESOLUTION) {
				printModifyValueQuestion();
				String modifyByString = inputString();
				smartDao.modifySmartPhoneOnePointByString(modifyIndex, modifyByString, modifySelectMode);
			} else if (modifySelectMode == ModifySmartPhoneMenu.MODIFY_MOD_PRICE
					|| modifySelectMode == ModifySmartPhoneMenu.MODIFY_MOD_SCANRATE
					|| modifySelectMode == ModifySmartPhoneMenu.MODIFY_MOD_RAM
					|| modifySelectMode == ModifySmartPhoneMenu.MODIFY_MOD_DISK
					|| modifySelectMode == ModifySmartPhoneMenu.MODIFY_MOD_CAMERA
					|| modifySelectMode == ModifySmartPhoneMenu.MODIFY_MOD_BATTERY
					|| modifySelectMode == ModifySmartPhoneMenu.MODIFY_MOD_WEIGHT) {
				printModifyValueQuestion();
				int modifyByInteger = inputInteger();
				smartDao.modifySmartPhoneOnePointByInteger(modifyIndex, modifyByInteger, modifySelectMode);
			} else if (modifySelectMode == ModifySmartPhoneMenu.MODIFY_MOD_SCREEN) {
				printModifyValueQuestion();
				double modifyByDouble = inputDouble();
				smartDao.modifySmartPhoneOnePointByDouble(modifyIndex, modifyByDouble, modifySelectMode);
			}
		}
		printModifyCompleteMsg();
	}
	public int deleteSelectProductNum() {
		printDeleteIndexQuestion();
		int listSize = smartDao.getSmartListsize();
		boolean listisFind = false;
		int deleteIdx = -1;
		if (listSize == 0) {
			System.out.println("스마트폰 데이터가 없습니다.");
			return -1;
		} else {
			deleteIdx = inputInteger();

			for (int i = 0; i < smartDao.getSmartPhoneList().size(); i++)	{
				if (deleteIdx == smartDao.getSmartPhoneList().get(i).getProduct_Num()) {
					listisFind = true;
				}
			}

		}
		if (listisFind)
			return deleteIdx;
		else {
			System.out.println("찾으려는 Prod_Num은 존재하지 않습니다. 다른 번호를 선택해주세요.");
			return -1;
		}
	}
	public void printDeleteIndexQuestion() {
		System.out.print("삭제할 데이터를 선택해주세요 : ");
	}
	public void printDeleteIndexCompleteMsg() {
		System.out.println("삭제가 완료되었습니다.");
		System.out.println("프로그램 메인으로 돌아갑니다.");
	}
	
	public void deleteSmartPhone() {
		int deleteIndex = deleteSelectProductNum();
		if (deleteIndex == -1) {
			return;
		} else {
			smartDao.deleteSmartPhoneDataRows(deleteIndex);
		}
		printDeleteIndexCompleteMsg();
	}

}
