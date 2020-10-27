package com.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDao;
import com.model.User;

/**
 * Servlet implementation class inscreption
 */

@WebServlet("/inscreption")
public class inscreption extends HttpServlet {
	private static final long serialVersionUID = 1L;
       // la variable
	UserDao um;
   
    public inscreption() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    //************ init **********
public void init(ServletConfig config) throws ServletException {
	super.init();
	um=new UserDao();
		
	}
//**************** DE GET **********

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom=request.getParameter("nom");
		String login=request.getParameter("login");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		String op=request.getParameter("btn");
		
		System.out.println(nom+""+login+" get");
		
	}

	//************ DE POST ********************
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		String nom=request.getParameter("nom");
		String login=request.getParameter("login");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		String op=request.getParameter("btn");
		
		System.out.println(nom+""+login+" post");
		if(op.equals("Register"))
		{
			User u = new User(nom,login,password,email);
			um.AddUser(u);	
		/*HttpSession ses =request.getSession();
				ses.setAttribute("user", u);
				response.sendRedirect("bienvenu2");*/
			//response.sendRedirect("login");
			request.getRequestDispatcher("register.jsp").forward(request, response);
			
			}
			
			}
		
		
		
	}


