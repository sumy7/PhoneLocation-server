package com.phonelocation.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.phonelocation.dao.UsersPhoneDao;
import com.phonelocation.model.IPhone;

@Controller
public class UserPageController {

	@Autowired
	private UsersPhoneDao usersPhoneDao;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView listLocation() {
		UserDetails userDetails = (UserDetails) SecurityContextHolder
				.getContext().getAuthentication().getPrincipal();

		Collection<IPhone> list = usersPhoneDao.findPhoneByUsername(userDetails
				.getUsername());
		return new ModelAndView("list", "phonelist", list);
	}

}
