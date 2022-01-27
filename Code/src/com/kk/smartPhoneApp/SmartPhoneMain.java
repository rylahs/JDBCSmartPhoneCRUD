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
					System.out.println("�α��� �����Դϴ�.");
				}
				break;
			case LoginMenu.LOGIN_MENU_REGISTER: // Member Register
				System.out.println("ȸ������");
				break;
			case LoginMenu.LOGIN_MENU_MODIFY: // Member Modify
				System.out.println("ȸ������");
				break;
			case LoginMenu.LOGIN_MENU_DELETE: // Member Delete
				System.out.println("ȸ��Ż��");
				break;
			case LoginMenu.LOGIN_MENU_VIEW: // Member View
				memMgr.MemberView();
				break;
			case LoginMenu.LOGIN_MENU_EXIT: // Program Exit
				System.out.println("���α׷��� �����մϴ�.");
				memMgr.programExit();
				System.exit(0);
				break;
			}
		}
	}
}
