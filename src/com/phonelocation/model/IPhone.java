package com.phonelocation.model;

/**
 * Phone的位置信息（传输用）
 * 
 * @author sumy
 *
 */
public class IPhone {

    private String name; // 名称PhoneID
    private double x;// x坐标
    private double y;// y坐标
    private long date;// 更新时间
    private double radius;// 精度半径

    public IPhone() {
    }

    public IPhone(String name, double x, double y, double radius, long date) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.date = date;
    }

    public IPhone(Location location) {
        this.name = location.getPhoneid();
        this.x = location.getX();
        this.y = location.getY();
        this.radius = location.getRadius();
        this.date = location.getDate();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (date ^ (date >>> 32));
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        long temp;
        temp = Double.doubleToLongBits(radius);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(x);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(y);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        IPhone other = (IPhone) obj;
        if (date != other.date)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (Double.doubleToLongBits(radius) != Double
                .doubleToLongBits(other.radius))
            return false;
        if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x))
            return false;
        if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y))
            return false;
        return true;
    }

}
