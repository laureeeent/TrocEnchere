
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="fr.eni.javaee.bo.ArticleVendu"%>
<%@page import="fr.eni.javaee.bll.UtilisateurManager"%>
<%@page import="fr.eni.javaee.bo.Utilisateur"%>
<%@page import="fr.eni.javaee.bo.Enchere"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.List"%>

<%
Utilisateur user = (Utilisateur) session.getAttribute("utilisateur");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/themes/sunny/theme.min.css">
<link rel="stylesheet" href="css/example.wink.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/hideshowpassword/2.1.1/hideShowPassword.min.js"></script>
<script src="JS/index.js"></script>

<title>Modification du compte de ${ utilisateur.getPseudo()}</title>
</head>
<body>
<header id="h_principal">
	<%@include file="fragment/div_id_entete.jsp"%>
</header>
	<main id="m_principal">
	<c:if test="${listeMessagesErreur != null }">
		<p style="color: red;">Erreur, le compte n'a pas pu être modifié :</p>
	</c:if>
	
	<c:forEach var="me" items="${listeMessagesErreur }">
		<p>${me}</p>
	</c:forEach>

	<h1>Profil de ${utilisateur.getPseudo()}</h1>

	<form id="ajouter_compte" action="./ModificationCompte"
		method="post">
		<div class="saisie">
			<label for="pseudo">Pseudo : </label> <input type="text" id="pseudo"
				pattern="[a-zA-Z0-9]{3,30}" name="pseudo" required="required"
				title="le pseudo doit contenir entre 3 et 30 caractères alphanumériques."
				value="${utilisateur.getPseudo() }">
		</div>

		<div class="saisie">
			<label for="email">Email : </label> <input type="email" id="email"
				name="email" size="40" required pattern="[a-z0-9-@.]{8,40}"
				value="${utilisateur.getEmail() }">
		</div>
		<div class="saisie">
			<label for="prenom">Prénom : </label> <input type="text" id="prenom"
				name="prenom" pattern="[a-zA-Z- ]{3,30}" required="required"
				value="${utilisateur.getPrenom() }">
		</div>
		<div class="saisie">
			<label for="nom">Nom : </label> <input type="text" id="nom"
				name="nom" pattern="[a-zA-Z- ']{3,30}" required="required"
				value="${utilisateur.getNom() }">
		</div>
		<div class="saisie">
			<label for="telephone">Téléphone : </label> <input type="tel"
				id="telephone" name="telephone" pattern="[0-9]{10}"
				value="${utilisateur.getTelephone() }">
		</div>
		<div class="saisie">
			<label for="rue">Rue : </label> <input type="text" id="rue"
				name="rue" pattern="[a-zA-Z0-9 ]{5,30}" required="required"
				value="${utilisateur.getRue() }">
		</div>
		<div class="saisie">
			<label for="ville">Ville : </label> <input type="text" id="ville"
				name="ville" pattern="[a-zA-Z -]{3,30}" required="required"
				value="${utilisateur.getVille() }">
		</div>
		<div class="saisie">
			<label for="codePostal">Code postal : </label> <input id="codePostal"
				name="codePostal" pattern="[0-9]{5}" required="required"
				value="${utilisateur.getCodePostal()}">
		</div>
		<div class="mdp">
			<label for="mdp">Mot de passe actuel : </label> <input
				type="password" id="mdp" name="mdpActuel" required
				title="saisir mdp pour supprimer/modifier le compte"
				pattern="[A-Za-z0-9]{8,30}">
		</div>
		<div class="mdp">
			<label for="mdp">Nouveau mot de passe : </label> <input
				type="password" id="mdp1" name="mdp" pattern="[A-Za-z0-9]{8,30}"
				title="le mot de passe doit contenir entre 8 et 30 caractères alphanumériques. Caractères spéciaux non autorisés.">
		</div>
		<div class="mdp">
			<label for="mdp">Confirmation mot de passe : </label> <input
				type="password" id="mdp2" name="confirmationMdp"
				pattern="[A-Za-z0-9]{8,30}">
		</div>
		<div class="consultation">
			<label for="credit">Crédit : ${utilisateur.getCredit() }</label>
		</div>
		<div>
			<input type="submit" name="submit" value="Enregistrer" />
		</div>
		<div>
			<input type="submit" name="submit" value="Supprimer mon compte" />
		</div>
	</form>

</main>
</body>
</html>