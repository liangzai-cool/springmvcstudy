package com.test.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.test.entity.Customer;
import com.test.service.ICustomerService;

public class CustomerController extends MultiActionController {

	private ICustomerService custSer;

	public ICustomerService getCustSer() {
		return custSer;
	}
	public void setCustSer(ICustomerService custSer) {
		this.custSer = custSer;
	}

	public ModelAndView add(HttpServletRequest request, HttpServletResponse response){
		return null;
	}
	
	public ModelAndView delete(HttpServletRequest request, HttpServletResponse response){
		return null;
	}
	
	public ModelAndView update(HttpServletRequest request, HttpServletResponse response){
		Customer customer = new Customer();
		customer.setId("1");
		customer.setName("newName");
		customer.setAge(22);
		customer.setSex("FM");
		custSer.update(customer);
		return null;
	}
	
	public ModelAndView list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		List<Customer> customers = custSer.query();
		Map<String, List<Customer>> map = new HashMap<String, List<Customer>>();
		map.put("data", customers);
		return new ModelAndView("/WEB-INF/jsp/customer/list.jsp", map);
	}
	
	public ModelAndView queryById(HttpServletRequest request, HttpServletResponse response){
		System.out.println(request.getParameter("id"));
		System.out.println(request.getParameter("method"));
		Customer p = new Customer();
		p.setId("1");
		Customer person = custSer.queryById(p);
		System.out.println("id:" + person.getId() + ",name:" + person.getName() + ",age:" + person.getAge() + ",sex:" + person.getSex());
		return null;
	}
}
