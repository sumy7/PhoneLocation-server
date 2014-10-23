package com.phonelocation.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.phonelocation.dao.UserDao;
import com.phonelocation.model.Roles;
import com.phonelocation.model.Users;

@Service
@Transactional(readOnly = true)
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserDao userDao;

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		Users user = userDao.findUserByUsername(username, true);
		UserDetails loginuser = null;
		if (user != null) {
			loginuser = new User(username, user.getPassword(),
					user.getEnabled() == 1 ? true : false, true, true, true,
					findUserAuthorities(user));

		}
		return loginuser;
	}

	private Collection<GrantedAuthority> findUserAuthorities(Users user) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		Set<Roles> roles = user.getRoles();
		// System.out.println(roles.size());
		for (Roles role : roles) {
			authorities.add(new SimpleGrantedAuthority(role.getRolename()));
		}
		return authorities;
	}

}
