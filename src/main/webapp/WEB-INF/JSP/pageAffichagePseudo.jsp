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
			<c:if test="${utilisateur != null}">
				<div>
					<p id="lignePseudo">Pseudo :       ${utilisateur.getPseudo() }</p>
					<p id="ligneNom">Nom :       ${utilisateur.getNom() }</p>
					<p id="lignePrenom">Prenom :       ${utilisateur.getPrenom() }</p>
					<p id="ligneEmail">Email :       ${utilisateur.getEmail() }</p>
					<p id="ligneTelephone">Téléphone :       ${utilisateur.getTelephone() }</p>
					<p id="ligneRue">Rue :       ${utilisateur.getRue() }</p>
					<p id="ligneCodePostal">Code postal :       ${utilisateur.getCodePostal() }</p>
					<p id="ligneVille">Ville :       ${utilisateur.getVille() }</p>
				</div>
			</c:if>

		<form action="ServletRedirectionAccueil" method="get">
			<button type="submit" ><h3>Retour Acceuil</h3></button>
		</form>
		<a href="./ModificationCompte"><input type="button" value="Modifier mon compte"></a>

</body>
</html>