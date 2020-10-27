package com.dao;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.model.Article;
import com.util.DBInteraction;

import panier.panier;

public class DaoPanier  implements IPanier {
	//Ajouter au panier 
	
	public int ajouterLivre(panier a)
	{
		DBInteraction.connect();
		String sql="insert into panier(id,nomlivre,prixlivre) values("+a.getId()+",'"+a.getNom_livre()+"',"+a.getPrix_livre()+")";
		int n=DBInteraction.Maj(sql);
		DBInteraction.disconnect();
		return n;
		
	}
	public int vider()
	{
		DBInteraction.connect();
		String sql="delete from panier";
		int n=DBInteraction.Maj(sql);
		DBInteraction.disconnect();
		return n;
	}
	public ArrayList<panier> Alllivres()
	{
		ArrayList<panier> ps=new ArrayList<>();
		DBInteraction.connect();
		String sql="select * from panier ";
		ResultSet rs = DBInteraction.Select(sql);
		try {
			while(rs.next())
			{
				panier a =new panier(rs.getInt(1), rs.getString(3), rs.getDouble(4));
			
				ps.add(a);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		DBInteraction.disconnect();
		
		
		return ps;
		
	}
	
	public int deleteliv(int id)
	{
		DBInteraction.connect();
		String sql="delete from panier where id="+id;
		int n=DBInteraction.Maj(sql);
		DBInteraction.disconnect();
		return n;
	}
	
}
