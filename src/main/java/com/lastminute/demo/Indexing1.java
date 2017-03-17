package com.lastminute.demo;

import java.sql.SQLException;
import java.util.Calendar;

import com.lastminute.db.DBConnection;

public class Indexing1 {
	
	
	public static void main(String[] arg) throws ClassNotFoundException, SQLException {
		
		DBConnection dbConnection = new DBConnection();
		dbConnection.getConnection();
		long startTime = Calendar.getInstance().getTimeInMillis();
		dbConnection.executeQuery("SELECT * FROM students WHERE last_name = 'Smith';");
		System.out.println("TimeTaken" + (Calendar.getInstance().getTimeInMillis() - startTime));
		startTime = Calendar.getInstance().getTimeInMillis();
		dbConnection.executeQuery("SELECT * FROM students WHERE class = '3A';");
		System.out.println("TimeTaken" + (Calendar.getInstance().getTimeInMillis() - startTime));
		startTime = Calendar.getInstance().getTimeInMillis();
		dbConnection.executeQuery("SELECT * FROM students WHERE class = '3A' and last_name = 'Smith';");
		System.out.println("TimeTaken" + (Calendar.getInstance().getTimeInMillis() - startTime));
		dbConnection.closeConnection();
		
		/*CREATE INDEX by_last_name ON students (`last_name`);
		  CREATE INDEX by_class ON students (`class`);
		  drop INDEX by_class ON students;
		  CREATE INDEX by_class_and_last_name ON students (class, last_name);*/
	}
}
