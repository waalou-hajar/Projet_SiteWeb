package com.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.model.Article;
import com.util.DBInteraction;

public class ArticleDao implements IArticle{
/***********************************************Ajouter un document********************************/
	@Override 
	public int AddArticle(Article a) {

		DBInteraction.connect();
		String sql="insert into Article(des,prix,qte,img) values('"+a.getDesc()+"','"+a.getPrix()+"',"+a.getQte()+",'"+a.getImg()+"')";
		int n=DBInteraction.Maj(sql);
		DBInteraction.disconnect();
		return n;
	}
/***********************************AJouter les para************************************************/
	@Override
	public int AddArticle( int id ,String desc, double prix , int qte ,String img) {
		DBInteraction.connect();
		String sql="insert into Article(id,des,prix,qte,img) values("+id+"'"+desc+"','"+prix+"',"+qte+",'"+img+"')";
		int n=DBInteraction.Maj(sql);
		DBInteraction.disconnect();
		return n;	}
/*********************************************Recherche document*********************************/
	@Override
	public Article FindArticle(int id) {
		
		Article a=null;
		DBInteraction
		.connect();
		String sql="select * from produit where id="+id;
		ResultSet rs = DBInteraction.Select(sql);
		try {
			if(rs.next())
			{
				a=new Article(rs.getString(2), rs.getDouble(3), rs.getInt(4), rs.getString(5));
				a.setId(rs.getInt(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBInteraction.disconnect();
		
		return a;
	}
/************************************Supprimer document***************************************/
	@Override
	public int deleteArticle(int id) {
		DBInteraction.connect();
		String sql="delete from produit where id="+id;
		int n=DBInteraction.Maj(sql);
		DBInteraction.disconnect();
		return n;	
	}
/**************************************modifier Dociment************************************/
	@Override
	public int UpdateArticle(int id, Article a) {
		
		DBInteraction.connect();
		String sql="update users set 'des'='"+a.getDesc()+"' ,'prix'='"+a.getPrix()+"','qte'='"+a.getQte()+"','email'='"+a.getImg()+"' where 'id'="+id;
		int nb=DBInteraction.Maj(sql);
		DBInteraction.disconnect();
		return nb;
	}
/***********************************Consulter Document***************************************/
	@Override
	public ArrayList<Article> AllArticle() {
		ArrayList<Article> ps=new ArrayList<>();
		DBInteraction.connect();
		String sql="select * from produit ";
		ResultSet rs = DBInteraction.Select(sql);
		try {
			while(rs.next())
			{
				Article a =new Article(rs.getString(2), rs.getDouble(3), rs.getInt(4), rs.getString(5));
				a.setId(rs.getInt(1));
				ps.add(a);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		DBInteraction.disconnect();
		
		
		return ps;
	}

}
