package com.training.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
public class DBUtil {
	public static Connection getConnection() throws ClassNotFoundException, SQLException
	{
		Connection conn=null;
		  ResourceBundle bundle=ResourceBundle.getBundle("connection");
	    	 String driver= bundle.getString("driver");
	    	 String url=bundle.getString("url");
	    	 String username=bundle.getString("username");
	    	 String password=bundle.getString("password");
	    	 Class.forName(driver);
	    	 conn = DriverManager.getConnection(url, username,password);
	    	 return conn;
	}

}
