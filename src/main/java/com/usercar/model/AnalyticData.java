package com.usercar.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class AnalyticData {
	@Id
	private String carno;
	private String eventType;
	private String desc;
	private String vin;
	private String user;

	
	public AnalyticData() {
		super();
	}

	public AnalyticData(String carno, String eventType, String desc, String vin, String user) {
		super();
		this.carno = carno;
		this.eventType = eventType;
		this.desc = desc;
		this.vin = vin;
		this.user = user;
	}
	public String getCarno() {
		return carno;
	}
	public void setCarno(String carno) {
		this.carno = carno;
	}
	public String getEventType() {
		return eventType;
	}
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		this.vin = vin;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	
}
