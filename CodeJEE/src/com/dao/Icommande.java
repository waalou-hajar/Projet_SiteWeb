package com.dao;

import java.util.ArrayList;

import com.model.Article;

import panier.Commande;
import panier.panier;


public interface Icommande {
	public int ajoutercommande(Commande c );
   public ArrayList<Commande> AllCommande();

     
}
