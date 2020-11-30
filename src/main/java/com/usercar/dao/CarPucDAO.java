package com.usercar.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.usercar.model.CarPuc;


public interface CarPucDAO extends MongoRepository<CarPuc, String> {
	List<CarPuc> findAllByCarno(String Carno);
}
