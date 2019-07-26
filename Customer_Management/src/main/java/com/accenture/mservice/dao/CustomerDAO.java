package com.accenture.mservice.dao;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.accenture.mservice.bean.Customer;

@Repository
public class CustomerDAO {
	
	static public Map<Integer, Customer> mapOfCustomer = new LinkedHashMap<Integer, Customer>();
	static int count=10004;
	static
	{
		mapOfCustomer.put(10001, new Customer("Jack",10001,12345.6));
		mapOfCustomer.put(10002, new Customer("Justin",10002,12355.6));
		mapOfCustomer.put(10003, new Customer("Eric",10003,12445.6));
	}
	
	public Collection<Customer> getAllCustomer(){
		return mapOfCustomer.values();			
	}
	
	public Customer getCustomerDetailsById(int id){
		return mapOfCustomer.get(id);
	}
	
	public Integer addCustomer(Customer customer){
		count++;
		customer.setCustomerId(count);
		mapOfCustomer.put(count, customer);
		return count;
	}
	
	public Customer updateCustomer (Customer customer){
		mapOfCustomer.put(customer.getCustomerId(), customer);
		return customer;
	}
	
	public Customer removeCustomer (int id){
		Customer emp= mapOfCustomer.remove(id);
		return emp;
	}
	
}
