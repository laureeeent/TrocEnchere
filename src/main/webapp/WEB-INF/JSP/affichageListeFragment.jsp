
			
			<c:if test="${listeAAfficher != null }">
			
				<h3>--- ${titreFiltre } prout : ---</h3>
				<h1>ici y'a une liste</h1>
				<c:forEach var="article" items="${listeAAfficher }">
					
					<form action="AfficherArticle" method="get" name="id">

						<div id="conteneur_article">
							<div class="img_conteneur_article">
								<img alt="#" src="${article.getImage()}" width="300"
									height="200">
							</div>
							<div class="texte_conteneur_article">
								<input type="text" hidden="none" name="id"
									value="${article.getNoArticle()}">
								<p class="designation_article">${article.getNomArticle()}</p>
								<p class="prix_initial">
									Prix initial:
									<c:out value="${article.getMiseAPrix()}"></c:out>
								</p>
								<p class="prix_encheres">
									Prix enchère:
									<c:out value="${article.getEnchere().getMontantEnchere() }"></c:out>
								</p>
								<p class="date_fin_enchere_article">
									Fin de l'enchère :
									<c:out value="${article.getDateFinEncheres()}"></c:out>
								</p>
								<p class="vendeur_enchere_article">
									Vendeur: <a href="ServletAfficherCompte"><c:out
											value="${article.getVendeur().getPseudo()}"></c:out></a>
								</p>
								<input type="submit" name="select_article"
									value="Voir l'enchère">
							</div>
						</div>
					</form>
				</c:forEach>
			</c:if>