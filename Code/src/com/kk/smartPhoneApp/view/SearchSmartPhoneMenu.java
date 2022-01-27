package com.kk.smartPhoneApp.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SearchSmartPhoneMenu {
	public static final int SEARCH_MENU_ALL = 1;
	public static final int SEARCH_MENU_NAME = 2;
	public static final int SEARCH_MENU_MODEL = 3;
	public static final int SEARCH_MENU_PRICE = 4;
	public static final int SEARCH_MENU_COMPANY = 5;
	public static final int SEARCH_MENU_SCREEN = 6;
	public static final int SEARCH_MENU_RESOLUTION = 7;
	public static final int SEARCH_MENU_SCANRATE = 8;
	public static final int SEARCH_MENU_RAM = 9;
	public static final int SEARCH_MENU_DISK = 10;
	public static final int SEARCH_MENU_CAMERA = 11;
	public static final int SEARCH_MENU_BATTERY = 12;
	public static final int SEARCH_MENU_WEIGHT = 13;
	public static final int SEARCH_MENU_PREV = 0;
	Scanner sc = new Scanner(System.in);

	public int selectMenu() {
		System.out.println("---------------------------------------------");
		System.out.println(">>\t\t스마트폰 정보 보기\t\t   <<");
		System.out.println("---------------------------------------------");
		System.out.print(" 1. 전체 데이터 보기"); // ALL
		System.out.print(" 2. 이름 검색\t"); // Like
		System.out.println(" 3. 모델명 검색"); // Like
		System.out.print(" 4. 가격 검색\t"); // >=
		System.out.print(" 5. 제조사 검색\t"); // Like
		System.out.println(" 6. 화면 크기 검색"); // >=
		System.out.print(" 7. 해상도 검색\t"); // Like
		System.out.print(" 8. 주사율 검색\t"); // >=
		System.out.println(" 9. 램용량"); // >=
		System.out.print(" 10. 디스크용량\t"); // >=
		System.out.print("11. 카메라\t"); // >=
		System.out.println("12. 배터리"); // >=
		System.out.print(" 13. 무게\t\t"); // >=
		System.out.println(" 0. 이전으로"); // Prev
		System.out.println("---------------------------------------------");
		System.out.print("메뉴를 선택하세요 : ");
		int menu = -1;
		while (true) {
			try {
				menu = sc.nextInt();
				if (menu >= SearchSmartPhoneMenu.SEARCH_MENU_PREV && menu <= SearchSmartPhoneMenu.SEARCH_MENU_WEIGHT)
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
