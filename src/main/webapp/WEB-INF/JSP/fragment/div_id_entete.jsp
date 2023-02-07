		<div id="entete">
			<a href="ServletRedirectionAccueil"><p id="nom_site">TROCENCHERE</p></a>


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
						<li><a href="ServletAfficherCompte">Mon profil ( ${utilisateur.getPseudo()})</a></li>
						<li><a href="ServletDeconnexion">Déconnexion</a></li>
					</ul>
				</c:if>


			</nav>
		</div>