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
		System.out.println("  ����Ʈ�� ���� ���� ���α׷�");
		System.out.println("-----------------------");
		System.out.println("  1. ����Ʈ�� ���� ��� ��ȸ");
		System.out.println("  2. ����Ʈ�� ���� ���� ��ȸ");
		System.out.println("  3. ����Ʈ�� ���� �߰�");
		System.out.println("  4. ����Ʈ�� ���� ����");
		System.out.println("  5. ����Ʈ�� ���� ����");
		System.out.println("  0. �α׾ƿ�");
		System.out.println("-----------------------");
		System.out.print("�޴��� �����ϼ��� : ");
		while (true) {
			try {
				menu = sc.nextInt();
				if (menu >= MAIN_MENU_LOGOUT && menu <= MAIN_MENU_DELETE)
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
