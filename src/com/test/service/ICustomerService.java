package com.test.service;

import java.util.List;

import com.test.entity.Customer;

public interface ICustomerService {

	boolean add(Customer customer);
	
	boolean delete(Customer customer);
	
	boolean update(Customer customer);
	
	List<Customer> query();
	
	Customer queryById(Customer customer);
}
