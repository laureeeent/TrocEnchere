<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="fr.eni.javaee.bo.*"
	import="java.util.List" import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<div id="conteneur_articles">
<c:if test="${listeArticles != null}">
	<c:forEach var="article" items="${listeArticles}">
		<form action="AfficherArticle" method="get" name="id">
			<div id="conteneur_article">
				<div class="img_conteneur_article">
					<c:if test="${article.getNoArticle()== articleById.getNoArticle()}">
						<img alt="#" src="${article.getImage()}" width="300" height="200">
					</c:if>
				</div>	
			</div>
		</form>
	</c:forEach>
	</c:if>
</div>

<label id="categorie"> Catégorie :
	${articleById.getCategorieArticle().getLibelle()} </label>
<input type="text"
	value="${articleById.getCategorieArticle().getLibelle()}"
	name="categorie" readonly="readonly" hidden="none">
<br>
<label id="finEnchere"> Fin de l'enchère :
	${articleById.getDateFinEncheres()} </label>
<input type="text" value="${articleById.getDateFinEncheres()}"
	name="finEnchere" readonly="readonly" hidden="none">
<br>

<h4>Meilleure offre :</h4>
<label> ${articleById.getEnchere() != null ? articleById.getEnchere().getMontantEnchere() : 0}
</label>
<input type="text"
	value="${articleById.getEnchere() != null ? articleById.getEnchere().getMontantEnchere() : 0}"
	name="meilleure_offre" readonly="readonly" hidden="none">
par
<label> ${articleById.getEnchere() != null ? articleById.getEnchere().getAcheteur().getPseudo() :  "
					Aucun acheteur" }</label>
<input type="text"
	value="${articleById.getEnchere() != null ? articleById.getEnchere().getAcheteur().getPseudo() :  "
	Aucun acheteur" }" name="meilleure_offre" readonly="readonly"
	hidden="none">
<br>
<label id="mise_a_prix"> Mise à prix :
	${articleById.getMiseAPrix()}</label>
<input type="text" value="${articleById.getMiseAPrix()}"
	name="mise_a_prix" readonly="readonly" hidden="none">
<br>