package com.phonelocation.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.google.code.kaptcha.Constants;
import com.phonelocation.dao.RolesDao;
import com.phonelocation.dao.UserDao;
import com.phonelocation.model.Roles;
import com.phonelocation.model.Users;

@Controller
public class UserController {

	@Autowired
	private UserDao userDao;

	@Autowired
	private RolesDao rolesDao;

	@RequestMapping(value = "/register.do", method = RequestMethod.GET)
	public String toRegister() {
		return "register";
	}

	@RequestMapping(value = "/register.do", method = RequestMethod.POST)
	public ModelAndView register(String j_username, String j_password,
			String j_password_rep, String j_code, HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		String code = (String) session
				.getAttribute(Constants.KAPTCHA_SESSION_KEY);
		ModelAndView mv = new ModelAndView("register");
		if (!code.equals(j_code)) {
			mv.addObject("msgtype", "info");
			mv.addObject("msgret", "验证码不匹配");
			mv.addObject("j_username", j_username);
			mv.addObject("j_password", j_password);
			mv.addObject("j_password_rep", j_password_rep);
			System.out.println(code + " " + j_code + " 验证码不匹配");
			return mv;
		}
		if (j_username.equals("") || j_password.equals("")
				|| j_password_rep.equals("")) {
			mv.addObject("msgtype", "warning");
			mv.addObject("msgret", "表单填写不完整");
			System.out.println("密码为空");
			return mv;
		}
		if (!j_password.equals(j_password_rep)) {
			mv.addObject("msgtype", "warning");
			mv.addObject("msgret", "两次密码不匹配");
			System.out.println("两次密码不同");
			return mv;
		}
		Users user = userDao.findUserByUsername(j_username, true);
		if (user != null) {
			mv.addObject("msgtype", "danger");
			mv.addObject("msgret", "用户已存在");
			System.out.println("用户已存在" + j_username + " " + user.getUsername());
			return mv;
		}

		user = new Users(j_username, j_password, 1);
		user.setUsername(j_username);
		user.setPassword(j_password);
		user.setEnabled(1);
		user.getRoles().add(rolesDao.findRolesByRolename(Roles.ROLE_USER));

		userDao.saveOrUpdate(user);

		System.out.println("新建用户");
		mv.setViewName("login");
		mv.addObject("msgtype", "success");
		mv.addObject("msgret", j_username + " 用户注册成功");
		return mv;
	}
}
