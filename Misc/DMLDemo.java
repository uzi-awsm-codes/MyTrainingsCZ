package com.training.jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DMLDemo {
	public static void main(String[] args) {
		// Driver driver = new oracle.jdbc.driver.OracleDriver();
		Connection conn = null;
		Statement st = null;
		int rows = 0;
		try {
			Driver driver = new com.mysql.cj.jdbc.Driver();
			DriverManager.registerDriver(driver);
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useSSL=false", "root", "root");
			// conn = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl",
			// "scott", "tiger");
			st = conn.createStatement();
//			int result = st.executeUpdate("create table student(regno int,sname varchar(20),subject1 int,subject2 int,subject3 int ,total int)");
//			System.out.println(result);
			rows = st.executeUpdate(
					"insert into student(sname,regno,subject1,subject2,subject3) values('c',3,77,87,90)");
			System.out.println(rows + " row inserted");
			rows = st.executeUpdate(
					"insert into student(sname,regno,subject1,subject2,subject3) values('d',4,88,99,90)");
			System.out.println(rows + " row inserted");
			rows = st.executeUpdate("update student set total=subject1+subject2+subject3");
			System.out.println(rows + "rows  updated");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {

				st.close();
				conn.close();

			} catch (SQLException e) {
				System.out.println(e.getErrorCode() + " " + e.getMessage());
			}

		}
	}

}
