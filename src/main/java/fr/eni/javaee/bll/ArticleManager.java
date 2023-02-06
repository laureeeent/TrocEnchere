package fr.eni.javaee.bll;

import java.util.List;

import fr.eni.javaee.bo.ArticleVendu;
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
		
		public ArticleVendu selectionnerByID (int id)throws BusinessException {
			ArticleVendu article = null;
			try {
			article= articleVenduDAO.selectById(id);
			}
			catch (BusinessException be) {
				be.printStackTrace();
			}
			return article ;
		}


		public List<ArticleVendu> selectionnerByEtat (String etat) {
		
			try {
				return this.articleVenduDAO.selectByEtat(etat);
			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
		public void ajouterArticle(ArticleVendu article) throws BusinessException {
			articleVenduDAO.insert(article);
			
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