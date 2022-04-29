package com.training.dao;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.training.util.DBUtil;

public class LoginDao {
public boolean validateUser(String username,String password)
{
	Connection conn=null;
	boolean valid=false;
	try {
		conn = DBUtil.getConnection();
		PreparedStatement st=conn.prepareStatement("select * from admin where username=? and password=?");
		st.setString(1, username);
		st.setString(2, password);
		ResultSet rs=st.executeQuery();
		if(rs.next())
		{
			valid=true;
		}
		
	} catch (ClassNotFoundException e) {
		
		e.printStackTrace();
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
   return valid;
	}
/*public List<User> listUsers()  
{
	List<User> lst=new ArrayList<User>();
	Connection con=null;
	ResultSet rs=null;
	try {
	 con= DBUtil.getConnection();
		String qryString = "select * from user_info";
		PreparedStatement ps = con.prepareStatement(qryString);
		rs=ps.executeQuery();
		while(rs.next())
		{
			User obj=new User();
			obj.setfName(rs.getString(1));
			obj.setlName(rs.getString(2));
			obj.setPassword(rs.getString(3));
			obj.setAge(rs.getInt(4));
			obj.setAddress(rs.getString(5));
			obj.setGender(rs.getString(6));
			obj.setCountry(rs.getString(7));
			lst.add(obj);
		} 
		System.out.println("list from dao="+lst);
	}
	catch(SQLException e)
	{
	e.printStackTrace();
	}
	catch (ClassNotFoundException e) {
	e.printStackTrace();
	}
	
	return lst;
	
}*/
}