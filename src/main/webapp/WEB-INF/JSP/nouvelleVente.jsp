<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="fr.eni.javaee.bo.*"
    import="java.util.List"
    import="java.util.ArrayList"
    
    %>
    
    <% 	Utilisateur user = (Utilisateur) session.getAttribute("utilisateur"); %>
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
		<label id="label_Article">Catégorie : </label><select name="categorie">
							<%
								List<Categorie> listeCategories = (ArrayList<Categorie>) request.getAttribute("listeCategories");
								if (listeCategories!=null){
									for (Categorie s : listeCategories) { %>
										<option value="<%=s.getLibelle()%>"><%=s.getLibelle()%></option>
								<%	}
								}
								%>
								</select> <br>
		<label id="label_Article">Photo de l'article : </label><input type="text" name="input_photo"><br>
		<label id="label_Article">Mise à prix : </label><input type="number" name="input_mise_a_prix"><br>
		<label id="label_Article">Début de l'enchère : </label><input type="date" name="input_date_debut_enchere"><br>
		<label id="label_Article">Fin de l'enchère : </label><input type="date" name="input_date_fin_enchere"><br>
		

	</form>
	
	
</body>
</html>