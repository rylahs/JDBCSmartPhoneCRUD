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
		System.out.println(">>\t\t����Ʈ�� �ڷ� ����\t\t   <<");
		System.out.println("---------------------------------------------");
		System.out.print(" 1. ��ü ������\t");
		System.out.print(" 2. ��ǰ��\t");
		System.out.println(" 3. �𵨸�");
		System.out.print(" 4. ����\t\t");
		System.out.print(" 5. ������\t");
		System.out.println(" 6. ȭ�� ũ��");
		System.out.print(" 7. �ػ�\t");
		System.out.print(" 8. �ֻ���\t");
		System.out.println(" 9. �޸� �뷮");
		System.out.print("10. ��ũ �뷮\t");
		System.out.print("11. ī�޶� ȭ��\t");
		System.out.println("12. ���͸�");
		System.out.print("13. ����\t\t");
		System.out.println(" 0. ��������");
		System.out.println("---------------------------------------------");
		System.out.print("�޴��� �����ϼ��� : ");
		int menu = -1;
		while (true) {
			try {
				menu = sc.nextInt();
				if (menu >= ModifySmartPhoneMenu.MODIFY_MOD_PREV && menu <= ModifySmartPhoneMenu.MODIFY_MOD_BATTERY)
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

	public int modifyMenu() {
		System.out.println("---------------------");
		System.out.println("    ����Ʈ�� ���� ����");
		System.out.println("---------------------");
		System.out.println(" 1. ��ü ������ ����");
		System.out.println(" 2. �����ϱ�");
		System.out.println(" 0. ��������");
		System.out.println("---------------------");
		System.out.print("�޴��� �����ϼ��� : ");
		int menu = -1;
		while (true) {
			try {
				menu = sc.nextInt();
				if (menu >= ModifySmartPhoneMenu.MODIFY_PREV && menu <= ModifySmartPhoneMenu.MODIFY_DO)
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
