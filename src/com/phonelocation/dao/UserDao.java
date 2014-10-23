package com.phonelocation.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.phonelocation.model.Users;

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

	public void saveOrUpdate(Users user) {
		getSession().saveOrUpdate(user);
	}

}
