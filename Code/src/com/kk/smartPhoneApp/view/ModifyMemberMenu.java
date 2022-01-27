package com.kk.smartPhoneApp.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ModifyMemberMenu {
	public static final int MEMBER_MODIFY_ALL_INFO = 1;
	public static final int MEMBER_MODIFY_PASSWORD = 2;
	public static final int MEMBER_MODIFY_EMAIL = 3;
	public static final int MEMBER_MODIFY_PHONE = 4;
	public static final int MEMBER_MODIFY_NAME = 5;
	public static final int MEMBER_MODIFY_ADDRESS = 6;
	public static final int MEMBER_PREV = 0;
	Scanner sc = new Scanner(System.in);

	public int modifyMember() {
		System.out.println("---------------------");
		System.out.println("    회원 정보 수정");
		System.out.println("---------------------");
		System.out.println(" 1. 전체 수정");
		System.out.println(" 2. 비밀번호 수정");
		System.out.println(" 3. 이메일 수정");
		System.out.println(" 4. 전화번호 수정");
		System.out.println(" 5. 이름 수정");
		System.out.println(" 6. 주소 수정");
		System.out.println(" 0. 이전으로");
		System.out.println("---------------------");
		System.out.print("메뉴를 선택하세요 : ");
		int menu = -1;
		while (true) {
			try {
				menu = sc.nextInt();
				if (menu >= ModifyMemberMenu.MEMBER_PREV && menu <= ModifyMemberMenu.MEMBER_MODIFY_ADDRESS)
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
