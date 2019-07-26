package com.spring.basics.database;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.spring.basics.database.repository.PersonDao;

@SpringBootApplication
public class SpringMasterClassDatabaseApplication implements CommandLineRunner{

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private PersonDao personDao;
	public static void main(String[] args) {
		SpringApplication.run(SpringMasterClassDatabaseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	logger.info("Person values {}",personDao.findAll());
		
	}

}
