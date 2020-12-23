package com.usercar.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.usercar.model.Trip;

public interface TripDAO extends MongoRepository<Trip, Integer> {

	List<Trip> findAllByCarnoOrderByTripidDesc(String Carno);
	Trip findByCarnoAndTripid(String Carno,int Tripid);
	Trip findByTripidAndCarno(int Tripid,String Carno);
}
