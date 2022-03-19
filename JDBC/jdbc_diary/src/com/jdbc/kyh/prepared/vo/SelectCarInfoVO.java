package com.jdbc.kyh.prepared.vo;

public class SelectCarInfoVO {

	private int price, cc;
	private String car_year, option;

	public SelectCarInfoVO() {
	}

	public SelectCarInfoVO(int price, int cc, String car_year, String option) {
		this.price = price;
		this.cc = cc;
		this.car_year = car_year;
		this.option = option;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getCc() {
		return cc;
	}

	public void setCc(int cc) {
		this.cc = cc;
	}

	public String getCar_year() {
		return car_year;
	}

	public void setCar_year(String car_year) {
		this.car_year = car_year;
	}

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

}