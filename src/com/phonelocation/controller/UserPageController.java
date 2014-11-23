package com.phonelocation.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.phonelocation.dao.LocationDao;
import com.phonelocation.model.Location;

/**
 * 控制器：个人信息
 * 
 * @author sumy
 *
 */
@Controller
public class UserPageController {

    @Autowired
    private LocationDao locationDao;

    /**
     * 列出登录用户下的设备
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView listLocation() {
        // 获取登录用户
        UserDetails userDetails = (UserDetails) SecurityContextHolder
                .getContext().getAuthentication().getPrincipal();

        Collection<Location> list = locationDao
                .findLocationByUsername(userDetails.getUsername());
        return new ModelAndView("list", "phonelist", list);
    }

}
