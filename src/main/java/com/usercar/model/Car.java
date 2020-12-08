package com.usercar.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Car {
	@Id
	private String carno;
	private String vinno;
	private String ownerno;
	private String maker;
	private String model;
	private String color;
	private Date rcexp;
	private int totalkms;
	private double fuel;
	private int enginestatus;
	private int coolentstatus;
	
	
	public Car(String carno, String vinno, String ownerno, String maker, String model, String color, Date rcexp,
			int totalkms, double fuel, int enginestatus, int coolentstatus) {
		super();
		this.carno = carno;
		this.vinno = vinno;
		this.ownerno = ownerno;
		this.maker = maker;
		this.model = model;
		this.color = color;
		this.rcexp = rcexp;
		this.totalkms = totalkms;
		this.fuel = fuel;
		this.enginestatus = enginestatus;
		this.coolentstatus = coolentstatus;
	}
	public String getVinno() {
		return vinno;
	}
	public void setVinno(String vinno) {
		this.vinno = vinno;
	}
	public int getTotalkms() {
		return totalkms;
	}
	public void setTotalkms(int totalkms) {
		this.totalkms = totalkms;
	}
	public double getFuel() {
		return fuel;
	}
	public void setFuel(double fuel) {
		this.fuel = fuel;
	}
	public int getEnginestatus() {
		return enginestatus;
	}
	public void setEnginestatus(int enginestatus) {
		this.enginestatus = enginestatus;
	}
	public int getCoolentstatus() {
		return coolentstatus;
	}
	public void setCoolentstatus(int coolentstatus) {
		this.coolentstatus = coolentstatus;
	}
	public String getCarno() {
		return carno;
	}
	public void setCarno(String carno) {
		this.carno = carno;
	}
	public String getOwnerno() {
		return ownerno;
	}
	public void setOwnerno(String ownerno) {
		this.ownerno = ownerno;
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
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Date getRcexp() {
		return rcexp;
	}
	public void setRcexp(Date rcexp) {
		this.rcexp = rcexp;
	}

	public Car() {
		super();
	}

}
