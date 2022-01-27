package com.kk.smartPhoneApp.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SmartPhoneMainMenu {
	public static final int MAIN_MENU_VIEW_ALL = 1;
	public static final int MAIN_MENU_VIEW_SEARCH = 2;
	public static final int MAIN_MENU_INSERT = 3;
	public static final int MAIN_MENU_MODIFY = 4;
	public static final int MAIN_MENU_DELETE = 5;
	public static final int MAIN_MENU_LOGOUT = 0;

	Scanner sc = new Scanner(System.in);

	public int menu() {
		int menu = -1;
		System.out.println("-----------------------");
		System.out.println("  스마트폰 정보 관리 프로그램");
		System.out.println("-----------------------");
		System.out.println("  1. 스마트폰 정보 모두 조회");
		System.out.println("  2. 스마트폰 정보 조건 조회");
		System.out.println("  3. 스마트폰 정보 추가");
		System.out.println("  4. 스마트폰 정보 수정");
		System.out.println("  5. 스마트폰 정보 삭제");
		System.out.println("  0. 로그아웃");
		System.out.println("-----------------------");
		System.out.print("메뉴를 선택하세요 : ");
		while (true) {
			try {
				menu = sc.nextInt();
				if (menu >= MAIN_MENU_LOGOUT && menu <= MAIN_MENU_DELETE)
					break;
				else
					System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
			} catch (InputMismatchException e) {
				sc = new Scanner(System.in);
				System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
			}
		}
		return menu;
	}
}
