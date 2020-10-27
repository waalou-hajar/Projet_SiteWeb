

package com.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.model.Admin;
import com.model.User;
import com.util.DBInteraction;

public class UserDao implements Iuser{
/*************************ajouter user*************************/
	@Override
	public void AddUser(User p) {

		DBInteraction.connect();
		String sql="insert into user(nom,login,password,email) values('"+p.getNom()+"','"+p.getLogin()+"','"+p.getPassword()+"','"+p.getEmail()+"')";
		int n=DBInteraction.Maj(sql);
		DBInteraction.disconnect();
		//return n;
		
	}
/***************************ajouter parametre********************/
	@Override
	public int AddUser(String nom, String login, String password, String email) {
		DBInteraction.connect();
		String sql="insert into user(nom,login,password,email) values('"+nom+"','"+login+"','"+password+"','"+email+"')";
		int n=DBInteraction.Maj(sql);
		DBInteraction.disconnect();
		return n;
			}
			
/****************************Recherche user*************************/
   @Override
	public User FindUser(int id) {
		
		User p=null;
		DBInteraction.connect();
		String sql="select * from user where id="+id;
		ResultSet rs = DBInteraction.Select(sql);
		try {
			if(rs.next())
			{
				p=new User(rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5));
				p.setId(rs.getInt(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBInteraction.disconnect();
		
		return p;
	}
/***************************************Supprimer user***********************/
	@Override
	public int deleteUser(int id) {
		DBInteraction.connect();
		String sql="delete from user where id="+id;
		int n=DBInteraction.Maj(sql);
		DBInteraction.disconnect();
		return n;	
	}
/**************************************Modifier user***********************/
	@Override
	public int UpdateUser(int id, User u) {
		DBInteraction.connect();
		String sql="update users set nom='"+u.getNom()+"' ,login='"+u.getLogin()+"', password='"+u.getPassword()+"',email='"+u.getEmail()+"' where id="+id;
		int nb=DBInteraction.Maj(sql);
		DBInteraction.disconnect();
		return nb;
	}
	
/*************************************Consulter************************/
	@Override
	public ArrayList<User> AllUser() {
		ArrayList<User> ps=new ArrayList<>();
		DBInteraction.connect();
		String sql="select * from user ";
		ResultSet rs = DBInteraction.Select(sql);
		try {
			while(rs.next())
			{
				
				User p=new User(rs.getString(2), rs.getString(3), 
						rs.getString(4),rs.getString(5));
				p.setId(rs.getInt(1));
				ps.add(p);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		DBInteraction.disconnect();
		
		
		return ps;
	}
/**********************************Authentification**********************************/
	@Override
	public Admin AuthAdmin(String nom, String email) {
		Admin u = null;
		DBInteraction.connect();
		String sql="select * from Admin where nomAdmin='"+nom+"' and emailAdmin='"+email+"'";
		ResultSet rs = DBInteraction.Select(sql);
		
		try {
			if(rs.next())
			{
				 u=new Admin(rs.getString(2), rs.getString(3));
				 u.setId(rs.getInt(1));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		DBInteraction.disconnect();
		return u;
	}
	public User Auth(String nom, String email) {
		User u=null;
		DBInteraction.connect();
		String sql="select * from user where nom='"+nom+"' and email='"+email+"'";
		ResultSet rs = DBInteraction.Select(sql);
		
		try {
			if(rs.next())
			{
				u=new User(rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5));
				u.setId(rs.getInt(1));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		DBInteraction.disconnect();
		return u;
	}


}
