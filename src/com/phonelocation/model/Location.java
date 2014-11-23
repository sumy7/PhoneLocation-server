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
 * Phone的位置信息实体（数据库用）
 * 
 * @author sumy
 *
 */
@Entity
@Table(name = "iphone")
public class Location {

    @Id
    private String phoneid;
    private double x;
    private double y;
    private double radius;
    private long date;

    @ManyToMany
    @JoinTable(name = "usersphone", joinColumns = { @JoinColumn(name = "phonename", referencedColumnName = "phoneid") }, inverseJoinColumns = { @JoinColumn(name = "username") })
    private Set<Users> users = new HashSet<Users>();

    public String getPhoneid() {
        return phoneid;
    }

    public void setPhoneid(String phoneid) {
        this.phoneid = phoneid;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public Set<Users> getUsers() {
        return users;
    }

    public void setUsers(Set<Users> users) {
        this.users = users;
    }

}
