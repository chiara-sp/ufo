package it.polito.ufo.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {

	

	public static Connection getConnection() throws SQLException {
		String jdbcURL= "jdbc:mysql://localhost/ufo_sightings?user=root&password=mysql123";
		return DriverManager.getConnection(jdbcURL);
	}
}
