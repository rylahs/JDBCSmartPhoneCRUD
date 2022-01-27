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
		System.out.println(">>\t\t����Ʈ�� ���� ����\t\t   <<");
		System.out.println("---------------------------------------------");
		System.out.print(" 1. ��ü ������ ����"); // ALL
		System.out.print(" 2. �̸� �˻�\t"); // Like
		System.out.println(" 3. �𵨸� �˻�"); // Like
		System.out.print(" 4. ���� �˻�\t"); // >=
		System.out.print(" 5. ������ �˻�\t"); // Like
		System.out.println(" 6. ȭ�� ũ�� �˻�"); // >=
		System.out.print(" 7. �ػ� �˻�\t"); // Like
		System.out.print(" 8. �ֻ��� �˻�\t"); // >=
		System.out.println(" 9. ���뷮"); // >=
		System.out.print(" 10. ��ũ�뷮\t"); // >=
		System.out.print("11. ī�޶�\t"); // >=
		System.out.println("12. ���͸�"); // >=
		System.out.print(" 13. ����\t\t"); // >=
		System.out.println(" 0. ��������"); // Prev
		System.out.println("---------------------------------------------");
		System.out.print("�޴��� �����ϼ��� : ");
		int menu = -1;
		while (true) {
			try {
				menu = sc.nextInt();
				if (menu >= SearchSmartPhoneMenu.SEARCH_MENU_PREV && menu <= SearchSmartPhoneMenu.SEARCH_MENU_WEIGHT)
					break;
				else
					System.out.println("�߸��� �Է��Դϴ�. �ٽ� �Է����ּ���.");
			} catch (InputMismatchException e) {
				sc = new Scanner(System.in);
				System.out.println("�߸��� �Է��Դϴ�. �ٽ� �Է����ּ���.");
			}
		}
		return menu;

	}
}
