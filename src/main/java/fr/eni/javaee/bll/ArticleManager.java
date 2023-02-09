package fr.eni.javaee.bll;

import java.time.LocalDateTime;
import java.util.List;

import fr.eni.javaee.bo.ArticleVendu;
import fr.eni.javaee.bo.Categorie;
import fr.eni.javaee.bo.Retrait;
import fr.eni.javaee.bo.Utilisateur;
import fr.eni.javaee.dal.ArticleVenduDAO;
import fr.eni.javaee.dal.DAOFactory;
import fr.eni.javaee.exceptions.BusinessException;

public class ArticleManager {

		private ArticleVenduDAO articleVenduDAO = null;
		
		public ArticleManager() {
			// TODO Auto-generated constructor stub
			articleVenduDAO = DAOFactory.getArticleDAO();
		}
		
		public List <ArticleVendu> selectionnerToutesLesCategories(){
			
			return this.articleVenduDAO.selectAll() ;
		}
		
		public ArticleVendu selectionnerByID (int id) throws BusinessException {
			ArticleVendu article = null;
			try {
				article= articleVenduDAO.selectById(id);
			}
			catch (BusinessException be) {
				be.printStackTrace();
			}
			return article ;
		}


		public List<ArticleVendu> selectionnerByEtat (String etat, int noCategorie) {
		
			try {
				return this.articleVenduDAO.selectByEtat(etat, noCategorie);
			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
		public List<ArticleVendu> selectionnerVentesUserEC(Utilisateur user) throws BusinessException {
			return articleVenduDAO.selectVentesUserEC(user);
		}
		
		public List<ArticleVendu> selectionnerEnchereUser(Utilisateur user, String filtre, int noCategorie) throws BusinessException {
			return articleVenduDAO.selectEnchereUser(user, filtre, noCategorie);
		}
		
		public void ajouterArticle(ArticleVendu article) throws BusinessException {
			articleVenduDAO.insert(article);
			
		}
		
		public int ajouterArticle( String nomArticle, String description, LocalDateTime dateDebutEnchere, LocalDateTime dateFinEnchere,
									int miseAPrix, Utilisateur user, String categorieLibelle, String retraitRue, String codePostal, String ville) throws BusinessException {
			CategorieManager categorieManager = new CategorieManager();
			
			Retrait retrait = new Retrait(retraitRue, codePostal, ville);
			Categorie categorie = categorieManager.selectionnerParLibelle(categorieLibelle);
			
			ArticleVendu artAVendre = new ArticleVendu(nomArticle, description, dateDebutEnchere, dateFinEnchere, miseAPrix, 0, user, categorie, retrait);
			articleVenduDAO.insert(artAVendre);
			
			return artAVendre.getNoArticle();
		}
		
		public void modifierPrixArticle(ArticleVendu article) {
			try {
				articleVenduDAO.updateMontantEnchere(article);
			}
			catch (BusinessException be) {
				be.printStackTrace();
			}
		}

	}