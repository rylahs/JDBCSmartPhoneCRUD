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
		mDao.selectMember();
		mDao.printMemberList();
	}

	public void DatabaseExit() {
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

	// 회원 수정
	public void printMoidfyComplete() {
		System.out.println("회원 정보 변경이 완료되었습니다.");
	}

	public void doLoginModify() {
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
					if (modNum == ModifyMemberMenu.MEMBER_MODIFY_ALL_INFO) {
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
					} else if (modNum == ModifyMemberMenu.MEMBER_MODIFY_PASSWORD) {
						System.out.print("변경할 비밀번호를 입력해주세요 : ");
						String afterPW = sc.nextLine();
						mDao.modifyMemberInfoPW(inputID, afterPW);
						printMoidfyComplete();
						return;
					} else if (modNum == ModifyMemberMenu.MEMBER_MODIFY_EMAIL) {
						System.out.print("변경할 이메일을 입력해주세요 : ");
						String afterEmail = sc.nextLine();
						mDao.modifyMemberInfoEmail(inputID, afterEmail);
						printMoidfyComplete();
						return;
					} else if (modNum == ModifyMemberMenu.MEMBER_MODIFY_PHONE) {
						System.out.print("변경할 전화번호을 입력해주세요 : ");
						String afterPhone = sc.nextLine();
						mDao.modifyMemberInfoPhone(inputID, afterPhone);
						printMoidfyComplete();
						return;
					} else if (modNum == ModifyMemberMenu.MEMBER_MODIFY_NAME) {
						System.out.print("변경할 이름을 입력해주세요 : ");
						String afterName = sc.nextLine();
						mDao.modifyMemberInfoName(inputID, afterName);
						printMoidfyComplete();
						return;
					} else if (modNum == ModifyMemberMenu.MEMBER_MODIFY_ADDRESS) {
						System.out.print("변경할 주소를 입력해주세요 : ");
						String afterAddress = sc.nextLine();
						mDao.modifyMemberInfoAddress(inputID, afterAddress);
						printMoidfyComplete();
						break;
					}

					else if (modNum == ModifyMemberMenu.MEMBER_PREV) {
						System.out.println("이전으로 돌아갑니다.");
						return;
					}

				}
			} else {
				loginCount++;
				if (loginCount < 3) {
					printLoginFailMsg(loginCount);
				}
			}
		}
	}

	public void doLoginQuit() {
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
				mDao.deleteMember(inputID);
				printQuitMsg();
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
