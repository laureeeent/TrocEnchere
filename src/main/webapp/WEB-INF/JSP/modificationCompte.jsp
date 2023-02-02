<%@page import="fr.eni.javaee.bo.ArticleVendu"%>
<%@page import="fr.eni.javaee.bll.UtilisateurManager"%>
<%@page import="fr.eni.javaee.bo.Utilisateur"%>
<%@page import="fr.eni.javaee.bo.Enchere"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
Utilisateur user = (Utilisateur) session.getAttribute("utilisateur");
int credit = user.getCredit();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modification du compte de <%=user.getPseudo()%></title>
</head>
<body>

	<%
	List<String> listeMessagesErreur = (List<String>) request.getAttribute("listeMessagesErreur");
	if (listeMessagesErreur != null) {
	%>
	<p style="color: red;">Erreur, le compte n'a pas pu être modifié :</p>
	<%
	for (String messageErreur : listeMessagesErreur) {
	%>
	<p>
		><%
	out.println(messageErreur);
	%>
	</p>
	<%
	}
	}
	%>

	<h1>
		Profil de
		<%=user.getPseudo()%></h1>

	<form action="<%=request.getContextPath()%>/ModificationCompte"
		method="post">
		<div class="saisie">
			<label for="pseudo">Pseudo : </label> <input type="text" id="pseudo"
				pattern="[a-zA-Z0-9]{3,30}" name="pseudo" required="required"
				title="le pseudo doit contenir entre 3 et 30 caractères alphanumériques."
				value="<%=user.getPseudo()%>">
		</div>

		<div class="saisie">
			<label for="email">Email : </label> <input type="email" id="email"
				name="email" size="40" required pattern="[a-z0-9-@.]{8,40}" value="<%=user.getEmail()%>">
		</div>
		<div class="saisie">
			<label for="prenom">Prénom : </label> <input type="text" id="prenom"
				name="prenom" pattern="[a-zA-Z- ]{3,30}" required="required"
				value="<%=user.getPrenom()%>">
		</div>
		<div class="saisie">
			<label for="nom">Nom : </label> <input type="text" id="nom"
				name="nom" pattern="[a-zA-Z- ']{3,30}" required="required"
				value="<%=user.getNom()%>">
		</div>
		<div class="saisie">
			<label for="telephone">Téléphone : </label> <input type="tel"
				id="telephone" name="telephone" pattern="[0-9]{10}"
				value="<%=user.getTelephone()%>">
		</div>
		<div class="saisie">
			<label for="rue">Rue : </label> <input type="text" id="rue"
				name="rue" pattern="[a-zA-Z0-9 ]{5,30}" required="required"
				value="<%=user.getRue()%>">
		</div>
		<div class="saisie">
			<label for="ville">Ville : </label> <input type="text" id="ville"
				name="ville" pattern="[a-zA-Z -]{3,30}" required="required"
				value="<%=user.getVille()%>">
		</div>
		<div class="saisie">
			<label for="codePostal">Code postal : </label> <input id="codePostal"
				name="codePostal" pattern="[0-9]{5}" required="required"
				value="<%=user.getCodePostal()%>">
		</div>
		<div class="saisie">
			<label for="mdp">Mot de passe actuel : </label> <input
				type="password" id="mdp" name="mdpActuel" required
				pattern="[A-Za-z0-9]{8,30}">
		</div>
		<div class="saisie">
			<label for="mdp">Nouveau mot de passe : </label> <input
				type="password" id="mdp" name="mdp" 
				pattern="[A-Za-z0-9]{8,30}"
				title="le mot de passe doit contenir entre 8 et 30 caractères alphanumériques. Caractères spéciaux non autorisés.">
		</div>
		<div class="saisie">
			<label for="mdp">Confirmation mot de passe : </label> <input
				type="password" id="mdp" name="confirmationMdp" 
				pattern="[A-Za-z0-9]{8,30}">
		</div>
		<div class="consultation">
			<label for="credit">Crédit : <%=credit%></label>
		</div>
		<div>
			<input type="submit" name="submit" value="Enregistrer" />
		</div>
		<div>
			<input type="submit" name="submit" value="Supprimer mon compte" />
		</div>
	</form>


</body>
</html>