package com.kk.smartPhoneApp.view;

import java.util.InputMismatchException;
import java.util.Scanner;


public class ModifySmartPhoneMenu {
	public static final int MODIFY_VIEW_ALL = 1;
	public static final int MODIFY_DO = 2;
	public static final int MODIFY_PREV = 0;

	public static final int MODIFY_MOD_ALL = 1;
	public static final int MODIFY_MOD_NAME = 2;
	public static final int MODIFY_MOD_MODEL = 3;
	public static final int MODIFY_MOD_PRICE = 4;
	public static final int MODIFY_MOD_COMPANY = 5;
	public static final int MODIFY_MOD_SCREEN = 6;
	public static final int MODIFY_MOD_RESOLUTION = 7;
	public static final int MODIFY_MOD_SCANRATE = 8;
	public static final int MODIFY_MOD_RAM = 9;
	public static final int MODIFY_MOD_DISK = 10;
	public static final int MODIFY_MOD_CAMERA = 11;
	public static final int MODIFY_MOD_BATTERY = 12;
	public static final int MODIFY_MOD_WEIGHT = 13;
	public static final int MODIFY_MOD_PREV = 0;

	Scanner sc = new Scanner(System.in);

	public int modifyModSelect() {
		System.out.println("---------------------------------------------");
		System.out.println(">>\t\t스마트폰 자료 수정\t\t   <<");
		System.out.println("---------------------------------------------");
		System.out.print(" 1. 전체 데이터\t");
		System.out.print(" 2. 상품명\t");
		System.out.println(" 3. 모델명");
		System.out.print(" 4. 가격\t\t");
		System.out.print(" 5. 제조사\t");
		System.out.println(" 6. 화면 크기");
		System.out.print(" 7. 해상도\t");
		System.out.print(" 8. 주사율\t");
		System.out.println(" 9. 메모리 용량");
		System.out.print("10. 디스크 용량\t");
		System.out.print("11. 카메라 화소\t");
		System.out.println("12. 배터리");
		System.out.print("13. 무게\t\t");
		System.out.println(" 0. 이전으로");
		System.out.println("---------------------------------------------");
		System.out.print("메뉴를 선택하세요 : ");
		int menu = -1;
		while (true) {
			try {
				menu = sc.nextInt();
				if (menu >= ModifySmartPhoneMenu.MODIFY_MOD_PREV && menu <= ModifySmartPhoneMenu.MODIFY_MOD_BATTERY)
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

	public int modifyMenu() {
		System.out.println("---------------------");
		System.out.println("    스마트폰 정보 수정");
		System.out.println("---------------------");
		System.out.println(" 1. 전체 데이터 보기");
		System.out.println(" 2. 수정하기");
		System.out.println(" 0. 이전으로");
		System.out.println("---------------------");
		System.out.print("메뉴를 선택하세요 : ");
		int menu = -1;
		while (true) {
			try {
				menu = sc.nextInt();
				if (menu >= ModifySmartPhoneMenu.MODIFY_PREV && menu <= ModifySmartPhoneMenu.MODIFY_DO)
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
