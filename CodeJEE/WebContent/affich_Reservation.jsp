<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% String nom=request.getParameter("nom");
double prix=Double.parseDouble(request.getParameter("prix"));
%>
 <p><b >Votre Commande a bien reserver :</b></p>
  Nom de livre  est :<%=nom %>
 prix de votre commande est :<%=prix %>
 

</body>
</html>