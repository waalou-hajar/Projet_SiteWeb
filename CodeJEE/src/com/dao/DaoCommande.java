package com.dao;

import java.sql.ResultSet;


import java.sql.SQLException;
import java.util.ArrayList;

import com.util.DBInteraction;


import panier.Commande;
import panier.panier;

public class DaoCommande implements Icommande {
	public int ajoutercommande(Commande c)
	{
		DBInteraction.connect();
		String sql="insert into comm(idc,nomc,prixc) values("+c.getIdCommande()+",'"+c.getNom_client()+"',"+c.getPrixTotale()+")";
		int n=DBInteraction.Maj(sql);
	DBInteraction.disconnect();
		return n;
		
	}

	public ArrayList<Commande> AllCommande()
	{
		
			ArrayList<Commande> ps=new ArrayList<>();
			DBInteraction.connect();
			String sql="select * from com";
			ResultSet rs = DBInteraction.Select(sql);
			try {
				while(rs.next())
				{
					Commande c =new Commande(rs.getInt(1),rs.getString(2), rs.getDouble(4));
				
					ps.add(c);
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			DBInteraction.disconnect();
			
			
			return ps;
			
		}
	}

