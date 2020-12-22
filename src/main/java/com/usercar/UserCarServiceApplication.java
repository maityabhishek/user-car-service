package com.usercar;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import com.usercar.dao.CarDAO;
import com.usercar.dao.CarPucDAO;
import com.usercar.dao.CarServicingDAO;
import com.usercar.dao.TripDAO;
import com.usercar.model.Car;
import com.usercar.model.CarPuc;
import com.usercar.model.CarServicing;
import com.usercar.model.Trip;
import com.usercar.model.TripSplits;

@SpringBootApplication
public class UserCarServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserCarServiceApplication.class, args);
	}

}

@Component
class cosmosdb
{

	cosmosdb(TripDAO cartrip,CarPucDAO carpucdao,CarServicingDAO carservdao,CarDAO cardao) 
	{
		
		cardao.save(new Car("OD02F7497","100","OD001","A","M","Black",new Date(),3000,56.9,0,0));
		carservdao.save(new CarServicing("OD02F7497", "PLG H", new Date(), "All Ok "));
		carpucdao.save(new CarPuc("OD02F7497", new Date(), new Date(), "Bhubaneswar", "Active"));
		List<TripSplits> ts= new ArrayList<TripSplits>();
		ts.add(new TripSplits(1,10,10.2,15,1));
		ts.add(new TripSplits(11,20,10.2,15,1));
		cartrip.save(new Trip(1,"OD02F7497", 658.3, 30.2, 45.3, 3.1,"Mumbai","Pune",new Date(),ts,0,0,0.0));
		ts= new ArrayList<TripSplits>();
		ts.add(new TripSplits(1,10,10.2,15,1));
		ts.add(new TripSplits(11,20,10.2,15,1));
		ts.add(new TripSplits(21,31,10.2,15,1));
		cartrip.save(new Trip(2,"OD02F7497", 1658.3, 60.2, 93.3, 7.1,"Delhi","Pune",new Date(),ts,10,0,0.0));
	}
}

