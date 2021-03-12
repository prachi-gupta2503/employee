package com.adj.warehouse.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GetConnection {
	
	public static Connection connection() throws ClassNotFoundException, SQLException {

		Connection connection = null;
		
		Class.forName("com.mysql.cj.jdbc.Driver");
	    connection=  DriverManager.getConnection("jdbc:mysql://localhost:3306/warehouse?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
	    return connection;
	}

}
