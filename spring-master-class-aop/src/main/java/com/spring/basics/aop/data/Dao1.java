package com.spring.basics.aop.data;

import org.springframework.stereotype.Repository;

import com.spring.basics.aop.aspect.TrackTime;

@Repository
public class Dao1 {
	
	@TrackTime
	public String retriveData() {
		return "Dao1";
	}
}
