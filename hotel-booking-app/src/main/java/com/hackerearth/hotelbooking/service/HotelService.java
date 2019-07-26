package com.hackerearth.hotelbooking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackerearth.hotelbooking.HotelServiceRepository;
import com.hackerearth.hotelbooking.entity.Hotel;

@Service
public class HotelService {
	@Autowired
	private HotelServiceRepository hotelRepo;
	
	public List<Hotel> getAllHotelByCity(String city){
		return hotelRepo.findByCity(city);
	}
	
	public List<String> getAllProvince(String searchTerm){
		return hotelRepo.getAllProvince(searchTerm);
	}
	
	public List<String> getAllCityByProvince(String searchTerm){
		return hotelRepo.getAllCityByProvince(searchTerm);
	}
}
