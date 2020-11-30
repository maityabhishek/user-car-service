package com.usercar.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class CarServicing {
	
	@Id
	private String carno;
	private String garagename;
	private Date dateofvisit;
	private String remarks;
	public String getCarno() {
		return carno;
	}
	public void setCarno(String carno) {
		this.carno = carno;
	}
	public String getGaragename() {
		return garagename;
	}
	public void setGaragename(String garagename) {
		this.garagename = garagename;
	}
	public Date getDateofvisit() {
		return dateofvisit;
	}
	public void setDateofvisit(Date dateofvisit) {
		this.dateofvisit = dateofvisit;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public CarServicing(String carno, String garagename, Date dateofvisit, String remarks) {
		super();
		this.carno = carno;
		this.garagename = garagename;
		this.dateofvisit = dateofvisit;
		this.remarks = remarks;
	}
	public CarServicing() {
		super();
	}
	

}
