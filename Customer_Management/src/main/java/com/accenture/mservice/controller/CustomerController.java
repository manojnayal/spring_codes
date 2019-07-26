package com.accenture.mservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.mservice.bean.Customer;
import com.accenture.mservice.dao.CustomerDAO;;

@RestController
public class CustomerController {

	@Autowired
	CustomerDAO customerDAO;
	
	@RequestMapping(value = "customer/getDetails", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Customer>> getCustomerDetails() {
		List<Customer> listCustomer = new ArrayList<Customer>(customerDAO.getAllCustomer());
		
		return new ResponseEntity<List<Customer>>(listCustomer,HttpStatus.OK);
	}

	@RequestMapping(value = "/customer/addCustomer", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.TEXT_HTML_VALUE)
	public ResponseEntity<String> addCustomer(@RequestBody Customer customer) {
		int count=customerDAO.addCustomer(customer);
		return new ResponseEntity<String>("customer added successfully with id:" + count,HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/customer/updateEmp", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customer> updateEmployee(@RequestBody  Customer customer) {
		System.out.println(">>>"+customer);
		if (customerDAO.getCustomerDetailsById(customer.getCustomerId()) == null) {
			Customer customer2 = null;
			return new ResponseEntity<Customer>(customer2,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		Customer updated = customerDAO.updateCustomer(customer);
		return new ResponseEntity<Customer>(updated, HttpStatus.OK);
	}

	@RequestMapping(value = "/emp/controller/deleteEmp/{id}", method = RequestMethod.DELETE,
	produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customer> deleteEmployee(@PathVariable("id") int myId) {
		if (customerDAO.getCustomerDetailsById(myId) == null) {
			Customer employee2 = null;
			return new ResponseEntity<Customer>(employee2,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		Customer employee = customerDAO.removeCustomer(myId);
		return new ResponseEntity<Customer>(employee, HttpStatus.OK);
	}
}