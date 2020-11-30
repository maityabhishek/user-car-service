package com.usercar.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class CarPuc {
	@Id
	private String carno;
	private Date issuedt;
	private Date expdt;
	private String place;
	private String status;
	public CarPuc(String carno, Date issuedt, Date expdt, String place, String status) {
		super();
		this.carno = carno;
		this.issuedt = issuedt;
		this.expdt = expdt;
		this.place = place;
		this.status = status;
	}
	public CarPuc() {
		super();
	}
	public String getCarno() {
		return carno;
	}
	public void setCarno(String carno) {
		this.carno = carno;
	}
	public Date getIssuedt() {
		return issuedt;
	}
	public void setIssuedt(Date issuedt) {
		this.issuedt = issuedt;
	}
	public Date getExpdt() {
		return expdt;
	}
	public void setExpdt(Date expdt) {
		this.expdt = expdt;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	

}
