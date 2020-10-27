package panier;

import com.model.Article;
import java.util.ArrayList;
import java.util.Collections;

public class panier
{

 private int id;
 private String nom_livre;
 private Double prix_livre;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}

public String getNom_livre() {
	return nom_livre;
}
public void setNom_livre(String nom_livre) {
	this.nom_livre = nom_livre;
}
public Double getPrix_livre() {
	return prix_livre;
}
public void setPrix_livre(Double prix_livre) {
	this.prix_livre = prix_livre;
}
public panier(int id, String nom_livre, Double prix_livre) {
	super();
	this.id = id;

	this.nom_livre = nom_livre;
	this.prix_livre = prix_livre;
}
 
 

    
}