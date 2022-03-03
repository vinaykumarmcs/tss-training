package com.tss.test;

import java.sql.Connection;

import com.tss.utility.DbUtil;
import com.tss.utility.FileUtility;

public class AddingDataFromFile {
	public static final String USER_NAME = "root";
	public static final String PASSWORD = "12345";
	public static final String SCHEMA = "training";
	public static final int PORT = 3306;

	public static void main(String[] args) throws Exception {
		Connection connection = DbUtil.getConnection("localhost", PORT, SCHEMA, USER_NAME, PASSWORD);
		DbUtil.batchUpdates(connection, "INSERT INTO app_menu(lang, name, description)" + "VALUES(?, ?, ?)", FileUtility.readFileData(".\\files\\appMenu.csv"));
		DbUtil.closeConnection(connection);
	}
}