package com.phucle.derby;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class QueryInventoryDB {
	public static final String SQL_STATEMENT = "SELECT * from inventory";

	public static void main(String[] args) throws SQLException {
		Connection connection = DriverManager
				.getConnection(CreateInventoryDB.JDBC_DERBYURL);
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(SQL_STATEMENT);
		ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
		int columnCount = resultSetMetaData.getColumnCount();
		for (int x = 1; x <= columnCount; x++)
			System.out.format("%-15s", resultSetMetaData.getColumnName(x));
		while (resultSet.next()) {
			System.out.println();
			//for (int x = 1; x <= columnCount; x++)
				System.out.format("%-15s", resultSet.getInt("inventoryId"));
				System.out.format("%-15s", resultSet.getString("itemName"));
				System.out.format("%-15s", "$"+ resultSet.getDouble("itemPrice"));
		}
		statement.close();
		connection.close();
	}
}
