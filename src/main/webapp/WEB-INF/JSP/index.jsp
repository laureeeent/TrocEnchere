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
		<div id="entete">
			<p id="nom_site">TROCENCHERE</p>


			<nav id="menu_nav_utilisateur">
				<c:if test="${utilisateur == null }">
					<ul>
						<li><a href="ServletConnecter">S'inscrire - Se connecter</a></li>
					</ul>
				</c:if>
				
				<c:if test="${utilisateur != null }">
					<ul>
						<li><a href="#">Enchères</a></li>
						<li><a href="ServletNouvelleVente">Vendre un article</a></li>
						<li><a href="ServletAfficherCompte">Mon profil ( ${utilisateur.getPseudo()})</a></li>
						<li><a href="ServletDeconnexion">Déconnexion</a></li>
					</ul>
				</c:if>
				 

			</nav>
		</div>
		<div id="titre_page">
			<h1>Liste des enchères</h1>
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
						<select name="categorie">
							<c:if test="${listeCategories != null }">
								<c:forEach var="c" items="${listeCategories}">
									<option value="${c.getLibelle()}"> ${c.getLibelle() }</option>
								</c:forEach>
							</c:if>
						</select>
					</div>
					<div class="footer_filtres">
						<div class="liste_options">
						<%-- 					<% if (user != null){%>
							<ul>
								<% for( Enchere enchere : encheres) { %>
								<li> <%= user.getEncheres() %></li>
								<%}}%>
							
							 </ul>  --%>
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
		<% List<ArticleVendu> liste_EnchereEC = (ArrayList<ArticleVendu>)request.getAttribute("listeArticles");
		 if (liste_EnchereEC != null){
			for (ArticleVendu article : liste_EnchereEC){%>
			
			<form action="AfficherArticle" method="get" name="id">
				
					<div id="conteneur_article">
						<div class="img_conteneur_article">
							<img alt="#" src="#">
						</div>
						<div class="texte_conteneur_article">
							 <input type="text" hidden="none" name="id" value="<%= article.getNoArticle() %>">
							<p class="designation_article"><%= article.getNomArticle() %></p>
							<p class="prix_initial">Prix initial: <%=  article.getMiseAPrix() %></p>
							<p class="prix_encheres">Prix enchère: <%=  article.getEnchere().getMontant_enchere() %></p>
							<p class="date_fin_enchere_article">Fin de l'enchère : <%= article.getDateFinEncheres() %></p>
							<p class="vendeur_enchere_article">Vendeur: <a href="ServletAfficherCompte"><%=article.getVendeur().getPseudo() %></a> </p>
							<input type="submit" name="select_article" value="Voir l'enchère" >
						</div>
					</div>
			
			</form>
		<% }}%>
		</div>
	</main>
	<footer id="f_principal"></footer>
</body>
</html>