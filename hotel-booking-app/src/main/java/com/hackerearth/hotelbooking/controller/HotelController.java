package com.hackerearth.hotelbooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hackerearth.hotelbooking.entity.Hotel;
import com.hackerearth.hotelbooking.service.HotelService;

@RestController
@RequestMapping("/hackerearth/booking")
public class HotelController {

	@Autowired
	private HotelService hotelService;
	
	@RequestMapping(method=RequestMethod.GET,value="/province/{searchTerm}")
	public List<String> getAllProvince(@PathVariable String searchTerm){
		return hotelService.getAllProvince(searchTerm);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/city/{searchTerm}")
	public List<String> getAllCityByProvince(@PathVariable String searchTerm){
		return hotelService.getAllCityByProvince(searchTerm);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/hotel/{city}")
	public List<Hotel> getAllHotelByCity(@PathVariable String city){
		return hotelService.getAllHotelByCity(city);
		
	}
}
