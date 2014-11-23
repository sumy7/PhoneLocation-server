package com.phonelocation.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.phonelocation.dao.LocationDao;
import com.phonelocation.dao.UserDao;
import com.phonelocation.model.Location;
import com.phonelocation.model.Token;
import com.phonelocation.model.Users;
import com.phonelocation.repository.TokenRepository;

/**
 * 控制器：认证处理
 * 
 * @author sumy
 *
 */
@Controller
public class AuthController {

    // 过期时间
    public final static long DEADLINE_ONE_WEEK = 1000 * 60 * 60 * 24 * 7;
    public final static long DEADLINE_TEN_MINIES = 1000 * 60 * 10;

    @Autowired
    private TokenRepository tokenRepository;

    @Autowired
    private UserDao userDao;

    @Autowired
    private LocationDao locationDao;

    /**
     * 认证用户名和密码，认证成功则返回Token
     */
    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    public @ResponseBody Token auth(@RequestParam("username") String username,
            @RequestParam("password") String password,
            @RequestParam("name") String name, HttpServletRequest request,
            HttpServletResponse response) {

        // 通过用户名查找用户并检查
        Users user = userDao.findUserByUsername(username, false);
        if (user == null || !user.getPassword().equals(password)) {
            try {
                // 用户检查错误，返回404
                response.sendError(404);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        // 创建一个默认的Token
        String tokenid = "";
        Token token = new Token(name, tokenid, System.currentTimeMillis()
                + DEADLINE_TEN_MINIES);

        // 将Phone添加到认证的用户下
        Location iphone = locationDao.findLocationByPhoneid(name);
        if (iphone == null) {
            iphone = new Location();
            iphone.setPhoneid(name);
            locationDao.saveOrUpdate(iphone);
        }
        user.getPhones().add(iphone);
        userDao.saveOrUpdate(user);

        // 补全TokenID并将Token保存到仓库中
        token = tokenRepository.insert(token);

        return token;
    }

}
