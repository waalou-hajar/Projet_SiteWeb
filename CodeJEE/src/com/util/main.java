package com.util;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.dao.UserDao;
import com.model.User;

public class main {

	public static void main(String[] args) {
		User u=null;
		UserDao u1=new UserDao();
		u=u1.Auth("hajar","hajar@123");
		System.out.println("684"+u.toString()); 

	
	
}
}
