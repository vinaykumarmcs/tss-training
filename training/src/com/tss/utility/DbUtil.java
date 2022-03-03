package com.tss.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DbUtil {

	public static Connection getConnection(String host, int port, String schema, String userName, String password)
			throws SQLException, ClassNotFoundException {
		Connection connection = null;
		connection = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + schema, userName,
				password);
		Class.forName("com.mysql.cj.jdbc.Driver");
		connection.setAutoCommit(false);
		return connection;
	}

	public static void closeConnection(Connection connection) throws SQLException {
		try {
			if (connection.getAutoCommit() == false) {
				connection.setAutoCommit(true);
			}
		} finally {
			if (connection != null && connection.getAutoCommit()) {
				connection.close();
			}
		}
	}

	/**
	 * Inserts the data into the db and returns the pk id of last insterted record
	 * 
	 * @author vinay
	 * @param connection
	 * @param sql
	 * @param args
	 * @return Integer
	 * @throws SQLException
	 */
	public static Integer getGeneratedKey(Connection connection, String sql, Object... args) throws SQLException {
		PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		int index = 0;
		for (Object value : args) {
			preparedStatement.setObject(++index, value);
		}
		preparedStatement.executeUpdate();
		ResultSet resultSet = preparedStatement.getGeneratedKeys();
		if (resultSet.next()) {
			int id = resultSet.getInt(1);
			preparedStatement.close();
			resultSet.close();
			return id;
		}
		return 0;
	}

	/**
	 * reads the single line of data from the table
	 * 
	 * @author vinay
	 * @param connection
	 * @param sql
	 * @param args
	 * @return Integer
	 * @throws SQLException
	 */
	public static Map<String, Object> get(Connection connection, String sql, Object... args) throws SQLException {
		List<Map<String, Object>> record = getMapList(connection, sql, args);
		if (record.isEmpty()) {
			return new LinkedHashMap<String, Object>();
		}
		return record.get(0);
	}

	/**
	 * updates the table by given query
	 * 
	 * @param connection
	 * @param sql
	 * @param args
	 * @return Integer
	 * @throws SQLException
	 */
	public static Integer update(Connection connection, String sql, Object... args) throws SQLException {
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		int index = 0;
		for (Object value : args) {
			preparedStatement.setObject(++index, value);
		}
		int rows = preparedStatement.executeUpdate();
		preparedStatement.close();
		return rows;
	}

	/**
	 * reads the data in the table stores in the list
	 * 
	 * @param connection
	 * @param sql
	 * @param args
	 * @return List<Map<String, Object>>
	 * @throws SQLException
	 */
	public static List<Map<String, Object>> getMapList(Connection connection, String sql, Object... args)
			throws SQLException {
		List<Map<String, Object>> records = new ArrayList<Map<String, Object>>();
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		int index = 0;
		for (Object values : args) {
			preparedStatement.setObject(++index, values);
		}
		ResultSet resultSet = preparedStatement.executeQuery();
		ResultSetMetaData metaData = resultSet.getMetaData();
		int colCount = metaData.getColumnCount();
		Map<String, Object> record = null;
		while (resultSet.next()) {
			record = new LinkedHashMap<String, Object>();
			for (int i = 1; i <= colCount; i++) {
				record.put(metaData.getColumnLabel(i), resultSet.getObject(i));
			}
			records.add(record);
		}
		preparedStatement.close();
		return records;
	}

	public static void batchUpdates(Connection connection, String sql, List<List<Object>> records) throws SQLException {
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		for (int i = 0; i < records.size(); i++) {
			int index = 0;
			for (Object obj : records.get(i)) {
				preparedStatement.setObject(++index, obj);
			}
			preparedStatement.addBatch();
		}
		preparedStatement.executeBatch();
		preparedStatement.close();
	}
}