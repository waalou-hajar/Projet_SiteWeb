<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Commande</title>
</head>
<body>
<body  style="background-image:url('./images/plan2.jpg')";>
<form action="./ServletCommande" method="Get">
<table align="center" borter="1" style="background-color:#C0C0C0;" >
<tbody>
<h1 align="center" stylse="color:red;"> Remplir les Informations Correct Pour Enregistre !!!!</h1>
<tr align="center">
<td colspan="2"> <label> livre panier : </label></td>
</tr>
<tr><td><label>  Num de Commande: </label></td><td><input type="number" name="id"></td></tr>
<tr><td><label>  Votre Nom : </label></td><td><input type="text" name="nom"></td></tr>
<tr><td><label>Prix total:</label></td><td><input type="number" name="prix"></td></tr>

<tr><td colspan="2"><input type="submit" name="btn" value="Ajouter"></tr>
</tbody>
</table>
</form>

</body>
</html>