package com.test.service.impl;

import com.test.dao.IAdminDao;
import com.test.entity.Admin;
import com.test.service.IAdminService;

public class AdminServiceImpl implements IAdminService {

	private IAdminDao adao;
	
	public IAdminDao getAdao() {
		return adao;
	}

	public void setAdao(IAdminDao adao) {
		this.adao = adao;
	}
	
	@Override
	public Admin login(Admin admin) {
		return adao.selectToLogin(admin);
	}

}
