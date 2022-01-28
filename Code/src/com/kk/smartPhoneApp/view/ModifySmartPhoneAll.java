package com.kk.smartPhoneApp.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.kk.smartPhoneApp.DTO.SmartPhone;

public class ModifySmartPhoneAll {
	Scanner sc = new Scanner(System.in);

	public SmartPhone modifyData() {
		System.out.println("-----------------");
		System.out.println("����Ʈ�� ���� ������ �����մϴ�.");
		System.out.print("��ǰ�� : ");
		String name = sc.nextLine();
		System.out.print("�� : ");
		String model = sc.nextLine();
		System.out.print("���� : ");
		int price = integerInput();
		System.out.print("������ : ");
		String company = sc.nextLine();
		System.out.print("ȭ�� ũ��[cm] : ");
		double screen = doubleInput();
		System.out.print("�ػ�[ex) 1920x1080] : ");
		String resolution = sc.nextLine();
		System.out.print("�ֻ���[Hz] : ");
		int scanRate = integerInput();
		System.out.print("�޸�[GB] : ");
		int ram = integerInput();
		System.out.print("��ũ �뷮[GB] : ");
		int disk = integerInput();
		System.out.print("�ĸ� 1�� ī�޶� �ػ�[�� ȭ��] : ");
		int camera = integerInput();
		System.out.print("���͸�[mAh] : ");
		int battery = integerInput();
		System.out.print("����[g] : ");
		int weight = integerInput();
		
		return new SmartPhone(name, model, price, company, screen, resolution,
				scanRate, ram, disk, camera, battery, weight);
	}
	public int integerInput() {
		int inputData = -1;
		while (true) {
			try {
				inputData = sc.nextInt();
				if (inputData >= 0)
					break;
				else
					System.out.println("�߸��� �Է��Դϴ�. �ٽ� �Է����ּ���.");
			} catch (InputMismatchException e) {
				sc = new Scanner(System.in);
				System.out.println("�߸��� �Է��Դϴ�. �ٽ� �Է����ּ���.");
			}
		}
		sc.nextLine();
		return inputData;
	}
	public double doubleInput() {
		double inputData = -1.0;
		while (true) {
			try {
				inputData = sc.nextDouble();
				if (inputData >= 0)
					break;
				else
					System.out.println("�߸��� �Է��Դϴ�. �ٽ� �Է����ּ���.");
			} catch (InputMismatchException e) {
				sc = new Scanner(System.in);
				System.out.println("�߸��� �Է��Դϴ�. �ٽ� �Է����ּ���.");
			}
		}
		sc.nextLine();
		return inputData;
	}
}
