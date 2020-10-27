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
	PreparedStatement stmt = con.prepareStatement("select * from user;");
	ResultSet resultats = stmt.executeQuery();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> les Client </title>
</head>
<body style="background-image:url('./images/plan2.jpg')";>
 <h1>  Bonjour l' admiiiiiiiiiiiiiin !!!!!!!!!!!!! </h1>
  <h1 style="text-align:center;" style="color:brouwn;" > Liste des Articles </h1>
<table  border="1" align="center"  width="100%" style="background-color:#C0C0C0;" >
<tr><td>Id</td><td>Nom</td><td>Login</td><td>Password</td><td>Email</td><td></td></tr>
		<tr>
		<%
			boolean encore = resultats.next();
			while (encore) {
		%>
		</tr>
		<tr>
		    <td><%=resultats.getInt(1)%></td>
			<td><%=resultats.getString(2)%></td>
			<td><%=resultats.getString(3)%></td>
			<td><%=resultats.getString(4)%></td>
			<td><%=resultats.getString(5)%></td>
			<td><a href="formSUPClient.html">Supprimer</a></td>
			
		</tr>
	<%
			encore = resultats.next();
			}
		%>

</table>
</br>  
</br>   
<a href="f.jsp"> Retour </a>  </br> 
</br>
</br> 

 
</body>
</html>