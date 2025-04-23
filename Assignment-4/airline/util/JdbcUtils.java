package com.airline.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUtils {
	private static Connection con;
	public static Connection getDbConnection() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection
				("jdbc:mysql://localhost:3306/box_office","root","password");
		return con;
	}
	

}
