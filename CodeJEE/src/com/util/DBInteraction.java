package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBInteraction {

	static String url="jdbc:mysql://localhost:3308/ecommerce";
	static Connection con;
	static Statement st;

	public static  void connect()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(url, "root", "");
		st = con.createStatement();	
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

public static void disconnect()
{
	try {
		con.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

public static int Maj(String sql)
{
	int n = 0;
	try {
		n = st.executeUpdate(sql);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return n;
}

public static ResultSet Select(String sql)
{
	ResultSet rs = null;
	try {
		rs = st.executeQuery(sql);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return rs;
}

///******************** fonction pour admin*****************
public static int EstAdmin(String sql)
{
	ResultSet rs = null;
	try {
		rs = st.executeQuery(sql);
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	if(rs==null)
	{
		return 0;
	}
	else {
		return 1;
	}
}


}
