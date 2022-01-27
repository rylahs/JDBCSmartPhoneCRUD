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
		System.out.println("로그인에 " + loginCount + "회 실패했습니다.");
		System.out.println((3 - loginCount) + "회를 더 실패하면 로그인 메뉴로 돌아갑니다.");
	}

	public void printLoginOverCount(int loginCount) {
		System.out.println("로그인에 " + loginCount + "회 실패 했습니다.");
		System.out.println("로그인 횟수를 초과했습니다.");
		System.out.println("메뉴로 돌아갑니다.");
	}
	public void printQuitMsg() {
		System.out.println("회원 탈퇴가 완료되었습니다.");
		System.out.println("지금까지 이용해주셔서 감사합니다.");
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

	// 회원 가입
	public void memberInsert(Member m) {
		mDao.insertUserInfo(m);
	}

	
}
