<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="fr.eni.javaee.bo.*"
    import="java.util.List"
    import="java.util.ArrayList"
    
    %>
    
    <%
    	Utilisateur user = (Utilisateur) session.getAttribute("utilisateur"); 
    	String messageVente = (String) request.getAttribute("messageVente");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Nouvelle vente (<%=user != null ? user.getPseudo() : "" %>)</title>
</head>
<body>
	<h2>Nouvelle vente</h2>
	<form action="./ServletNouvelleVente" method="post">
		<label id="label_article">Article : </label><input type="text" name="input_article"><br>
		<label id="label_description">Description : </label><input type="text" name="input_description"><br>
		<label id="label_categorie">Catégorie : </label><select name="input_categorie">
							<%
								List<Categorie> listeCategories = (ArrayList<Categorie>) request.getAttribute("listeCategories");
								if (listeCategories!=null){
									for (Categorie s : listeCategories) { %>
										<option value="<%=s.getLibelle()%>"><%=s.getLibelle()%></option>
								<%	}
								}
								%>
								</select> <br>
		<label id="label_photo">Photo de l'article : </label><input type="text" name="input_photo"><br>
		<label id="label_mise_a_prix">Mise à prix : </label><input type="number" name="input_mise_a_prix"><br>
		<label id="label_debut_enchere">Début de l'enchère : </label><input type="datetime-local" name="input_date_debut_enchere"><br>
		<label id="label_fin_enchere">Fin de l'enchère : </label><input type="datetime-local" name="input_date_fin_enchere"><br>
		<br>
		
		<h3>Retrait : </h3>
		<label id="label_rue"> Rue : </label><input type="text" value="<%= user != null ? user.getRue() : "" %>" name="input_rue"><br>
		<label id="label_code_postal"> Code postal : </label><input type="text" value="<%= user != null ? user.getCodePostal() : "" %>" name="input_code_postal"><br>
		<label id="label_ville"> Ville : </label><input type="text" value="<%= user != null ? user.getVille() : "" %>" name="input_ville"><br><br>
		
		<%
			if (messageVente != null) {
				%><p><%=messageVente%></p><% 
			}
		%>
		
		<button type="submit" name="boutton_form" value="enregistrer">Enregistrer</button>
		<button type="submit" name="boutton_form" value="annuler">Annuler</button>
		<button type="submit" name="boutton_form" value="annuler_vente">Annuler la vente</button>
	</form>
	
	
</body>
</html>