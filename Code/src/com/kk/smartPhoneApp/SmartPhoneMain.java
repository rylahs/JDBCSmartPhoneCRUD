package com.kk.smartPhoneApp;

import com.kk.smartPhoneApp.control.MemberMgr;
import com.kk.smartPhoneApp.view.LoginMenu;

public class SmartPhoneMain {
	public static void main(String[] args) {
		LoginMenu loginMenu = new LoginMenu();
		MemberMgr memMgr = new MemberMgr();
		while (true) { // Loop Start
			switch (loginMenu.menu()) { // Return Login Menu Number (Integer)
			case LoginMenu.LOGIN_MENU_LOGIN:
				boolean isLogin = memMgr.doLoginMain();
				if (!isLogin) {
					break;
				}
				else {
					System.out.println("로그인 성공입니다.");
				}
				break;
			case LoginMenu.LOGIN_MENU_REGISTER: // Member Register
				System.out.println("회원가입");
				break;
			case LoginMenu.LOGIN_MENU_MODIFY: // Member Modify
				System.out.println("회원수정");
				break;
			case LoginMenu.LOGIN_MENU_DELETE: // Member Delete
				System.out.println("회원탈퇴");
				break;
			case LoginMenu.LOGIN_MENU_VIEW: // Member View
				memMgr.MemberView();
				break;
			case LoginMenu.LOGIN_MENU_EXIT: // Program Exit
				System.out.println("프로그램을 종료합니다.");
				memMgr.programExit();
				System.exit(0);
				break;
			}
		}
	}
}
