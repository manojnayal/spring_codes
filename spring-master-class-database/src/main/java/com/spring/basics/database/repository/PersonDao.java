package com.spring.basics.database.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.spring.basics.database.bean.Person;

@Repository
public class PersonDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	public List<Person> findAll(){
		return jdbcTemplate.query("select * from person", new BeanPropertyRowMapper<Person>(Person.class));
	}
}
