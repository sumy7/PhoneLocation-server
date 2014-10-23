package com.phonelocation.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.phonelocation.dao.LocationDao;
import com.phonelocation.model.IPhone;
import com.phonelocation.model.Location;
import com.phonelocation.model.Token;
import com.phonelocation.repository.TokenRepository;

@Controller
public class PhoneLocationController {

	@Autowired
	private LocationDao locationDao;

	@Autowired
	private TokenRepository tokenRepository;

	@RequestMapping(value = "/find/{name}", method = RequestMethod.GET)
	public @ResponseBody IPhone findPhone(@PathVariable("name") String name) {
		return new IPhone(locationDao.findLocationByPhoneid(name));
	}

	@RequestMapping(value = "/phone", method = RequestMethod.POST)
	public @ResponseBody IPhone updates(@RequestBody IPhone location,
			@RequestHeader("tokenid") String tokenId,
			HttpServletResponse response) {
		System.out.println(location.getName() + location.getX()
				+ location.getY() + " tokenid:" + tokenId);
		Token token = tokenRepository.findByTokenId(tokenId);
		System.out.println(token);
		if (token == null || !token.getOwner().equals(location.getName())
				|| System.currentTimeMillis() > token.getDeadline()) {
			try {
				System.out.println("haha");
				response.sendError(401);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}
		Location iPhone = locationDao.findLocationByPhoneid(location.getName());
		if (iPhone == null) {
			iPhone = new Location();
			iPhone.setPhoneid(location.getName());
		}
		iPhone.setX(location.getX());
		iPhone.setY(location.getY());
		iPhone.setRadius(location.getRadius());
		iPhone.setDate(location.getDate());
		locationDao.saveOrUpdate(iPhone);
		response.setStatus(200);
		return location;
	}

	@RequestMapping(value = "/show/{name}", method = RequestMethod.GET)
	public String showlocation(@PathVariable("name") String name, ModelMap model) {
		Location location = locationDao.findLocationByPhoneid(name);
		if (location == null) {
			return "error";
		}
		model.addAttribute("x", location.getX());
		model.addAttribute("y", location.getY());
		model.addAttribute("radius", location.getRadius());
		model.addAttribute("labeltext", location.getPhoneid());
		model.addAttribute("titletext", new Date(location.getDate()).toString());

		return "show";
	}

}
