package com.kk.smartPhoneApp.control;

import java.util.Scanner;

import com.kk.smartPhoneApp.DAO.MemberDAO;
import com.kk.smartPhoneApp.DTO.Member;

public class MemberMgr {
	MemberDAO mDao = new MemberDAO();
	
	Scanner sc = new Scanner(System.in); // Scanner

	public void memberView() {
		mDao.selectMember();
		mDao.printMemberList();
	}

	public void programExit() {
		mDao.quit();
	}

	public void printLoginFailMsg(int loginCount) {
		System.out.println("�α��ο� " + loginCount + "ȸ �����߽��ϴ�.");
		System.out.println((3 - loginCount) + "ȸ�� �� �����ϸ� �α��� �޴��� ���ư��ϴ�.");
	}

	public void printLoginOverCount(int loginCount) {
		System.out.println("�α��ο� " + loginCount + "ȸ ���� �߽��ϴ�.");
		System.out.println("�α��� Ƚ���� �ʰ��߽��ϴ�.");
		System.out.println("�޴��� ���ư��ϴ�.");
	}
	public void printQuitMsg() {
		System.out.println("ȸ�� Ż�� �Ϸ�Ǿ����ϴ�.");
		System.out.println("���ݱ��� �̿����ּż� �����մϴ�.");
	}
	public boolean doLoginMain() {
		boolean isLogin = false;
		int loginCount = 0;
		while (true) {
			if (loginCount >= 3) {
				printLoginOverCount(loginCount);
				break;
			}
			System.out.print("ID       : ");
			String inputID = sc.nextLine();
			System.out.print("PASSWORD : ");
			String inputPW = sc.nextLine();
			isLogin = mDao.doLoginMain(inputID, inputPW);
			if (isLogin)
				break;

			else {
				loginCount++;
				if (loginCount < 3) {
					printLoginFailMsg(loginCount);
				}
			}

		}
		return isLogin;
	}

	// ȸ�� ����
	public void memberInsert(Member m) {
		mDao.insertUserInfo(m);
	}

	
}
