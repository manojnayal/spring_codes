package com.spring.basics.aop.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.basics.aop.data.Dao1;

@Service
public class Business1 {

	@Autowired
	private Dao1 dao1;
	
	public String calculateData() {
		return dao1.retriveData();
	}
}
