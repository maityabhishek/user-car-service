package com.usercar;

import java.util.Date;

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

@SpringBootApplication
public class UserCarServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserCarServiceApplication.class, args);
	}

}
/*
@Component
class cosmosdb
{

	cosmosdb(TripDAO cartrip,CarPucDAO carpucdao,CarServicingDAO carservdao,CarDAO cardao) 
	{
		
		cardao.save(new Car("OD02F7497","OD001","A","M","Black",new Date()));
		carservdao.save(new CarServicing("OD02F7497", "PLG H", new Date(), "All Ok "));
		carpucdao.save(new CarPuc("OD02F7497", new Date(), new Date(), "Bhubaneswar", "Active"));
		cartrip.save(new Trip(1,"OD02F7497", 658.3, 30.2, 93.3, 7.1));
	}
}
*/