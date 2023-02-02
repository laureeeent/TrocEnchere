<%@page import="fr.eni.javaee.bo.ArticleVendu"%>
<%@page import="fr.eni.javaee.bll.UtilisateurManager"%>
<%@page import="fr.eni.javaee.bo.Utilisateur"%>
<%@page import="fr.eni.javaee.bo.Enchere"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Création d'un compte sur TrocEnchère</title>
</head>
<body>

<%
			List<String> listeMessagesErreur = (List<String>)request.getAttribute("listeMessagesErreur");
			if(listeMessagesErreur!=null)
			{
		%>
				<p style="color:red;">Erreur, le compte n'a pas pu être crée :</p>
		<%
				for(String messageErreur:listeMessagesErreur)
				{
		%>		<p>><%out.println(messageErreur);%></p>
		<%		
				}
			}
		%>

	<div class="retourAccueil">
		<a href="<%=request.getContextPath()%>/index.jsp"><input
			type="button" value="TrocEnchère - Retour accueil" /></a>
	</div>

	<h1>Mon Profil</h1>

	<form action="<%=request.getContextPath()%>/AjoutCompte" method="post">
		<div class="saisie">
			<label for="pseudo">Pseudo : </label>
			<input type="text" id="pseudo" pattern="[a-zA-Z0-9]{3,30}" name="pseudo" required="required" value="<%=request.getParameter("pseudo") != null ? request.getParameter("pseudo") : ""%>">
		</div>

		<div class="saisie">
			<label for="email">Email : </label> <input type="email" id="email" name="email"
				 size="40" required pattern="[a-z0-9-@.]{8,40}" >
		</div>
		<div class="saisie">
			<label for="prenom">Prénom : </label>
			<input type="text" id="prenom" name="prenom" pattern="[a-zA-Z- ]{3,30}" required="required" value="<%=request.getParameter("prenom") != null ? request.getParameter("prenom") : ""%>">
		</div>
		<div class="saisie">
			<label for="nom">Nom : </label>
			<input type="text" id="nom" name="nom" pattern="[a-zA-Z- ']{3,30}" required="required" value="<%=request.getParameter("nom") != null ? request.getParameter("nom") : ""%>">
		</div>
		<div class="saisie">
			<label for="telephone">Téléphone : </label>
			<input type="tel" id="telephone" name="telephone" pattern="[0-9]{10}" value="<%=request.getParameter("telephone") != null ? request.getParameter("telephone") : ""%>" >
		</div>
		<div class="saisie">
			<label for="rue">Rue : </label>
			<input type="text" id="rue" name="rue" pattern="[a-zA-Z0-9 ]{5,30}" required="required" value="<%=request.getParameter("rue") != null ? request.getParameter("rue") : ""%>" >
		</div>
		<div class="saisie">
			<label for="ville">Ville : </label>
			<input type="text" id="ville" name="ville" pattern="[a-zA-Z -]{3,30}" required="required" value="<%=request.getParameter("ville") != null ? request.getParameter("ville") : ""%>" >
		</div>
		<div class="saisie">
			<label for="codePostal">Code postal : </label>
			<input id="codePostal" name="codePostal" pattern="[0-9]{5}" required="required" value="<%=request.getParameter("codePostal") != null ? request.getParameter("codePostal") : ""%>">
		</div>
		<div class="saisie">
			<label for="mdp">Mot de passe : </label> <input type="password"
				id="mdp" name="mdp" required pattern="[A-Za-z0-9]{8,30}" title="le mot de passe doit contenir entre 8 et 30 caractères alphanumériques. Caractères spéciaux non autorisés."> 
		</div>
		<div class="saisie">
			<label for="mdp">Confirmation mot de passe : </label> <input
				type="password" id="mdp" name="confirmationMdp" required pattern="[A-Za-z0-9]{8,30}">
		</div>
		<div>
			<input type="submit" value="Créer" />
		</div>
	</form>

	<div class="retourAccueil">
		<a href="<%=request.getContextPath()%>/index.jsp"><input
			type="button" value="Annuler" /></a>
	</div>



</body>
</html>