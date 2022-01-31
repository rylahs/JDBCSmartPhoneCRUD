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
	ModifySmartPhoneAll modSmartPhoneAll = new ModifySmartPhoneAll(); // ����Ʈ�� ���� �����ÿ� �ʿ��� View
	Scanner sc = new Scanner(System.in); // Scanner

	public void viewSmartPhone() {
		smartDao.selectSmartPhone(); // Select * from SmartPhone Query�� �����ϸ� ArrayList�� ��� ����Ʈ�� ������ ����
		smartDao.printSmartPhoneList(); // ArrayList Print
	}

	public void printGoPrev() { // �������� ���ư��� Message Print
		System.out.println("�������� ���ư��ϴ�.");
	}

	public String inputString() { // input String, ������ ���߱� ���� ���� �޼ҵ�
		return sc.nextLine();
	}

	public int inputInteger() { // input Integer, InputMismatchException �ذ��� ���� �޼ҵ�
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

	public double inputDouble() { // input Double, InputMismatchException �ذ��� ���� �޼ҵ�
		double inputDouble = 0;

		while (true) {
			try {
				inputDouble = sc.nextDouble();
				sc.nextLine();
				break;
			} catch (InputMismatchException e) {
				sc = new Scanner(System.in);
				System.out.println("�߸��� �Է��Դϴ�. �ٽ� �Է����ּ���.");
			}
		}
		return inputDouble;
	}

	// Search Menu

	public void printSearchQuestion() { // �˻��� �Է����ּ��� ����� ���� �޼ҵ�
		System.out.print("�˻�� �Է����ּ��� : ");
	}

	public void searchSmartPhone(int searchSmartPhoneMenuNum) {
		// Search by String
		if (searchSmartPhoneMenuNum == SearchSmartPhoneMenu.SEARCH_MENU_NAME
				|| searchSmartPhoneMenuNum == SearchSmartPhoneMenu.SEARCH_MENU_MODEL
				|| searchSmartPhoneMenuNum == SearchSmartPhoneMenu.SEARCH_MENU_COMPANY
				|| searchSmartPhoneMenuNum == SearchSmartPhoneMenu.SEARCH_MENU_RESOLUTION) {
			printSearchQuestion(); // �˻�� �Է����ּ��� : 
			String searchByString = inputString(); // Input String
			
			// �Է� ���� MenuNum => DBColName���� �Ѱܼ� Select * from smartPhone where �÷��� like �˻���
			smartDao.searchByOneKeyWordsStringLike(searchByString, searchSmartPhoneMenuNum); // �� ����� ArrayList�� ���  
			smartDao.printSmartPhoneList(); // ArrayList ���
		}
		// Search by Integer (��� �̻����� ����)
		else if (searchSmartPhoneMenuNum == SearchSmartPhoneMenu.SEARCH_MENU_PRICE
				|| searchSmartPhoneMenuNum == SearchSmartPhoneMenu.SEARCH_MENU_SCANRATE
				|| searchSmartPhoneMenuNum == SearchSmartPhoneMenu.SEARCH_MENU_RAM
				|| searchSmartPhoneMenuNum == SearchSmartPhoneMenu.SEARCH_MENU_DISK
				|| searchSmartPhoneMenuNum == SearchSmartPhoneMenu.SEARCH_MENU_CAMERA
				|| searchSmartPhoneMenuNum == SearchSmartPhoneMenu.SEARCH_MENU_BATTERY
				|| searchSmartPhoneMenuNum == SearchSmartPhoneMenu.SEARCH_MENU_WEIGHT) {
			printSearchQuestion();
			int searchByInteger = inputInteger();
			
			// �Է°��� MenuNum => DBColName���� �Ѱܼ� Select * from smartphone where �÷��� >= �˻���
			// ��ġ�� �ƴ� �̻����� ������ ����
			smartDao.searchByOneKeyWordsInteger(searchByInteger, searchSmartPhoneMenuNum); // �� ����� ArrayList�� ���
			smartDao.printSmartPhoneList(); // ArrayList ���
		}
		// Search by Double
		else if (searchSmartPhoneMenuNum == SearchSmartPhoneMenu.SEARCH_MENU_SCREEN) {
			printSearchQuestion();
			double searchByDouble = inputDouble();
			
			// �Է°��� MenuNum => DBColName���� �Ѱܼ� Select * from smartphone where �÷��� >= �˻���
			// ��ġ�� �ƴ� �̻����� ������ ����
			smartDao.searchByOneKeyWordsDouble(searchByDouble, searchSmartPhoneMenuNum); // �� ����� ArrayList�� ���
			smartDao.printSmartPhoneList(); // ArrayList ���
		} else {
			System.out.println("�߸��� ���� �Է��Դϴ�.");
		}
	}

	// Insert 
	public void insertSmartPhone(SmartPhone sm) {
		smartDao.insertSmartPhoneInfo(sm); // Insert Query ����
	}

	public void printSearchCompleteMsg() {
		System.out.println("�˻��� �Ϸ�Ǿ����ϴ�.");
		System.out.println("���α׷� �������� ���ư��ϴ�.");
	}

	public void printModifyIndexQuestion() {
		System.out.print("������ �����͸� �������ּ��� : ");
	}

	public void printModifyValueQuestion() {
		System.out.print("������ ���� �Է����ּ��� : ");
	}

	public void printModifyCompleteMsg() {
		System.out.println("������ �Ϸ�Ǿ����ϴ�.");
		System.out.println("���α׷� �������� ���ư��ϴ�.");
	}

	public int ModifySelectProductNum() { // ������ ������ Prod_Num�� �Է¹ް� �� ��ȣ�� ArrayList�� ProdNum�� �����ϴ����� Ȯ���ϴ� �޼ҵ�
		printModifyIndexQuestion();
		int listSize = smartDao.getSmartListsize(); // ArrayListSize�� 0�� ��쿡�� �˻��� ���� �ʰ� �����ϱ� ���� ����
		boolean listIsFind = false; // ����Ʈ���� �Է°��� Prod_Num�� ��ġ�ؾ� True �ƴϸ� False 
		int modifyIdx = -1; // Input
		if (listSize == 0) { // ArrayList�� ����ٸ�,
			System.out.println("����Ʈ�� �����Ͱ� �����ϴ�.");
			return -1; // -1 return
		} else {
			modifyIdx = inputInteger(); // Input 

			for (int i = 0; i < smartDao.getSmartPhoneList().size(); i++)	{ // ArrayList Search
				if (modifyIdx == smartDao.getSmartPhoneList().get(i).getProduct_Num()) { // ��ġ�Ѵٸ�
					listIsFind = true; // True
					break; // �ϳ��� ã���� �Ǽ� �ݺ��� Ż�� (�� �ڴ� ������� ����)
				}
			}

		}
		if (listIsFind) // ã�Ҵٸ�
			return modifyIdx; // �Է� ���� ��ȯ
		else { // ã�� ���ߴٸ�
			System.out.println("ã������ Prod_Num�� �������� �ʽ��ϴ�. �ٸ� ��ȣ�� �������ּ���.");
			return -1; // -1�� ��ȯ
		}
	}

	public void modifySmartPhone(int modifySelectMode) {
		// ������ �����͸� Ž���ϴ� ���� (ROW)
		int modifyIndex = ModifySelectProductNum(); // �Է°��� ��ȿ���� �Է¹ް� �˻� ����
		if (modifyIndex == -1) { // �Է°��� ��ȿ���� �ʴٸ� �޼ҵ� ����, �޽����� ���� �޼ҵ忡�� �̹� �����
			return;
		} else {
			// ������ ���� ����
			if (modifySelectMode == ModifySmartPhoneMenu.MODIFY_MOD_ALL) { // ������Ʈ ALL�� �Է��� ��� �ް� Update ������ �ϳ��ϳ� �����ϴ� ������ ����
				SmartPhone modifyData = modSmartPhoneAll.modifyData(); // ��� ���� �Է� �ޱ� ���� �ϳ��� ������ SmartPhone ��ü�� �����ϴ� �޴� ����
				// ���� ���� ������ Update ���� ����
				smartDao.modifySmartPhoneOnePointByString(modifyIndex, modifyData.getName(), ModifySmartPhoneMenu.MODIFY_MOD_NAME); // ��ǰ �̸� ����
				smartDao.modifySmartPhoneOnePointByString(modifyIndex, modifyData.getModel(), ModifySmartPhoneMenu.MODIFY_MOD_MODEL); // �𵨸� ���� 
				smartDao.modifySmartPhoneOnePointByInteger(modifyIndex, modifyData.getPrice(), ModifySmartPhoneMenu.MODIFY_MOD_PRICE); // ���� ����
				smartDao.modifySmartPhoneOnePointByString(modifyIndex, modifyData.getCompany(), ModifySmartPhoneMenu.MODIFY_MOD_COMPANY); // ������ ����
				smartDao.modifySmartPhoneOnePointByDouble(modifyIndex, modifyData.getScreen(), ModifySmartPhoneMenu.MODIFY_MOD_SCREEN); // ȭ�� ũ�� ����
				smartDao.modifySmartPhoneOnePointByString(modifyIndex, modifyData.getResolution(), ModifySmartPhoneMenu.MODIFY_MOD_RESOLUTION); // �ػ� ����
				smartDao.modifySmartPhoneOnePointByInteger(modifyIndex, modifyData.getScan_Rate(), ModifySmartPhoneMenu.MODIFY_MOD_SCANRATE); // �ֻ��� ����
				smartDao.modifySmartPhoneOnePointByInteger(modifyIndex, modifyData.getRam(), ModifySmartPhoneMenu.MODIFY_MOD_RAM); // �� �뷮 ����
				smartDao.modifySmartPhoneOnePointByInteger(modifyIndex, modifyData.getDisk(), ModifySmartPhoneMenu.MODIFY_MOD_DISK); // ��ũ �뷮 ����
				smartDao.modifySmartPhoneOnePointByInteger(modifyIndex, modifyData.getCamera(), ModifySmartPhoneMenu.MODIFY_MOD_CAMERA); // �ĸ� ī�޶� 1�� ȭ�� ����
				smartDao.modifySmartPhoneOnePointByInteger(modifyIndex, modifyData.getBattery(), ModifySmartPhoneMenu.MODIFY_MOD_BATTERY); // ���͸� �뷮 ����
				smartDao.modifySmartPhoneOnePointByInteger(modifyIndex, modifyData.getWeight(), ModifySmartPhoneMenu.MODIFY_MOD_WEIGHT); // ���� ����
			} else if (modifySelectMode == ModifySmartPhoneMenu.MODIFY_MOD_NAME
					|| modifySelectMode == ModifySmartPhoneMenu.MODIFY_MOD_MODEL
					|| modifySelectMode == ModifySmartPhoneMenu.MODIFY_MOD_COMPANY
					|| modifySelectMode == ModifySmartPhoneMenu.MODIFY_MOD_RESOLUTION) { // String �Է� ��� ���� ���� (�� ���� �����͸� ����)
				printModifyValueQuestion();
				String modifyByString = inputString();
				smartDao.modifySmartPhoneOnePointByString(modifyIndex, modifyByString, modifySelectMode); // Update Query ����
			} else if (modifySelectMode == ModifySmartPhoneMenu.MODIFY_MOD_PRICE
					|| modifySelectMode == ModifySmartPhoneMenu.MODIFY_MOD_SCANRATE
					|| modifySelectMode == ModifySmartPhoneMenu.MODIFY_MOD_RAM
					|| modifySelectMode == ModifySmartPhoneMenu.MODIFY_MOD_DISK
					|| modifySelectMode == ModifySmartPhoneMenu.MODIFY_MOD_CAMERA
					|| modifySelectMode == ModifySmartPhoneMenu.MODIFY_MOD_BATTERY
					|| modifySelectMode == ModifySmartPhoneMenu.MODIFY_MOD_WEIGHT) { // Integer �Է� ��� ���� ���� (�� ���� �����͸� ����)
				printModifyValueQuestion();
				int modifyByInteger = inputInteger();
				smartDao.modifySmartPhoneOnePointByInteger(modifyIndex, modifyByInteger, modifySelectMode); // Update Query ����
			} else if (modifySelectMode == ModifySmartPhoneMenu.MODIFY_MOD_SCREEN) { // Double �Է� ��� ���� ���� (�� ���� �����͸� ����)
				printModifyValueQuestion();
				double modifyByDouble = inputDouble();
				smartDao.modifySmartPhoneOnePointByDouble(modifyIndex, modifyByDouble, modifySelectMode); // Update Query ����
			}
		}
		printModifyCompleteMsg(); // ���� �Ϸ� �޽��� ���
	}
	public int deleteSelectProductNum() { // ������ ������ Prod_Num�� �Է¹ް� �� ��ȣ�� ArrayList�� ProdNum�� �����ϴ����� Ȯ���ϴ� �޼ҵ�
		printDeleteIndexQuestion();
		int listSize = smartDao.getSmartListsize(); // ArrayListSize�� 0�� ��쿡�� �˻��� ���� �ʰ� �����ϱ� ���� ����
		boolean listIsFind = false; // ����Ʈ���� �Է°��� Prod_Num�� ��ġ�ؾ� True �ƴϸ� False 
		int deleteIdx = -1; // Input
		if (listSize == 0) { // ArrayList�� ����ٸ�,
			System.out.println("����Ʈ�� �����Ͱ� �����ϴ�.");
			return -1; // -1 Return
		} else {
			deleteIdx = inputInteger(); // Input

			for (int i = 0; i < smartDao.getSmartPhoneList().size(); i++)	{ // ArrayList Search
				if (deleteIdx == smartDao.getSmartPhoneList().get(i).getProduct_Num()) { // ��ġ�ϴ� �����Ͱ� �ִٸ�
					listIsFind = true; // ������ ����
					break; // �ϳ��� ã���� �Ǽ� �ݺ��� Ż�� (�� �ڴ� ������� ����)
				}
			}

		}
		if (listIsFind) // ã�Ҵٸ�
			return deleteIdx; // �Է� �� ��ȯ
		else {
			System.out.println("ã������ Prod_Num�� �������� �ʽ��ϴ�. �ٸ� ��ȣ�� �������ּ���."); // ���� �޽��� ���
			return -1; // -1 Return
		}
	}
	public void printDeleteIndexQuestion() {
		System.out.print("������ �����͸� �������ּ��� : ");
	}
	public void printDeleteIndexCompleteMsg() {
		System.out.println("������ �Ϸ�Ǿ����ϴ�.");
		System.out.println("���α׷� �������� ���ư��ϴ�.");
	}
	
	public void deleteSmartPhone() { // Delete Query Method
		int deleteIndex = deleteSelectProductNum(); // �Է°��� ��ȿ���� �Է¹ް� �˻� ����
		if (deleteIndex == -1) { // ��ȿ���� ������
			return; // ��ȯ, �޽����� �˻翡�� �̹� �����
		} else {
			smartDao.deleteSmartPhoneDataCols(deleteIndex); // Delete Query Run
		}
		printDeleteIndexCompleteMsg(); // Print Message
	}

}
