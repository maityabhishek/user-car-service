package com.usercar.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usercar.dao.CarDAO;
import com.usercar.dao.CarPucDAO;
import com.usercar.dao.CarServicingDAO;
import com.usercar.dao.TripDAO;
import com.usercar.model.AnalyticData;
import com.usercar.model.Car;
import com.usercar.model.CarPuc;
import com.usercar.model.CarServicing;
import com.usercar.model.CarSummary;
import com.usercar.model.Trip;
import com.usercar.model.UserCarRes;
import com.usercar.utlity.PasswordHash;

@Service
public class CarService {
	
	@Autowired
	private CarDAO cardao;
	@Autowired
	private CarServicingDAO carservdao;
	@Autowired
	private CarPucDAO carpucdao;
	@Autowired
	private TripDAO cartrip;
	
	@Autowired
	private PasswordHash passwordhash;
	public boolean verifyuser(String carno,String token)
	{
		try {
			
		
		Car car;
		if((car= cardao.findById(carno).orElse(null))!=null)
		{
			if(passwordhash.hash(car.getOwnerno()).equals(token))
			{
				return true;
			}
			else
				return false;
			
		}
		else
		{
			return false;
		}
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	public UserCarRes addCar(String token,Car car)
	{
		try {
			
		
		
		if(verifyuser(car.getOwnerno(),token))
		{
			cardao.save(car);
			return new UserCarRes(11,true,"Car Added");
			
		}
		else
		{
			return new UserCarRes(0,false,"invalid token");
		}
		}
		catch(Exception e)
		{
			return new UserCarRes(0,false,"internal error");
		}
	}
	
	public UserCarRes addCarService(String token,String carno, CarServicing car)
	{
		try {
			
		
		
		if(verifyuser(carno,token))
		{
			carservdao.save(car);
			return new UserCarRes(11,true,"Car Servicing Added");
			
		}
		else
		{
			return new UserCarRes(0,false,"invalid token");
		}
		}
		catch(Exception e)
		{
			return new UserCarRes(0,false,"internal error");
		}
		
	}
	
	public UserCarRes addCarPuc(String token,String carno, CarPuc car)
	{
		try {
		if(verifyuser(carno,token))
		{
			carpucdao.save(car);
			return new UserCarRes(11,true,"Car Servicing Added");
			
		}
		else
		{
			return new UserCarRes(0,false,"invalid token");
		}
		}
		catch(Exception e)
		{
			return new UserCarRes(0,false,"internal error");
		}
		
	}
	
	public UserCarRes addCarTrip(String token,String carno, Trip trip)
	{
		try {
		if(verifyuser(carno,token))
		{
			cartrip.save(trip);
			return new UserCarRes(11,true,"Car Servicing Added");
			
		}
		else
		{
			return new UserCarRes(0,false,"invalid token");
		}
		}
		catch(Exception e)
		{
			return new UserCarRes(0,false,"internal error");
		}
		
	}
	public boolean addCarTripInternal(String carno,String startpoint,String endpoint)
	{
			cartrip.count();
			Trip t= new Trip((int) (cartrip.count()+1),carno,0.0,0.0,0.0,0.0,startpoint,endpoint,(new Date()),0,null);
			cartrip.save(t);
			return true;
		
	}
	public CarSummary viewCar(String token,String carno)
	{
		try {
			if(verifyuser(carno,token))
			{
				CarSummary cs=new CarSummary();
				cs.setCar(cardao.findById(carno).orElse(null));
				cs.setTriplist(cartrip.findAllByCarno(carno));
				cs.setCarserv(carservdao.findAllByCarno(carno));
				cs.setPuclist(carpucdao.findAllByCarno(carno));
				return cs;
				
			}
			else
			{
				return new CarSummary();
			}
		}
		catch(Exception e)
		{
			return new CarSummary();
		}
	}
	public List<Car> viewCars()
	{
		return cardao.findAll();
	}
	
	public List<CarServicing> viewService(String carno) {
		return carservdao.findAllByCarno(carno);
	}

	public List<CarPuc> viewPuc(String carno) {
		return carpucdao.findAllByCarno(carno);
	}

	public List<Trip> viewTrip(String carno) {
		return cartrip.findAllByCarno(carno);
	}
	public Trip viewlastTrip(String carno)
	{
		List<Trip> list= viewTrip(carno);
		return cartrip.findByCarnoAndTripid(carno, list.size());
	}
	
	public AnalyticData viewAnalyticInfo(String carno) {
		return null;
	}
}
