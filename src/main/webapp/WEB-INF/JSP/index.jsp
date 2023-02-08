<%@page import="fr.eni.javaee.bo.ArticleVendu"%>
<%@page import="fr.eni.javaee.bll.UtilisateurManager"%>
<%@page import="fr.eni.javaee.bo.Utilisateur"%>
<%@page import="fr.eni.javaee.bo.Enchere"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="fr.eni.javaee.bo.Categorie"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TrocEnchère</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<%
	//Utilisateur user = (Utilisateur) session.getAttribute("utilisateur");
	%>
	<header id="h_principal">
		<%@include file="fragment/div_id_entete.jsp"%>
		<div id="titre_page">
			<h1>Liste des enchères</h1>
		</div>
		<div id="filtres">
			<form action="./ServletFiltreAcceuil" method="get" id="form_rechercher_filtres">
				<div id="filtres_left">
					<div class="header_filtres">
						<h2>Filtres:</h2>
						<div class="rechercher">
							<input type="text" placeholder="Le nom de l'article contient">
						</div>
					</div>
					<div class="main_filtres">
						<h3>Catégorie:</h3>
						<select name="categorie">
							<c:if test="${listeCategories != null }">
								<c:forEach var="c" items="${listeCategories}">
									<option value="${c.getLibelle()}">${c.getLibelle() }</option>
								</c:forEach>
							</c:if>
						</select>
					</div>
					<div class="footer_filtres">
						<div class="liste_options">
							<fieldset>
								<legend>Selectioner Achats ou Mes ventes:</legend>

								<input type="radio" id="achats" name="choix" value="achats"
									checked> <label for="achats">Achats</label>
								<c:if test="achat"></c:if>
								<div class="sous_achats">
									<input type="checkbox" id="enchere" name="EC" value="1" checked>
									<label for="EC">enchères ouvertes</label>
									
									<input type="checkbox" id="enchere" name="mes_encheres" value="1">
									<label for="mes_encheres">mes enchères</label> 
									
									<input type="checkbox" id="enchere" name="mes_encheres_remportees" value="1">
									<label for="mes_encheres_remportees">mes enchères remportées</label>
								</div>


								<input type="radio" id="mes_ventes" name="choix"
									value="mes_ventes"> <label for="mes_ventes">Mes
									ventes</label>
								<div class="sous_ventes">
									<input type="checkbox" id="ventes" name="ventes_EC" checked>
									<label for="ventes_EC">mes ventes en cours</label> 
									
									<input type="checkbox" id="ventes" name="ventes_CR">
									<label for="ventes_CR">ventes non débutées</label>
									
									<input type="checkbox" id="ventes" name="VD">
									<label for="VD">ventes terminées</label>
								</div>

							</fieldset>
						</div>
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
			<c:if test="${listeArticles != null}">
				<c:forEach var="article" items="${listeArticles}">
					<form action="AfficherArticle" method="get" name="id">

						<div id="conteneur_article">
							<div class="img_conteneur_article">
								<img alt="#" src="${article.getImage()}" width="300"
									height="200">
							</div>
							<div class="texte_conteneur_article">
								<input type="text" hidden="none" name="id"
									value="${article.getNoArticle()}">
								<p class="designation_article">${article.getNomArticle()}</p>
								<p class="prix_initial">
									Prix initial:
									<c:out value="${article.getMiseAPrix()}"></c:out>
								</p>
								<p class="prix_encheres">
									Prix enchère:
									<c:out value="${article.getEnchere().getMontantEnchere() }"></c:out>
								</p>
								<p class="date_fin_enchere_article">
									Fin de l'enchère :
									<c:out value="${article.getDateFinEncheres()}"></c:out>
								</p>
								<p class="vendeur_enchere_article">
									Vendeur: <a href="ServletAfficherCompte"><c:out
											value="${article.getVendeur().getPseudo()}"></c:out></a>
								</p>
								<input type="submit" name="select_article"
									value="Voir l'enchère">
							</div>
						</div>

					</form>
				</c:forEach>
			</c:if>
		</div>
		
		<div id=listes_achats>
			<c:if test="${listeArticlesEC != null }">
				<h3>Enchères en cours : </h3>
				<c:forEach var="article" items="${listeArticlesEC }">
					<form action="AfficherArticle" method="get" name="id">

						<div id="conteneur_article">
							<div class="img_conteneur_article">
								<img alt="#" src="${article.getImage()}" width="300"
									height="200">
							</div>
							<div class="texte_conteneur_article">
								<input type="text" hidden="none" name="id"
									value="${article.getNoArticle()}">
								<p class="designation_article">${article.getNomArticle()}</p>
								<p class="prix_initial">
									Prix initial:
									<c:out value="${article.getMiseAPrix()}"></c:out>
								</p>
								<p class="prix_encheres">
									Prix enchère:
									<c:out value="${article.getEnchere().getMontantEnchere() }"></c:out>
								</p>
								<p class="date_fin_enchere_article">
									Fin de l'enchère :
									<c:out value="${article.getDateFinEncheres()}"></c:out>
								</p>
								<p class="vendeur_enchere_article">
									Vendeur: <a href="ServletAfficherCompte"><c:out
											value="${article.getVendeur().getPseudo()}"></c:out></a>
								</p>
								<input type="submit" name="select_article"
									value="Voir l'enchère">
							</div>
						</div>
					</form>
				</c:forEach>
			</c:if>
			
			<c:if test="${listeArticlesEnchereUser != null }">
				<h3>--- Mes Enchères en cours : ---</h3>
				<c:forEach var="article" items="${listeArticlesEnchereUser }">
					<form action="AfficherArticle" method="get" name="id">

						<div id="conteneur_article">
							<div class="img_conteneur_article">
								<img alt="#" src="${article.getImage()}" width="300"
									height="200">
							</div>
							<div class="texte_conteneur_article">
								<input type="text" hidden="none" name="id"
									value="${article.getNoArticle()}">
								<p class="designation_article">${article.getNomArticle()}</p>
								<p class="prix_initial">
									Prix initial:
									<c:out value="${article.getMiseAPrix()}"></c:out>
								</p>
								<p class="prix_encheres">
									Prix enchère:
									<c:out value="${article.getEnchere().getMontantEnchere() }"></c:out>
								</p>
								<p class="date_fin_enchere_article">
									Fin de l'enchère :
									<c:out value="${article.getDateFinEncheres()}"></c:out>
								</p>
								<p class="vendeur_enchere_article">
									Vendeur: <a href="ServletAfficherCompte"><c:out
											value="${article.getVendeur().getPseudo()}"></c:out></a>
								</p>
								<input type="submit" name="select_article"
									value="Voir l'enchère">
							</div>
						</div>
					</form>
				</c:forEach>
			</c:if>
			
			
			<c:if test="${listeArticlesEnchereUserRemportee != null }">
				<h3>--- Mes Enchères remportées : ---</h3>
				<c:forEach var="article" items="${listeArticlesEnchereUserRemportee }">
					<form action="AfficherArticle" method="get" name="id">

						<div id="conteneur_article">
							<div class="img_conteneur_article">
								<img alt="#" src="${article.getImage()}" width="300"
									height="200">
							</div>
							<div class="texte_conteneur_article">
								<input type="text" hidden="none" name="id"
									value="${article.getNoArticle()}">
								<p class="designation_article">${article.getNomArticle()}</p>
								<p class="prix_initial">
									Prix initial:
									<c:out value="${article.getMiseAPrix()}"></c:out>
								</p>
								<p class="prix_encheres">
									Prix enchère:
									<c:out value="${article.getEnchere().getMontantEnchere() }"></c:out>
								</p>
								<p class="date_fin_enchere_article">
									Fin de l'enchère :
									<c:out value="${article.getDateFinEncheres()}"></c:out>
								</p>
								<p class="vendeur_enchere_article">
									Vendeur: <a href="ServletAfficherCompte"><c:out
											value="${article.getVendeur().getPseudo()}"></c:out></a>
								</p>
								<input type="submit" name="select_article"
									value="Voir l'enchère">
							</div>
						</div>
					</form>
				</c:forEach>
			</c:if>
		</div>
		
		
	</main>
	<footer id="f_principal"></footer>
</body>
</html>