package com.test.dao;

import java.util.List;
import java.util.Map;

import com.test.entity.Customer;

public interface ICustomerDao {

	boolean insert(Customer p);
	
	boolean delete(Customer p);
	
	boolean update(Customer p);
	
	List<Map<String,Object>> select();
	
	Customer selectByid(Customer customer);
}
