<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TrocEnchère</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<header id="h_principal">
		<nav id="menu_nav_utilisateur">
			<ul>
				<li><a href="#">Enchères</a></li>
				<li><a href="#">Vendre un article</a></li>
				<li><a href="#">Mon profil</a></li>
				<li><a href="#">Deconexion</a></li>
			</ul>
		</nav>
		<h1>Espace de connexion</h1>
		<div id="filtres">
		<form action="#" method="get" id="form_rechercher_filtres">
			<div class="header_filtres"></div>
			<div class="main_filtres"></div>
			<div class="footer_filtres">
				
					<div class="liste_options"></div>
				</form>
			</div>

		</div>
		<div id="btn_valide_filtres">
			<input type="submit" name="rechercher" value="Rechercher">
		</div>
		
	</header>
	<main id="m_principal">
		<div id="conteneur_articles">
			<div id="conteneur_article">
				<div class="img_conteneur_article">
					<img alt="#" src="#">
				</div>
				<div class="texte_conteneur_article">
					<p class="designation_article"></p>
					<p class="prix_article">Prix:</p>
					<p class="date_fin_enchere_article">Fin de l'enchère :</p>
					<p class="vendeur_enchere_article">Vendeur:</p>
				</div>
			</div>
		</div>
	</main>
	<footer id="f_principal"></footer>
</body>
</html>