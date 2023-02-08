<%@page import="java.time.LocalDateTime"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="fr.eni.javaee.bo.*"
    import="java.util.List"
    import="java.util.ArrayList"
 %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
    <%
    	Utilisateur user = (Utilisateur) session.getAttribute("utilisateur"); 
    	String messageVente = (String) request.getAttribute("messageVente");
    	LocalDateTime dateNow = LocalDateTime.now();
    	dateNow = LocalDateTime.of( dateNow.getYear(), dateNow.getMonthValue(), dateNow.getDayOfMonth(), dateNow.getHour()+1, dateNow.getMinute());
    	LocalDateTime dateFin = dateNow.plusDays(1);
/*    		LocalDateTime dateFin = LocalDateTime.of(dateNow.getYear(), dateNow.getMonthValue(), dateNow.getDayOfMonth(), dateNow.getHour(), dateNow.getMinute());
 */   	
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Nouvelle vente ${utilisateur != null ? utilisateur.getPseudo() : "" }</title>
</head>
<body>
<header id="h_principal">
	<%@include file="fragment/div_id_entete.jsp"%>
</header>
	<h2>Nouvelle vente</h2>
	<form action="./ServletNouvelleVente" method="post">
		<label id="label_article">Article : </label><input type="text" name="input_article"><br>
		<label id="label_description">Description : </label><input type="text" name="input_description"><br>
		<label id="label_categorie">Catégorie : </label><select name="input_categorie">
							<c:if test="${listeCategories != null }">
								<c:forEach var="c" items="${listeCategories}">
									<option value="${c.getLibelle()}"> ${c.getLibelle() }</option>
								</c:forEach>
							</c:if>
								</select> <br>
		<label id="label_photo">Photo de l'article : </label><input type="text" name="input_photo"><br>
		<label id="label_mise_a_prix">Mise à prix : </label><input type="number" name="input_mise_a_prix" value="0"><br>
		<label id="label_debut_enchere">Début de l'enchère : </label><input type="datetime-local" name="input_date_debut_enchere" value="<%=dateNow.toString()%>"><br>
		<label id="label_fin_enchere">Fin de l'enchère : </label><input type="datetime-local" name="input_date_fin_enchere" value="<%=dateFin.toString()%>"><br>
		<br>
		
		<h3>Retrait : </h3>
		<label id="label_rue"> Rue : </label><input type="text" value="${utilisateur != null ? utilisateur.getRue() : "" }" name="input_rue"><br>
		<label id="label_code_postal"> Code postal : </label><input type="text" value="${ utilisateur != null ? utilisateur.getCodePostal() : "" }" name="input_code_postal"><br>
		<label id="label_ville"> Ville : </label><input type="text" value="${ utilisateur != null ? utilisateur.getVille() :"" }" name="input_ville"><br><br>
		
		<p>${messageVente != null ? messageVente : "" }</p>
		
		
		<button type="submit" name="boutton_form" value="enregistrer">Enregistrer</button>
		<button type="submit" name="boutton_form" value="annuler">Annuler</button>
		<button type="submit" name="boutton_form" value="annuler_vente">Annuler la vente</button>
	</form>
	
	<p>En confirmant cette mise en vente, vous vous engagez dès que le début de l'enchère a commencé. <br>
		Vous ne pouvez ni supprimer l'article, ni supprimer votre compte jusqu'à la fin de l'enchère et au retrait de l'article. <a href="ServletRedirectionConditionsGénérales">Voir les conditions générales</a></p>
	
	
</body>
</html>