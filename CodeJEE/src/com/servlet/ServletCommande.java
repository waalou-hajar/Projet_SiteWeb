package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.DaoCommande;

import panier.Commande;
import panier.panier;


@WebServlet("/ServletCommande")
public class ServletCommande extends HttpServlet {
	private static final long serialVersionUID = 1L;
  DaoCommande dc= new DaoCommande();
    public ServletCommande() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		int id =Integer.parseInt(request.getParameter("id"));
		String nom=request.getParameter("nom");
		double prix=Double.parseDouble(request.getParameter("prix"));
		System.out.println(nom+prix+id);
		Commande c= new Commande(id,nom,prix);
		if(c!=null)
		System.out.println();
		int n=dc.ajoutercommande(c);
      request.getRequestDispatcher("shop.html").forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
