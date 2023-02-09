package fr.eni.javaee.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.javaee.bll.ArticleManager;
import fr.eni.javaee.bll.CategorieManager;
import fr.eni.javaee.bo.ArticleVendu;
import fr.eni.javaee.bo.Categorie;
import fr.eni.javaee.bo.Utilisateur;
import fr.eni.javaee.exceptions.BusinessException;

/**
 * Servlet implementation class ServletFiltreAcceuil
 */
@WebServlet("/ServletFiltreAcceuil")
public class ServletFiltreAcceuil extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String categorieStr = request.getParameter("categorie");
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/JSP/index.jsp");
		
		Utilisateur user = (Utilisateur) session.getAttribute("utilisateur");
		if (user == null) {
			rd = request.getRequestDispatcher("/WEB-INF/JSP/erreurConnexionUtilisateur.jsp");
			rd.forward(request, response);
		}
		else {
			ArticleManager articleManager = new ArticleManager();
			CategorieManager categorieManager = new CategorieManager();
			
			String choixEnchere = request.getParameter("choix");
			
			
			if (choixEnchere.equals("achats")) {
				String filtreEC = (request.getParameter("EC") );
				String filtreUserEnchereEC = request.getParameter("mes_encheres");
				String filtreUserEnchereRemportee = request.getParameter("mes_encheres_remportees");
				try {
					int noCategorie = 0;
					
					if ( !(categorieStr.equals("toutesCategories")) ) {
						noCategorie = categorieManager.selectionnerParLibelle(categorieStr).getNoCategorie();
					}
					
					
					if (filtreEC != null ) {
						
						request.setAttribute("listeArticlesEC", articleManager.selectionnerByEtat("EC", noCategorie));
						
					}
					if (filtreUserEnchereEC != null ) {
						request.setAttribute("listeArticlesEnchereUser", articleManager.selectionnerEnchereUser(user, "EC", noCategorie));
					}
					if (filtreUserEnchereRemportee != null) {
						request.setAttribute("listeArticlesEnchereUserRemportee", articleManager.selectionnerEnchereUser(user, "remportee", noCategorie));
					}
					else if (filtreEC == null && filtreUserEnchereEC == null && filtreUserEnchereRemportee == null) {
						List<ArticleVendu> listeArticlesCR = articleManager.selectionnerByEtat("CR", noCategorie);
						List<ArticleVendu> listeArticlesEC = articleManager.selectionnerByEtat("EC", noCategorie);
						List<ArticleVendu> listeArticlesVD = articleManager.selectionnerByEtat("VD", noCategorie);
						List<ArticleVendu> listeArticlesRT = articleManager.selectionnerByEtat("RT", noCategorie);
						List<ArticleVendu> listeArticlesVendu = new ArrayList<ArticleVendu>();
						listeArticlesVendu.addAll(listeArticlesCR);
						listeArticlesVendu.addAll(listeArticlesEC);
						listeArticlesVendu.addAll(listeArticlesVD);
						listeArticlesVendu.addAll(listeArticlesRT);
						
						request.setAttribute("listeTousArticles", listeArticlesVendu);
					}
				} catch (BusinessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				request.setAttribute("listeCategories", categorieManager.selectionnerToutesLesCategories());
				rd.forward(request, response);
			}
			else if (choixEnchere.equals("mes_ventes")) {
				String filtreVentesECUser = request.getParameter("ventes_EC");
				String filtresVentesCR = request.getParameter("ventes_CR");
				String filtresVentesVDRT = request.getParameter("VD");
					
				try {
					int noCategorie = 0;
					if ( !(categorieStr.equals("toutesCategories")) ) {
						noCategorie = categorieManager.selectionnerParLibelle(categorieStr).getNoCategorie();
					}
					
					if (filtreVentesECUser != null) {
						request.setAttribute("listeVentesUserEC", articleManager.selectionnerVentesUserEC(user));
					}
					if (filtresVentesCR != null) {
						request.setAttribute("listeVentesCR", articleManager.selectionnerByEtat("CR", noCategorie));
					}
					if (filtresVentesVDRT != null) {
						List<ArticleVendu> listeArticlesVD = articleManager.selectionnerByEtat("VD", noCategorie);
						List<ArticleVendu> listeArticlesRT = articleManager.selectionnerByEtat("RT", noCategorie);
						List<ArticleVendu> listeArticlesVendu = new ArrayList<ArticleVendu>();
						listeArticlesVendu.addAll(listeArticlesVD);
						listeArticlesVendu.addAll(listeArticlesRT);
						
						request.setAttribute("listeVentesVDRT", listeArticlesVendu);
					}
					
					if (filtreVentesECUser == null && filtresVentesCR == null && filtresVentesVDRT == null ) {
						List<ArticleVendu> listeArticlesEC = articleManager.selectionnerByEtat("EC", noCategorie);
						List<ArticleVendu> listeArticlesVD = articleManager.selectionnerByEtat("VD", noCategorie);
						List<ArticleVendu> listeArticlesRT = articleManager.selectionnerByEtat("RT", noCategorie);
						List<ArticleVendu> listeArticlesVendu = new ArrayList<ArticleVendu>();
						listeArticlesVendu.addAll(listeArticlesEC);
						listeArticlesVendu.addAll(listeArticlesVD);
						listeArticlesVendu.addAll(listeArticlesRT);
						
						request.setAttribute("listeTousVentes", listeArticlesVendu);
					}
					request.setAttribute("listeCategories", categorieManager.selectionnerToutesLesCategories());
					rd.forward(request, response);
				}
				catch (BusinessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			
		}
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
