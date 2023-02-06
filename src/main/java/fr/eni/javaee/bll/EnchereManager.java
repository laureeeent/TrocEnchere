package fr.eni.javaee.bll;

import java.time.LocalDateTime;

import fr.eni.javaee.bo.ArticleVendu;
import fr.eni.javaee.bo.Enchere;
import fr.eni.javaee.bo.Utilisateur;
import fr.eni.javaee.dal.EnchereDAO;
import fr.eni.javaee.exceptions.BusinessException;

public class EnchereManager {
	
	private EnchereDAO enchereDAO = null;
	
	
	public void ajouterEnchere(int noArticle, int enchereEnCours, Utilisateur user, int noAncienEncherisseur, int ancienPrix)
					throws BusinessException {
		ArticleManager articleManager = new ArticleManager();
		UtilisateurManager utilisateurManager = new UtilisateurManager();
		
		Enchere enchere = null;
		Utilisateur ancienAcheteur = null;
		ArticleVendu article = null;
		LocalDateTime dateEnchere = LocalDateTime.now();
	
		article = articleManager.selectionnerByID(noArticle);
		ancienAcheteur = utilisateurManager.selectionnerUtilisateurParID(noAncienEncherisseur);
		ancienAcheteur.setCredit(ancienAcheteur.getCredit()+ancienPrix);
		user.setCredit(user.getCredit() - enchereEnCours);

		utilisateurManager.modifierUtilisateur(user);
		utilisateurManager.modifierUtilisateur(ancienAcheteur);

		enchere = new Enchere(article.getNoArticle(), dateEnchere, enchereEnCours, user, article);
		enchereDAO.insert(enchere);

	}
	
}
