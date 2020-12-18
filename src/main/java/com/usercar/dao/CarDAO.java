package com.usercar.dao;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.usercar.model.Car;



public interface CarDAO extends MongoRepository<Car, String>{
	
	
}
