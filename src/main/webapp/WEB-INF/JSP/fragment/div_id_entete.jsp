		<div id="entete">
			<p id="nom_site"><a href="ServletRedirectionAccueil">TROCENCHERE</a></p>


			<nav id="menu_nav_utilisateur">
				<c:if test="${utilisateur == null }">
					<ul>
						<li><a href="ServletConnecter">S'inscrire - Se connecter</a></li>
					</ul>
				</c:if>
				
				<c:if test="${utilisateur != null }">
					<ul>
						<li><a href="#">Enchères</a></li>
						<li><a href="ServletNouvelleVente">Vendre un article</a></li>
						<li><a href="ServletAfficherCompte">Mon profil ( ${utilisateur.getPseudo()} : ${utilisateur.getCredit()} crédits )</a></li>
						<li><a href="ServletDeconnexion">Déconnexion</a></li>
					</ul>
				</c:if>


			</nav>
		</div>