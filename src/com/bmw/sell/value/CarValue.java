package com.bmw.sell.value;

public class CarValue {
	private int carid=0;
	private String carname=null; 
	private String carpic=null;
	private float price=0;
	private String color=null; 
	private String engine=null;
	private int stock=0;
	
	
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getCarid() {
		return carid;
	}
	public void setCarid(int carid) {
		this.carid = carid;
	}
	public String getCarname() {
		return carname;
	}
	public void setCarname(String carname) {
		this.carname = carname;
	}
	public String getCarpic() {
		return carpic;
	}
	public void setCarpic(String carpic) {
		this.carpic = carpic;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getEngine() {
		return engine;
	}
	public void setEngine(String engine) {
		this.engine = engine;
	} 

}
