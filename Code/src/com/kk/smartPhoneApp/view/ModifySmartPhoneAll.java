package com.kk.smartPhoneApp.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.kk.smartPhoneApp.DTO.SmartPhone;

public class ModifySmartPhoneAll {
	Scanner sc = new Scanner(System.in);

	public SmartPhone modifyData() {
		System.out.println("-----------------");
		System.out.println("스마트폰 정보 수정을 시작합니다.");
		System.out.print("상품명 : ");
		String name = sc.nextLine();
		System.out.print("모델 : ");
		String model = sc.nextLine();
		System.out.print("가격 : ");
		int price = integerInput();
		System.out.print("제조사 : ");
		String company = sc.nextLine();
		System.out.print("화면 크기[cm] : ");
		double screen = doubleInput();
		System.out.print("해상도[ex) 1920x1080] : ");
		String resolution = sc.nextLine();
		System.out.print("주사율[Hz] : ");
		int scanRate = integerInput();
		System.out.print("메모리[GB] : ");
		int ram = integerInput();
		System.out.print("디스크 용량[GB] : ");
		int disk = integerInput();
		System.out.print("후면 1번 카메라 해상도[만 화소] : ");
		int camera = integerInput();
		System.out.print("배터리[mAh] : ");
		int battery = integerInput();
		System.out.print("무게[g] : ");
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
					System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
			} catch (InputMismatchException e) {
				sc = new Scanner(System.in);
				System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
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
					System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
			} catch (InputMismatchException e) {
				sc = new Scanner(System.in);
				System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
			}
		}
		sc.nextLine();
		return inputData;
	}
}
