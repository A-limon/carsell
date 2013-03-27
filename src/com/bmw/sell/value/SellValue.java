package com.bmw.sell.value;

public class SellValue {
	
	private int engineid=0;
	private String selldate=null;
	private int carid=0;
	private int userid=0;
	private String carname=null;
	private String username=null;
	
	
	public String getCarname() {
		return carname;
	}
	public void setCarname(String carname) {
		this.carname = carname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getEngineid() {
		return engineid;
	}
	public void setEngineid(int engineid) {
		this.engineid = engineid;
	}
	public String getSelldate() {
		return selldate;
	}
	public void setSelldate(String selldate) {
		this.selldate = selldate;
	}
	public int getCarid() {
		return carid;
	}
	public void setCarid(int carid) {
		this.carid = carid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
}
