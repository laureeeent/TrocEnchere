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
			<textarea rows="1" cols="30" id="pseudo" pattern="[a-zA-Z0-9]+" name="pseudo"><%=request.getParameter("pseudo") != null ? request.getParameter("pseudo") : ""%></textarea>
		</div>

		<div class="saisie">
			<label for="email">Email : </label> <input type="email" id="email" name="email"
				 size="30" required>
		</div>
		<div class="saisie">
			<label for="prenom">Prénom : </label>
			<textarea rows="1" cols="30" id="prenom" name="prenom"><%=request.getParameter("prenom") != null ? request.getParameter("prenom") : ""%></textarea>
		</div>
		<div class="saisie">
			<label for="nom">Nom : </label>
			<textarea rows="1" cols="30" id="nom" name="nom"><%=request.getParameter("nom") != null ? request.getParameter("nom") : ""%></textarea>
		</div>
		<div class="saisie">
			<label for="telephone">Téléphone : </label>
			<textarea rows="1" cols="30" id="telephone" name="telephone"><%=request.getParameter("telephone") != null ? request.getParameter("telephone") : ""%></textarea>
		</div>
		<div class="saisie">
			<label for="rue">Rue : </label>
			<textarea rows="1" cols="30" id="rue" name="rue"><%=request.getParameter("rue") != null ? request.getParameter("rue") : ""%></textarea>
		</div>
		<div class="saisie">
			<label for="ville">Ville : </label>
			<textarea rows="1" cols="30" id="ville" name="ville"><%=request.getParameter("ville") != null ? request.getParameter("ville") : ""%></textarea>
		</div>
		<div class="saisie">
			<label for="codePostal">Code postal : </label>
			<textarea rows="1" cols="30" id="codePostal" name="codePostal"><%=request.getParameter("codePostal") != null ? request.getParameter("codePostal") : ""%></textarea>
		</div>
		<div class="saisie">
			<label for="mdp">Mot de passe : </label> <input type="password"
				id="mdp" name="mdp" required>
		</div>
		<div class="saisie">
			<label for="mdp">Confirmation mot de passe : </label> <input
				type="password" id="mdp" name="mdp" required>
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