package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.dao.DaoPanier;
import com.model.Article;
import panier.panier;


@WebServlet("/ServletPanier")
public class ServletPanier extends HttpServlet {
	private static final long serialVersionUID = 1L;
       DaoPanier dp=  new DaoPanier();
    public ServletPanier() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		int id =Integer.parseInt(request.getParameter("id"));
		String nom=request.getParameter("nom");
		double prix=Double.parseDouble(request.getParameter("prix"));
		System.out.println(nom+prix+id);
		panier p= new panier(id,nom,prix);
		if(p!=null)
		System.out.println(p.getId());
		int n=dp.ajouterLivre(p);
      request.getRequestDispatcher("les_livrespanier.jsp").forward(request, response);	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
