package com.dao;

import java.util.ArrayList;

import com.model.Admin;
import com.model.User;


public interface Iuser {
	
	public void AddUser(User p);
	public User FindUser(int id);
	public int deleteUser(int id);
	public int UpdateUser(int id,User p);
	public ArrayList<User> AllUser();
	User Auth(String codeu, String pass);
	public Admin AuthAdmin(String codeu, String pass);
	int AddUser(String nom, String login, String password, String email);
	
}
