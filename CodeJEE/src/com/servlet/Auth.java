package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.AdminDao;
import com.dao.UserDao;
import com.model.Admin;
import com.model.User;
import com.util.DBInteraction;

/**
 * Servlet implementation class aurh
 */
@WebServlet("/Auth")
public class Auth extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDao um ;
    AdminDao ad ;
       
   
    public Auth() {//
    	  super();
          um = new UserDao();
          ad = new AdminDao();
          // TODO Auto-generated constructor stub
      }

  	/**
  	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
  	 */
  	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  		// TODO Auto-generated method stub
  		
  		
  		
  		//PrintWriter out = response.getWriter();
  		String nom=request.getParameter("nom");
  		String email=request.getParameter("email");
  		//System.out.println(nom + email);
  		User u =um.Auth(nom,email);
  		/* **System.out.println(u.getEmail());
  		int v=ad.Valide(u);
  		*/
  		
  		if(u!=null)
  		{   
  			if(u.getNom().equals("hajar") &&  u.getEmail().equals("hajar@123"))
  			{
  				request.getRequestDispatcher("les_articles.jsp").forward(request, response);	
  		    }
  		
  			else {
  				HttpSession ses =request.getSession();
  				ses.setAttribute("user", u);
  			request.getRequestDispatcher("Shop.html").forward(request, response);	
  				
  		        }
  		}
  		
  		else{
  			request.getRequestDispatcher("register.jsp").forward(request, response);
  		}
  		
  		
  		
  		
  		
  		
  		
  	}

  	/**
  	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
  	 */
  	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  		// TODO Auto-generated method stub
  		doGet(request, response);
  	}

  }
