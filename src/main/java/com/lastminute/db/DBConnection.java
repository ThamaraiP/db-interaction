package com.lastminute.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
	private Connection con;

	public void getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/db-interaction", "root", "test123");
	}

	public ResultSet executeQuery(String query) throws SQLException {
		Statement stmt = con.createStatement();
		ResultSet rs = stmt
				.executeQuery(query);
		return rs;
	}

	public void closeConnection() throws SQLException {
		con.close();
	}
}
