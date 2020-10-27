package com.dao;

import com.model.Admin;

import com.model.User;
import com.util.DBInteraction;

public class AdminDao implements Iadmin {
	@Override 
	public int Valide(User u) {
		DBInteraction.connect();
		String sql="select * from Admin where nomAmin='"+u.getNom()+"' and emailAdmin='"+u.getEmail()+"'";
		int n=DBInteraction.EstAdmin(sql);
		DBInteraction.disconnect();
		return n;
	}

}
