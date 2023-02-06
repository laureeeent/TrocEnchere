<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="fr.eni.javaee.bo.*"
	import="java.util.List" import="java.util.ArrayList"%>

<%
Utilisateur user = (Utilisateur) session.getAttribute("utilisateur");
ArticleVendu art = (ArticleVendu) session.getAttribute("articleById");
Enchere enchere;

/* art.getNoArticle(); */
/* Utilisateur vendeur=art.getVendeur();  */
/* Utilisateur ancienEncherisseur =enchere.getAcheteur(); */
 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Récupérer les attributs de l'objet en vente - Faire une
	enchère</title>
</head>
<body>
	<%
			List<String> listeMessagesErreur = (List<String>)request.getAttribute("listeMessagesErreur");
			if(listeMessagesErreur!=null)
			{
		%>
				<p style="color:red;">Erreur, votre enchère n'a pas été enregistrée :</p>
		<%
				for(String messageErreur:listeMessagesErreur)
				{
		%>		<p>><%out.println(messageErreur);%></p>
		<%		
				}
			}
		%>
	<h2>Détails enchère</h2>
	<input type="text" hidden="none" name="noArticle" value="<%= art.getNoArticle() %>">
	<label id="description"> Description :</label><input type="text" value="<%=art.getDescription()%> " name="description" readonly="readonly"><br>
	<label id="categorie"> Catégorie : </label><input type="text" value="<%=art.getCategorieArticle().getLibelle()%> " name="categorie" readonly="readonly"><br>
	<label id="finEnchere"> Fin de l'enchère : </label><input type="text" value="<%=art.getDateFinEncheres()%>" name="finEnchere" readonly="readonly"><br>
	<h4>Meilleure offre :</h4>
	<input type="text" value="<%=user.getEncheres()%>" name="meilleure_offre" readonly="readonly"> par <input type="text" value="<%=user.getPseudo()%>" name="meilleure_offre" readonly="readonly">
	<label id="mise_a_prix"> Mise à prix :</label><input type="text" value="<%=art.getMiseAPrix()%>" name="mise_a_prix" readonly="readonly"><br>
	<h4>Retrait :</h4>
	<label id="label_rue"> Rue : </label><input type="text" value="<%=art.getVendeur().getRue()%>" name="label_rue" readonly="readonly"><br>
	<label id="label_code_postal"> Code postal : </label><input type="text" value=" <%=art.getVendeur().getCodePostal()%>" name="input_code_postal" readonly="readonly">
	<label id="label_ville"> Ville : </label><input type="text" value="<%=art.getVendeur().getVille()%>" name="input_ville" readonly="readonly"><br>
	<label id="vendeur"> Vendeur : </label><input type="text" value="<%=art.getVendeur().getPseudo()%>" name="vendeur" readonly="readonly"><br>
	<label>Nom_pseudo</label><input name="var_pseudo" value="nom_pseudo" type="hidden">


	<h4>Ma proposition :</h4>
	<input id="enchereEnCours" type="number"
		min=" "
		max=" " name="enchereEnCours"
		required="required" value="montant de l'enchère actuelle + 1">
	<form action="./DetailEnchere"
		method="post">
	<input type="submit" name="encherir" value="Enchérir" />
	</form>




</body>
</html>