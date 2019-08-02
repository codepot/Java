package com.phucle.derby;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CreateInventoryDB {

	public static final String DERBY_DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
	public static final String JDBC_DERBYURL = "jdbc:derby:inventoryDB;create=true";

	public static void main(String[] args) throws ClassNotFoundException,
			SQLException {
		Class.forName(DERBY_DRIVER);
		Connection connection = DriverManager.getConnection(JDBC_DERBYURL);
		connection.createStatement().execute(
				"create table inventory(inventoryId int, itemName varchar(25), "
						+ "itemPrice DOUBLE PRECISION)");
		connection.createStatement().execute(
				"insert into inventory values " + "(1, 'A4 Paper Pk.', 8.95), "
						+ "(2, 'Pilot Pen', 1.75), "
						+ "(3, 'Glue Stick', 1.85)");
		System.out.println("inventory table created and records inserted...");
	}

}
