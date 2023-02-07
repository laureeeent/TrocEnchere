package fr.eni.javaee.bll;

import java.time.LocalDateTime;

import fr.eni.javaee.bo.ArticleVendu;
import fr.eni.javaee.bo.Enchere;
import fr.eni.javaee.bo.Retrait;
import fr.eni.javaee.bo.Utilisateur;
import fr.eni.javaee.dal.DAOFactory;
import fr.eni.javaee.dal.EnchereDAO;
import fr.eni.javaee.dal.EnchereDAOJdbcImpl;
import fr.eni.javaee.exceptions.BusinessException;

public class EnchereManager {

	private EnchereDAO enchereDAO = null;

	public EnchereManager() {
		enchereDAO = DAOFactory.getEnchereDAO();
	}

	public void ajouterEnchere(int noArticle, int enchereEnCours, Utilisateur user, int noAncienEncherisseur,
			int ancienPrix) throws BusinessException {
		ArticleManager articleManager = new ArticleManager();
		UtilisateurManager utilisateurManager = new UtilisateurManager();

		Enchere nouvelleEnchere = null;
		Enchere ancienneEnchere = selectionnerEnchereParArticle(noArticle);
		Utilisateur nouvelEncherisseur = user;
		Utilisateur ancienEncherisseur = null;
		ArticleVendu article = null;
		LocalDateTime dateEnchere = LocalDateTime.now();

		try {
			article = articleManager.selectionnerByID(noArticle);
			ancienEncherisseur = utilisateurManager.selectionnerUtilisateurParID(noAncienEncherisseur);
			ancienEncherisseur.setCredit(ancienEncherisseur.getCredit() + ancienPrix);
			nouvelEncherisseur.setCredit(nouvelEncherisseur.getCredit() - enchereEnCours);

			utilisateurManager.modifierUtilisateur(nouvelEncherisseur);
			utilisateurManager.modifierUtilisateur(ancienEncherisseur);
			articleManager.modifierPrixArticle(article);

			supprimerEnchere(ancienneEnchere);
			nouvelleEnchere = new Enchere(article.getNoArticle(), dateEnchere, enchereEnCours, nouvelEncherisseur,
					article);
			enchereDAO.insert(nouvelleEnchere);
		} catch (BusinessException e) {
			e.printStackTrace();
		}

	}

	public void ajouterEnchere(int noArticle, int enchereEnCours, Utilisateur user)throws BusinessException {
		
		ArticleManager articleManager = new ArticleManager();
		Utilisateur nouvelEncherisseur = user;
		UtilisateurManager utilisateurManager = new UtilisateurManager();
		
		Enchere enchere = null;
		ArticleVendu article = null;
		LocalDateTime dateEnchere = LocalDateTime.now();
	
		try {
			article = articleManager.selectionnerByID(noArticle);
			nouvelEncherisseur.setCredit(nouvelEncherisseur.getCredit() - enchereEnCours);
			utilisateurManager.modifierUtilisateur(nouvelEncherisseur);
			articleManager.modifierPrixArticle(article);
			enchere = new Enchere(article.getNoArticle(), dateEnchere, enchereEnCours, nouvelEncherisseur, article);
			enchereDAO.insert(enchere);
		} catch (BusinessException e) {
			e.printStackTrace();
		}
	}

	public void supprimerEnchere(Enchere enchere) throws BusinessException {
		enchereDAO.delete(enchere);
	}

	public Enchere selectionnerEnchereParArticle(int noArticle) throws BusinessException {

		Enchere enchere = null;

		enchere = this.enchereDAO.selectById(noArticle);

		return enchere;

	}
}
