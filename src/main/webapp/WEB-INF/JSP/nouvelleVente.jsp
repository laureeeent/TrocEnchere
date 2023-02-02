<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="fr.eni.javaee.bo.*"
    import="java.util.List"
    import="java.util.ArrayList"
    
    %>
    
    <% 	Utilisateur user = (Utilisateur) session.getAttribute("utilisateur"); 
    	List<Categorie> listeCategorie = (ArrayList<Categorie>) request.getAttribute("listeCategorie");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Nouvelle vente (<%=user.getPseudo() %>)</title>
</head>
<body>
	<h2>Nouvelle vente</h2>
	<form action="./ServletAjouterArticle" method="post">
		<label id="label_Article">Article : </label><input type="text" name="input_article"><br>
		<label id="label_Description">Description : </label><input type="text" name="input_description"><br>
		<label id="label_Article">Catégorie : </label><input type="text" name="input_categorie"><br>
		<label id="label_Article">Photo de l'article : </label><input type="text" name="input_article"><br>
		

	</form>
	
	
</body>
</html>