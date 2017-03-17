package com.lastminute.demo;

import java.sql.SQLException;
import java.util.Calendar;

import com.lastminute.db.DBConnection;

public class Misc {

	public static void main(String[] arg) throws ClassNotFoundException,
			SQLException {

		DBConnection dbConnection = new DBConnection();
		dbConnection.getConnection();
		long startTime = Calendar.getInstance().getTimeInMillis();
		dbConnection
				.executeQuery("SELECT p.product_name, type, name "
						+ "FROM Product p, Product_association pa "
						+ "WHERE p.id = pa.product_id;");
		System.out.println("TimeTaken"
				+ (Calendar.getInstance().getTimeInMillis() - startTime));
		startTime = Calendar.getInstance().getTimeInMillis();
		dbConnection
				.executeQuery("SELECT p.product_name"
						+ ", Min(case when pa.Type = 'Category' then pa.Name end) Category"
						+ ", Min(case when pa.Type = 'Seller' then pa.Name end) Seller"
						+ " FROM Product p, Product_association pa"
						+ " WHERE p.id = pa.product_id"
						+ " GROUP BY p.product_name;");
		System.out.println("TimeTaken"
				+ (Calendar.getInstance().getTimeInMillis() - startTime));
		dbConnection.closeConnection();
	}
}
