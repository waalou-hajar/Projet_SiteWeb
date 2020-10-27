package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ArticleDao;
import com.dao.UserDao;


@WebServlet("/SUPClient")
public class SUPClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SUPClient() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		UserDao ad= new UserDao();	
		ad.deleteUser(id);
		request.getRequestDispatcher("les_clients.jsp").forward(request, response);	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
