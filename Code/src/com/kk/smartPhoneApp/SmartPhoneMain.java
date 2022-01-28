package com.kk.smartPhoneApp;

import com.kk.smartPhoneApp.control.MemberMgr;
import com.kk.smartPhoneApp.control.SmartPhoneMgr;
import com.kk.smartPhoneApp.view.InsertMemberMenu;
import com.kk.smartPhoneApp.view.InsertSmartPhoneMenu;
import com.kk.smartPhoneApp.view.LoginMenu;
import com.kk.smartPhoneApp.view.ModifySmartPhoneMenu;
import com.kk.smartPhoneApp.view.SearchSmartPhoneMenu;
import com.kk.smartPhoneApp.view.SmartPhoneMainMenu;

public class SmartPhoneMain {
	public static void main(String[] args) {
		LoginMenu loginMenu = new LoginMenu();
		InsertMemberMenu insertMemberMenu = new InsertMemberMenu();
		InsertSmartPhoneMenu insertSmartPhoneMenu = new InsertSmartPhoneMenu();
		SmartPhoneMainMenu sMainMenu = new SmartPhoneMainMenu();
		SearchSmartPhoneMenu sSearchMenu = new SearchSmartPhoneMenu();
		ModifySmartPhoneMenu sModifyMenu = new ModifySmartPhoneMenu();
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
							smartMgr.viewSmartPhone();
							smartMgr.printSearchCompleteMsg();
						}
						else if (sMainMenuNum == SmartPhoneMainMenu.MAIN_MENU_VIEW_SEARCH) { //select * from ~ where = ?
							while(true) {
								int searchSmartPhoneMenuNum = sSearchMenu.selectMenu();
								if (searchSmartPhoneMenuNum == SearchSmartPhoneMenu.SEARCH_MENU_ALL) { // Select * from smartphone
									smartMgr.viewSmartPhone();
									smartMgr.printSearchCompleteMsg();
									break; // SmartPhone Search While Loop Break;
								}
								else if (searchSmartPhoneMenuNum == SearchSmartPhoneMenu.SEARCH_MENU_PREV) { // Go Previous
									smartMgr.printGoPrev();
									break;
								}
								else { // Search Other Condition
									smartMgr.searchSmartPhone(searchSmartPhoneMenuNum);
									break;
								}
							}
						}
						else if (sMainMenuNum == SmartPhoneMainMenu.MAIN_MENU_INSERT) { // Insert into SmartPhone(....) values(....)
							smartMgr.insertSmartPhone(insertSmartPhoneMenu.insertData());
						}
						else if (sMainMenuNum == SmartPhoneMainMenu.MAIN_MENU_MODIFY) { // Update ~~ set ~~ 
							while(true) {
								int modifySmartPhoneMenuValue = sModifyMenu.modifyMenu();
								if (modifySmartPhoneMenuValue == ModifySmartPhoneMenu.MODIFY_VIEW_ALL) {
									smartMgr.viewSmartPhone();
								}
								else if (modifySmartPhoneMenuValue == ModifySmartPhoneMenu.MODIFY_PREV) {
									smartMgr.printGoPrev();
									break;
								}
								else { // else if (modifySmartPhoneMenuValue == ModifySmartPhoneMenu.MODIFY_DO) {}
									while(true) {
										smartMgr.viewSmartPhone();
										int modifySelectMode = sModifyMenu.modifyModSelect();
										if (modifySelectMode == ModifySmartPhoneMenu.MODIFY_MOD_PREV) {
											smartMgr.printGoPrev();
											break;
										}
										else { // 나머지는 하나만 update 하면 됨
											smartMgr.modifySmartPhone(modifySelectMode);
											break;
										}
									}
								}
							}
						}
						else if (sMainMenuNum == SmartPhoneMainMenu.MAIN_MENU_DELETE) { // Delete ~
							smartMgr.viewSmartPhone();
							smartMgr.deleteSmartPhone();
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
