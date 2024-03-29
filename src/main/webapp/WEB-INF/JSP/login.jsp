<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
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
</head>
<body>

	<header id="h_principal">

		<div id="titre_page">
			<h1>Espace de connexion</h1>
		</div>
	</header>
	<main id="m_principal">
		<div id="conteneur_connexion_form">
			<form id="se_connecter" action="ServletConnecter" method="post">
				<div id="h_form">
					<div class="indentifiant">
						<label id="id">Identifiant: </label>
						<input id="id"name="identifiant" type="text" required="required"  title="Votre Pseudo ou votre E-mail entre 3 et 40 caractères">
					</div>
					<div class="mot_de_passe">
						<label id="motdepasse">Mot de Passe: </label>
						<input id="mdp" name="mot_de_passe" type="password" required="required" pattern="[A-Za-z0-9]{3,40}" title="le mot de passe doit contenir entre 8 et 30 caractères alphanumériques. Caractères spéciaux non autorisés.">
					</div>
				</div>
				<div id="connexion_form">
					<div class="connexion_form_left">
						<input type="submit" name="connexion" value="Connexion">
					</div>
					<div class="connexion_form_right">
						<input type="checkbox" id="btn_souvenir" name="souvenir"><label
							id="texte_souvenir">Se souvenir de moi</label><a href="#">Mot de
							passe oublié</a>
					</div>

					<c:if test="${messageErreur != null }">
						<p style="color: red">${messageErreur}</p>
					</c:if>
					
				</div>
			</form>
			<form class="btn_ajouter_compte" action="AjoutCompte" method="get">
				<input type="submit" name="creer_compte" value="Créer un compte">
			</form>
		</div>
	</main>

</body>
</html>