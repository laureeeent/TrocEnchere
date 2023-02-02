<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="fr.eni.javaee.bo.Utilisateur" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Profil de (mettre le nom du pseudo que l'on consulte)</title>
</head>
<body>
	<% 	
		Utilisateur user = (Utilisateur) session.getAttribute("utilisateur"); 
		
	%>
	
	<% if (user != null) {
		
			
		
			%>
			<div>
				<p id="lignePseudo">Pseudo :       <%=user.getPseudo() %></p>
				<p id="ligneNom">Nom :       <%=user.getNom() %></p>
				<p id="lignePrenom">Prenom :       <%=user.getPrenom() %></p>
				<p id="ligneEmail">Email :       <%=user.getEmail() %></p>
				<p id="ligneTelephone">Téléphone :       <%=user.getTelephone() %></p>
				<p id="ligneRue">Rue :       <%=user.getRue() %></p>
				<p id="ligneCodePostal">Code postal :       <%=user.getCodePostal() %></p>
				<p id="ligneVille">Ville :       <%=user.getVille() %></p>
			</div>
			
		<%
	}
	%>
	
		<form action="ServletRedirectionAccueil" method="get">
			<button type="submit" ><h3>Retour Acceuil</h3></button>
		</form>
		<a href="./ModificationCompte"><input type="button" value="Modifier mon compte"></a>
	



</body>
</html>