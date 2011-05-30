package com.baxter.qa.dbunittest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.junit.Test;

public class AppTest {

	@Test
	public void testDBConnection() {

	    try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Connection conn = null;
		Properties connectionProps = new Properties();
		connectionProps.put("user", "qa");
		connectionProps.put("password", "qa");

		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.9.221:1521:BAXTERDB",connectionProps);
			System.out.println("Connected to database");
			conn.close();
		} catch (SQLException e){
			e.printStackTrace();
		}
	}

}
