package com.tss.test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.tss.utility.DbUtil;

public class DbMain {

	public static final String USER_NAME = "root";
	public static final String PASSWORD = "12345";
	public static final String SCHEMA = "training";
	public static final int PORT = 3306;

	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		Connection connection = DbUtil.getConnection("localhost", PORT, SCHEMA, USER_NAME, PASSWORD);
//		System.out.println(DbUtil.getGeneratedKey(connection, "INSERT INTO customer(name, address, phone_no)" + "VALUES(?, ?, ?)", "ramu","bangalore", "7022515845"));
//		System.out.println(DbUtil.get(connection, "SELECT * FROM customer where pk_id=?",3));
//		System.out.println(DbUtil.update(connection, "UPDATE customer SET name=? WHERE pk_id=2", "ramesh"));
//		System.out.println(DbUtil.getMapList(connection, "SELECT * FROM app_menu"));
//		List<List<Object>> list = new ArrayList<List<Object>>();
//		List<Object> listOne = new ArrayList<Object>();
//		listOne.add("david");
//		listOne.add(1);
//
//		List<Object> listTwo = new ArrayList<Object>();
//		listTwo.add("john");
//		listTwo.add(2);
//
//		list.add(listOne);
//		list.add(listTwo);
//		DbUtil.batchUpdates(connection, "UPDATE customer SET name=? WHERE pk_id=?",(list));
//		DbUtil.batchUpdates(connection, "UPDATE customer SET name=? WHERE pk_id=?",Arrays.asList(list.get(0),list.get(1)));
//		DbUtil.readFileData(new File(".\\files\\appMenu.csv"));
//		DbUtil.batchUpdates(connection, "INSERT INTO app_menu(lang, name, description)" + "VALUES(?, ?, ?)",DbUtil.readFileData(new File(".\\files\\appMenu.csv")));
		DbUtil.closeConnection(connection);
	}
}