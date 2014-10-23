package com.phonelocation.model;

public class IPhone {

	private String name;
	private double x;
	private double y;
	private long date;
	private double radius;

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
		return (int) (name.hashCode() + x + y + radius + date);
		// return Objects.hash(name, x, y, radius, date);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof IPhone) {
			IPhone that = (IPhone) obj;
			return (this.name == that.name) && (this.x == that.x)
					&& (this.y == that.y) && (this.radius == that.radius)
					&& (this.date == that.date);
		} else {
			return false;
		}
	}

}
