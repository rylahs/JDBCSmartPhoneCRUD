package com.kk.smartPhoneApp.view;

import java.util.Scanner;

import com.kk.smartPhoneApp.DTO.Member;

public class InsertMemberMenu {
	Scanner sc = new Scanner(System.in);

	public Member insertData() {
		System.out.println("-----------------");
		System.out.println("ȸ�� ������ �����մϴ�.");
		System.out.print("ID : ");
		String iMemberId = sc.nextLine();
		System.out.print("Password : ");
		String iMemberPassword = sc.nextLine();
		System.out.print("E-mail : ");
		String iMemberEmail = sc.nextLine();
		System.out.print("Phone : ");
		String iMemberPhone = sc.nextLine();
		System.out.print("�̸� : ");
		String iMemberName = sc.nextLine();
		System.out.print("�ּ� : ");
		String iMemberAddress = sc.nextLine();
		return new Member(iMemberId, iMemberPassword, iMemberEmail, iMemberPhone, iMemberName, iMemberAddress);
	}

	
}
