package com.phonelocation.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.code.kaptcha.Constants;
import com.phonelocation.dao.AuthoritieDao;
import com.phonelocation.dao.UserDao;
import com.phonelocation.model.Authoritie;
import com.phonelocation.model.User;

@Controller
public class UserController {

	@Autowired
	private UserDao userDao;

	@Autowired
	private AuthoritieDao authoritieDao;

	@RequestMapping(value = "/register.do", method = RequestMethod.GET)
	public String toRegister(){
		return "register";
	}
	
	@RequestMapping(value = "/register.do", method = RequestMethod.POST)
	public String register(String j_username, String j_password,
			String j_password_rep, String j_code, HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		String code = (String) session
				.getAttribute(Constants.KAPTCHA_SESSION_KEY);
		if (!code.equals(j_code)) {
			System.out.println(code + " " + j_code + " 验证码不匹配");
			return "register";
		}
		if (j_username.equals("") || j_password.equals("")
				|| j_password_rep.equals("")) {
			System.out.println("密码为空");
			return "register";
		}
		if (!j_password.equals(j_password_rep)) {
			System.out.println("两次密码不同");
			return "register";
		}
		User user = userDao.findByUsername(j_username);
		if (user != null) {
			System.out.println("用户已存在");
			return "register";
		}

		user = new User(j_username, j_password, 1);
		Authoritie authoritie = new Authoritie(j_username, Authoritie.ROLE_USER);
		userDao.insert(user);
		authoritieDao.insert(authoritie);
		System.out.println("新建用户");
		return "";
	}
}
