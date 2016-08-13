package com.test.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.test.entity.Admin;
import com.test.service.IAdminService;

public class AdminController extends MultiActionController {

	private IAdminService adminSer;

	public IAdminService getAdminSer() {
		return adminSer;
	}
	public void setAdminSer(IAdminService adminSer) {
		this.adminSer = adminSer;
	}
	
	/**
	 * 管理员登录
	 * @param request
	 * @param response
	 * @param admin
	 * @return
	 */
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response, Admin admin){
		Admin adm = adminSer.login(admin);
		Map<String, Object> map = new HashMap<String, Object>();
		String path = null;
		if(adm != null){
			map.put("admin", adm);
			request.getSession().setAttribute("admin", adm);
			path = "redirect:/customer.htm?action=list";
		}else{
			map.put("msg", "用户名或密码错误！");
			map.put("admin", admin);
			path = "login.jsp";
		}
		return new ModelAndView(path, map);
	}
	
	/**
	 * 管理员退出系统
	 * @param request
	 * @param response
	 * @param admin
	 * @return
	 */
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response, Admin admin){
		request.getSession().removeAttribute("admin");
		try {
			response.sendRedirect("login.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
