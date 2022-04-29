package com.training.jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FetchDemo {
	public static void main(String[] args) {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			Driver driver = new com.mysql.cj.jdbc.Driver();
			DriverManager.registerDriver(driver);
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ems", "root", "root");
			System.out.println("connection=" + conn);
			st = conn.createStatement();
			rs = st.executeQuery("select * from employee");
			System.out.println("Id \t\t Name \t\t Job\t\t Salary");
			while (rs.next()) {
				// System.out.println(rs.getInt(1) +" "+rs.getString(2));
				System.out.println(rs.getString("empid") + "\t\t" + rs.getString("empname") + "\t \t"
						+ rs.getString("job") + "\t \t" + rs.getString("salary"));
			}
		} catch (SQLException e) {
			System.out.println(e.getErrorCode() +" "+e.getMessage());
			//e.printStackTrace();
		} 
			//finally {
//			try
//			{
//				//conn.close();
//			//rs.close();
//			//st.close();
//			
//			}
//			catch(SQLException e)
//			{
//				System.out.println(e.getErrorCode() +" "+e.getMessage());
//			}
//
//		}

	}
}


