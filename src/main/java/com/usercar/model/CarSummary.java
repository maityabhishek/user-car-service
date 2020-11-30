package com.usercar.model;

import java.util.List;

public class CarSummary {
	
	private Car car;
	private List<Trip> triplist;
	private List<CarPuc> puclist;
	private List<CarServicing> carserv;
	
	public CarSummary(Car car, List<Trip> triplist, List<CarPuc> puclist, List<CarServicing> carserv) {
		super();
		this.car = car;
		this.triplist = triplist;
		this.puclist = puclist;
		this.carserv = carserv;
	}
	public CarSummary() {
		super();
	}
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	public List<Trip> getTriplist() {
		return triplist;
	}
	public void setTriplist(List<Trip> triplist) {
		this.triplist = triplist;
	}
	public List<CarPuc> getPuclist() {
		return puclist;
	}
	public void setPuclist(List<CarPuc> puclist) {
		this.puclist = puclist;
	}
	public List<CarServicing> getCarserv() {
		return carserv;
	}
	public void setCarserv(List<CarServicing> carserv) {
		this.carserv = carserv;
	}
	
	

}
