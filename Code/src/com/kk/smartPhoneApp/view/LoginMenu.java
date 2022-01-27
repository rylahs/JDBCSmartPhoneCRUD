package com.kk.smartPhoneApp.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LoginMenu {
	public static final int LOGIN_MENU_LOGIN = 1;
	public static final int LOGIN_MENU_REGISTER = 2;
	public static final int LOGIN_MENU_MODIFY = 3;
	public static final int LOGIN_MENU_DELETE = 4;
	public static final int LOGIN_MENU_VIEW = 5;
	public static final int LOGIN_MENU_EXIT = 0;

	Scanner sc = new Scanner(System.in);

	public int menu() {
		int menu = 0;
		System.out.println("---------------------");
		System.out.println("  1. 로그인");
		System.out.println("  2. 회원 가입");
		System.out.println("  3. 회원 정보 수정");
		System.out.println("  4. 회원 탈퇴");
		System.out.println("  5. (시연용) 회원 정보 보기");
		System.out.println("  0. 프로그램 종료");
		System.out.println("---------------------");
		System.out.print("메뉴를 선택하세요 : ");
		while (true) {
			try {
				menu = sc.nextInt();
				if (menu >= LoginMenu.LOGIN_MENU_EXIT && menu <= LoginMenu.LOGIN_MENU_DELETE || menu == LOGIN_MENU_VIEW)
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
