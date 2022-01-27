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
				System.out.println("�α��ο� " + loginCount +"ȸ ���� �߽��ϴ�.");
				System.out.println("�α��� Ƚ���� �ʰ��߽��ϴ�.");
				System.out.println("�޴��� ���ư��ϴ�.");
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
					System.out.println("�α��ο� " + loginCount + "ȸ �����߽��ϴ�.");
					System.out.println((3 - loginCount) + "ȸ�� �� �����ϸ� �α��� �޴��� ���ư��ϴ�.");
				}
			}

		}
		return isLogin;
	}
	
	
}
