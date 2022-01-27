package com.kk.smartPhoneApp;

import com.kk.smartPhoneApp.control.MemberMgr;
import com.kk.smartPhoneApp.control.SmartPhoneMgr;
import com.kk.smartPhoneApp.view.InsertMemberMenu;
import com.kk.smartPhoneApp.view.LoginMenu;
import com.kk.smartPhoneApp.view.SmartPhoneMainMenu;

public class SmartPhoneMain {
	public static void main(String[] args) {
		LoginMenu loginMenu = new LoginMenu();
		InsertMemberMenu insertMemberMenu = new InsertMemberMenu();
		SmartPhoneMainMenu sMainMenu = new SmartPhoneMainMenu();
		SmartPhoneMgr smartMgr = new SmartPhoneMgr();
		MemberMgr memMgr = new MemberMgr();
		while (true) { // Loop Start
			switch (loginMenu.menu()) { // Return Login Menu Number (Integer)
			case LoginMenu.LOGIN_MENU_LOGIN:
				boolean isLogin = memMgr.doLoginMain();
				if (!isLogin) {
				} else {
					while(true) { // SmartPhoneApp MainView Start
						int sMainMenuNum = sMainMenu.menu();
						if (sMainMenuNum == SmartPhoneMainMenu.MAIN_MENU_VIEW_ALL) { // select * from ~
							System.out.println("Select * from SmartPhone");
							smartMgr.smartPhoneView();
						}
						else if (sMainMenuNum == SmartPhoneMainMenu.MAIN_MENU_VIEW_SEARCH) { //select * from ~ where = ?
							System.out.println("Select * from SmartPhone where = ?");
						}
						else if (sMainMenuNum == SmartPhoneMainMenu.MAIN_MENU_INSERT) { // Insert into SmartPhone(....) values(....)
							System.out.println("insert into SmartPhone() values()");
						}
						else if (sMainMenuNum == SmartPhoneMainMenu.MAIN_MENU_MODIFY) { // Update ~~ set ~~ 
							System.out.println("update");
						}
						else if (sMainMenuNum == SmartPhoneMainMenu.MAIN_MENU_DELETE) { // Delete ~
							System.out.println("delete");
						}
						else if (sMainMenuNum == SmartPhoneMainMenu.MAIN_MENU_LOGOUT) { // Program Exit or Logout? 
							// System.out.println("프로그램을 종료합니다.");
							System.out.println("로그아웃 되었습니다.");
							break;
						}
					}
				}
				break;
			case LoginMenu.LOGIN_MENU_REGISTER: // Member Register
				memMgr.memberInsert(insertMemberMenu.insertData());
				break;
			case LoginMenu.LOGIN_MENU_MODIFY: // Member Modify
				memMgr.doLoginModify();
				break;
			case LoginMenu.LOGIN_MENU_DELETE: // Member Delete
				memMgr.doLoginQuit();
				break;
			case LoginMenu.LOGIN_MENU_VIEW: // Member View
				memMgr.memberView();
				break;
			case LoginMenu.LOGIN_MENU_EXIT: // Program Exit
				System.out.println("프로그램을 종료합니다.");
				memMgr.DatabaseExit();
				System.exit(0);
				break;
			}
		}
	}
}
