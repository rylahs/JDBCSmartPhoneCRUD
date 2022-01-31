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
		System.out.println("�α��ο� " + loginCount + "ȸ �����߽��ϴ�.");
		System.out.println((3 - loginCount) + "ȸ�� �� �����ϸ� �α��� �޴��� ���ư��ϴ�.");
	}

	public void printLoginOverCount(int loginCount) { // Print Login Fail Over Message
		System.out.println("�α��ο� " + loginCount + "ȸ ���� �߽��ϴ�.");
		System.out.println("�α��� Ƚ���� �ʰ��߽��ϴ�.");
		System.out.println("�޴��� ���ư��ϴ�.");
	}

	public void printQuitMsg() { // Print Member Quit Complete Message
		System.out.println("ȸ�� Ż�� �Ϸ�Ǿ����ϴ�.");
		System.out.println("���ݱ��� �̿����ּż� �����մϴ�.");
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

	// ȸ�� ����
	public void memberInsert(Member m) {
		mDao.insertUserInfo(m);
	}

	// ȸ�� ���� ���� �޼���
	public void printMoidfyComplete() {
		System.out.println("ȸ�� ���� ������ �Ϸ�Ǿ����ϴ�.");
	}

	public void doLoginModify() { // �α����� �Ǿ�� ȸ�� ���� ������ ����
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
					if (modNum == ModifyMemberMenu.MEMBER_MODIFY_ALL_INFO) { // ��� ���� => �ϳ��ϳ� ���� ���� �޼ҵ带 ��� ���� 
						System.out.print("������ ��й�ȣ�� �Է����ּ��� : ");
						String afterPW = sc.nextLine();
						System.out.print("������ �̸����� �Է����ּ��� : ");
						String afterEmail = sc.nextLine();
						System.out.print("������ ��ȭ��ȣ�� �Է����ּ��� : ");
						String afterPhone = sc.nextLine();
						System.out.print("������ �̸��� �Է����ּ��� : ");
						String afterName = sc.nextLine();
						System.out.print("������ �ּҸ� �Է����ּ��� : ");
						String afterAddress = sc.nextLine();
						mDao.modifyMemberInfoPW(inputID, afterPW);
						mDao.modifyMemberInfoEmail(inputID, afterEmail);
						mDao.modifyMemberInfoPhone(inputID, afterPhone);
						mDao.modifyMemberInfoName(inputID, afterName);
						mDao.modifyMemberInfoAddress(inputID, afterAddress);
						printMoidfyComplete();
						return;
					} else if (modNum == ModifyMemberMenu.MEMBER_MODIFY_PASSWORD) { // ��й�ȣ ����
						System.out.print("������ ��й�ȣ�� �Է����ּ��� : ");
						String afterPW = sc.nextLine();
						mDao.modifyMemberInfoPW(inputID, afterPW);
						printMoidfyComplete();
						return;
					} else if (modNum == ModifyMemberMenu.MEMBER_MODIFY_EMAIL) { // �̸��� ����
						System.out.print("������ �̸����� �Է����ּ��� : ");
						String afterEmail = sc.nextLine();
						mDao.modifyMemberInfoEmail(inputID, afterEmail);
						printMoidfyComplete();
						return;
					} else if (modNum == ModifyMemberMenu.MEMBER_MODIFY_PHONE) { // ��ȭ��ȣ ����
						System.out.print("������ ��ȭ��ȣ�� �Է����ּ��� : ");
						String afterPhone = sc.nextLine();
						mDao.modifyMemberInfoPhone(inputID, afterPhone);
						printMoidfyComplete();
						return;
					} else if (modNum == ModifyMemberMenu.MEMBER_MODIFY_NAME) { // �̸� ����
						System.out.print("������ �̸��� �Է����ּ��� : ");
						String afterName = sc.nextLine();
						mDao.modifyMemberInfoName(inputID, afterName);
						printMoidfyComplete();
						return;
					} else if (modNum == ModifyMemberMenu.MEMBER_MODIFY_ADDRESS) { // �ּ� ����
						System.out.print("������ �ּҸ� �Է����ּ��� : ");
						String afterAddress = sc.nextLine();
						mDao.modifyMemberInfoAddress(inputID, afterAddress);
						printMoidfyComplete();
						break;
					}

					else if (modNum == ModifyMemberMenu.MEMBER_PREV) { // ��������
						System.out.println("�������� ���ư��ϴ�.");
						return;
					}

				}
			} else {
				loginCount++; // �α��� ���н� ���� ī��Ʈ 1 ����
				if (loginCount < 3) {
					printLoginFailMsg(loginCount); // 3ȸ ���� �α��� ���н� �޽��� ���
				}
			}
		}
	}

	public void doLoginQuit() { // ȸ�� Ż�� ���� �α���
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
				mDao.deleteMember(inputID); // ȸ�� Ż�� Query ����
				printQuitMsg(); // ȸ�� Ż�� Message ���
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
