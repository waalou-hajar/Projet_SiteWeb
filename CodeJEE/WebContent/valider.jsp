<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@page  import="java.sql.*"%>
      <%@page import="java.util.ArrayList"%>
    <%@page import="com.dao.ArticleDao"%>
<%@page import="com.model.Article"%>
<%@page import="com.dao.DaoPanier"%>
    <%
	String url = "jdbc:mysql://localhost/ecommerce";
	String driver = "com.mysql.jdbc.Driver";
	Class.forName(driver).newInstance();
	Connection con = DriverManager.getConnection(url, "root", "");
	PreparedStatement stmt = con.prepareStatement("select * from panier;");
	ResultSet resultats = stmt.executeQuery();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> FIN d'achter </title>
</head>
<body style="background-color:pink;">

  <h1 style="text-align:center;" style="color:blue;" > votre Commande : </h1>
<%      
            double p=0;
            String s="";
			boolean encore = resultats.next();
			while (encore) {
				p=p+resultats.getDouble(3);
				s=s+resultats.getString(2)+"";
				encore = resultats.next();
			}
		%>
 <b style="color:green;" >les livres acheter est :</b>  <%=s %></br> </br>
<b style="color:green;">  le prix totale de votre Commande est :</b><%=p %>
</br>
</br>
<%
   DaoPanier d=new DaoPanier();
  d.vider();
%>

 Enregistrer votre commande a l'administrateur : -----------> <a href="cmdadmin.jsp">Enregistrer</a>
 
 </br>
 </br>
<a href="login.jsp" > Déconnecter </a>
</body>
</html>