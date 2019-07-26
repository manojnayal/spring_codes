package com.spring.basics.aop.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.basics.aop.data.Dao2;

@Service
public class Business2 {

	@Autowired
	private Dao2 dao2;
	
	public String calculateData() {
		return dao2.retriveData();
	}
}
