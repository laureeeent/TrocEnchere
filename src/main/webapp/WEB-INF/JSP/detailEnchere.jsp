<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="fr.eni.javaee.bo.*"
	import="java.util.List" import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Récupérer les attributs de l'objet en vente - Faire une
	enchère</title>
</head>
<body>
<header id="h_principal">
	<%@include file="fragment/div_id_entete.jsp"%>
</header>
	<c:if test="${listeMessagesErreur!=null}">
		<p style="color:red;">Erreur, votre enchère n'a pas été enregistrée :</p>
		<c:forEach var="c" items="${listeMessagesErreur}">
			<p><c:out value="${c}"></c:out> </p>
		</c:forEach>
	</c:if>
	<h2>Détails enchère</h2>

	<form action="./DetailEnchere"
		method="post">
	<input type="text" hidden="none" name="noArticle" value="${articleById.getNoArticle()}">
	<input type="text" hidden="none" name="no_ancien_encherisseur" value="${articleById.getEnchere() != null ? articleById.getEnchere().getAcheteur().getNoUtilisateur() : 0 }">
	<label id="description"> Description :</label><input type="text" value="${articleById.getDescription()}" name="description" readonly="readonly"><br>
	<label id="categorie"> Catégorie : </label><input type="text" value="${articleById.getCategorieArticle().getLibelle()}" name="categorie" readonly="readonly"><br>
	<label id="finEnchere"> Fin de l'enchère : </label><input type="text" value="${articleById.getDateFinEncheres()}" name="finEnchere" readonly="readonly"><br>


	<h4>Meilleure offre : </h4>
	<input type="text" value="${articleById.getEnchere()!= null ? articleById.getEnchere().getMontant_enchere():0}" name="meilleure_offre" readonly="readonly"> par <input type="text" value="${articleById.getEnchere() != null ? articleById.getEnchere().getAcheteur().getPseudo() :  "Aucun acheteur" }" name="meilleureOffre" readonly="readonly">

	<label id="mise_a_prix"> Mise à prix :</label><input type="text" value="${articleById.getMiseAPrix()}" name="mise_a_prix" readonly="readonly"><br>
	<h4>Retrait :</h4>
	<label id="label_rue"> Rue : </label><input type="text" value="${articleById.getVendeur().getRue()}" name="label_rue" readonly="readonly"><br>
	<label id="label_code_postal"> Code postal : </label><input type="text" value="${articleById.getVendeur().getCodePostal()}" name="input_code_postal" readonly="readonly">
	<label id="label_ville"> Ville : </label><input type="text" value="${articleById.getVendeur().getVille()}" name="input_ville" readonly="readonly"><br>
	<label id="label_vendeur"> Vendeur : </label><input type="text" value="${articleById.getVendeur().getPseudo()}" name="vendeur" readonly="readonly"><br>
	<label id="label_pseudo"> Pseudo : </label><input name="var_pseudo" value="nom_pseudo" type="hidden">


	<h4>Ma proposition :</h4>
	<c:if test="${utilisateur.getCredit() <= articleById.getMiseAPrix()}">
		<p style="color:red;">Crédit insuffisant! Veuillez contacter notre organisme financier pour augmenter votre Crédit disponible, afin de participer à l'enchère.</p>
	</c:if>
	<c:if test="${utilisateur.getCredit() > articleById.getMiseAPrix()}">
	<input id="enchereEnCours" type="number"
		min="${articleById.getEnchere().getMontant_enchere() < articleById.getMiseAPrix() ? articleById.getMiseAPrix(): articleById.getEnchere().getMontant_enchere()+1}"
		max="${utilisateur.getCredit()}" name="enchereEnCours"
		required="required" value="">
	</c:if>
	<input type="submit" name="encherir" value="Enchérir" />
	</form>

</body>
</html>