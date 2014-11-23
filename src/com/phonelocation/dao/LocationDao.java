package com.phonelocation.dao;

import java.util.ArrayList;
import java.util.Collection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.phonelocation.model.Location;
import com.phonelocation.model.Users;

/**
 * 位置信息处理
 * 
 * @author sumy
 *
 */
@Service
@Transactional
public class LocationDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Session getSession() {
        return this.sessionFactory.getCurrentSession();
    }

    /**
     * 保存位置信息
     * 
     * @param location
     *            位置信息
     */
    public void saveOrUpdate(Location location) {
        getSession().saveOrUpdate(location);
    }

    /**
     * 获取数据库所有的位置信息
     * 
     * @return 位置信息列表
     */
    public Collection<Location> findAllLocation() {
        ArrayList<Location> result = (ArrayList<Location>) getSession()
                .createCriteria(Location.class).list();
        return result;
    }

    /**
     * 通过PhoneID查找位置信息
     * 
     * @param phoneid
     *            设备码
     * @return 位置信息列表
     */
    public Location findLocationByPhoneid(String phoneid) {
        Location location = (Location) getSession()
                .get(Location.class, phoneid);
        return location;
    }

    /**
     * 查找用户下的位置信息
     * 
     * @param username
     *            用户名
     * @return 位置信息列表
     */
    public Collection<Location> findLocationByUsername(String username) {
        Users users = (Users) getSession().get(Users.class, username);
        if (users != null) {
            users.getPhones().size();
            return users.getPhones();
        }
        return null;
    }

}
