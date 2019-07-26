package com.spring.basics.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.spring.basics.aop.business.Business1;
import com.spring.basics.aop.business.Business2;

@SpringBootApplication
public class SpringMasterClassAopApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private Business1 business1;
	@Autowired
	private Business2 business2;
	public static void main(String[] args) {
		SpringApplication.run(SpringMasterClassAopApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		logger.info(business1.calculateData());
		logger.info(business2.calculateData());
	}

}
