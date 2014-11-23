package com.phonelocation.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.phonelocation.model.Users;

/**
 * 用户处理
 * 
 * @author sumy
 *
 */
@Service
@Transactional
public class UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Session getSession() {
        return this.sessionFactory.getCurrentSession();
    }

    /**
     * 通过用户名查找用户信息
     * 
     * @param username
     *            用户名
     * @param lazy
     *            lazy模式：当需要使用用户的Role和Phone时请置为<i>false</i>
     * @return 用户信息
     */
    public Users findUserByUsername(String username, boolean lazy) {
        Users user = (Users) getSession().get(Users.class, username);
        if (user == null)
            return null;
        if (!lazy) {
            user.getRoles().size();
            user.getPhones().size();
        }
        return user;
    }

    /**
     * 保存或更新用户信息
     * 
     * @param user
     *            需要保存或更新的用户信息
     */
    public void saveOrUpdate(Users user) {
        getSession().saveOrUpdate(user);
    }

}
