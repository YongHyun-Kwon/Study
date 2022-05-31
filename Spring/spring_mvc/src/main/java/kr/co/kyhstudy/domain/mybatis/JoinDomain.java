package kr.co.kyhstudy.domain.mybatis;

public class JoinDomain {

	private String maker, model, car_option, car_img;
	private int car_year, price;

	public JoinDomain() {
		// TODO Auto-generated constructor stub
	}

	public String getMaker() {
		return maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getCar_option() {
		return car_option;
	}

	public void setCar_option(String car_option) {
		this.car_option = car_option;
	}

	public String getCar_img() {
		return car_img;
	}

	public void setCar_img(String car_img) {
		this.car_img = car_img;
	}

	public int getCar_year() {
		return car_year;
	}

	public void setCar_year(int car_year) {
		this.car_year = car_year;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "JoinDomain [maker=" + maker + ", model=" + model + ", car_option=" + car_option + ", car_img=" + car_img
				+ ", car_year=" + car_year + ", price=" + price + "]";
	}

}