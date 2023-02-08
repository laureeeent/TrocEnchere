<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="fr.eni.javaee.bo.*"
	import="java.util.List" import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Faire une
	enchère</title>
</head>
<body>
	<header id="h_principal">
		<%@include file="fragment/div_id_entete.jsp"%>
	</header>
	<c:if test="${listeMessagesErreur!=null}">
		<p style="color: red;">Erreur, votre enchère n'a pas été
			enregistrée :</p>
		<c:forEach var="c" items="${listeMessagesErreur}">
			<p>
				<c:out value="${c}"></c:out>
			</p>
		</c:forEach>
	</c:if>
	<h2>Détails enchère de ${articleById.getDescription()}</h2>

	<form action="./DetailEnchere" method="post">
		<input type="text" hidden="none" name="noArticle"
			value="${articleById.getNoArticle()}"> <input type="text"
			hidden="none" name="no_ancien_encherisseur"
			value="${articleById.getEnchere() != null ? articleById.getEnchere().getAcheteur().getNoUtilisateur() : 0 }">

		<c:choose>
			<c:when test="${articleById.getEtatVente().equals('EC')}">
			<label id="categorie">	Catégorie : ${articleById.getCategorieArticle().getLibelle()} </label> <input type="text"
			value="${articleById.getCategorieArticle().getLibelle()}"
			name="categorie" readonly="readonly" hidden="none"> <br> 
			<label
			id="finEnchere"> Fin de l'enchère : ${articleById.getDateFinEncheres()} </label><input type="text"
			value="${articleById.getDateFinEncheres()}" name="finEnchere"
			readonly="readonly" hidden="none"><br>
			
			<h4>Meilleure offre :</h4>
				<label> ${articleById.getEnchere() != null ? articleById.getEnchere().getMontantEnchere() : 0} </label>
				<input type="text"
					value="${articleById.getEnchere() != null ? articleById.getEnchere().getMontantEnchere() : 0}"
					name="meilleure_offre" readonly="readonly"  hidden="none" > par 
					<label> ${articleById.getEnchere() != null ? articleById.getEnchere().getAcheteur().getPseudo() :  "
					Aucun acheteur" }</label>
					<input type="text"
					value="${articleById.getEnchere() != null ? articleById.getEnchere().getAcheteur().getPseudo() :  "
					Aucun acheteur" }" name="meilleure_offre" readonly="readonly" hidden="none"><br> 
				<label id="mise_a_prix"> Mise à prix : ${articleById.getMiseAPrix()}</label>
				<input type="text" value="${articleById.getMiseAPrix()}"
					name="mise_a_prix" readonly="readonly" hidden="none">
				<br>
				
				<h4>Ma proposition :</h4>
				<c:if
					test="${utilisateur.getCredit() <= articleById.getMiseAPrix() or utilisateur.getCredit() <= articleById.getEnchere().getMontantEnchere()}">
					<p style="color: red;">Crédit insuffisant! Veuillez contacter
						notre organisme financier pour augmenter votre Crédit disponible,
						afin de participer à l'enchère.</p>
				</c:if>
				<c:choose>
				<c:when test="${utilisateur.getCredit() > articleById.getMiseAPrix() and articleById.getEnchere().getAcheteur().getNoUtilisateur()!= utilisateur.getNoUtilisateur()}">
					<input id="enchereEnCours" type="number"
						min="${articleById.getEnchere().getMontantEnchere() < articleById.getMiseAPrix() && articleById.getEnchere()== null  ? articleById.getMiseAPrix(): articleById.getEnchere().getMontantEnchere()+1}"
						max="${utilisateur.getCredit()}" name="enchereEnCours"
						required="required"
						placeholder="${articleById.getEnchere().getMontantEnchere() < articleById.getMiseAPrix() && articleById.getEnchere()== null ? articleById.getMiseAPrix(): articleById.getEnchere().getMontantEnchere()+1}">
					<input id="encherir" type="submit" name="encherir" value="Enchérir" />
				</c:when>
				<c:otherwise>
				<p style="color: red;">Votre enchère actuelle est la plus haute pour cet article. Vous ne pouvez pas surenchérir pour le moment.</p>
				</c:otherwise>
				</c:choose>
			</c:when>
			<c:otherwise>
				<h4>Enchère terminée :</h4>
				<label id="mise_a_prix"> Mise à prix : ${articleById.getMiseAPrix()}</label><br>
				<label id="meilleureOffre"> Dernière enchère de $ : ${articleById.getEnchere() != null ? articleById.getEnchere().getMontantEnchere() : 0} faite par ${articleById.getEnchere() != null ? articleById.getEnchere().getAcheteur().getPseudo() :  "Aucun acheteur" }</label>
			</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${articleById.getEnchere().getAcheteur().getNoUtilisateur()==utilisateur.getNoUtilisateur() and articleById.getEtatVente().equals('VD') }">
				<h2>Félicitations ! L'article est à vous et vous attend</h2>
				<h4>Adresse du retrait :</h4>
				<label id="label_rue"> ${articleById.getVendeur().getRue()} </label>
				<input type="text" value="${articleById.getVendeur().getRue()}"
					name="label_rue" readonly="readonly" hidden="none">
				<br>
				<label id="label_code_postal">${articleById.getVendeur().getCodePostal()} </label>
				<input type="text"
					value="${articleById.getVendeur().getCodePostal()}"
					name="input_code_postal" readonly="readonly" hidden="none">
				<label id="label_ville"> ${articleById.getVendeur().getVille()}</label>
				<input type="text" value="${articleById.getVendeur().getVille()}"
					name="input_ville" readonly="readonly" hidden="none">
				<br>
				<label id="label_vendeur"> Vendeur : ${articleById.getVendeur().getPseudo()}</label>
				<input type="text" value="${articleById.getVendeur().getPseudo()}"
					name="vendeur" readonly="readonly" hidden="none">
				<br>
				</c:when>
			
		</c:choose>
	</form>

</body>
</html>