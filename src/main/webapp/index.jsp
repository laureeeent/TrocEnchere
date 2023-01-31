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
	<div id="entete">
		<p id="nom_site">TROCENCHERE</p>
		<nav id="menu_nav_utilisateur">
			<ul>
				<li><a href="#">Enchères</a></li>
				<li><a href="#">Vendre un article</a></li>
				<li><a href="#">Mon profil</a></li>
				<li><a href="#">Deconexion</a></li>
			</ul>
		</nav>
		</div>
		<div id="titre_page">
		<h1>Espace de connexion</h1>
		</div>
		<div id="filtres">
			<form action="#" method="get" id="form_rechercher_filtres">
			<div id="filtres_left">
				<div class="header_filtres">
					<h2>Filtres:</h2>
					<div class="rechercher">
						<input type="text" placeholder="Le nom de l'article contient">
					</div>
				</div>
				<div class="main_filtres">
					<h3>Catégorie:</h3>
					<select><option>Par défault pour l'instant</option></select>
				</div>
				<div class="footer_filtres">
					<div class="liste_options"><p class="infos">LISTE A METTRE !!!</p> </div>
				</div>
			</div>
			<div id="filtres_right">
				<div id="btn_valide_filtres">
					<input type="submit" name="rechercher" value="Rechercher">
				</div>
			</div>
			</form>
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