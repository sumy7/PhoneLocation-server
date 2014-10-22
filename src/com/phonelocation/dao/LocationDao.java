package com.phonelocation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.phonelocation.model.IPhone;

@Component
public class LocationDao {

	@Autowired
	private DataSource dataSource;

	public void update(IPhone location) {
		String sql = "UPDATE iphone SET "
				+ "p_x=?, p_y=?, p_radius=?, p_date=? WHERE p_name=?";

		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(5, location.getName());
			ps.setDouble(1, location.getX());
			ps.setDouble(2, location.getY());
			ps.setDouble(3, location.getRadius());
			ps.setLong(4, location.getDate());
			System.out.println(ps.toString());
			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
	}

	public void insert(IPhone location) {
		String sql = "INSERT INTO iphone "
				+ "(p_name, p_x, p_y, p_radius, p_date) VALUES (?, ?, ?, ?, ?)";

		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, location.getName());
			ps.setDouble(2, location.getX());
			ps.setDouble(3, location.getY());
			ps.setDouble(4, location.getRadius());
			ps.setLong(5, location.getDate());
			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
	}

	public Collection<IPhone> findAll() {
		String sql = "SELECT * FROM iphone";

		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ArrayList<IPhone> list = new ArrayList<IPhone>();
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				IPhone iPhone = new IPhone(rs.getString("P_NAME"),
						rs.getDouble("P_X"), rs.getDouble("P_Y"),
						rs.getDouble("P_RADIUS"), rs.getLong("P_DATE"));
				list.add(iPhone);
			}
			rs.close();
			ps.close();
			return list;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
	}

	public IPhone findByName(String name) {
		String sql = "SELECT * FROM iphone WHERE p_name=?";

		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			IPhone iPhone = null;
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				iPhone = new IPhone(rs.getString("P_NAME"),
						rs.getDouble("P_X"), rs.getDouble("P_Y"),
						rs.getDouble("P_RADIUS"), rs.getLong("P_DATE"));
			}
			rs.close();
			ps.close();
			return iPhone;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
	}
}
