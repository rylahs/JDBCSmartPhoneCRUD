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
	ModifySmartPhoneAll modSmartPhoneAll = new ModifySmartPhoneAll(); // 스마트폰 정보 수정시에 필요한 View
	Scanner sc = new Scanner(System.in); // Scanner

	public void viewSmartPhone() {
		smartDao.selectSmartPhone(); // Select * from SmartPhone Query를 수행하며 ArrayList에 모든 스마트폰 정보를 담음
		smartDao.printSmartPhoneList(); // ArrayList Print
	}

	public void printGoPrev() { // 이전으로 돌아가는 Message Print
		System.out.println("이전으로 돌아갑니다.");
	}

	public String inputString() { // input String, 형식을 맞추기 위해 만든 메소드
		return sc.nextLine();
	}

	public int inputInteger() { // input Integer, InputMismatchException 해결을 위한 메소드
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

	public double inputDouble() { // input Double, InputMismatchException 해결을 위한 메소드
		double inputDouble = 0;

		while (true) {
			try {
				inputDouble = sc.nextDouble();
				sc.nextLine();
				break;
			} catch (InputMismatchException e) {
				sc = new Scanner(System.in);
				System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
			}
		}
		return inputDouble;
	}

	// Search Menu

	public void printSearchQuestion() { // 검색어 입력해주세요 출력을 위한 메소드
		System.out.print("검색어를 입력해주세요 : ");
	}

	public void searchSmartPhone(int searchSmartPhoneMenuNum) {
		// Search by String
		if (searchSmartPhoneMenuNum == SearchSmartPhoneMenu.SEARCH_MENU_NAME
				|| searchSmartPhoneMenuNum == SearchSmartPhoneMenu.SEARCH_MENU_MODEL
				|| searchSmartPhoneMenuNum == SearchSmartPhoneMenu.SEARCH_MENU_COMPANY
				|| searchSmartPhoneMenuNum == SearchSmartPhoneMenu.SEARCH_MENU_RESOLUTION) {
			printSearchQuestion(); // 검색어를 입력해주세요 : 
			String searchByString = inputString(); // Input String
			
			// 입력 값을 MenuNum => DBColName으로 넘겨서 Select * from smartPhone where 컬럼명 like 검색어
			smartDao.searchByOneKeyWordsStringLike(searchByString, searchSmartPhoneMenuNum); // 이 결과는 ArrayList에 담김  
			smartDao.printSmartPhoneList(); // ArrayList 출력
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
			
			// 입력값을 MenuNum => DBColName으로 넘겨서 Select * from smartphone where 컬럼명 >= 검색어
			// 일치가 아닌 이상으로 나오게 구현
			smartDao.searchByOneKeyWordsInteger(searchByInteger, searchSmartPhoneMenuNum); // 이 결과는 ArrayList에 담김
			smartDao.printSmartPhoneList(); // ArrayList 출력
		}
		// Search by Double
		else if (searchSmartPhoneMenuNum == SearchSmartPhoneMenu.SEARCH_MENU_SCREEN) {
			printSearchQuestion();
			double searchByDouble = inputDouble();
			
			// 입력값을 MenuNum => DBColName으로 넘겨서 Select * from smartphone where 컬럼명 >= 검색어
			// 일치가 아닌 이상으로 나오게 구현
			smartDao.searchByOneKeyWordsDouble(searchByDouble, searchSmartPhoneMenuNum); // 이 결과는 ArrayList에 담김
			smartDao.printSmartPhoneList(); // ArrayList 출력
		} else {
			System.out.println("잘못된 값의 입력입니다.");
		}
	}

	// Insert 
	public void insertSmartPhone(SmartPhone sm) {
		smartDao.insertSmartPhoneInfo(sm); // Insert Query 수행
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

	public int ModifySelectProductNum() { // 수정할 데이터 Prod_Num을 입력받고 그 번호가 ArrayList의 ProdNum에 존재하는지를 확인하는 메소드
		printModifyIndexQuestion();
		int listSize = smartDao.getSmartListsize(); // ArrayListSize가 0인 경우에는 검색을 하지 않고 종료하기 위한 변수
		boolean listIsFind = false; // 리스트에서 입력값과 Prod_Num이 일치해야 True 아니면 False 
		int modifyIdx = -1; // Input
		if (listSize == 0) { // ArrayList가 비었다면,
			System.out.println("스마트폰 데이터가 없습니다.");
			return -1; // -1 return
		} else {
			modifyIdx = inputInteger(); // Input 

			for (int i = 0; i < smartDao.getSmartPhoneList().size(); i++)	{ // ArrayList Search
				if (modifyIdx == smartDao.getSmartPhoneList().get(i).getProduct_Num()) { // 일치한다면
					listIsFind = true; // True
					break; // 하나만 찾으면 되서 반복문 탈출 (그 뒤는 쓸모없는 연산)
				}
			}

		}
		if (listIsFind) // 찾았다면
			return modifyIdx; // 입력 값을 반환
		else { // 찾지 못했다면
			System.out.println("찾으려는 Prod_Num은 존재하지 않습니다. 다른 번호를 선택해주세요.");
			return -1; // -1을 반환
		}
	}

	public void modifySmartPhone(int modifySelectMode) {
		// 수정할 데이터를 탐색하는 영역 (ROW)
		int modifyIndex = ModifySelectProductNum(); // 입력값이 유효한지 입력받고 검사 받음
		if (modifyIndex == -1) { // 입력값이 유효하지 않다면 메소드 종료, 메시지는 이전 메소드에서 이미 출력함
			return;
		} else {
			// 데이터 수정 영역
			if (modifySelectMode == ModifySmartPhoneMenu.MODIFY_MOD_ALL) { // 업데이트 ALL은 입력을 모두 받고 Update 쿼리를 하나하나 실행하는 것으로 구현
				SmartPhone modifyData = modSmartPhoneAll.modifyData(); // 모든 값을 입력 받기 위해 하나의 수정값 SmartPhone 객체를 생성하는 메뉴 실행
				// 각각 수정 쿼리인 Update 쿼리 실행
				smartDao.modifySmartPhoneOnePointByString(modifyIndex, modifyData.getName(), ModifySmartPhoneMenu.MODIFY_MOD_NAME); // 상품 이름 수정
				smartDao.modifySmartPhoneOnePointByString(modifyIndex, modifyData.getModel(), ModifySmartPhoneMenu.MODIFY_MOD_MODEL); // 모델명 수정 
				smartDao.modifySmartPhoneOnePointByInteger(modifyIndex, modifyData.getPrice(), ModifySmartPhoneMenu.MODIFY_MOD_PRICE); // 가격 수정
				smartDao.modifySmartPhoneOnePointByString(modifyIndex, modifyData.getCompany(), ModifySmartPhoneMenu.MODIFY_MOD_COMPANY); // 제조사 수정
				smartDao.modifySmartPhoneOnePointByDouble(modifyIndex, modifyData.getScreen(), ModifySmartPhoneMenu.MODIFY_MOD_SCREEN); // 화면 크기 수정
				smartDao.modifySmartPhoneOnePointByString(modifyIndex, modifyData.getResolution(), ModifySmartPhoneMenu.MODIFY_MOD_RESOLUTION); // 해상도 수정
				smartDao.modifySmartPhoneOnePointByInteger(modifyIndex, modifyData.getScan_Rate(), ModifySmartPhoneMenu.MODIFY_MOD_SCANRATE); // 주사율 수정
				smartDao.modifySmartPhoneOnePointByInteger(modifyIndex, modifyData.getRam(), ModifySmartPhoneMenu.MODIFY_MOD_RAM); // 램 용량 수정
				smartDao.modifySmartPhoneOnePointByInteger(modifyIndex, modifyData.getDisk(), ModifySmartPhoneMenu.MODIFY_MOD_DISK); // 디스크 용량 수정
				smartDao.modifySmartPhoneOnePointByInteger(modifyIndex, modifyData.getCamera(), ModifySmartPhoneMenu.MODIFY_MOD_CAMERA); // 후면 카메라 1번 화소 수정
				smartDao.modifySmartPhoneOnePointByInteger(modifyIndex, modifyData.getBattery(), ModifySmartPhoneMenu.MODIFY_MOD_BATTERY); // 배터리 용량 수정
				smartDao.modifySmartPhoneOnePointByInteger(modifyIndex, modifyData.getWeight(), ModifySmartPhoneMenu.MODIFY_MOD_WEIGHT); // 무게 수정
			} else if (modifySelectMode == ModifySmartPhoneMenu.MODIFY_MOD_NAME
					|| modifySelectMode == ModifySmartPhoneMenu.MODIFY_MOD_MODEL
					|| modifySelectMode == ModifySmartPhoneMenu.MODIFY_MOD_COMPANY
					|| modifySelectMode == ModifySmartPhoneMenu.MODIFY_MOD_RESOLUTION) { // String 입력 기반 수정 모음 (한 가지 데이터만 수정)
				printModifyValueQuestion();
				String modifyByString = inputString();
				smartDao.modifySmartPhoneOnePointByString(modifyIndex, modifyByString, modifySelectMode); // Update Query 수행
			} else if (modifySelectMode == ModifySmartPhoneMenu.MODIFY_MOD_PRICE
					|| modifySelectMode == ModifySmartPhoneMenu.MODIFY_MOD_SCANRATE
					|| modifySelectMode == ModifySmartPhoneMenu.MODIFY_MOD_RAM
					|| modifySelectMode == ModifySmartPhoneMenu.MODIFY_MOD_DISK
					|| modifySelectMode == ModifySmartPhoneMenu.MODIFY_MOD_CAMERA
					|| modifySelectMode == ModifySmartPhoneMenu.MODIFY_MOD_BATTERY
					|| modifySelectMode == ModifySmartPhoneMenu.MODIFY_MOD_WEIGHT) { // Integer 입력 기반 수정 모음 (한 가지 데이터만 수정)
				printModifyValueQuestion();
				int modifyByInteger = inputInteger();
				smartDao.modifySmartPhoneOnePointByInteger(modifyIndex, modifyByInteger, modifySelectMode); // Update Query 수행
			} else if (modifySelectMode == ModifySmartPhoneMenu.MODIFY_MOD_SCREEN) { // Double 입력 기반 수정 모음 (한 가지 데이터만 수정)
				printModifyValueQuestion();
				double modifyByDouble = inputDouble();
				smartDao.modifySmartPhoneOnePointByDouble(modifyIndex, modifyByDouble, modifySelectMode); // Update Query 수행
			}
		}
		printModifyCompleteMsg(); // 수정 완료 메시지 출력
	}
	public int deleteSelectProductNum() { // 삭제할 데이터 Prod_Num을 입력받고 그 번호가 ArrayList의 ProdNum에 존재하는지를 확인하는 메소드
		printDeleteIndexQuestion();
		int listSize = smartDao.getSmartListsize(); // ArrayListSize가 0인 경우에는 검색을 하지 않고 종료하기 위한 변수
		boolean listIsFind = false; // 리스트에서 입력값과 Prod_Num이 일치해야 True 아니면 False 
		int deleteIdx = -1; // Input
		if (listSize == 0) { // ArrayList가 비었다면,
			System.out.println("스마트폰 데이터가 없습니다.");
			return -1; // -1 Return
		} else {
			deleteIdx = inputInteger(); // Input

			for (int i = 0; i < smartDao.getSmartPhoneList().size(); i++)	{ // ArrayList Search
				if (deleteIdx == smartDao.getSmartPhoneList().get(i).getProduct_Num()) { // 일치하는 데이터가 있다면
					listIsFind = true; // 참으로 수정
					break; // 하나만 찾으면 되서 반복문 탈출 (그 뒤는 쓸모없는 연산)
				}
			}

		}
		if (listIsFind) // 찾았다면
			return deleteIdx; // 입력 값 반환
		else {
			System.out.println("찾으려는 Prod_Num은 존재하지 않습니다. 다른 번호를 선택해주세요."); // 실패 메시지 출력
			return -1; // -1 Return
		}
	}
	public void printDeleteIndexQuestion() {
		System.out.print("삭제할 데이터를 선택해주세요 : ");
	}
	public void printDeleteIndexCompleteMsg() {
		System.out.println("삭제가 완료되었습니다.");
		System.out.println("프로그램 메인으로 돌아갑니다.");
	}
	
	public void deleteSmartPhone() { // Delete Query Method
		int deleteIndex = deleteSelectProductNum(); // 입력값이 유효한지 입력받고 검사 받음
		if (deleteIndex == -1) { // 유효하지 않으면
			return; // 반환, 메시지는 검사에서 이미 출력함
		} else {
			smartDao.deleteSmartPhoneDataCols(deleteIndex); // Delete Query Run
		}
		printDeleteIndexCompleteMsg(); // Print Message
	}

}
