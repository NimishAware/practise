package com.airline.service;

import java.time.LocalDate;
import java.util.List;

import com.airline.dao.FlightDao;
import com.airline.entity.Flight;

public class FlightService {
 private FlightDao flightDao;
 
	public FlightService() {
		flightDao = new FlightDao();
		
	}
	
	public List<Flight> searchFlight(String source, String destination, LocalDate date){
		return flightDao.searchFlight(source, destination, date);
		
	}

}
