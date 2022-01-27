package com.kk.smartPhoneApp.DTO;

public class SmartPhone {
	private int Product_Num;
	private String Name; // 갤럭시A52
	private String Model; // 모델명 (SM-756N)
	private int Price;
	private String Company; // 제조사 (APPLE)
	private double Screen; // 화면 크기 (19.01cm)
	private String Resolution; // 해상도 (1920x1080)
	private int Scan_Rate; // 주사율 (120Hz)
	private int Ram; // 램 용량 (6GB)
	private int Disk; // Disk 용량(128GB)
	private int Camera; // 후면 1번 카메라 화소
	private int Battery; // 배터리 용량 (mAh)
	private int Weight; // 무게 (g)

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