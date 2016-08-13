package com.test.dao;

import com.test.entity.Admin;

public interface IAdminDao {
	
	Admin selectToLogin(Admin admin);
}
