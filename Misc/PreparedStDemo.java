package com.training.jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PreparedStDemo {

	static Connection getConnection() throws SQLException {
		Connection conn = null;
		Driver driver = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(driver);
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useSSL=false", "root", "root");
		return conn;
	}

	void create(int regno, String sname, int m1, int m2, int m3) throws SQLException {
		PreparedStatement ps = null;
		Connection conn = getConnection();
		String query = "insert into student(regno,sname,subject1,subject2,subject3) values(?,?,?,?,?)";
		ps = conn.prepareStatement(query);
		ps.setInt(1, regno);
		ps.setString(2, sname);
		ps.setInt(3, m1);
		ps.setInt(4, m2);
		ps.setInt(5, m3);
		int rows = ps.executeUpdate();
		System.out.println(rows + "row  inserted");
		conn.close();
	}

	void read(int total) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection conn = getConnection();
		String query = "select sname,total from student where total >?";
		ps = conn.prepareStatement(query);
		ps.setInt(1, total);
		rs = ps.executeQuery();
		System.out.println("Students with score greater than" + total);
		while (rs.next()) {
			System.out.println(rs.getString("sname") + " " + rs.getInt("total"));
		}
		conn.close();
	}

	void update(int regno) throws SQLException {
		PreparedStatement ps = null;
		Connection conn = getConnection();
		String query = "update student set total=subject1+subject2+subject3 where regno=?";
		ps = conn.prepareStatement(query);
		ps.setInt(1, regno);
		int res = ps.executeUpdate();
		System.out.println(res + " row updated");
		conn.close();
	}

	void delete(int regno) throws SQLException {
		PreparedStatement ps = null;
		Connection conn = getConnection();
		String query = "delete from student where regno=?";
		ps = conn.prepareStatement(query);
		ps.setInt(1, regno);
		int res = ps.executeUpdate();
		System.out.println(res + " row deleted");
		conn.close();
	}

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStDemo obj = new PreparedStDemo();
		Scanner scanner = new Scanner(System.in);
		int regno, m1, m2, m3, total;
		String sname, choice;
		int ch;

		do {
			System.out.println("CRUD Application");
			System.out.println("1.Create \n 2.Read \n 3.Update \n4.Delete");
			System.out.println("Enter choice");
			ch = scanner.nextInt();
			switch (ch) {
			case 1:
				System.out.println("Enter student regno,name and marks in 3 subjects");
				regno = scanner.nextInt();
				sname = scanner.next();
				m1 = scanner.nextInt();
				m2 = scanner.nextInt();
				m3 = scanner.nextInt();
				try
				{
				obj.create(regno, sname, m1, m2, m3);
				}
				catch(SQLException e)
				{
					System.out.println(e.getMessage());
				}
				break;
			case 2:
				System.out.println("Enter total");
				total = scanner.nextInt();
				try
				{
				obj.read(total);
				}
				catch(SQLException e)
				{
					System.out.println(e.getMessage());
				}
				break;

			case 3:
				System.out.println("Enter regno to update total");
				regno = scanner.nextInt();
				try
				{
				obj.update(regno);
				}
				catch(SQLException e)
				{
					System.out.println(e.getMessage());
				}
				break;
			case 4:
				System.out.println("Enter regno to delete");
				regno = scanner.nextInt();
				try
				{
				obj.delete(regno);
				}
				catch(SQLException e)
				{
					System.out.println(e.getMessage());
				}
				break;
			default:
				System.out.println("Invalid choice");
			}

			System.out.println("want to continue");
			choice = scanner.next();
		} while (choice.equals("yes"));

	}
}
