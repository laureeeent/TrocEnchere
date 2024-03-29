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
<header id="h_principal">
	<%@include file="fragment/div_id_entete.jsp"%>
</header>
			<c:choose>
				 <c:when test="${utilisateur != null && utilisateur.equals(param_pseudo) || autre_profil == null}">
					<div>
	
						<p id="lignePseudo">Pseudo :       ${utilisateur.getPseudo() }</p>
						<p id="ligneNom">Nom :       ${utilisateur.getNom() }</p>
						<p id="lignePrenom">Prenom :       ${utilisateur.getPrenom() }</p>
						<p id="ligneEmail">Email :       ${utilisateur.getEmail() }</p>
						<p id="ligneTelephone">Téléphone :       ${utilisateur.getTelephone() }</p>
						<p id="ligneRue">Rue :       ${utilisateur.getRue() }</p>
						<p id="ligneCodePostal">Code postal :       ${utilisateur.getCodePostal() }</p>
						<p id="ligneVille">Ville :       ${utilisateur.getVille() }</p>
						<a href="./ModificationCompte"><input type="button" value="Modifier mon compte"></a>
					</div>
				</c:when>
				<c:otherwise>
					<c:if test="${autre_profil != null}">
						<div>
		
							<p id="lignePseudo">Pseudo :       ${autre_profil.getPseudo() }</p>
							<p id="ligneNom">Nom :       ${autre_profil.getNom() }</p>
							<p id="lignePrenom">Prenom :       ${autre_profil.getPrenom() }</p>
							<p id="ligneEmail">Email :       ${autre_profil.getEmail() }</p>

		
						</div>
					</c:if>
				</c:otherwise>
			</c:choose>
<%@include file="fragment/bouttonRetourAccueil.jsp" %>


</body>
</html>