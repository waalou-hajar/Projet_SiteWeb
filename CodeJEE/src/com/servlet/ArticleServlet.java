package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.ArticleDao;
import com.model.Admin;
import com.model.Article;
@WebServlet("/ArticleServlet")
public class ArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	  ArticleDao am=new ArticleDao();
    public ArticleServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    PrintWriter out=response.getWriter();
	    HttpSession ses=request.getSession();
	    Admin A=(Admin)ses.getAttribute("Admin");
	    out.println("BienVenu Mr "+A.getNomAdmin()+"l'admin de site");
	    if(request.getParameter("op")!= null)
	    {
	    	if(request.getParameter("op").equals("d"))
	    	{
	    		int id=Integer.parseInt(request.getParameter("desc"));
		    	am.deleteArticle(id);
	    	}
	    	else
	    	{
	    		if(request.getParameter("op").equals("u"))
	    				{
	    			// recuperer les donnes
	    			int id=Integer.parseInt(request.getParameter("id"));
	    			String desc=request.getParameter("desg");
	    			double prix=Double.parseDouble(request.getParameter("prix"));
	    			int qte= Integer.parseInt(request.getParameter("qte"));
	    			String img=request.getParameter("img");
	    			Article a=new Article(desc,prix,qte,img);
	    			am.UpdateArticle(id, a);
	    			response.sendRedirect("ArticleServlet");
	    				}
	    		
	    	}
	    
	    }
	    out.println(" <h1> style='text-align:center'; style='color:blue'> Liste des Articles </h1>");
	    ArrayList<Article> ps=am.AllArticle();
	    out.println("<table>");
	    out.println("<tr><td>Description</td><td>Prix</td><td>Qantité</td><td>Img</td></tr>");
	    for(int i=0;i<ps.size();i++)
	    {
	    	if(request.getParameter("op")!=null)
	    	{
	    		if(request.getParameter("op").equals("m"))
	    		{
	    			int id=Integer.parseInt(request.getParameter("id"));
	    			if(id==ps.get(i).getId())
	    			{
	    				out.println("<from action='deleteArt' ><tr><td ><input type='text' readonly value='"+ps.get(i).getId()+"' name='id'></td><td>");
	    				out.println("<td ><input type='text'value='"+ps.get(i).getDesc()+"' name='desc'></td>");
	    				out.println("<td ><input type='text'value='"+ps.get(i).getPrix()+"' name='prix'></td>");
	    				out.println("<td ><input type='number'value='"+ps.get(i).getQte()+"' name='qte'></td>");
	    				out.println("<td ><input type='text'value='"+ps.get(i).getImg()+"' name='img'></td><td><input type='hidder' name='op' value='u'</td>");
	    				
	    				out.println("<td ><input type='submit'value='valider' name=''> <input type='rest'value='annuler' name=''></td></tr></from>");
	    			}
	    			else {
	    				out.println("<tr><td>"+ps.get(i).getId()+"</td><td>"+ps.get(i).getDesc()+"</td> <td>"+ps.get(i).getPrix()+"</td><td>"+ps.get(i).getQte()+"</td><td>"+ps.get(i).getImg()+"</td><td><a href='?id="+ps.get(i).getId()+"&op=d'>supprimer</td>");
	    		    	out.println("- <td><a href='?id="+ps.get(i).getId()+"&op=m'>Modifier</td></tr>");
	    			}
	    		}
	    	}
	    	
	    	out.println("<tr><td>"+ps.get(i).getId()+"</td><td>"+ps.get(i).getDesc()+"</td> <td>"+ps.get(i).getPrix()+"</td><td>"+ps.get(i).getQte()+"</td><td>"+ps.get(i).getImg()+"</td><td><a href='?id="+ps.get(i).getId()+"&op=d'>supprimer</td>");
	    	out.println("- <td><a href='?id="+ps.get(i).getId()+"&op=m'>Modifier</td></tr>");
	    	
	    }
	    
	    out.println("</table>");
	    out.println("<a href='addArticle.html'>Ajouter un Article</a>");
	    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
