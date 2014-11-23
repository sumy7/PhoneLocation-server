package com.phonelocation.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * 用户角色实体
 * 
 * @author sumy
 *
 */
@Entity
@Table(name = "roles")
public class Roles implements Serializable {

    public final static String ROLE_ADMIN = "ROLE_ADMIN"; // 管理员
    public final static String ROLE_USER = "ROLE_USER";// 普通用户

    private static final long serialVersionUID = 1L;

    @Id
    private String rolename;
    private String roledesc;

    @ManyToMany
    @JoinTable(name = "authorities", joinColumns = { @JoinColumn(name = "authority", referencedColumnName = "rolename") }, inverseJoinColumns = { @JoinColumn(name = "username") })
    private Set<Users> users = new HashSet<Users>();

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public String getRoledesc() {
        return roledesc;
    }

    public void setRoledesc(String roledesc) {
        this.roledesc = roledesc;
    }

    public Set<Users> getUsers() {
        return users;
    }

    public void setUsers(Set<Users> users) {
        this.users = users;
    }

}
