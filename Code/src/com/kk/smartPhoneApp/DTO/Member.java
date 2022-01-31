package com.kk.smartPhoneApp.DTO;

public class Member {
	private String id; // ID
	private String password; // PassWord
	private String emailAddress; // E-mail
	private String phoneNumber; // Phone
	private String memberName; // Name
	private String memberAddress; // Address

	// Default Constructor
	public Member() {
		super();
	}

	// Constructor Member
	public Member(String id, String password, String emailAddress, String phoneNumber, String memberName,
			String memberAddress) {
		super();
		this.id = id;
		this.password = password;
		this.emailAddress = emailAddress;
		this.phoneNumber = phoneNumber;
		this.memberName = memberName;
		this.memberAddress = memberAddress;
	}

	// Getter , Setter
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberAddress() {
		return memberAddress;
	}

	public void setMemberAddress(String memberAddress) {
		this.memberAddress = memberAddress;
	}
	
	// Print Member
	public void printMember() {
		System.out.print("ID : " + id);
		System.out.print("  PASSWORD : " + password);
		System.out.print("  E-MAIL : " + emailAddress);
		System.out.print("  PHONE : " + phoneNumber);
		System.out.print("  NAME : " + memberName);
		System.out.print("  ADDRESS : " + memberAddress);
		System.out.println();
	}
}
