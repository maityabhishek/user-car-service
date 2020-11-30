package com.usercar.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.usercar.model.CarServicing;


public interface CarServicingDAO extends MongoRepository<CarServicing,String>{
	List<CarServicing> findAllByCarno(String Carno);
}
