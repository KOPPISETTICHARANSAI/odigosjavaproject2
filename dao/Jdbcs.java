package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Jdbcs {
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		   Class.forName("com.mysql.cj.jdbc.Driver");
		   Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/productManagement","root","BhardwajSai@123");
		   return conn;
	   }

	
	
	
	
}
