package com.airline.service;

import java.util.List;

import com.airline.dao.BookingDao;
import com.airline.entity.Booking;

public class BookingService {
	private BookingDao bookingDao;
	
	public BookingService() {
		bookingDao = new BookingDao();
	}
	public boolean bookFlight(int userId, int flightId) {
		return bookingDao.save(userId, flightId);	
	}
	public List<Booking>getBookingByUserId(int userId){
		return bookingDao.findAllById(userId);	
	}
}
