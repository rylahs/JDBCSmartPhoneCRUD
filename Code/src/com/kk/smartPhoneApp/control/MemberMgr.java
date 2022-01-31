package com.kk.smartPhoneApp.control;

import java.util.Scanner;

import com.kk.smartPhoneApp.view.ModifyMemberMenu;
import com.kk.smartPhoneApp.DAO.MemberDAO;
import com.kk.smartPhoneApp.DTO.Member;

public class MemberMgr {
	MemberDAO mDao = new MemberDAO();
	ModifyMemberMenu modifyMemberMenu = new ModifyMemberMenu();
	Scanner sc = new Scanner(System.in); // Scanner

	public void memberView() {
		mDao.selectMember(); // ArrayList input Member Select Query
		mDao.printMemberList(); // Print
	}

	public void DatabaseExit() {
		mDao.quit(); // Quit Database close();
	}

	public void printLoginFailMsg(int loginCount) { // Print Login Fail Message
		System.out.println("로그인에 " + loginCount + "회 실패했습니다.");
		System.out.println((3 - loginCount) + "회를 더 실패하면 로그인 메뉴로 돌아갑니다.");
	}

	public void printLoginOverCount(int loginCount) { // Print Login Fail Over Message
		System.out.println("로그인에 " + loginCount + "회 실패 했습니다.");
		System.out.println("로그인 횟수를 초과했습니다.");
		System.out.println("메뉴로 돌아갑니다.");
	}

	public void printQuitMsg() { // Print Member Quit Complete Message
		System.out.println("회원 탈퇴가 완료되었습니다.");
		System.out.println("지금까지 이용해주셔서 감사합니다.");
	}

	public boolean doLoginMain() { // Login Main
		boolean isLogin = false;
		int loginCount = 0; 
		while (true) {
			if (loginCount >= 3) { // Login Fail >= 3
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

	// 회원 수정 성공 메세지
	public void printMoidfyComplete() {
		System.out.println("회원 정보 변경이 완료되었습니다.");
	}

	public void doLoginModify() { // 로그인이 되어야 회원 정보 수정이 가능
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
			if (isLogin) {
				while (true) {
					int modNum = modifyMemberMenu.modifyMember();
					if (modNum == ModifyMemberMenu.MEMBER_MODIFY_ALL_INFO) { // 모두 수정 => 하나하나 정보 수정 메소드를 모두 실행 
						System.out.print("변경할 비밀번호를 입력해주세요 : ");
						String afterPW = sc.nextLine();
						System.out.print("변경할 이메일을 입력해주세요 : ");
						String afterEmail = sc.nextLine();
						System.out.print("변경할 전화번호을 입력해주세요 : ");
						String afterPhone = sc.nextLine();
						System.out.print("변경할 이름을 입력해주세요 : ");
						String afterName = sc.nextLine();
						System.out.print("변경할 주소를 입력해주세요 : ");
						String afterAddress = sc.nextLine();
						mDao.modifyMemberInfoPW(inputID, afterPW);
						mDao.modifyMemberInfoEmail(inputID, afterEmail);
						mDao.modifyMemberInfoPhone(inputID, afterPhone);
						mDao.modifyMemberInfoName(inputID, afterName);
						mDao.modifyMemberInfoAddress(inputID, afterAddress);
						printMoidfyComplete();
						return;
					} else if (modNum == ModifyMemberMenu.MEMBER_MODIFY_PASSWORD) { // 비밀번호 수정
						System.out.print("변경할 비밀번호를 입력해주세요 : ");
						String afterPW = sc.nextLine();
						mDao.modifyMemberInfoPW(inputID, afterPW);
						printMoidfyComplete();
						return;
					} else if (modNum == ModifyMemberMenu.MEMBER_MODIFY_EMAIL) { // 이메일 수정
						System.out.print("변경할 이메일을 입력해주세요 : ");
						String afterEmail = sc.nextLine();
						mDao.modifyMemberInfoEmail(inputID, afterEmail);
						printMoidfyComplete();
						return;
					} else if (modNum == ModifyMemberMenu.MEMBER_MODIFY_PHONE) { // 전화번호 수정
						System.out.print("변경할 전화번호을 입력해주세요 : ");
						String afterPhone = sc.nextLine();
						mDao.modifyMemberInfoPhone(inputID, afterPhone);
						printMoidfyComplete();
						return;
					} else if (modNum == ModifyMemberMenu.MEMBER_MODIFY_NAME) { // 이름 수정
						System.out.print("변경할 이름을 입력해주세요 : ");
						String afterName = sc.nextLine();
						mDao.modifyMemberInfoName(inputID, afterName);
						printMoidfyComplete();
						return;
					} else if (modNum == ModifyMemberMenu.MEMBER_MODIFY_ADDRESS) { // 주소 수정
						System.out.print("변경할 주소를 입력해주세요 : ");
						String afterAddress = sc.nextLine();
						mDao.modifyMemberInfoAddress(inputID, afterAddress);
						printMoidfyComplete();
						break;
					}

					else if (modNum == ModifyMemberMenu.MEMBER_PREV) { // 이전으로
						System.out.println("이전으로 돌아갑니다.");
						return;
					}

				}
			} else {
				loginCount++; // 로그인 실패시 실패 카운트 1 증가
				if (loginCount < 3) {
					printLoginFailMsg(loginCount); // 3회 이하 로그인 실패시 메시지 출력
				}
			}
		}
	}

	public void doLoginQuit() { // 회원 탈퇴를 위한 로그인
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
			if (isLogin) {
				mDao.deleteMember(inputID); // 회원 탈퇴 Query 수행
				printQuitMsg(); // 회원 탈퇴 Message 출력
				return;
			} else {
				loginCount++;
				if (loginCount < 3) {
					printLoginFailMsg(loginCount);
				}
			}
		}
	}

}
