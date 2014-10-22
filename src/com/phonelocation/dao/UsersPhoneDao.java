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
public class UsersPhoneDao {
	@Autowired
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void insert(String username, String phonename) {
		String sql = "INSERT INTO usersphone "
				+ "(username, phonename) VALUES (?, ?)";
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, phonename);
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

	public Collection<IPhone> findPhoneByUsername(String username) {
		String sql = "SELECT * FROM usersphone,iphone WHERE username = ? AND phonename=p_name";

		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			ArrayList<IPhone> list = new ArrayList<IPhone>();
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

	public void delete(String username, String phonename) {

	}
}
