package com.sdp.user.VO;

public class Temperature {

	private int id;
	private String userName;
	private String temperatureValue;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTemperatureValue() {
		return temperatureValue;
	}

	public void setTemperatureValue(String temperatureValue) {
		this.temperatureValue = temperatureValue;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "Temperature [id=" + id + ", userName=" + userName + ", temperatureValue=" + temperatureValue + "]";
	}
	
	

}
