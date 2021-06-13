/**
 * 
 */
package com.flipkart.dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Shravya
 *
 */
public class Connection1 {

	/**
	 * @param args
	 */
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/crs";

	//  Database credentials
	static final String USER = "root";
	static final String PASS = "root";

	private static java.sql.Connection connectionInstance = null;

	public static java.sql.Connection getConnection() {
		if (connectionInstance != null)
			return connectionInstance;
		java.sql.Connection conn = null;
		PreparedStatement stmt = null;

		try {

			// Step 3 Register Driver here and create connection

			Class.forName("com.mysql.jdbc.Driver");

			// Step 4 make/open  a connection

			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
		}
		// TODO Auto-generated method stub
		catch (Exception e) {
			System.out.println(e);
		}
//		connectionInstance = conn;
		return conn;
	}

}
