<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<% String message = (String) request.getAttribute("messageErreur"); %>

	<header id="h_principal">
		<div id="entete">
			<p id="nom_site">TROCENCHERE</p>
		</div>
		<div id="titre_page">
			<h1>Espace de connexion</h1>
		</div>
	</header>
	<main id="m_principal">
		<div id="conteneur_connexion_form">
			<form action="ServletConnecter" method="post">
				<div id="h_form">
					<label id="id">Identifiant: </label><input id="id"
						name="identifiant" type="text" required="required"  title="Votre Pseudo ou votre E-mail entre 3 et 40 caractères"><label
						id="mdp">Mot de Passe: </label><input id="mdp" name="mot_de_passe"
						type="password" required="required" pattern="[A-Za-z0-9]{3,40}">
				</div>
				<div id="connexion_form">
					<div class="connexion_form_left">
						<input type="submit" name="connexion" value="Connexion">
					</div>
					<div class="connexion_form_right">
						<input type="checkbox" id="souvenir" name="souvenir"><label
							id="souvenir">Se souvenir de moi</label><a href="#">Mot de
							passe oublié</a>
					</div>
					<% 
						if (message != null) {
							%><p style="color: red"><%=message%></p><%
						}
							
					%>
				</div>
			</form>
			<form action="AjoutCompte" method="get">
				<input type="submit" name="creer_compte" value="Créer un compte">
			</form>
		</div>
	</main>
	<footer id="f_principal"></footer>
</body>
</html>