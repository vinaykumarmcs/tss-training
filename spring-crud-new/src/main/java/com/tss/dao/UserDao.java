package com.tss.dao;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import com.tss.model.User;

public class UserDao {
	private JdbcTemplate jdbcTemplate;
	public DataSource dataSource;
	
	public static UserDao init(Connection connection) {
		UserDao dao = new UserDao();
		dao.jdbcTemplate = new JdbcTemplate();
		dao.jdbcTemplate.setDataSource(new SingleConnectionDataSource(connection, false));
		return dao;
	}

	public List<Map<String, Object>> list() {
		return jdbcTemplate.queryForList("SELECT * FROM user");
	}

	public int add(User contact) {
		return jdbcTemplate.update("INSERT INTO user(name, phone) VALUES(?,?)", contact.getName(), contact.getPhone());
	}

	public int update(User contact) {
		return jdbcTemplate.update("UPDATE user SET name=? WHERE phone=?", contact.getName(), contact.getPhone());
	}

	public int delete(String phone) {
		return jdbcTemplate.update("DELETE FROM user WHERE phone=?", phone);
	}

	public Map<String, Object> get(String phone) {
		try {
			return jdbcTemplate.queryForMap("SELECT * FROM user WHERE phone=?", phone);
		} catch (DataAccessException e) {
			return null;
		}
	}
}
