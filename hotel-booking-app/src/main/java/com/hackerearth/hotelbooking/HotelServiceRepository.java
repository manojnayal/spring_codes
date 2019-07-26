package com.hackerearth.hotelbooking;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hackerearth.hotelbooking.entity.Hotel;

public interface HotelServiceRepository extends JpaRepository<Hotel, String> {
	public List<Hotel> findByCity(String city);
	
	@Query("select distinct h.province from #{#entityName} h where h.country = :searchTerm")
	public List<String> getAllProvince(@Param("searchTerm") String searchTerm);
	
	@Query("select distinct h.city from #{#entityName} h where h.province = :searchTerm")
	public List<String> getAllCityByProvince(@Param("searchTerm") String searchTerm);
}
