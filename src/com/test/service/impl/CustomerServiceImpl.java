package com.test.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.test.dao.ICustomerDao;
import com.test.entity.Customer;
import com.test.service.ICustomerService;

public class CustomerServiceImpl implements ICustomerService {

	private ICustomerDao custDao;
	

	public ICustomerDao getCustDao() {
		return custDao;
	}
	public void setCustDao(ICustomerDao custDao) {
		this.custDao = custDao;
	}

	@Override
	public boolean add(Customer customer) {
		custDao.insert(customer);
		return true;
	}

	@Override
	public boolean delete(Customer customer) {
		custDao.delete(customer);
		return true;
	}

	@Override
	public boolean update(Customer customer) {
		custDao.update(customer);
		return true;
	}

	@Override
	public List<Customer> query() {
		List<Map<String,Object>> colls = custDao.select();
		List<Customer> customers = new ArrayList<Customer>();
		for(Map<String, Object> row : colls){
			Customer customer = new Customer();
			customer.setId(row.get("id").toString());
			customer.setName(row.get("name").toString());
			customer.setAge(Integer.parseInt(row.get("age").toString()));
			customer.setSex(row.get("sex").toString());
			customers.add(customer);
		}
		return customers;
	}

	@Override
	public Customer queryById(Customer customer) {
		return custDao.selectByid(customer);
	}

}
