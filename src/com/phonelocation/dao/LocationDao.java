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

	public void saveOrUpdate(Location location) {
		getSession().saveOrUpdate(location);
	}

	public Collection<Location> findAllLocation() {
		ArrayList<Location> result = (ArrayList<Location>) getSession()
				.createCriteria(Location.class).list();
		return result;
	}

	public Location findLocationByPhoneid(String phoneid) {
		Location location = (Location) getSession()
				.get(Location.class, phoneid);
		return location;
	}

	public Collection<Location> findLocationByUsername(String username) {

		Users users = (Users) getSession().get(Users.class, username);
		if (users != null) {
			users.getPhones().size();
			return users.getPhones();
		}
		return null;
	}

}
