package com.test.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.test.dao.ICustomerDao;
import com.test.entity.Customer;

/**
 * �Կͻ����м򵥵� ��ɾ���ĺͲ�
 * @author Light
 *
 */
public class CustomerDaoImpl extends JdbcDaoSupport implements ICustomerDao {

	@Override
	public boolean insert(Customer customer) {
		String sql = "insert into person (name, age, sex) values(?, ?, ?)";
		super.getJdbcTemplate().update(sql, new Object[]{customer.getName(), customer.getAge(), customer.getSex()});
		return true;
	}

	@Override
	public boolean delete(Customer p) {
		String sql = "delete person where id = ?";
		super.getJdbcTemplate().update(sql, new Object[]{p.getId()});
		return true;
	}

	@Override
	public boolean update(Customer p) {
		String sql = "update person set name = ?, age = ?, sex = ? where id = ?";
		super.getJdbcTemplate().update(sql, new Object[]{p.getName(), p.getAge(), p.getSex(), p.getId()});
		return true;
	}

	@Override
	public List<Map<String,Object>> select() {
		String sql = "select * from customer";
		return super.getJdbcTemplate().queryForList(sql);
	}

	@Override
	public Customer selectByid(Customer customer) {
		String sql = "select * from customer where id = ?";
		List<Map<String,Object>> rows = super.getJdbcTemplate().queryForList(sql, new Object[]{customer.getId()});
		Customer person = new Customer();
		for(Map<String, Object> row : rows){
			person.setId(row.get("id").toString());
			person.setName(row.get("name").toString());
			person.setAge(Integer.parseInt(row.get("age").toString()));
			person.setSex(row.get("sex").toString());
			break;
		}
		return person;
	}

}
