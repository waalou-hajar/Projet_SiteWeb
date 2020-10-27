package com.dao;


import java.sql.Date;
import java.util.ArrayList;

import com.model.Article;

public interface IArticle {

	public int AddArticle(Article a);
	public int AddArticle(int id ,String desc , double prix , int qte , String img);
	public Article FindArticle(int id);
	public int deleteArticle(int id);
	public int UpdateArticle(int id,Article a);
	public ArrayList<Article> AllArticle();
	
	
	
}
