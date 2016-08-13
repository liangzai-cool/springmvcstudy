package com.test.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.test.dao.IAdminDao;
import com.test.entity.Admin;

public class AdminDaoImpl extends JdbcDaoSupport implements IAdminDao {

	@Override
	public Admin selectToLogin(Admin admin){
		String sql = "select id, name from admin where name = ? and password = ?";
		Admin admin2 = super.getJdbcTemplate().query(sql, new Object[]{admin.getName(), admin.getPassword()}, new ResultSetExtractor<Admin>(){

			@Override
			public Admin extractData(ResultSet arg0) throws SQLException, DataAccessException {
				Admin admin = null;
				if(arg0.next()){
					admin = new Admin();
					admin.setId(arg0.getInt("id"));
					admin.setName(arg0.getString("name"));
				}
				return admin;
			}
			
		});
		return admin2;
	}
}
