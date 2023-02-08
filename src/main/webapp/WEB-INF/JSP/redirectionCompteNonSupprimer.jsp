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
<title>Compte Non Supprimer</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<%
	//Utilisateur user = (Utilisateur) session.getAttribute("utilisateur");
	%>
	<header id="h_principal">

		<div id="titre_page">
			<h1>Suppression de votre compte</h1>
		</div>
	</header>
	<main id="m_principal">
		<h2>Votre compte n'a pas été supprimer</h2>
		<p><strong>Une enchère vous engage tant que celle-ci n'est pas terminée. <a href="ServletRedirectionConditionsGénérales">Voir les conditions générales</a></strong></p>
		<%@include file="fragment/bouttonRetourAccueil.jsp"%>
	</main>
	<footer id="f_principal"></footer>
</body>
</html>