package com.tss.main;

import java.sql.Connection;
import com.tss.util.DbUtility;

public class DataBaseMain {
	public static final String USER_NAME = "root";
	public static final String PASSWORD = "12345";
	public static final String SCHEMA = "training";
	public static final int PORT = 3306;

	public static void main(String[] args) throws Exception {
		Connection connection = DbUtility.getConnection("localhost", PORT, SCHEMA, USER_NAME, PASSWORD);
//		DbUtility.insert(connection,"INSERT INTO student(name,phone,email)" + "VALUES(?, ?, ?)", "veeru", "9745165439", "veeru@gmail.com");
		DbUtility.select(connection, "SELECT * FROM student");
		// DbUtility.update(connection, "UPDATE student SET name=? WHERE pk_id=1","ramesh");
		// DbUtility.delete(connection,"DELETE FROM student WHERE name=?","raghu");
		DbUtility.getClose(connection);
	}
}