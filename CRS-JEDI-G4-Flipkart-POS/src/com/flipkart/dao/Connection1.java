/** */
package com.flipkart.dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;

// TODO: Auto-generated Javadoc
/**
 * The Class Connection1.
 *
 * @author Shravya
 */
public class Connection1 {

  /** The Constant JDBC_DRIVER. */
  static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

  /** The Constant DB_URL. */
  static final String DB_URL = "jdbc:mysql://localhost/crs";

  /** The Constant USER. */
  //  Database credentials
  static final String USER = "root";

  /** The Constant PASS. */
  static final String PASS = "root";

  /** The connection instance. */
  private static java.sql.Connection connectionInstance = null;

  /**
   * Gets the connection.
   *
   * @return the connection
   */
  public static java.sql.Connection getConnection() {
    if (connectionInstance != null) return connectionInstance;
    java.sql.Connection conn = null;
    PreparedStatement stmt = null;

    try {

      // Step 3 Register Driver here and create connection

      Class.forName("com.mysql.jdbc.Driver");

      // Step 4 make/open  a connection

      //			System.out.println("Connecting to database...");
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
