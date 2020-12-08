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
	private String startpoint;
	private String endpoint;
	
	public String getStartpoint() {
		return startpoint;
	}
	public void setStartpoint(String startpoint) {
		this.startpoint = startpoint;
	}
	public String getEndpoint() {
		return endpoint;
	}
	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}
	public Trip(int tripid, String carno, double distance, double fuel, double avgspeed, double triptime,
			String startpoint, String endpoint) {
		super();
		this.tripid = tripid;
		this.carno = carno;
		this.distance = distance;
		this.fuel = fuel;
		this.avgspeed = avgspeed;
		this.triptime = triptime;
		this.startpoint = startpoint;
		this.endpoint = endpoint;
	}
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
	
	public Trip() {
		super();
		
	}
	

}
