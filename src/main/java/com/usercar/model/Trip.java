package com.usercar.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Trip {
	@Id
	private int tripid;
	private String carno;
	private double distance;
	private double fuel;
	private double avgspeed;
	private double triptime;
	public int getTripid() {
		return tripid;
	}
	public void setTripid(int tripid) {
		this.tripid = tripid;
	}
	public String getCarno() {
		return carno;
	}
	public void setCarno(String carno) {
		this.carno = carno;
	}
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	public double getFuel() {
		return fuel;
	}
	public void setFuel(double fuel) {
		this.fuel = fuel;
	}
	public double getAvgspeed() {
		return avgspeed;
	}
	public void setAvgspeed(double avgspeed) {
		this.avgspeed = avgspeed;
	}
	public double getTriptime() {
		return triptime;
	}
	public void setTriptime(double triptime) {
		this.triptime = triptime;
	}
	public Trip(int tripid, String carno, double distance, double fuel, double avgspeed, double triptime) {
		super();
		this.tripid = tripid;
		this.carno = carno;
		this.distance = distance;
		this.fuel = fuel;
		this.avgspeed = avgspeed;
		this.triptime = triptime;
	}
	public Trip() {
		super();
		
	}
	

}
