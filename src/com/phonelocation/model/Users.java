package com.phonelocation.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * 用户实体
 * @author sumy
 *
 */
@Entity
@Table(name = "users")
public class Users {

	@Id
	private String username;
	private String password;

	private int enabled;

	@ManyToMany
	@JoinTable(name = "authorities", joinColumns = { @JoinColumn(name = "username") }, inverseJoinColumns = { @JoinColumn(name = "authority", referencedColumnName = "rolename") })
	private Set<Roles> roles = new HashSet<Roles>();

	@ManyToMany
	@JoinTable(name = "usersphone", joinColumns = { @JoinColumn(name = "username") }, inverseJoinColumns = { @JoinColumn(name = "phonename", referencedColumnName = "phoneid") })
	private Set<Location> phones = new HashSet<Location>();

	public Users() {
	}

	public Users(String username, String password, int enabled) {
		super();
		this.username = username;
		this.password = password;
		this.enabled = enabled;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	public Set<Roles> getRoles() {
		return roles;
	}

	public void setRoles(Set<Roles> roles) {
		this.roles = roles;
	}

	public Set<Location> getPhones() {
		return phones;
	}

	public void setPhones(Set<Location> phones) {
		this.phones = phones;
	}

}
