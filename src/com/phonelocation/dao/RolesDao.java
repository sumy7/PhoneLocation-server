package com.phonelocation.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.phonelocation.model.Roles;

/**
 * 角色信息处理
 * 
 * @author sumy
 *
 */
@Service
@Transactional
public class RolesDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Session getSession() {
        return this.sessionFactory.getCurrentSession();
    }

    /**
     * 通过角色名获取用户角色
     * 
     * @param rolename
     *            角色名
     * @return 用户角色
     */
    public Roles findRolesByRolename(String rolename) {
        Roles result = (Roles) getSession().get(Roles.class, rolename);
        return result;
    }

}
