package com.crm.SDET25.Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteQuery {

	@Test
	public void sampleJDBCExecuteQuery() throws Throwable
	{
		//Step 1: Register the database
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		
		//step 2:  Get connection with database - provide db name
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentsdb", "root", "root");
		
		//Step 3: Issue create statement
		Statement stat = conn.createStatement();
		
		//Step 4: Execute a query - Provide table name
		ResultSet result = stat.executeQuery("select * from studentinfo;");
		
		while (result.next())
		{
			System.out.println(result.getString(1)+" "+result.getString(2)+" "+result.getString(3));
		}
		
		//Step 5: close the database
		conn.close();
		
		
		
	}
}
