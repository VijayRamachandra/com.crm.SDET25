package com.crm.SDET25.Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteUpdate {
	
	@Test
	public void sampleJDBCExecuteupdate() throws Throwable {
		Connection conn=null;
		try {
		//step 1:Register the database
			Driver driverRef=new Driver();
			DriverManager.registerDriver(driverRef);
			
		//Step 2:Get connection with database - provide db name
		 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentsdb", "root", "root");
			
		//Step 3:Issue create statement
			Statement stat = conn.createStatement();
					
		//Step 4:Execute a query - Provide table name
			int result = stat.executeUpdate("insert into studentinfo values('Nethra',17,'USA')");
			
		if (result==1)
		{
			System.out.println("Data Created");
		}
		else {
			System.out.println("Data Creation Failed");
		}
		}
		catch(Exception e)
		{
			
		}
		finally {
		//Step 5: close the database
		conn.close();
		System.out.println("connection is closed");
		}
	}
	

}
