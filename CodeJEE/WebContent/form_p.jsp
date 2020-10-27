<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body  style="background-image:url('./images/plan2.jpg')";>
<form action="ServletPanier" method="Get">
<table align="center" borter="1">
<tbody>
<h1 align="center" stylse="color:red;"> Remplir les Informations Correct Pour Valider bien Votre Commande !!!!</h1>
<tr align="center">
<td colspan="2"> <label> livre panier : </label></td>
</tr>
<tr><td><label>  Num de livre : </label></td><td><input type="number" name="id"></td></tr>
<tr><td><label>  Nom de livre : </label></td><td><input type="text" name="nom"></td></tr>
<tr><td><label>Prix de livre:</label></td><td><input type="number" name="prix"></td></tr>

<tr><td colspan="2"><input type="submit" name="btn" value="Ajouter"><input type="submit" name="btn" value="Annuler"></td></tr>
</tbody>
</table>
</form>

</body>
</html>