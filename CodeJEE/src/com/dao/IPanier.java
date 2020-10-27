package com.dao;

import java.util.ArrayList;

import com.model.Article;

import panier.panier;

public interface IPanier {
     
	public int ajouterLivre(panier a );
	public int vider();
	public ArrayList<panier> Alllivres();
	public int deleteliv(int id);
}
