package com.lastminute.demo;

import java.sql.SQLException;
import java.util.Calendar;

import com.lastminute.db.DBConnection;

public class Indexing2 {
	
	
	public static void main(String[] arg) throws ClassNotFoundException, SQLException {
		
		DBConnection dbConnection = new DBConnection();
		dbConnection.getConnection();
		long startTime = Calendar.getInstance().getTimeInMillis();
		dbConnection.executeQuery("select * from employee where department_id = 1 and first_name like 'M%';");
		System.out.println("TimeTaken" + (Calendar.getInstance().getTimeInMillis() - startTime));
		dbConnection.closeConnection();
		
		/*create index by_first_name on employee(first_name);*/
	}
}
