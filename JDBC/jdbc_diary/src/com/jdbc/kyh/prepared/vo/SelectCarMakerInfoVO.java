package com.jdbc.kyh.prepared.vo;

public class SelectCarMakerInfoVO {

	private String carCountry, carMaker, carModel, carYear, carOption;
	private int price;
	
	public SelectCarMakerInfoVO() {
		// TODO Auto-generated constructor stub
	}
	
	

	public SelectCarMakerInfoVO(String carCountry, String carMaker, String carModel, String carYear,
			String carOption, int price) {
		this.carCountry = carCountry;
		this.carMaker = carMaker;
		this.carModel = carModel;
		this.carYear = carYear;
		this.carOption = carOption;
		this.price = price;
	}



	public String getCarCountry() {
		return carCountry;
	}

	public void setCarCountry(String carCountry) {
		this.carCountry = carCountry;
	}

	public String getCarMaker() {
		return carMaker;
	}

	public void setCarMaker(String carMaker) {
		this.carMaker = carMaker;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public String getCarYear() {
		return carYear;
	}

	public void setCarYear(String carYear) {
		this.carYear = carYear;
	}

	public String getCarOption() {
		return carOption;
	}

	public void setCarOption(String carOption) {
		this.carOption = carOption;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}