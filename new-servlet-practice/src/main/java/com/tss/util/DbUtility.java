package com.tss.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbUtility {

	public static Connection getConnection(String host, int port, String schema, String userName, String password)
			throws SQLException, ClassNotFoundException {
		Connection connection = null;
		connection = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + schema, userName,
				password);
		Class.forName("com.mysql.cj.jdbc.Driver");
		// connection.setAutoCommit(false);
		return connection;
	}

	public static void getClose(Connection connection) throws SQLException {
		if (connection != null) {
			connection.close();
		}
	}

	public static void insert(Connection connection, String sql, String name, String phone, String email) {

		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, name);
			statement.setString(2, phone);
			statement.setString(3, email);
			int rows = statement.executeUpdate();
			if (rows > 0) {
			}
		} catch (SQLException ex) {
		}
	}

	public static void select(Connection connection, String sql) {

		try {

			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet result = statement.executeQuery(sql);
			while (result.next()) {
				int pk_id = result.getInt("pk_id");
				String name = result.getString("name");
				String phone = result.getString("phone");
				String email = result.getString("email");
				System.out.println(pk_id + ":" + name + "," + phone + "," + email);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public static void update(Connection connection, String sql, String name) {
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, name);
			int rows = statement.executeUpdate();
			if (rows > 0) {
				System.out.println("Successfully updated");
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public static void delete(Connection connection, String sql, String name) {
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, name);
			int rows = statement.executeUpdate();
			if (rows > 0) {
				System.out.println("Row is deleted");
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
}