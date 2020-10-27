package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ArticleDao;

@WebServlet("/addArticle")
public class addArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
	  ArticleDao am=new ArticleDao();
       
    
    public addArticle() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		int id = Integer.parseInt(request.getParameter("id"));
		String desc=request.getParameter("desg");
		double prix=Double.parseDouble(request.getParameter("prix"));
		int qte= Integer.parseInt(request.getParameter("qte"));
		String img=request.getParameter("img");
		am.AddArticle(id,desc, prix, qte, img);
		request.getRequestDispatcher("les_articles.jsp").forward(request, response);	
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
