package com.kk.smartPhoneApp.DTO;

public class SmartPhone {
	private int Product_Num;
	private String Name; // ������A52
	private String Model; // �𵨸� (SM-756N)
	private int Price;
	private String Company; // ������ (APPLE)
	private double Screen; // ȭ�� ũ�� (19.01cm)
	private String Resolution; // �ػ� (1920x1080)
	private int Scan_Rate; // �ֻ��� (120Hz)
	private int Ram; // �� �뷮 (6GB)
	private int Disk; // Disk �뷮(128GB)
	private int Camera; // �ĸ� 1�� ī�޶� ȭ��
	private int Battery; // ���͸� �뷮 (mAh)
	private int Weight; // ���� (g)

	public SmartPhone() {
		super();
	}

	public SmartPhone(String name, String model, int price, String company, double screen, String resolution,
			int scan_Rate, int ram, int disk, int camera, int battery, int weight) {
		super();
		Name = name;
		Model = model;
		Price = price;
		Company = company;
		Screen = screen;
		Resolution = resolution;
		Scan_Rate = scan_Rate;
		Ram = ram;
		Disk = disk;
		Camera = camera;
		Battery = battery;
		Weight = weight;
	}

	public SmartPhone(int product_Num, String name, String model, int price, String company, double screen,
			String resolution, int scan_Rate, int ram, int disk, int camera, int battery, int weight) {
		super();
		Product_Num = product_Num;
		Name = name;
		Model = model;
		Price = price;
		Company = company;
		Screen = screen;
		Resolution = resolution;
		Scan_Rate = scan_Rate;
		Ram = ram;
		Disk = disk;
		Camera = camera;
		Battery = battery;
		Weight = weight;
	}

	public int getProduct_Num() {
		return Product_Num;
	}

	public void setProduct_Num(int product_Num) {
		Product_Num = product_Num;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getModel() {
		return Model;
	}

	public void setModel(String model) {
		Model = model;
	}

	public int getPrice() {
		return Price;
	}

	public void setPrice(int price) {
		Price = price;
	}

	public String getCompany() {
		return Company;
	}

	public void setCompany(String company) {
		Company = company;
	}

	public double getScreen() {
		return Screen;
	}

	public void setScreen(double screen) {
		Screen = screen;
	}

	public String getResolution() {
		return Resolution;
	}

	public void setResolution(String resolution) {
		Resolution = resolution;
	}

	public int getScan_Rate() {
		return Scan_Rate;
	}

	public void setScan_Rate(int scan_Rate) {
		Scan_Rate = scan_Rate;
	}

	public int getRam() {
		return Ram;
	}

	public void setRam(int ram) {
		Ram = ram;
	}

	public int getDisk() {
		return Disk;
	}

	public void setDisk(int disk) {
		Disk = disk;
	}

	public int getCamera() {
		return Camera;
	}

	public void setCamera(int camera) {
		Camera = camera;
	}

	public int getBattery() {
		return Battery;
	}

	public void setBattery(int battery) {
		Battery = battery;
	}

	public int getWeight() {
		return Weight;
	}

	public void setWeight(int weight) {
		Weight = weight;
	}

	
	
}