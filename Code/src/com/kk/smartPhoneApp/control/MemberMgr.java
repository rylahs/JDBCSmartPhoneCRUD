package com.kk.smartPhoneApp.control;

import java.util.Scanner;

import com.kk.smartPhoneApp.DAO.MemberDAO;

public class MemberMgr {
	MemberDAO mDao = new MemberDAO();
	Scanner sc = new Scanner(System.in); // Scanner
	
	public void MemberView() {
		mDao.SelectMember();
	}
	
	public void MemberLogin() {
		mDao.doLogin(null);
	}
	
	public void programExit() {
		mDao.Quit();
	}
	
	public boolean doLoginMain() {
		boolean isLogin = false;
		int loginCount = 0;
		while (true) {
			if (loginCount >= 3) {
				System.out.println("로그인에 " + loginCount +"회 실패 했습니다.");
				System.out.println("로그인 횟수를 초과했습니다.");
				System.out.println("메뉴로 돌아갑니다.");
				break;
			}
			String inputID = "";
			String inputPW = "";
			System.out.print("ID       : ");
			inputID = sc.nextLine();
			System.out.print("PASSWORD : ");
			inputPW = sc.nextLine();
			isLogin = mDao.doLoginMain(inputID, inputPW);
			if (isLogin)
				break;

			if (!isLogin) {
				loginCount++;
				if (loginCount < 3) {
					System.out.println("로그인에 " + loginCount + "회 실패했습니다.");
					System.out.println((3 - loginCount) + "회를 더 실패하면 로그인 메뉴로 돌아갑니다.");
				}
			}

		}
		return isLogin;
	}
	
	
}
