<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page  import="java.sql.*"%>
      <%@page import="java.util.ArrayList"%>
    <%@page import="com.dao.ArticleDao"%>
<%@page import="com.model.Article"%>
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
<title>Panier</title>
</head>
<body style="background-image:url('./images/panier.jpg');">
 
  <h1 style="text-align:center;" style="color:brouwn;" > votre panier : </h1>
<table  border="1" align="center"  width="100%" style="background-color:#C0C0C0;"  >
<tr><td>Id</td><td>Nom</td><td>Prix </td><td> Option </td></tr>
		<tr>
		<%
			boolean encore = resultats.next();
			while (encore) {
		%>
		</tr>
		<tr>
		    <td><%=resultats.getInt(1)%></td>
			<td><%=resultats.getString(2)%></td>
			<td><%=resultats.getDouble(3)%></td>
			<td><a href="ls.html">Supprimer</a></td>
		
			<td></td>
			
			
		</tr>
	<%
			encore = resultats.next();
			}
		%>

</table>
</br>   
</br>   
<a href="cmd.jsp"> ajouter d'autres livres ! </a>  </br> 
</br>
  pour acheter vous devez Authetifieé !----> <a href="login.jsp"> AUTHETIFICATION </a>  </br> 


</body>
</html>